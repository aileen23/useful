package kr.co.useful.approval.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.useful.approval.domain.ApprovalRestVO;
import kr.co.useful.approval.service.ApprovalRestService;

@RestController
public class ApprovalRestController {	// �Է��� ������ ������ Ajax ó���� ���� controller
	
	@Inject
	private ApprovalRestService service;
	
	@RequestMapping("/approval/getDept")		// �ۼ����� �μ� �� Ÿ�μ��� ���� ���
	public List<ApprovalRestVO> getDept(int deptno) throws Exception{
		List<ApprovalRestVO> list = service.getDept(deptno);
		return list;
	}
	
	@RequestMapping("/approval/getLine")		// ���缱 ���� ���
	public List<ApprovalRestVO> getLine(ApprovalRestVO vo) throws Exception{
		List<ApprovalRestVO> list = service.getLine(vo);
		return list;
	}
	
}
