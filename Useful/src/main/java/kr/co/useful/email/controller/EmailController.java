package kr.co.useful.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.useful.email.domain.Email;
import kr.co.useful.email.service.EmailSender;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailSender emailSender;
     
    @RequestMapping("/send")
    public String sendEmailAction () throws Exception {
 
        Email email = new Email();
         
        String reciver = "chw120424@naver.com"; //��������� �̸����Դϴ�.
        String subject = "�׽�Ʈ!!";
        String content = "���� �Ǿ��...";
         
        email.setReciver(reciver);
        email.setSubject(subject);
        email.setContent(content);
        emailSender.SendEmail(email);
         
        return "login/Main2";
    }
}
