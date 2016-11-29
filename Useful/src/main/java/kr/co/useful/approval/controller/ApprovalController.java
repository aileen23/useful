package kr.co.useful.approval.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.useful.approval.domain.ApprovalVO;
import kr.co.useful.approval.service.ApprovalService;
import kr.co.useful.manager.domain.EmpVO;

@Controller
@RequestMapping("/approval")
public class ApprovalController {
	
	@Inject
	private ApprovalService service;
	
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET)
	public String read(Model m,@PathVariable int no) throws Exception{
		m.addAttribute("vo", service.select(no));
		return "/approval/read";
	}
	

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		return "/approval/form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String insert(ApprovalVO vo) throws Exception{
		service.create(vo);
		return "/approval/form";
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
		int empno=((EmpVO)session.getAttribute("LoginUser")).getEmpno();
		Map<String, Object> map = new HashMap<>();
		map.put("status","�Ϸ�");
		map.put("deptno", service.getMyDeptno(empno));	// ������� �μ���ȣ �� ��ȸ ���� ����
		m.addAttribute("list", service.listStatus(map));
		return "/approval/list";
	}
}
