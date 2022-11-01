package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwf.dao.HealthGoodsDAO;
import com.hwf.dao.MemberDAO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.MemberDTO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	
	//디폴트 생성자
	public MemberController() {
	
	}
	
	
	//index.html에서 쓰인 'cmd'
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //request에 set
		
		String cmd = request.getParameter("cmd"); //~~~?cmd=AdminMemberSelect
		System.out.println("cmd : " + cmd); //Console창 출력테스트
		
		if (cmd.equals("AdminMemberSelect")) { //http://localhost:8080/HwF/member?cmd=AdminMemberSelect
			AdminMemberSelect(request, response);
		} 
		else if (cmd.equals("HealthGoodsSelect")) {
			HealthGoodsSelect(request, response);
		} 
//		else if (cmd.equals("select")) {
//			select(request, response);
//		} 
//		else if (cmd.equals("update")) {
//			update(request, response);
//		} 
//		else if (cmd.equals("delete")) {
//			delete(request, response);
//		} 
//		else if (cmd.equals("detail")) {
//			detail(request, response);
//		}
	} //end service()
	
	
	

	//관리자 + 회원) 헬스용품 조회
	public void HealthGoodsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> HealthGoodsSelect = dao.HealthGoodsSelect();
		
		if (HealthGoodsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); //data save
			request.getRequestDispatcher("/views/jsp/HealthGoodsSelect.jsp").forward(request, response); //getRequestDispatcher : 데이터 넘겨주는 메소드 (값들만 forward)
			//response.sendRedirect("/views/jsp/HealthGoodsSelect.jsp");
		} 
		else {
			response.sendRedirect("/views/jsp/error.jsp"); //추후에 error페이지 만든 후 error 처리
		}
	} 
	
	
	
	//관리자) 회원 조회
	public void AdminMemberSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> AdminMemberSelect = dao.AdminMemberSelect(); //MemberDAO의 AdminMemberSelect()메소드의 return값을 MemberDTO형태의 AdminMemberSelect변수에 담음
		
		if (AdminMemberSelect != null) {
			request.setAttribute("AdminMemberSelect", AdminMemberSelect); //data save
			request.getRequestDispatcher("/views/jsp/AdminMemberSelect.jsp").forward(request, response); //getRequestDispatcher : 데이터 넘겨주는 메소드 (값들만 forward)
			//response.sendRedirect("/views/jsp/AdminMemberSelect.jsp");
		} 
		else {
			response.sendRedirect("/views/jsp/error.jsp"); //추후에 error페이지 만든 후 error 처리
		}
	} 
	
	

	/*
	public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("write page 여기까지 왔는지?");
		
//		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("euc-kr"); //response에 set
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println(title + ",\t" + writer +",\t" + content);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(title, writer, content);
		
		int rowcount = dao.insert(dto);
		if( rowcount > 0 ) {
//			response.sendRedirect("board.do?cmd=list");
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("views/error.jsp");
		}
	} //end write() : insert

	

	public void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(seq, title, writer, content);
		
		System.out.println(seq + ",\t" + title + ",\t" + writer +",\t" + content);
		
		int rowcount = dao.update(dto);
		if( rowcount > 0 ) {
			response.sendRedirect("./board?cmd=list"); //.안붙혀지면 에러!!!!!!!!
//			response.sendRedirect("./board?cmd=detail");
		} else {
			response.sendRedirect("views/error.jsp");
		}
	} //end update() : update


	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		
		int rowCount = dao.delete(Integer.parseInt(seq));
		if (rowCount > 0) {
			list(request, response); //또는 response.sendRedirect("board?cmd=list");
		}
	} //end delete() : delete

	

	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.detail(Integer.parseInt(seq));
		
		if(dto != null) {
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("views/detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
		
	} //end detail() : detail
	*/

}
