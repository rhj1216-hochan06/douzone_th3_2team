package com.hwf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.hwf.dao.MemberDAO;
import com.hwf.model.MemberDTO;

@WebServlet("/Member")
public class MemberController extends HttpServlet {
	
	@Inject
	MemberDAO MemberDao;

	public MemberController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		System.out.println("cmd : " + cmd);
		if (cmd.equals("login")) {
			login(request, response);
		} else if (cmd.equals("logincheck")) {
			logincheck(request, response);
		} else if (cmd.equals("join")) {
			join(request, response);
		} else if (cmd.equals("mypage")) {
			mypage(request, response);
		} else if (cmd.equals("insertmember")) {
			insertmember(request, response);
		}  else if (cmd.equals("logout")) {
			logout(request, response);
		}else
			
			System.out.println("service code error");
	}

	////////////////////////////////////////////////////////////////////
	// 전체조회
	////////////////////////////////////////////////////////////////////
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session;
			session = request.getSession();
			String name = session .getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님"))
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		} catch (Exception e) {
			//null 이면 에러 발생 = 로그인 기록 없음
			System.out.println("login error");
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		}  
		request.getRequestDispatcher("/views/jsp/mypage.jsp").forward(request, response);
	}

	public void logincheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberid = request.getParameter("memberid");
		String memberpwd = request.getParameter("memberpwd");

		MemberDTO dto = new MemberDTO(memberid, memberpwd); // 회원 id와 pwd를 세팅

		MemberDAO dao = new MemberDAO();

		// boolean check = dao.checkMemberb(dto);
		// List<MemberDTO> list = dao.checkMember(dto);

		MemberDTO dto2 = dao.checkMember(dto);
		System.out.println("로그인 정보 불러오기 ");
		System.out.println(dto2.getMemberid().toString());

		HttpSession session;
		session = request.getSession();
		
		
		
		
		
		if (memberpwd.equals(dto2.getMemberpwd()))// 로그인 성공
		{

			// 로그인이 되면
			System.out.println("로그인 성공 ");
			
			
			String membersex = "";

			if (dto2.getMembersex().equals("1"))
				membersex = "남자";
			else
				membersex = "여자";

			// data save

			
			
			
	        session.setAttribute("memberid", memberid);
	        session.setAttribute("membername", dto2.getMembername());
	        session.setAttribute("membername1", dto2.getMembername()+"님 환영합니다.");
	        session.setAttribute("membersex", membersex);
	        
	        System.out.println("memberid 확인: " + session.getAttribute("memberid").toString());
	        System.out.println("membername: " +  session.getAttribute("membername").toString());
	        System.out.println("membersex: " +  session.getAttribute("membersex").toString());
	        
	        //세션 유지시간 설정(초단위) 20분
	        session.setMaxInactiveInterval(20*60);
			
			
		


			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		}

	}

	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/join.jsp").forward(request, response);

	}

	public void insertmember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberid = request.getParameter("userid");
		String memberpwd = request.getParameter("passwd");
		String membername = request.getParameter("name");
		String membersex = request.getParameter("sex");

		MemberDTO dto = new MemberDTO(memberid, memberpwd, membername, membersex); // 회원 id와 pwd를 세팅

		MemberDAO dao = new MemberDAO();
		System.out.println(dto.toString());

		int rowcount = dao.insert(dto);

		if (rowcount > 0) {
			// 성공
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("회원가입 실패");
			request.getRequestDispatcher("/views/jsp/join.jsp").forward(request, response);
		}
	}

	public void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/mypage.jsp").forward(request, response);

	}
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {HttpSession session;
			session = request.getSession();
			session.setAttribute("membername1","환영합니다. 고객님");
			

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		}  
	
		request.getRequestDispatcher("/Main.jsp").forward(request, response);
	}
	////////////////////////////////////////////////////////////////////
	// 전체조회 끝
	////////////////////////////////////////////////////////////////////
}
