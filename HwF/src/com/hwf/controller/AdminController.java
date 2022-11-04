package com.hwf.controller;

import java.io.IOException;
//import java.util.Date;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.hwf.*;
import com.hwf.dao.GoodsDAO;
//import com.hwf.dao.HealthGoodsDAO;
import com.hwf.dao.MemberDAO;
import com.hwf.model.GoodsDTO;
//import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.MemberDTO;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

	// 디폴트 생성자
	public AdminController() {

	}
	
	/*************** cmd ***************/
	
	// index.html에서 쓰인 'cmd'
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request에 set

		String cmd = request.getParameter("cmd"); // ~~~?cmd=AdminMemberSelect
		System.out.println("cmd : " + cmd); // Console창 출력테스트

		if (cmd.equals("AdminMemberSelect")) { // 관리자) 회원 조회
			AdminMemberSelect(request, response);
		}
		
//		else if (cmd.equals("GoodsSelect")) { // 관리자+회원) 상품(헬스용품 + 헬스식품 + 영양제) 전체 조회 
//			GoodsSelect(request, response);
//		} 
		else if (cmd.equals("AdminHealthGoodsSelect")) { //관리자) 헬스용품 전체 조회
			AdminHealthGoodsSelect(request, response);
		} 
		else if (cmd.equals("AdminHealthFoodSelect")) { //관리자) 헬스식품 전체 조회
			AdminHealthFoodSelect(request, response);
		} 
		else if (cmd.equals("AdminNutrientsSelect")) { //관리자) 영양제 전체 조회
			AdminNutrientsSelect(request, response);
		} 
		
		else if (cmd.equals("AdminHealthGoodsInsert")) { // 관리자) 헬스용품 등록
			AdminHealthGoodsInsert(request, response);
		}
		else if (cmd.equals("AdminHealthFoodInsert")) {  // 관리자) 헬스식품 등록
			try {
				AdminHealthFoodInsert(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	/*************** 상품 전체 조회 ***************/
	
//	// 관리자+회원) 상품(헬스용품 + 헬스식품 + 영양제) 전체 조회
//	public void GoodsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		GoodsDAO dao = new GoodsDAO();
//		List<GoodsDTO> HealthGoodsSelect = dao.HealthGoodsSelect();
//		List<GoodsDTO> HealthFoodSelect = dao.HealthFoodSelect();
//		List<GoodsDTO> NutrientsSelect = dao.NutrientsSelect();
//
//		if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
//			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); // data save
//			request.setAttribute("HealthFoodSelect", HealthFoodSelect); // data save
//			request.setAttribute("NutrientsSelect", NutrientsSelect); // data save
//			request.getRequestDispatcher("/views/jsp/GoodsSelect.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
//		}
//
//	}
	
	
	
	/*************** 상품 조회 ***************/
	
	// 관리자) 헬스용품 전체 조회
	public void AdminHealthGoodsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> AdminHealthGoodsSelect = dao.AdminHealthGoodsSelect();

		if (AdminHealthGoodsSelect != null) {
			request.setAttribute("AdminHealthGoodsSelect", AdminHealthGoodsSelect); // data save
			request.getRequestDispatcher("/views/jsp/AdminHealthGoodsSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}
	
	
	
	// 관리자) 헬스식품 전체 조회
	public void AdminHealthFoodSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> AdminHealthFoodSelect = dao.AdminHealthFoodSelect();

		if (AdminHealthFoodSelect != null) {
			request.setAttribute("AdminHealthFoodSelect", AdminHealthFoodSelect); // data save
			request.getRequestDispatcher("/views/jsp/AdminHealthFoodSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}
		
		
		
	// 관리자) 영양제 전체 조회
	public void AdminNutrientsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> AdminNutrientsSelect = dao.AdminNutrientsSelect();

		if (AdminNutrientsSelect != null) {
			request.setAttribute("AdminNutrientsSelect", AdminNutrientsSelect); // data save
			request.getRequestDispatcher("/views/jsp/AdminNutrientsSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}		

	
	
	/*************** 상품 등록 ***************/
	
	// 관리자) 헬스용품 등록
	public void AdminHealthGoodsInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("왔니????"); //OK
		
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("euc-kr"); //response에 set
		
		// 헬스용품 등록
		String healthGoodsName = request.getParameter("healthGoodsName");
//		System.out.println(healthGoodsName); //null 출력
		int healthGoodsPrice = Integer.parseInt(request.getParameter("healthGoodsPrice"));
		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsImg = request.getParameter("healthGoodsImg");
		String healthGoodsDetail = request.getParameter("healthGoodsDetail");
		String healthGoodsLink = request.getParameter("healthGoodsLink");
		
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dtoHealthGoods = new GoodsDTO(healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, healthGoodsLink);
//		System.out.println("왔니");
		
		int resultHealthGoodsInsert = dao.AdminHealthGoodsInsert(dtoHealthGoods);
		if (resultHealthGoodsInsert > 0) {
			response.sendRedirect("admin?cmd=GoodsSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}
		
		
		
	// 관리자) 헬스식품 등록
	public void AdminHealthFoodInsert(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
			
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("euc-kr"); //response에 set	
		
		// 헬스식품 등록
		String hfName = request.getParameter("hfName");
		int hfPrice = Integer.parseInt(request.getParameter("hfPrice"));
		int hfCategory = Integer.parseInt(request.getParameter("hfCategory"));
		String hfImg = request.getParameter("hfImg");
		String hfDetail = request.getParameter("hfDetail");
		
		SimpleDateFormat SDF = new SimpleDateFormat("yy-MM-dd");
		String hfDomString = request.getParameter("hfDom");
		Date hfDom = (Date) SDF.parse(hfDomString);

//		Date hfDom = request.getParameter("hfDom");
		
//		String hfDom = request.getParameter("hfDom");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		String hfLink = request.getParameter("hfLink");
		
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dtoHealthFood = new GoodsDTO(hfName, hfPrice, hfCategory, hfImg, hfDetail, hfDom, hfLink);
		
		int resultHealthFoodInsert = dao.AdminHealthFoodInsert(dtoHealthFood);
		
		if (resultHealthFoodInsert > 0) {
			response.sendRedirect("admin?cmd=GoodsSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}
		
		
		// 영양제 등록


	
	
	/*************** 회원 조회 ***************/
	
	// 관리자) 회원 조회
	public void AdminMemberSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		List<MemberDTO> AdminMemberSelect = dao.AdminMemberSelect(); // MemberDAO의 AdminMemberSelect()메소드의 return값을 MemberDTO형태의 AdminMemberSelect변수에 담음

		if (AdminMemberSelect != null) {
			request.setAttribute("AdminMemberSelect", AdminMemberSelect); // data save
			request.getRequestDispatcher("/views/jsp/AdminMemberSelect.jsp").forward(request, response);
			// response.sendRedirect("/views/jsp/AdminMemberSelect.jsp");
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}
	}

}
