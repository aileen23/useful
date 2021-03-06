package kr.co.useful.note.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.useful.board.domain.PageMaker;
import kr.co.useful.board.domain.SearchCriteria;
import kr.co.useful.manager.domain.EmpVO;
import kr.co.useful.note.domain.NoteFindUserVO;
import kr.co.useful.note.domain.RecipientVO;
import kr.co.useful.note.domain.SendVO;
import kr.co.useful.note.service.RecipientService;
import kr.co.useful.note.service.SendService;

@Controller
@RequestMapping("/note")
public class NoteController {
	@Inject
	private SendService service;
	@Inject
	private RecipientService reservice;
	/*@RequestMapping(value="/notePage",method=RequestMethod.GET)
	public void list_note(HttpSession session,Model model,SearchCriteria cri)throws Exception{
		String mynote=((EmpVO) session.getAttribute("LoginUser")).getEname();
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.search_count_note(cri));
		pageMaker.calc();
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.list_note(mynote));
		//model.addAttribute("list", service.search_not(cri));
	};*/
	
	@RequestMapping("/notePage")
	public void list_notePOST(SearchCriteria cri, HttpSession session,Model model)throws Exception{
		System.out.println("들어옴");
		System.out.println(cri.toString());
		String mynote=((EmpVO) session.getAttribute("LoginUser")).getEname();
		System.out.println(mynote);
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.search_count_note(cri,mynote));
		pageMaker.calc();
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.search_not(cri,mynote));
		//model.addAttribute("list", service.list_note(mynote));
	};
	
	@RequestMapping(value="/noteCreatePage",method=RequestMethod.GET)
	public void create_note_get()throws Exception{};
	
	@RequestMapping(value="/noteCreatePage",method=RequestMethod.POST)
	public String create_note(HttpSession session,SendVO vo)throws Exception{
		RecipientVO recipientVO=new RecipientVO();
		String mynote=((EmpVO)session.getAttribute("LoginUser")).getEname();
		recipientVO.setReciid(mynote);
		recipientVO.setMynote(vo.getSendman());
		recipientVO.setRecontent(vo.getSendcontent());
		vo.setMynote(mynote);
		service.recipient_note(recipientVO);
		service.create_note(vo);
		return "redirect:/note/notePage";
	};
	
	
	@RequestMapping("/finduserPage")
	public void noteUserFindPage(Model model,SearchCriteria cri)throws Exception{
		if(cri.getKeyword()!=null){
			List<NoteFindUserVO> list=service.find_user_note(cri);
			model.addAttribute("list", list);
			model.addAttribute("cri", cri);
		}
	};
	@RequestMapping("/noteReadPage")
	public void noteReadPage(HttpSession httpSession,int serial,Model model)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		SendVO vo=new SendVO();
		vo.setMynote(mynote);
		vo.setSerial(serial);
		model.addAttribute("list", service.select_note(vo));
	};
	@RequestMapping("/deletePage")
	public String noteDeletePage(int serial,HttpSession httpSession)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		SendVO vo=new SendVO();
		vo.setMynote(mynote);
		vo.setSerial(serial);
		service.delete_note(vo);
		return "redirect:/note/notePage";
	};
	
	/*--------------여기서 부터 나의 받은 쪽지함내용--------------*/
	/*@RequestMapping(value="noteMyPage",method=RequestMethod.GET)
	public void recipient_note_list(HttpSession httpSession,Model model)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		model.addAttribute("list", reservice.recipient_note_list(mynote));
	};*/
	@RequestMapping("/noteMyPage")
	public void recipient_note_list_search(HttpSession httpSession,Model model,SearchCriteria cri)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.search_count_note(cri,mynote));
		pageMaker.calc();
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", reservice.search_Recipient_note(cri, mynote));
	};
	
	
	
	@RequestMapping("/riciReadPage")
	public void select_recipient_note(RecipientVO recipientVO,HttpSession httpSession,int serial,Model mod)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		System.out.println(serial);
		System.out.println(mynote);
		recipientVO.setSerial(serial);
		recipientVO.setMynote(mynote);
		mod.addAttribute("list",reservice.select_recipient_note(recipientVO));
		
		//mod.addAttribute("list", reservice.select_recipient_note(recipientVO));
		
	};
	
	@RequestMapping("/deletePage2")
	public String recipient_note_noteDeletePage(int serial,HttpSession httpSession)throws Exception{
		String mynote=((EmpVO)httpSession.getAttribute("LoginUser")).getEname();
		RecipientVO recipientVO=new RecipientVO();
		recipientVO.setMynote(mynote);
		recipientVO.setSerial(serial);
		System.out.println(mynote);
		System.out.println(serial);
		reservice.delete_recipient_note(recipientVO);
		return "redirect:/note/noteMyPage";
	};
	
	public void create_recipient_note(RecipientVO recipientVO)throws Exception{
		SendVO sendVO=new SendVO();
		sendVO.setSendman(recipientVO.getReciid());
		sendVO.setMynote(recipientVO.getMynote());
		sendVO.setSendcontent(recipientVO.getRecontent());
		reservice.create_send_note(sendVO);
		reservice.create_recipient_note(recipientVO);
	};
	
	
}
