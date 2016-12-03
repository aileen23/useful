package kr.co.useful.login.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.useful.email.domain.Email;
import kr.co.useful.email.service.EmailSender;
import kr.co.useful.login.service.LoginService;
import kr.co.useful.manager.domain.EmpVO;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Inject
	private LoginService service;
	
	 @Autowired
	    private EmailSender emailSender;
	
	//�α��� �� ���̱�
	@RequestMapping("/Login")
	public void login(){
		
	}
	
	//�α��� üũ
	@RequestMapping("/Main")
	public ResponseEntity<String> main(HttpServletRequest req,HttpSession session){
		
		ResponseEntity<String> entity = null;
		
		String empno = req.getParameter("empno");
		String pass = req.getParameter("pass");
		
		try {
			String dpass = service.select(Integer.parseInt(empno)).getPass();
			if(pass.equals(dpass)){
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
			service.update(Integer.parseInt(empno));
			EmpVO vo = service.selectLoginUser(Integer.parseInt(empno), dpass);
			if(vo != null){
				session.setAttribute("LoginUser", vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return entity;
	}
	
	//�ʱ� �α��� ������ ��й�ȣ ������
	@RequestMapping("/Modify_Pass")
	public void modifyPass(){
		
	}
	
	@RequestMapping(value="/checkpass",method=RequestMethod.POST)
	public @ResponseBody String checkPass(HttpServletRequest req)throws Exception{
		int empno = ((EmpVO)(req.getSession().getAttribute("LoginUser"))).getEmpno();
		String password = req.getParameter("password");
		
		service.updatepass(empno, password);
		
		return "SUCCESS";
	}
	
	//�α��� ������ �����ִ� ���κ�
	@RequestMapping("/Mainview")
	public String main_view(){

		return "/login/Main2";
	}
	
	//�α׾ƿ� �������� ���� ����
	@RequestMapping("/Logout")
	public void logout(HttpSession session){
		
	}
	
	//�α��� ������ ��й�ȣ ã�� ������ �� ��
	@RequestMapping("/Search_Pass")
	public void searchPass()throws Exception{
		
	}

	//��й�ȣ ã�� ������ ����� �̸����ּҿ� �ش��ϴ� ���ڵ尡 �ִ��� Ȯ��, �ӽ� ��й�ȣ �߼�
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public @ResponseBody String check(EmpVO vo)throws Exception{
		EmpVO empVO=service.selectAll(vo); //���, �̸�, �̸��� �̾ƿ�.
		
		if(empVO!=null){
			
			 Email email = new Email();
		        
		        int num = EmailSender.generateNumber(6);
		                
		        String subject = "�ӽ� ��й�ȣ�� �߼��ص帳�ϴ�.";
		        String content = "�ӽ� ��й�ȣ��" + num + "�Դϴ�.";
		        String pass = ""+num;
		        
		        email.setReciver(empVO.getEmail());
		        email.setSubject(subject);
		        email.setContent(content);
		        emailSender.SendEmail(email);
		        
		        service.updatepass(empVO.getEmpno(),pass);
		        
		        return "SUCCESS";
		}else
			return "FAIL";
	}
	
	
	
	
	//��й�ȣ ��ȣȭ �۾�
	@RequestMapping("/Encrypt")
	public void encrypt(){
		
	}
}
