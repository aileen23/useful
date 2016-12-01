package kr.co.useful.approval.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.useful.approval.domain.ApprovalCommentVO;
import kr.co.useful.approval.service.ApprovalCommentService;

@Controller
@RequestMapping("/approval/comment")
public class ApprovalCommentController {
	
	@Inject
	private ApprovalCommentService service;
	
	// Ư�� ���繮���� ����� �ڸ�Ʈ�� ���� ������ (1�� �̻��϶� �ڸ�Ʈ ����Ʈ�� ���� ���� Ajax ó����)
	@RequestMapping("/count/{no}")
	public @ResponseBody int getCommentCount(@PathVariable int no) throws Exception{
		return service.listcount(no);
	}

	// �ڸ�Ʈ�� 1�� �̻��� �� �ڸ�Ʈ ����Ʈ ����
	@RequestMapping(value="/list/{no}")
	public String list(@PathVariable int no,Model m)throws Exception{
		m.addAttribute("list", service.list(no));
		return "/approval/comment/view";
	}
}
