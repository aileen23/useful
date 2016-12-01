package kr.co.useful.sharetask.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import kr.co.useful.sharetask.domain.Criteria;
import kr.co.useful.sharetask.domain.PageMaker;
import kr.co.useful.sharetask.domain.SearchCriteria;
import kr.co.useful.sharetask.domain.ShareTaskVO;
import kr.co.useful.sharetask.service.ShareTaskService;



@Controller
@RequestMapping("/sharetask")
public class ShareTaskController {
	private static final Logger logger = LoggerFactory.getLogger(ShareTaskController.class);
	
	@Inject
	private ShareTaskService service;
	
	
	//����Ʈ
	@RequestMapping(value = "share_Board", method = RequestMethod.GET)
	public void shareList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception {
	
		cri.setDeptno(20);
	 	model.addAttribute("list", service.listSearchCriteria(cri));
	 	
	    System.out.println("����Ʈ!!!:"+cri );
	 	
	 	
		PageMaker maker = new PageMaker();
	 	maker.setCri(cri);
	 	maker.setTotalCount(service.listSearchCount(cri));
	 	model.addAttribute("pageMaker", maker);
	 	
	}
	
	//�Է�get
	@RequestMapping(value = "/share_Input", method = RequestMethod.GET) 
	public void registerGET() {
		logger.info("�Է���");
		System.out.println("�Է��� ��û........");
	}
	
	//�Է�post
	@RequestMapping(value = "/insert", method = RequestMethod.POST) 
	public String registerPOST(ShareTaskVO vo, RedirectAttributes attr) throws Exception {
		//logger.info("DB�Է� ��û........");
		System.out.println(vo);
		service.regist(vo);
		
		return "redirect:/sharetask/share_Board";
	}

	
	//�� 
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String modifyPageGet(int bno,
            @ModelAttribute("cri") SearchCriteria cri,
            Model model) throws Exception {

		// ������ ����
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
		System.out.println(model);
		System.out.println(cri);
		
		return "/sharetask/share_Select";
	}
	
	
	@RequestMapping("/prev")
	public String prevRead(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		//������ ����
		model.addAttribute(service.prevRead(bno));
		model.addAttribute("cri", cri);
		System.out.println(model);
		return "/sharetask/share_Select";	
	}
	
	public String nextRead(){
		return "";
	}
	  
	// �󼼿��� ����
	@RequestMapping(value ="/change", method = RequestMethod.POST)
	public String modifyPagePost(ShareTaskVO vo, SearchCriteria cri, RedirectAttributes attr) throws Exception {
		   
		System.out.println("�������� = "+vo);
		   service.change(vo);//�����۾�
	
		   attr.addAttribute("page", cri.getPage() );
		   attr.addAttribute("perPageNum", cri.getPerPageNum() );
		   attr.addAttribute("searchType", cri.getSearchType() );
		   attr.addAttribute("keyword", cri.getKeyword() );
		   
		return "redirect:/sharetask/share_Board";
	}

	
	@RequestMapping("/remove")
	public String deletePage(int bno, RedirectAttributes attr, Criteria
			cri) throws Exception {
		
		service.remove(bno);
		attr.addAttribute("page", cri.getPage());
		return "redirect:/sharetask/share_Board";
	}
	

	
	
	
	
}
