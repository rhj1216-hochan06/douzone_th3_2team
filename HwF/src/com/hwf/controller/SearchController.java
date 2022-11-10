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
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;

//@WebServlet("/views/search")
@WebServlet("/search")
public class SearchController extends HttpServlet {

	@Autowired
	public SearchController() {
	}

	// ------------------------------

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 한글로 데이터를 받고 내려가야함

		String cmd = request.getParameter("cmd"); // ~~?cmd=list
		System.out.println("cmd : " + cmd);
		System.out.println("알려주세요 :" + request);
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("searching")) {
			searching(request, response);
		}

	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SearchDAO dao = new SearchDAO();
		/* List<SearchDTO> list = dao.serachAll(); */

		List<HealthGoodsDTO> HealthGoodsSelect = dao.SearchHealthGoodsSelect();

		List<HealthFoodDTO> HealthFoodSelect = dao.SearchHealthFoodSelect();

		List<NutrientsDTO> NutrientsSelect = dao.SearchNutrientsSelect();

		System.out.println("HealthGoodsSelect : " + HealthGoodsSelect);
		System.out.println("HealthFoodSelect : " + HealthFoodSelect);
		System.out.println("NutrientsSelect : " + NutrientsSelect);

		System.out.println("왔습니다 컨트롤러 : " + HealthGoodsSelect);

		if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect);
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);
			request.setAttribute("NutrientsSelect", NutrientsSelect);
			request.getRequestDispatcher("/views/jsp/search/searchpage.jsp").forward(request, response);

		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // list end

	public void searching(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 컬럼명
		request.setCharacterEncoding("UTF-8");
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); // column : title or writer or contnet
		map.put("keyvalue", keyvalue); // keyvalue : 김연아

		SearchDAO dao = new SearchDAO();
		List<HealthGoodsDTO> HealthGoodsSelect = dao.searchingHealthGoodsSelect(map);
		List<HealthFoodDTO> HealthFoodSelect = dao.searchingHealthFoodSelect(map);
		List<NutrientsDTO> NutrientsSelect = dao.searchingNutrientsSelect(map);

		System.out.println("왔습니다 컨트롤러");

		if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect);
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);
			request.setAttribute("NutrientsSelect", NutrientsSelect);

			request.getRequestDispatcher("/views/jsp/search/searchpage.jsp").forward(request, response);
//			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
		} else {

			response.sendRedirect("views/error.jsp");
		}
	}

//	public void surveysearching(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		// 컬럼명
//		request.setCharacterEncoding("UTF-8");
//		String column = request.getParameter("column");
//		String keyvalue = request.getParameter("keyvalue");
//		System.out.println(column + " / " + keyvalue);
//
//		Map<String, String> map = new HashMap<>(); // collection
//		map.put("column", column); // column : title or writer or contnet
//		map.put("keyvalue", keyvalue); // keyvalue : 김연아
//
//		SearchDAO dao = new SearchDAO();
//		List<HealthGoodsDTO> HealthGoodsSelect = dao.searchingHealthGoodsSelect(map);
//		List<HealthFoodDTO> HealthFoodSelect = dao.searchingHealthFoodSelect(map);
//		List<NutrientsDTO> NutrientsSelect = dao.searchingNutrientsSelect(map);
//		
//		System.out.println("왔습니다 컨트롤러");
//		
//		if( HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
//			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); 
//			request.setAttribute("HealthFoodSelect", HealthFoodSelect);  
//			request.setAttribute("NutrientsSelect", NutrientsSelect);
//			
//			request.getRequestDispatcher("/views/jsp/recommendpage.jsp").forward(request, response);
////			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
//		} else {
//			
//			response.sendRedirect("views/error.jsp");
//		}
//	}
//	
//	public void inbodysearching(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		// 컬럼명
//		request.setCharacterEncoding("UTF-8");
//		String column = request.getParameter("column");
//		String keyvalue = request.getParameter("keyvalue");
//		System.out.println(column + " / " + keyvalue);
//
//		Map<String, String> map = new HashMap<>(); // collection
//		map.put("column", column); // column : title or writer or contnet
//		map.put("keyvalue", keyvalue); // keyvalue : 김연아
//
//		SearchDAO dao = new SearchDAO();
//		List<HealthGoodsDTO> HealthGoodsSelect = dao.searchingHealthGoodsSelect(map);
//		List<HealthFoodDTO> HealthFoodSelect = dao.searchingHealthFoodSelect(map);
//		List<NutrientsDTO> NutrientsSelect = dao.searchingNutrientsSelect(map);
//		
//		System.out.println("왔습니다 컨트롤러");
//		
//		if( HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
//			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); 
//			request.setAttribute("HealthFoodSelect", HealthFoodSelect);  
//			request.setAttribute("NutrientsSelect", NutrientsSelect);
//			
//			request.getRequestDispatcher("/views/jsp/recommendpage.jsp").forward(request, response);
////			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
//		} else {
//			
//			response.sendRedirect("views/error.jsp");
//		}
//	}

	// -------------------------------------------------------------
//  서칭 원본
//	public void searching(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		// 컬럼명
//		request.setCharacterEncoding("UTF-8");
//		String column = request.getParameter("column");
//		String keyvalue = request.getParameter("keyvalue");
//		System.out.println(column + " / " + keyvalue);
//
//		Map<String, String> map = new HashMap<>(); // collection
//		map.put("column", column); // column : title or writer or contnet
//		map.put("keyvalue", keyvalue); // keyvalue : 김연아
//
//		SearchDAO dao = new SearchDAO();
//		List<SearchDTO> list = dao.searching(map);
//		
//		
//		System.out.println("controller dto : " + list);
//		
//		if (list != null) {
//			request.setAttribute("list", list);
//			
//			System.out.println("list : "+list);
//			request.getRequestDispatcher("/views/jsp/searchpage.jsp").forward(request, response);
////			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
//		} else {
//			
//			response.sendRedirect("views/error.jsp");
//		}
//	}

//
//	public void searchselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String healthgoodsname = request.getParameter("healthgoodsname");
//		String hfname = request.getParameter("hfname");
//		String nutrientsname = request.getParameter("nutrientsname");
//		String keyvalue = request.getParameter("keyvalue");
//
//		Map<String, String> map = new HashMap<>(); // collection
//		map.put("healthgoodsname", healthgoodsname);
//		System.out.println(healthgoodsname);
//		map.put("hfname", hfname);
//		map.put("nutrientsname", nutrientsname);
//		System.out.println(nutrientsname);
//		map.put("keyvalue", keyvalue);
//
//		SearchDAO dao = new SearchDAO();
//		List<SearchDTO> list = dao.getSearchListSelect(map);
//		
////		if (list != null) {
////			request.setAttribute("list", list);
////			request.getRequestDispatcher("/views/jsp/searchList.jsp").forward(request, response);
////		} else {
////			response.sendRedirect("views/error.jsp");
////		}
//	
//		if (list != null) {
//			request.setAttribute("searchListSelect", list);
//			request.getRequestDispatcher("/views/jsp/searchgoods.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("views/error.jsp");
//		}
//	}
//	

}
