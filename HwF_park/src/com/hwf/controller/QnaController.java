package com.hwf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.hwf.dao.QnaDAO;
import com.hwf.model.QnaDTO;


@WebServlet("/views/board")
//@WebServlet("/board")
public class QnaController extends HttpServlet {
	
	@Autowired
	public QnaController() { }
	
	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 한글로 데이터를 받고 내려가야함 
		
		String cmd = request.getParameter("cmd");  //  ~~?cmd=list
		System.out.println("cmd : " + cmd);
		System.out.println("알려주세요 :" + request);
		if( cmd.equals("list") ) {			
			list(request, response);
		} else if( cmd.equals("write") ) {			
			write(request, response);
		}else if( cmd.equals("search") ) {		
			search(request, response);
			} 
		
	} // service end

	public void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		QnaDAO dao = new QnaDAO();
		List<QnaDTO>  list = dao.selectAll();
		System.out.println("list : " + list);
		if( list != null ) {
			request.setAttribute("list", list);  // data save
			request.getRequestDispatcher("/views/jsp/list.jsp").forward(request, response);
//			request.getRequestDispatcher("/views/list.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // list end
	
	
	
	
	  public void write(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
	 
			request.setCharacterEncoding("UTF-8");
			  String memberid = request.getParameter("memberid"); 
			  String qnacontent = request.getParameter("qnacontent"); 
			  String qnaanswer = request.getParameter("qnaanswer");
			
			  System.out.println(qnacontent + ",\t" + qnaanswer +",\t" + memberid);
			
			QnaDAO dao = new QnaDAO();
			QnaDTO dto = new QnaDTO(qnacontent, qnaanswer, memberid);
			System.out.println(dto);
			int rowcount = dao.insert(dto);
			System.out.println(dao);
			
			if( rowcount > 0 ) {
				response.sendRedirect("board?cmd=list");
//				response.sendRedirect("/HwF/views/jsp/list.jsp");
//				response.sendRedirect("/HwF/views/list.jsp");
			} else {
				response.sendRedirect("/views/jsp/error.jsp");
			}
		} // write end
	  
		public void search(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// 컬럼명
			String column = request.getParameter("column");
			String keyvalue = request.getParameter("keyvalue");
			System.out.println(column + " / " + keyvalue);

			Map<String, String> map = new HashMap<>(); // collection
			map.put("column", column); // column : title or writer or contnet
			map.put("keyvalue", keyvalue); // keyvalue : 김연아

			QnaDAO dao = new QnaDAO();
			
			List<QnaDTO> list = dao.getSearchList(map);
			if (list != null) {
				request.setAttribute("list", list);
				
				System.out.println("list : "+list);
				request.getRequestDispatcher("/views/jsp/list.jsp").forward(request, response);
//				request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
			} else {
				response.sendRedirect("views/error.jsp");
			}
		}

	  
}