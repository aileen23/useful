package kr.co.useful.approval.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.useful.approval.domain.ApprovalCriteria;
import kr.co.useful.approval.domain.ApprovalPageMaker;
import kr.co.useful.approval.domain.ApprovalProgressVO;
import kr.co.useful.approval.domain.ApprovalVO;
import kr.co.useful.approval.domain.PathMaker;
import kr.co.useful.approval.service.ApprovalService;
import kr.co.useful.manager.domain.EmpVO;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	@Inject
	private ApprovalService service;
	
	// 특정 문서 조회
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET)
	public String read(HttpServletRequest request,Model m,@PathVariable int no) throws Exception{
		m.addAttribute("vo", service.select(no));
		return "/approval/read";
	}
	
	// 기안 작성폼 열기
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		return "/approval/form";
	}
	
	// 작성된 기안 등록
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String insert(ApprovalVO vo, MultipartFile file, HttpServletRequest request,
												RedirectAttributes rttr) throws Exception{
		// 파일업로드 경로 지정 (각 pc의 git 폴더내 src/main/webapp/upload )
		service.create(vo, file, request);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/approval/listmine";
	}
		
	// 기안 수정폼 열기 (반려된 문서의 작성자가 열었을 때에 한함)
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(int no,Model m) throws Exception{
		m.addAttribute("vo", service.select(no));
	}
	
	// 기안 수정하기 (내용수정 + 문서상태를 '반려->진행'으로 변경)
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String update(ApprovalVO vo,MultipartFile file,	String oldfilename,
				HttpServletRequest request,RedirectAttributes rttr) throws Exception{
		EmpVO empVO = (EmpVO) request.getSession().getAttribute("LoginUser");
		vo.setCurr_approval(empVO.getEmpno());
		service.update(vo,file,request,oldfilename);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/approval/listmine";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(ApprovalVO vo,String oldfilename,HttpServletRequest request,
													RedirectAttributes rttr) throws Exception{
		vo.setFilename(oldfilename);
		service.delete(vo,request);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/approval/listmine";
	}
	
	/* 문서 리스트 조회
	1. 결재완료이고 수신부서가 우리부서 또는 전체인것 조회 -> 세부내용조회
	2. 우리부서내에서 결재 진행중인것			-> 세부내용조회
	3. 내가 작성한 것 -> 반려된거는 수정기능
	4. 내가 결재할 차례인것 -> 결재하기
	 */
	
	@RequestMapping("/listmine")	// 내가 작성한 문서 조회
	public String listmine(HttpSession session, ApprovalCriteria cri,Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		vo.setWriter(((EmpVO)session.getAttribute("LoginUser")).getEmpno());
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listCount(vo, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.list(vo,cri));
		return "/approval/listmine";
	}

	@RequestMapping("/listmyturn")	// 내가 결재할 차례인것 조회
	public String listmyturn(HttpSession session, ApprovalCriteria cri,Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		vo.setNext_approval(((EmpVO)session.getAttribute("LoginUser")).getEmpno());
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listCount(vo, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.list(vo,cri));
		return "/approval/listmyturn";
	}
	
	@RequestMapping("/listdept")	// 수신부서가 우리부서 or 전체용 문서 조회
	public String listdept(HttpSession session, ApprovalCriteria cri, Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		int empno=((EmpVO)session.getAttribute("LoginUser")).getEmpno();
		vo.setReceiver(service.getMyDeptno(empno));	// 사번으로 부서번호 얻어서 조회 조건 지정
		vo.setStatus("완료");							// 결재완료인 상태로 조건 지정
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listCount(vo, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.list(vo,cri));
		return "/approval/listdept";
	}
	
	@RequestMapping("/liststatus")	// 우리부서내에서 결재 진행중인것 조회 (발신부서 조회)
	public String liststatus(HttpSession session, ApprovalCriteria cri, Model m) throws Exception{
		int deptno=((EmpVO)session.getAttribute("LoginUser")).getDeptno();
		Map<String, Object> map = new HashMap<>();
		map.put("status","완료");
		map.put("deptno", deptno);
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listStatusCount(map, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.listStatus(map,cri));
		return "/approval/liststatus";
	}
	
	/* <결재하기>
	 * 결재시 update 할것  : curr_approval은 결재한사람, next_approval은 결재한사람의 상사로 바꾸기
	 * <반려하기>
	 * 반려시 update 할것 : curr_approval은 작성자로, next_approval은 0으로 바꾸기, status를 반려로 바꾸기
	 * <수정하기 - 작성자에게 반려된 문서만 수정가능>
	 * status는 진행, next_approval을 작성자의 상사로 바꾸기
	 * <결재선>
	 * 전체결재문서(수신부서가 0인것) : 결재선은 사장(직책번호0)까지
	 * 나머지결재문서(수신부서가 0이 아닌것) : 결재선은 부장(직책번호10)까지
	 * <결재완료 처리 - 결재선에 도달한 경우>
	 * curr_approval, next_approval을 0으로 바꾸기
	 * status를 완료로 바꾸기 */
	
	/* ApprovalVO : 결재문서 정보, ApprovalProgressVO : 결재자 정보 */
		
	// 결재하기 (결재/반려)
	@RequestMapping(value="/do_approval",method=RequestMethod.POST)
	public String do_approval(ApprovalVO vo, String comments, String status,HttpSession session,
													RedirectAttributes rttr) throws Exception{
		EmpVO emp = (EmpVO) session.getAttribute("LoginUser");
		if(comments==null || comments.equals("")) comments=null;
		ApprovalProgressVO progressVO = new ApprovalProgressVO(vo.getNo(),emp.getEmpno(),
														emp.getPosition(),emp.getEname(),
														emp.getDeptno(),status.equals("accept"),
														comments);
		service.do_approval(vo, progressVO);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/approval/listmyturn";
	}
	
	// 결재/반려시 입력할 코멘트폼 띄우기
	@RequestMapping("/comment/form")
	public void approval_comment_form()throws Exception{}
	
	// 결재문서에 등록된 첨부파일 다운받기
	@ResponseBody
	@RequestMapping(value="/filedownload")
	public ResponseEntity<byte[]> file_download(String filename,HttpServletRequest request)throws Exception{
		String uploadFolder=PathMaker.getUploadPath(request);
		ResponseEntity<byte[]> entity = null;
		InputStream fis = null;
		try{
			HttpHeaders headers = new HttpHeaders();
			fis = new FileInputStream(uploadFolder+"/"+filename);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment;filename=\""
							+filename+"\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(fis),headers,HttpStatus.CREATED);
		}
		catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		finally{
			fis.close();
		}
		return entity;
	}
}
