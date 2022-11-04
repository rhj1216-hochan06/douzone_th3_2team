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
		}else
			System.out.println("service code error");
	}

	////////////////////////////////////////////////////////////////////
	// 전체조회
	////////////////////////////////////////////////////////////////////
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);

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

		if (memberpwd.equals(dto2.getMemberpwd()))// 로그인 성공
		{

			// 로그인이 되면
			System.out.println("로그인 성공 ");
			HttpSession session;
			session = request.getSession();

			// 로그인 세션값 설정
			session.setAttribute("memberid", memberid);
			session.setAttribute("membername", dto2.getMembername());
			System.out.println("login memberid 확인: " + session.getAttribute("memberid"));
			System.out.println("login membername 확인: " + session.getAttribute("membername"));

			// 세션 유지시간 설정(초단위) 20분
			session.setMaxInactiveInterval(20 * 60);

			request.setAttribute("dto", dto2); // data save
			request.setAttribute("memberid", memberid);
			request.setAttribute("membername", dto2.getMembername());

			System.out.println(request.getAttribute("dto").toString());

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

	////////////////////////////////////////////////////////////////////
	// 전체조회 끝
	////////////////////////////////////////////////////////////////////
}
