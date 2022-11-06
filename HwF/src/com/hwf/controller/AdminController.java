package com.hwf.controller;

import java.io.IOException;
//import java.util.Date;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
//import org.springframework.ui.Model;

//import com.hwf.*;
import com.hwf.dao.GoodsDAO;
import com.hwf.dao.MemberDAO;
import com.hwf.model.HealthFoodDTO;
//import com.hwf.model.GoodsDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.MemberDTO;
import com.hwf.model.NutrientsDTO;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

//	private Model model;
	
	// 디폴트 생성자
	public AdminController() {
		
	}
	
	/*************** cmd ***************/
	
	// index.html에서 쓰인 'cmd'
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request에 set

		String cmd = request.getParameter("cmd"); // ~~~?cmd=AdminMemberSelect
		System.out.println("cmd : " + cmd); // Console창 출력테스트

		//회원 전체 조회
		if (cmd.equals("AdminMemberSelect")) { // 관리자) 회원 조회
			AdminMemberSelect(request, response);
		}
		
		// 상품 전체 조회
		else if (cmd.equals("GoodsSelect")) { // 관리자+회원) 상품(헬스용품 + 헬스식품 + 영양제) 전체 조회 
			GoodsSelect(request, response);
		} 
		else if (cmd.equals("AdminHealthGoodsSelect")) { //관리자) 헬스용품 전체 조회
			AdminHealthGoodsSelect(request, response);
		} 
		else if (cmd.equals("AdminHealthFoodSelect")) { //관리자) 헬스식품 전체 조회
			AdminHealthFoodSelect(request, response);
		} 
		else if (cmd.equals("AdminNutrientsSelect")) { //관리자) 영양제 전체 조회
			AdminNutrientsSelect(request, response);
		} 
		
		// 상품 수정
		else if (cmd.equals("AdminHealthGoodsDetail")) { //관리자) 헬스용품 상세보기
			AdminHealthGoodsDetail(request, response);
		} 
		else if (cmd.equals("AdminHealthGoodsUpdate")) { //관리자) 헬스용품 수정
			AdminHealthGoodsUpdate(request, response);
//			AdminHealthGoodsUpdate(request, response, model);
		} 
		else if (cmd.equals("AdminHealthFoodDetail")) { //관리자) 헬스식품 상세보기
			AdminHealthFoodDetail(request, response);
		} 
		else if (cmd.equals("AdminHealthFoodUpdate")) { //관리자) 헬스식품 수정
			AdminHealthFoodUpdate(request, response);
		} 
		
		// 상품 등록
		else if (cmd.equals("AdminHealthGoodsInsert")) { // 관리자) 헬스용품 등록
			AdminHealthGoodsInsert(request, response);
		}
		else if (cmd.equals("AdminHealthFoodInsert")) {  // 관리자) 헬스식품 등록
			AdminHealthFoodInsert(request, response);
		}
	}

	
	
	/*************** 상품 전체 조회 ***************/
	
	// 관리자+회원) 상품(헬스용품 + 헬스식품 + 영양제) 전체 조회
	public void GoodsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<HealthGoodsDTO> HealthGoodsSelect = dao.AdminHealthGoodsSelect();
		List<HealthFoodDTO> HealthFoodSelect = dao.AdminHealthFoodSelect();
		List<NutrientsDTO> NutrientsSelect = dao.AdminNutrientsSelect();

		if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); // data save
			request.setAttribute("HealthFoodSelect", HealthFoodSelect); // data save
			request.setAttribute("NutrientsSelect", NutrientsSelect); // data save
			request.getRequestDispatcher("/views/jsp/GoodsSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}

	}
	
	
	
	/*************** 상품 조회 ***************/
	
	// 관리자) 헬스용품 전체 조회
	public void AdminHealthGoodsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<HealthGoodsDTO> AdminHealthGoodsSelect = dao.AdminHealthGoodsSelect();

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
		List<HealthFoodDTO> AdminHealthFoodSelect = dao.AdminHealthFoodSelect();

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
		List<NutrientsDTO> AdminNutrientsSelect = dao.AdminNutrientsSelect();

		if (AdminNutrientsSelect != null) {
			request.setAttribute("AdminNutrientsSelect", AdminNutrientsSelect); // data save
			request.getRequestDispatcher("/views/jsp/AdminNutrientsSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}		

	
	
	/*************** 상품 수정 ***************/
		
	//관리자) 헬스용품 상세보기
	public void AdminHealthGoodsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int healthGoodsId = Integer.parseInt(request.getParameter("healthGoodsId"));
			
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = dao.AdminHealthGoodsDetail(healthGoodsId);
			
		if(dtoHealthGoods != null) {
			request.setAttribute("com.hwf.model.HealthGoodsDTO", dtoHealthGoods);
			request.getRequestDispatcher("/views/jsp/AdminHealthGoodsUpdate.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
			
	}
	
	//관리자) 헬스용품 수정
	public void AdminHealthGoodsUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int healthGoodsId = Integer.parseInt(request.getParameter("healthGoodsId"));
		String healthGoodsName = request.getParameter("healthGoodsName");
		int healthGoodsPrice = Integer.parseInt(request.getParameter("healthGoodsPrice"));
		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsImg = request.getParameter("healthGoodsImg");
		String healthGoodsDetail = request.getParameter("healthGoodsDetail");
		String healthGoodsLink = request.getParameter("healthGoodsLink");
		
		System.out.println(healthGoodsId + ",\t" + healthGoodsName + ",\t" + healthGoodsPrice +",\t" + healthGoodsCategory + ",\t" + healthGoodsImg + ",\t" + healthGoodsDetail + ",\t" + healthGoodsLink);
		
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = new HealthGoodsDTO(healthGoodsId, healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, healthGoodsLink);
		
//		request.setAttribute("healthGoodsName", healthGoodsName);
//		request.setAttribute("healthGoodsPrice", healthGoodsPrice);
//		request.setAttribute("healthGoodsCategory", healthGoodsCategory);
//		request.setAttribute("healthGoodsImg", healthGoodsImg);
//		request.setAttribute("healthGoodsDetail", healthGoodsDetail);
//		request.setAttribute("healthGoodsLink", healthGoodsLink);
		
//		model.addAttribute("healthGoodsName", dtoHealthGoods);
		
//		model.addAttribute("healthGoodsName", healthGoodsName);
//		model.addAttribute("healthGoodsPrice", healthGoodsPrice);
//		model.addAttribute("healthGoodsCategory", healthGoodsCategory);
//		model.addAttribute("healthGoodsImg", healthGoodsImg);
//		model.addAttribute("healthGoodsDetail", healthGoodsDetail);
//		model.addAttribute("healthGoodsLink", healthGoodsLink);
		
		int resultHealthGoodsUpdate = dao.AdminHealthGoodsUpdate(dtoHealthGoods);
		if( resultHealthGoodsUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthGoodsSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	//관리자) 헬스식품 상세보기
	public void AdminHealthFoodDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hfId = Integer.parseInt(request.getParameter("hfId"));
			
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = dao.AdminHealthFoodDetail(hfId);
			
		if(dtoHealthFood != null) {
			request.setAttribute("com.hwf.model.HealthFoodDTO", dtoHealthFood);
			request.getRequestDispatcher("/views/jsp/AdminHealthFoodUpdate.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
			
	}
	
	//관리자) 헬스식품 수정
	public void AdminHealthFoodUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int hfId = Integer.parseInt(request.getParameter("hfId"));
		String hfName = request.getParameter("hfName");
		int hfPrice = Integer.parseInt(request.getParameter("hfPrice"));
		int hfCategory = Integer.parseInt(request.getParameter("hfCategory"));
		String hfImg = request.getParameter("hfImg");
		String hfDetail = request.getParameter("hfDetail");
		String hfDom = request.getParameter("hfDom");
		String hfLink = request.getParameter("hfLink");
		
		System.out.println(hfId + ",\t" + hfName + ",\t" + hfPrice +",\t" + hfCategory + ",\t" + hfImg + ",\t" + hfDetail + ",\t" + hfLink);
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfId, hfName, hfPrice, hfCategory, hfImg, hfDetail, hfDom, hfLink);
		
		int resultHealthFoodUpdate = dao.AdminHealthFoodUpdate(dtoHealthFood);
		if( resultHealthFoodUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthFoodSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	/*************** 상품 등록 ***************/
	
	// 관리자) 헬스용품 등록
	public void AdminHealthGoodsInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("왔니????"); //OK
		
		request.setCharacterEncoding("UTF-8");
		
		String healthGoodsName = request.getParameter("healthGoodsName");
//		System.out.println(healthGoodsName); //null 출력
		int healthGoodsPrice = Integer.parseInt(request.getParameter("healthGoodsPrice"));
		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsImg = request.getParameter("healthGoodsImg");
		String healthGoodsDetail = request.getParameter("healthGoodsDetail");
		String healthGoodsLink = request.getParameter("healthGoodsLink");
		
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = new HealthGoodsDTO(healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, healthGoodsLink);
		
		int resultHealthGoodsInsert = dao.AdminHealthGoodsInsert(dtoHealthGoods);
		if (resultHealthGoodsInsert > 0) {
			response.sendRedirect("admin?cmd=AdminHealthGoodsSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}
		
		
		
	// 관리자) 헬스식품 등록
	public void AdminHealthFoodInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");	
		
		String hfName = request.getParameter("hfName");
		int hfPrice = Integer.parseInt(request.getParameter("hfPrice"));
		int hfCategory = Integer.parseInt(request.getParameter("hfCategory"));
		String hfImg = request.getParameter("hfImg");
		String hfDetail = request.getParameter("hfDetail");
		
//		SimpleDateFormat SDF = new SimpleDateFormat("yy-MM-dd");
//		String hfDomString = request.getParameter("hfDom");
//		Date hfDom = (Date) SDF.parse(hfDomString);

//		Date hfDom = request.getParameter("hfDom");
		
		String hfDom = request.getParameter("hfDom");       
		System.out.println(hfDom);
		String hfLink = request.getParameter("hfLink");
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfName, hfPrice, hfCategory, hfImg, hfDetail, hfDom, hfLink);
//		System.out.println(dtoHealthFood.getHfId());
		
		int resultHealthFoodInsert = dao.AdminHealthFoodInsert(dtoHealthFood);
		if (resultHealthFoodInsert > 0) {
			response.sendRedirect("admin?cmd=AdminHealthFoodSelect");
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
