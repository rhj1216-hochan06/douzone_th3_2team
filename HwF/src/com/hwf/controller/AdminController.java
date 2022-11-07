package com.hwf.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
//import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

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
		} 
		else if (cmd.equals("AdminHealthFoodDetail")) { //관리자) 헬스식품 상세보기
			AdminHealthFoodDetail(request, response);
		} 
		else if (cmd.equals("AdminHealthFoodUpdate")) { //관리자) 헬스식품 수정
			AdminHealthFoodUpdate(request, response);
		} 
		else if (cmd.equals("AdminNutrientsDetail")) { //관리자) 영양제 상세보기
			AdminNutrientsDetail(request, response);
		} 
		else if (cmd.equals("AdminNutrientsUpdate")) { //관리자) 영양제 수정
			AdminNutrientsUpdate(request, response);
		} 
		
		
		// 상품 삭제
		else if (cmd.equals("AdminHealthGoodsDelete")) { //관리자) 헬스용품 삭제
			AdminHealthGoodsDelete(request, response);
		} 
		
		
		// 상품 등록
		else if (cmd.equals("AdminHealthGoodsInsert")) { //관리자) 헬스용품 등록
			AdminHealthGoodsInsert(request, response);
		}
		else if (cmd.equals("AdminHealthFoodInsert")) {  //관리자) 헬스식품 등록
			AdminHealthFoodInsert(request, response);
		}
		else if (cmd.equals("AdminNutrientsInsert")) {  //관리자) 영양제 등록
			AdminNutrientsInsert(request, response);
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
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect);
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);
			request.setAttribute("NutrientsSelect", NutrientsSelect);
			request.getRequestDispatcher("/views/jsp/admin/GoodsSelect.jsp").forward(request, response);
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
			request.setAttribute("AdminHealthGoodsSelect", AdminHealthGoodsSelect);
			request.getRequestDispatcher("/views/jsp/admin/AdminHealthGoodsSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}
	
	
	
	// 관리자) 헬스식품 전체 조회
	public void AdminHealthFoodSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<HealthFoodDTO> AdminHealthFoodSelect = dao.AdminHealthFoodSelect();

		if (AdminHealthFoodSelect != null) {
			request.setAttribute("AdminHealthFoodSelect", AdminHealthFoodSelect); 
			request.getRequestDispatcher("/views/jsp/admin/AdminHealthFoodSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}	

	}
		
		
		
	// 관리자) 영양제 전체 조회
	public void AdminNutrientsSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GoodsDAO dao = new GoodsDAO();
		List<NutrientsDTO> AdminNutrientsSelect = dao.AdminNutrientsSelect();

		if (AdminNutrientsSelect != null) {
			request.setAttribute("AdminNutrientsSelect", AdminNutrientsSelect);
			request.getRequestDispatcher("/views/jsp/admin/AdminNutrientsSelect.jsp").forward(request, response);
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
		
		HttpSession session;	      
		session = request.getSession();
		
		session.setAttribute("healthGoodsId", healthGoodsId);
        session.setAttribute("healthGoodsName", dtoHealthGoods.getHealthGoodsName());
        session.setAttribute("healthGoodsPrice", dtoHealthGoods.getHealthGoodsPrice());
        session.setAttribute("healthGoodsCategory", dtoHealthGoods.getHealthGoodsCategory());
        session.setAttribute("healthGoodsImg", dtoHealthGoods.getHealthGoodsImg());
        session.setAttribute("healthGoodsDetail", dtoHealthGoods.getHealthGoodsDetail());
        session.setAttribute("link", dtoHealthGoods.getLink());
        
        //세션 유지시간 설정(초단위) 20분
        session.setMaxInactiveInterval(20*60);
			
		if(dtoHealthGoods != null) {
			request.setAttribute("com.hwf.model.HealthGoodsDTO", dtoHealthGoods);
			request.getRequestDispatcher("/views/jsp/admin/AdminHealthGoodsUpdate.jsp").forward(request, response);
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
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = new HealthGoodsDTO(healthGoodsId, healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, link);
	
//		int resultHealthGoodsDelete = dao.AdminHealthGoodsDelete(healthGoodsId);
//		System.out.println("왔니");
		
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
			
//		SimpleDateFormat SDF = new SimpleDateFormat("yy-MM-dd");
//		String hfDomString = request.getParameter("hfDom");
//		Date hfDom = (Date) SDF.parse(hfDomString);
		
//        String HfDomString = dtoHealthFood.getHfDom(); //String 타입의 HfDom
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MM-dd");  //포맷터
//        Date HfDomDate = formatter.parse(HfDomString); //String 타입의 HfDom -> Date 타입의 HfDom
        
		HttpSession session;	      
		session = request.getSession();
		
		session.setAttribute("hfId", hfId);
        session.setAttribute("hfName", dtoHealthFood.getHfName());
        session.setAttribute("hfPrice", dtoHealthFood.getHfPrice());
        session.setAttribute("hfCategory", dtoHealthFood.getHfCategory());
        session.setAttribute("hfImg", dtoHealthFood.getHfImg());
        session.setAttribute("hfDetail", dtoHealthFood.getHfDetail());
        session.setAttribute("hfDom", dtoHealthFood.getHfDom());
        session.setAttribute("link", dtoHealthFood.getLink());
        
        //세션 유지시간 설정(초단위) 20분
        session.setMaxInactiveInterval(20*60);
        
		if(dtoHealthFood != null) {
			request.setAttribute("com.hwf.model.HealthFoodDTO", dtoHealthFood);
			request.getRequestDispatcher("/views/jsp/admin/AdminHealthFoodUpdate.jsp").forward(request, response);
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
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfId, hfName, hfPrice, hfCategory, hfImg, hfDetail, hfDom, link);
		
		int resultHealthFoodUpdate = dao.AdminHealthFoodUpdate(dtoHealthFood);
		
		if( resultHealthFoodUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthFoodSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	
	//관리자) 영양제 상세보기
	public void AdminNutrientsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nutrientsId = Integer.parseInt(request.getParameter("nutrientsId"));
			
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = dao.AdminNutrientsDetail(nutrientsId);
		
		HttpSession session;	      
		session = request.getSession();
		
		session.setAttribute("nutrientsId", nutrientsId);
        session.setAttribute("nutrientsName", dtoNutrients.getNutrientsName());
        session.setAttribute("nutrientsPrice", dtoNutrients.getNutrientsPrice());
        session.setAttribute("nutrientsCategory", dtoNutrients.getNutrientsCategory());
        session.setAttribute("nutrientsImg", dtoNutrients.getNutrientsImg());
        session.setAttribute("nutrientsDetail", dtoNutrients.getNutrientsDetail());
        session.setAttribute("nutrientsDom", dtoNutrients.getNutrientsDom());
        session.setAttribute("dailyIntake", dtoNutrients.getDailyIntake());
        session.setAttribute("numPerBottle", dtoNutrients.getNumPerBottle());
        session.setAttribute("remainingNum", dtoNutrients.getRemainingNum());
        session.setAttribute("link", dtoNutrients.getLink());
        
        //세션 유지시간 설정(초단위) 20분
        session.setMaxInactiveInterval(20*60);
			
		if(dtoNutrients != null) {
			request.setAttribute("com.hwf.model.NutrientsDTO", dtoNutrients);
			request.getRequestDispatcher("/views/jsp/admin/AdminNutrientsUpdate.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
			
	}
	
	//관리자) 영양제 수정
	public void AdminNutrientsUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int nutrientsId = Integer.parseInt(request.getParameter("nutrientsId"));
		String nutrientsName = request.getParameter("nutrientsName");
		int nutrientsPrice = Integer.parseInt(request.getParameter("nutrientsPrice"));
		int nutrientsCategory = Integer.parseInt(request.getParameter("nutrientsCategory"));
		String nutrientsImg = request.getParameter("nutrientsImg");
		String nutrientsDetail = request.getParameter("nutrientsDetail");
		String nutrientsDom = request.getParameter("nutrientsDom");
		String dailyIntake = request.getParameter("dailyIntake");
		int numPerBottle = Integer.parseInt(request.getParameter("numPerBottle"));
		int remainingNum = Integer.parseInt(request.getParameter("remainingNum"));
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = new NutrientsDTO(nutrientsId, nutrientsName, nutrientsPrice, nutrientsCategory, nutrientsImg, nutrientsDetail, nutrientsDom, dailyIntake, numPerBottle, remainingNum, link);
		
		int resultNutrientsUpdate = dao.AdminNutrientsUpdate(dtoNutrients);
		if( resultNutrientsUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminNutrientsSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	/*************** 상품 삭제 ***************/
	public void AdminHealthGoodsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int healthGoodsId = Integer.parseInt(request.getParameter("healthGoodsId"));
		System.out.println(healthGoodsId);
		
		GoodsDAO dao = new GoodsDAO();
		
		int resultHealthGoodsDelete = dao.AdminHealthGoodsDelete(healthGoodsId);
		
//		if (resultHealthGoodsDelete > 0) {
//			AdminHealthGoodsSelect(request, response); //또는 response.sendRedirect("admin?cmd=AdminHealthGoodsSelect");
//		}
		
		if( resultHealthGoodsDelete > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthGoodsSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	/*************** 상품 등록 ***************/
	
	// 관리자) 헬스용품 등록
	public void AdminHealthGoodsInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String healthGoodsName = request.getParameter("healthGoodsName");
		int healthGoodsPrice = Integer.parseInt(request.getParameter("healthGoodsPrice"));
		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsImg = request.getParameter("healthGoodsImg");
		String healthGoodsDetail = request.getParameter("healthGoodsDetail");
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = new HealthGoodsDTO(healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, link);
		
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
//		System.out.println(hfDom);
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfName, hfPrice, hfCategory, hfImg, hfDetail, hfDom, link);
		
		int resultHealthFoodInsert = dao.AdminHealthFoodInsert(dtoHealthFood);
		if (resultHealthFoodInsert > 0) {
			response.sendRedirect("admin?cmd=AdminHealthFoodSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}
		
		
	// 관리자) 영양제 등록
	public void AdminNutrientsInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");	
		
		String nutrientsName = request.getParameter("nutrientsName");
		int nutrientsPrice = Integer.parseInt(request.getParameter("nutrientsPrice"));
		int nutrientsCategory = Integer.parseInt(request.getParameter("nutrientsCategory"));
		String nutrientsImg = request.getParameter("nutrientsImg");
		String nutrientsDetail = request.getParameter("nutrientsDetail");
		String nutrientsDom = request.getParameter("nutrientsDom");       
		String dailyIntake = request.getParameter("dailyIntake");
		int numPerBottle = Integer.parseInt(request.getParameter("numPerBottle"));
		int remainingNum = Integer.parseInt(request.getParameter("remainingNum"));
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = new NutrientsDTO(nutrientsName, nutrientsPrice, nutrientsCategory, nutrientsImg, nutrientsDetail, nutrientsDom, dailyIntake, numPerBottle, remainingNum, link);
		
		int resultNutrientsInsert = dao.AdminNutrientsInsert(dtoNutrients);
		if (resultNutrientsInsert > 0) {
			response.sendRedirect("admin?cmd=AdminNutrientsSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}	


	
	
	/*************** 회원 조회 ***************/
	
	// 관리자) 회원 조회
	public void AdminMemberSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		List<MemberDTO> AdminMemberSelect = dao.AdminMemberSelect(); // MemberDAO의 AdminMemberSelect()메소드의 return값을 MemberDTO형태의 AdminMemberSelect변수에 담음

		if (AdminMemberSelect != null) {
			request.setAttribute("AdminMemberSelect", AdminMemberSelect); // data save
			request.getRequestDispatcher("/views/jsp/admin/AdminMemberSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp"); // 추후에 error페이지 만든 후 error 처리
		}
	}

}
