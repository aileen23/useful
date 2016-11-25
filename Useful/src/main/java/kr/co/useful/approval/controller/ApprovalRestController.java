package kr.co.useful.approval.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.useful.approval.domain.ApprovalRestVO;
import kr.co.useful.approval.service.ApprovalRestService;

@RestController
public class ApprovalRestController {	// �� ������ ������ Ajax ó���� ���� controller
	
	@Inject
	private ApprovalRestService service;
	
	@RequestMapping("/getDept")
	public List<ApprovalRestVO> getDept(int deptno) throws Exception{
		List<ApprovalRestVO> list = service.getDept(deptno);
		return list;
	}
	
}
