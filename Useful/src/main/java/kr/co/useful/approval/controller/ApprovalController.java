package kr.co.useful.approval.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
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

import kr.co.useful.approval.domain.ApprovalCriteria;
import kr.co.useful.approval.domain.ApprovalPageMaker;
import kr.co.useful.approval.domain.ApprovalProgressVO;
import kr.co.useful.approval.domain.ApprovalVO;
import kr.co.useful.approval.service.ApprovalService;
import kr.co.useful.manager.domain.EmpVO;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	@Inject
	private ApprovalService service;
	
	// Ư�� ���� ��ȸ
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET)
	public String read(HttpServletRequest request,Model m,@PathVariable int no) throws Exception{
		m.addAttribute("vo", service.select(no));
		return "/approval/read";
	}
	
	// ��� �ۼ��� ����
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		return "/approval/form";
	}
	
	// �ۼ��� ��� ���
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String insert(ApprovalVO vo, MultipartFile file, HttpServletRequest request) throws Exception{
		// ���Ͼ��ε� ��� ���� (�� pc�� git ������ src/main/webapp/upload )
		service.create(vo, file, request);
		return "/approval/complete";
	}
		
	// ��� ������ ���� (�ݷ��� ������ �ۼ��ڰ� ������ ���� ����)
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(int no,Model m) throws Exception{
		m.addAttribute("vo", service.select(no));
	}
	
	// ��� �����ϱ� (������� + �������¸� '�ݷ�->����'���� ����)
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String update(ApprovalVO vo,MultipartFile file,
								String oldfilename, HttpServletRequest request) throws Exception{
		EmpVO empVO = (EmpVO) request.getSession().getAttribute("LoginUser");
		vo.setCurr_approval(empVO.getEmpno());
		service.update(vo,file,request,oldfilename);
		return "/approval/complete";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(ApprovalVO vo,String oldfilename,HttpServletRequest request) throws Exception{
		vo.setFilename(oldfilename);
		service.delete(vo,request);
		return "/approval/complete";
	}
	
	/* ���� ����Ʈ ��ȸ
	1. ����Ϸ��̰� ���źμ��� �츮�μ� �Ǵ� ��ü�ΰ� ��ȸ -> ���γ�����ȸ
	2. �츮�μ������� ���� �������ΰ�			-> ���γ�����ȸ
	3. ���� �ۼ��� �� -> �ݷ��ȰŴ� �������
	4. ���� ������ �����ΰ� -> �����ϱ�
	 */
	
	@RequestMapping("/listmine")	// ���� �ۼ��� ���� ��ȸ
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

	@RequestMapping("/listmyturn")	// ���� ������ �����ΰ� ��ȸ
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
	
	@RequestMapping("/listdept")	// ���źμ��� �츮�μ� or ��ü�� ���� ��ȸ
	public String listdept(HttpSession session, ApprovalCriteria cri, Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		int empno=((EmpVO)session.getAttribute("LoginUser")).getEmpno();
		vo.setReceiver(service.getMyDeptno(empno));	// ������� �μ���ȣ �� ��ȸ ���� ����
		vo.setStatus("�Ϸ�");							// ����Ϸ��� ���·� ���� ����
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listCount(vo, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.list(vo,cri));
		return "/approval/listdept";
	}
	
	@RequestMapping("/liststatus")	// �츮�μ������� ���� �������ΰ� ��ȸ (�߽źμ� ��ȸ)
	public String liststatus(HttpSession session, ApprovalCriteria cri, Model m) throws Exception{
		int deptno=((EmpVO)session.getAttribute("LoginUser")).getDeptno();
		Map<String, Object> map = new HashMap<>();
		map.put("status","�Ϸ�");
		map.put("deptno", deptno);
		ApprovalPageMaker pagemaker = new ApprovalPageMaker();
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(service.listStatusCount(map, cri));
		m.addAttribute("pagemaker",pagemaker);
		m.addAttribute("list", service.listStatus(map,cri));
		return "/approval/liststatus";
	}
	
	/* <�����ϱ�>
	 * ����� update �Ұ�  : curr_approval�� �����ѻ��, next_approval�� �����ѻ���� ���� �ٲٱ�
	 * <�ݷ��ϱ�>
	 * �ݷ��� update �Ұ� : curr_approval�� �ۼ��ڷ�, next_approval�� 0���� �ٲٱ�, status�� �ݷ��� �ٲٱ�
	 * <�����ϱ� - �ۼ��ڿ��� �ݷ��� ������ ��������>
	 * status�� ����, next_approval�� �ۼ����� ���� �ٲٱ�
	 * <���缱>
	 * ��ü���繮��(���źμ��� 0�ΰ�) : ���缱�� ����(��å��ȣ0)����
	 * ���������繮��(���źμ��� 0�� �ƴѰ�) : ���缱�� ����(��å��ȣ10)����
	 * <����Ϸ� ó�� - ���缱�� ������ ���>
	 * curr_approval, next_approval�� 0���� �ٲٱ�
	 * status�� �Ϸ�� �ٲٱ� */
	
	/* ApprovalVO : ���繮�� ����, ApprovalProgressVO : ������ ���� */
		
	// �����ϱ� (����/�ݷ�)
	@RequestMapping(value="/do_approval",method=RequestMethod.POST)
	public String do_approval(ApprovalVO vo, String comments, String status,HttpSession session) throws Exception{
		EmpVO emp = (EmpVO) session.getAttribute("LoginUser");
		ApprovalProgressVO progressVO = new ApprovalProgressVO(vo.getNo(),emp.getEmpno(),emp.getPosition(),emp.getEname(),emp.getDeptno(),status.equals("accept"),comments);
		service.do_approval(vo, progressVO);
		return "/approval/complete"; 
	}
	
	// ����/�ݷ��� �Է��� �ڸ�Ʈ�� ����
	@RequestMapping("/comment/form")
	public void approval_comment_form()throws Exception{}
	
	// ���繮���� ��ϵ� ÷������ �ٿ�ޱ�
	@ResponseBody
	@RequestMapping(value="/filedownload")
	public ResponseEntity<byte[]> file_download(String filename,HttpServletRequest request)throws Exception{
		ServletContext application = request.getServletContext();
		String realpath=application.getRealPath("").replace('\\', '/');
		String uploadFolder = realpath.substring(0, realpath.indexOf("/workspace"))+"/git"
				+application.getContextPath()
				+"/"+application.getInitParameter("projectName")
				+"/src/main/webapp/upload";
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
