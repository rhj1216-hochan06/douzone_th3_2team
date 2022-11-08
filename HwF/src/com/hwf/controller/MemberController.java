package com.hwf.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.InbodyDAO;
import com.hwf.dao.MemberDAO;
import com.hwf.dao.SurveyDAO;
import com.hwf.model.InbodyDTO;
import com.hwf.model.MemberDTO;
import com.hwf.model.SurveyDTO;

@WebServlet("/Member")
public class MemberController extends HttpServlet {

	@Inject
	MemberDAO MemberDao;

	public MemberController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

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
		} else if (cmd.equals("logout")) {
			logout(request, response);
		} else if (cmd.equals("survey")) {
			survey(request, response);
		} else if (cmd.equals("surveyresult")) {
			surveyresult(request, response);
		} else if (cmd.equals("inbody")) {
			inbody(request, response);
		} else if (cmd.equals("inbodyresult")) {
			inbodyresult(request, response);
		} else
			System.out.println("service code error");
	}

	////////////////////////////////////////////////////////////////////
	// 전체조회
	////////////////////////////////////////////////////////////////////
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session;
			session = request.getSession();
			String name = session.getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님"))
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		} catch (Exception e) {
			// null 이면 에러 발생 = 로그인 기록 없음
			System.out.println("login error");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/jsp/member/mypage.jsp").forward(request, response);
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
			session.setAttribute("membername1", dto2.getMembername() + "님 환영합니다.");
			session.setAttribute("membersex", membersex);

			System.out.println("memberid 확인: " + session.getAttribute("memberid").toString());
			System.out.println("membername: " + session.getAttribute("membername").toString());
			System.out.println("membersex: " + session.getAttribute("membersex").toString());

			// 세션 유지시간 설정(초단위) 20분
			session.setMaxInactiveInterval(20 * 60);

			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

	}

	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/join.jsp").forward(request, response);

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
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		} else {
			System.out.println("회원가입 실패");
			request.getRequestDispatcher("/views/jsp/member/join.jsp").forward(request, response);
		}
	}

	public void survey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/survey.jsp").forward(request, response);

	}

	public void surveyresult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);

		String goal = request.getParameter("goal");
		String currentstate = request.getParameter("currentstate");
		String currentintke = request.getParameter("currentintke");
		String memberid = session.getAttribute("memberid").toString();
		String link = "";

		if (goal.equals("1")) {
			link = "증량";
			goal = "증량";
			session.setAttribute("link", link);
			session.setAttribute("goal", goal);
		} else if (goal.equals("2")) {
			link = "다이어트";
			goal = "감량";
			session.setAttribute("link", link);
			session.setAttribute("goal", goal);
		}

		if (currentstate.equals("1")) {
			currentstate = "비만";
			session.setAttribute("currentstate", currentstate);
		} else if (currentstate.equals("2")) {
			currentstate = "정상";
			session.setAttribute("currentstate", currentstate);
		} else if (currentstate.equals("3")) {
			currentstate = "왜소";
			session.setAttribute("currentstate", currentstate);
		}

		if (currentintke.equals("1")) {
			currentintke = "과다";
			session.setAttribute("currentintke", currentintke);
		} else if (currentstate.equals("2")) {
			currentintke = "정상";
			session.setAttribute("currentintke", currentintke);
		} else if (currentstate.equals("3")) {
			currentintke = "부족";
			session.setAttribute("currentintke", currentintke);
		}
		memberid = session.getAttribute("memberid").toString();
		System.out.println(goal);
		System.out.println(currentstate);
		System.out.println(currentintke);
		System.out.println(memberid);

		SurveyDTO dto = new SurveyDTO(goal, currentstate, currentintke, link, memberid);
		SurveyDAO dao = new SurveyDAO();

		int rowcount = dao.insert(dto);

		if (rowcount > 0) {
			// 성공
			request.getRequestDispatcher("/views/jsp/member/surveyresult.jsp").forward(request, response);
		} else {
			System.out.println("설문 실패");
			request.getRequestDispatcher("/views/jsp/member/survey.jsp").forward(request, response);
		}

	}

	public void inbody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/inbody.jsp").forward(request, response);

	}

	public void inbodyresult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);

		String memberheight = request.getParameter("memberheight"); // 키
		String memberweight = request.getParameter("memberweight"); // 몸무게
		String bodymuscle = request.getParameter("bodymuscle"); // 근육량
		String bodyfat = request.getParameter("bodyfat"); // 체지방량
		String inbodyresult = "";// 상태 결과 bmi
		String link = "";
		double iresult = Double.parseDouble(memberweight)
				/ ((Double.parseDouble(memberheight) / 100) * (Double.parseDouble(memberheight) / 100));

		System.out.println("iresult" + iresult);
		inbodyresult = String.format("%.2f", iresult);

		int ir = (int) (iresult * 10);
		System.out.println("ir" + ir);

		if (ir < 185) {// 저체중
			link = "증량";
		} else if (185 <= ir && ir < 229) {// 정상
			link = "둘다";
		} else {// 과체중
			link = "다이어트";
		}
		if (20 < Integer.parseInt(bodyfat)) {
			link = "다이어트";
		}
		String memberid = session.getAttribute("memberid").toString();

		InbodyDTO dto = new InbodyDTO(Integer.parseInt(memberheight), Integer.parseInt(memberweight), bodymuscle,
				bodyfat, inbodyresult, link, memberid);
		InbodyDAO dao = new InbodyDAO();
		int rowcount = dao.insert(dto);

		if (rowcount > 0) {
			// 성공
			session.setAttribute("memberheight", memberheight);
			session.setAttribute("memberweight", memberweight);
			session.setAttribute("bodymuscle", bodymuscle);
			session.setAttribute("bodyfat", bodyfat);
			session.setAttribute("inbodyresult", inbodyresult);
			session.setAttribute("link", link);
			session.setAttribute("memberid", memberid);

			request.getRequestDispatcher("/views/jsp/member/inbodyresult.jsp").forward(request, response);
		} else {
			System.out.println("설문 실패");
			request.getRequestDispatcher("/views/jsp/member/inbody.jsp").forward(request, response);
		}

	}

	public void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/mypage.jsp").forward(request, response);

	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session;
			session = request.getSession();
			session.setAttribute("membername1", "환영합니다. 고객님");
			session.setAttribute("memberid", "");

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

		request.getRequestDispatcher("/Main.jsp").forward(request, response);
	}
	////////////////////////////////////////////////////////////////////
	// 전체조회 끝
	////////////////////////////////////////////////////////////////////
}