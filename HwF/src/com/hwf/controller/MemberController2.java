package com.hwf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwf.dao.MemberDAO;
import com.hwf.model.MemberDTO;



@Controller //컨트롤러 빈
public class MemberController2 {


	@Inject
	MemberDAO MemberDao; 
	
	
	@RequestMapping("/") //시작 페이지
	public String home(Model model) {
		model.addAttribute("key", "스프링 시큐리티 테스트 입니다");
		return "home"; //home.jsp로 이동
	}
	//로그인 페이지로 이동
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	//회원가입 페이지로 이동
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	//회원가입 처리 	
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam String userid, 
			@RequestParam String passwd,
			@RequestParam String name, 
			@RequestParam String authority) {
		
		return "user/login"; // login.jsp로 이동
	}
	//예지 페이지로 이동 하면된다
	//관리자 영역 페이지 (테스트용)
	   @RequestMapping("/main")
	   public String admin(HttpSession session) {
	      if(session.getAttribute("memberid").equals("ADMIN")) return "admin/main";
	      else if(session.getAttribute("memberid").equals("admin")) return "admin/main";
	      else return "main";
	   }
	
	//관리자 영역 페이지	
	@RequestMapping("/user/")
	public String user() {
		return "user/userMain";
	}
	
	//로그인
	public void authenticationMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      String memberid = request.getParameter("memberid");
	      String memberpwd = request.getParameter("memberpwd");
	      
	      
	    
	      MemberDTO dto = new MemberDTO(memberid, memberpwd);  //회원 id와 pwd를 세팅
	      
	      boolean check = MemberDao.checkMember(dto);
	      
	      //로그인이 되면
	      if(check == true) {
	         HttpSession session;
	         session = request.getSession();
	   
	         //로그인 세션값 설정
	         session.setAttribute("memberid", memberid);
	         System.out.println("login memberid 확인: " + session.getAttribute("memberid"));
	         //세션 유지시간 설정(초단위) 20분
	         session.setMaxInactiveInterval(20*60);
	         
	         response.sendRedirect("/web/main");
	      } else {
	         response.sendRedirect("/web/member?cmd=login");
	      }
	   }


	}
	











