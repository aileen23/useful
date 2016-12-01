package kr.co.useful.approval.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String insert(ApprovalVO vo) throws Exception{
		int deptno=vo.getReceiver();
		if(deptno!=0)
			vo.setReceiver_dname(service.getDname(deptno));	// ����ó �μ���ȣ�� �μ��� �� vo�� ����
		else
			vo.setReceiver_dname("��ü");			// ����ó �μ���ȣ�� 0�̸� vo�� ���źμ����� ��ü�� ����
		service.create(vo);
		return "/approval/complete";
	}
		
	// ��� ������ ���� (�ݷ��� ������ �ۼ��ڰ� ������ ���� ����)
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(int no,Model m) throws Exception{
		m.addAttribute("vo", service.select(no));
	}
	
	// ��� �����ϱ� (������� + �������¸� '�ݷ�->����'���� ����)
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String update(ApprovalVO vo,HttpSession session,Model m) throws Exception{
		vo.setCurr_approval(((EmpVO)session.getAttribute("LoginUser")).getEmpno());
		service.update(vo);
		return "/approval/complete";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(ApprovalVO vo) throws Exception{
		int no=vo.getNo();
		service.delete(no);
		return "/approval/complete";
	}
	
	/* ���� ����Ʈ ��ȸ
	1. ����Ϸ��̰� ���źμ��� �츮�μ� �Ǵ� ��ü�ΰ� ��ȸ -> ���γ�����ȸ
	2. �츮�μ������� ���� �������ΰ�			-> ���γ�����ȸ
	3. ���� �ۼ��� �� -> �ݷ��ȰŴ� �������
	4. ���� ������ �����ΰ� -> �����ϱ�
	 */
	@RequestMapping("/listmine")	// ���� �ۼ��� ���� ��ȸ
	public String listmine(HttpSession session, Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		vo.setWriter(((EmpVO)session.getAttribute("LoginUser")).getEmpno());
		m.addAttribute("list", service.list(vo));
		return "/approval/list";
	}

	@RequestMapping("/listmyturn")	// ���� ������ �����ΰ� ��ȸ
	public String listmyturn(HttpSession session,Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		vo.setNext_approval(((EmpVO)session.getAttribute("LoginUser")).getEmpno());
		m.addAttribute("list", service.list(vo));
		return "/approval/list";
	}
	
	@RequestMapping("/listdept")	// ���źμ��� �츮�μ� or ��ü�� ���� ��ȸ
	public String listdept(HttpSession session, Model m) throws Exception{
		ApprovalVO vo = new ApprovalVO();
		int empno=((EmpVO)session.getAttribute("LoginUser")).getEmpno();
		vo.setReceiver(service.getMyDeptno(empno));	// ������� �μ���ȣ �� ��ȸ ���� ����
		vo.setStatus("�Ϸ�");							// ����Ϸ��� ���·� ���� ����
		m.addAttribute("list", service.list(vo));
		return "/approval/list";
	}
	
	@RequestMapping("/liststatus")	// �츮�μ������� ���� �������ΰ� ��ȸ (�߽źμ� ��ȸ)
	public String liststatus(HttpSession session, Model m) throws Exception{
		int deptno=((EmpVO)session.getAttribute("LoginUser")).getDeptno();
		Map<String, Object> map = new HashMap<>();
		map.put("status","�Ϸ�");
		map.put("deptno", deptno);
		m.addAttribute("list", service.listStatus(map));
		return "/approval/list";
	}
	
	/* <�����ϱ�>
	 * ����� update �Ұ�  : curr_approval�� �����ѻ��, next_approval�� �����ѻ���� ���� �ٲٱ�
	 * <�ݷ��ϱ�>
	 * �ݷ��� update �Ұ� : curr_approval, next_approval ��� �ۼ��ڷ� �ٲٱ�, status�� �ݷ��� �ٲٱ�
	 * <�����ϱ� - �ۼ��ڿ��� �ݷ��� ������ ��������>
	 * status�� ����, next_approval�� �ۼ����� ���� �ٲٱ�
	 * <���缱>
	 * ��ü���繮��(���źμ��� 0�ΰ�) : ���缱�� ����(��å��ȣ0)����
	 * ���������繮��(���źμ��� 0�� �ƴѰ�) : ���缱�� ����(��å��ȣ10)����
	 * <����Ϸ� ó�� - ���缱�� ������ ���>
	 * curr_approval, next_approval�� 0���� �ٲٱ�
	 * status�� �Ϸ�� �ٲٱ� */
	
	/* ApprovalVO : ���繮�� ����, ApprovalProgressVO : ������ ���� */
	
/*	// ���� ����(���������ڷ� �������� or ����Ϸ�ó��)
	@RequestMapping(value="/accept",method=RequestMethod.POST)
	public String approval_accept(ApprovalVO vo, HttpSession session) throws Exception{
		EmpVO emp = (EmpVO) session.getAttribute("LoginUser");
		ApprovalProgressVO progressVO = new ApprovalProgressVO(vo.getNo(),emp.getEmpno(),emp.getPosition(),emp.getEname(),emp.getDeptno(),true);
		service.do_approval(vo, progressVO);
		return "/approval/complete";
	}
	
	// ���� �ݷ�(������ ������ �ۼ��ڷ� ����, ���������� �ݷ��� ����)
	@RequestMapping(value="/reject", method=RequestMethod.POST)
	public String approval_reject(ApprovalVO vo, HttpSession session) throws Exception{
		EmpVO emp = (EmpVO) session.getAttribute("LoginUser");
		ApprovalProgressVO progressVO = new ApprovalProgressVO(vo.getNo(),emp.getEmpno(),emp.getPosition(),emp.getEname(),emp.getDeptno(),false);
		service.do_approval(vo, progressVO);
		return "/approval/complete";
	}*/
	
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
}
