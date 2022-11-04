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


import com.hwf.dao.SearchDAO;
import com.hwf.model.SearchDTO;


@WebServlet("/views/search")
public class SearchController extends HttpServlet{

	@Autowired
	public SearchController() { }
	

	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글로 데이터를 받고 내려가야함 
		
		String cmd = request.getParameter("cmd");  //  

		System.out.println("cmd : " + cmd );
		System.out.println("알려주세요 :" + request);
		if( cmd.equals("listsearch") ) {			
			list(request, response);
		} else if( cmd.equals("searching") ) {			
			searching(request, response);
		} else if( cmd.equals("searchselect") ) {			
			searchselect(request, response);
		} 
	} // service end
	
	public void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		SearchDAO dao = new SearchDAO();
		List<SearchDTO>  list = dao.searchpage();
		if( list != null ) {
			request.setAttribute("list", list);  // data save
			request.getRequestDispatcher("/views/jsp/searchpage.jsp").forward(request, response);
//			request.getRequestDispatcher("/views/list.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // list end
	
	
	
	public void searching(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		System.out.println("searching || column : " + column + " / " + "keyvalue : "+ keyvalue);
		
		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); // column : title or writer or contnet
		map.put("keyvalue", keyvalue); // keyvalue : 김연아
		
		SearchDAO dao = new SearchDAO();
	
		List<SearchDTO> list = dao.searching(map);
		System.out.println("searching : " + list);
		if (list != null) {
			request.setAttribute("list", list);
			
			System.out.println("searchpage list : "+list);
			
			request.getRequestDispatcher("/views/jsp/searchpage.jsp").forward(request, response);
//			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void searchselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String healthgoodsname = request.getParameter("healthgoodsname");
		String hfname = request.getParameter("hfname");
		String nutrientsname = request.getParameter("nutrientsname");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<>(); // collection
		map.put("healthgoodsname", healthgoodsname);
		System.out.println(healthgoodsname);
		map.put("hfname", hfname);
		map.put("nutrientsname", nutrientsname);
		System.out.println(nutrientsname);
		map.put("keyvalue", keyvalue);

		SearchDAO dao = new SearchDAO();
		List<SearchDTO> list = dao.getSearchListSelect(map);
		
//		if (list != null) {
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/views/jsp/searchList.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("views/error.jsp");
//		}
	
		if (list != null) {
			request.setAttribute("searchListSelect", list);
			request.getRequestDispatcher("/views/jsp/searchgoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}
	
}
