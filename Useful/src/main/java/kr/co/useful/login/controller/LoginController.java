package kr.co.useful.login.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.co.useful.login.service.LoginService;
import kr.co.useful.manager.domain.EmpVO;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Inject
	private LoginService service;
	
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
		System.out.println("pass : " + pass);
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
	public void searchPass(){
		
	}
	
	//�ʱ� �α��� ������ ��й�ȣ ������
	@RequestMapping("/Modify_Pass")
	public void modifyPass(){
		
	}
	
	//��й�ȣ ��ȣȭ �۾�
	@RequestMapping("/Encrypt")
	public void encrypt(){
		
	}
}
