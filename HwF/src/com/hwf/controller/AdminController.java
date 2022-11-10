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
import com.hwf.dao.PurchaseDAO;
import com.hwf.model.HealthFoodDTO;
//import com.hwf.model.GoodsDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.MemberDTO;
import com.hwf.model.NutrientsDTO;
import com.hwf.model.PurchaseDTO;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	
	// 디폴트 생성자
	public AdminController() {
		
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 

		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd); //Console창 출력테스트

		
		//회원 조회
		if (cmd.equals("AdminMemberSelect")) { //관리자) 회원 조회
			AdminMemberSelect(request, response);
		}
		
		
		// 상품 전체 조회
		else if (cmd.equals("GoodsSelect")) { //관리자) 상품(헬스용품 + 헬스식품 + 영양제) 전체 조회 
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
		else if (cmd.equals("AdminHealthFoodDelete")) { //관리자) 헬스식품 삭제
			AdminHealthFoodDelete(request, response);
		} 
		else if (cmd.equals("AdminNutrientsDelete")) { //관리자) 영양제 삭제
			AdminNutrientsDelete(request, response);
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
		
		
		// 주문 조회
		else if (cmd.equals("AdminOrderSelect")) { //관리자) 주문 조회
			AdminOrderSelect(request, response);
		} 
	}
	
	
	
	/*************** 회원 조회 ***************/
	
	// 관리자) 회원 조회
	public void AdminMemberSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		List<MemberDTO> AdminMemberSelect = dao.AdminMemberSelect();

		if (AdminMemberSelect != null) {
			request.setAttribute("AdminMemberSelect", AdminMemberSelect);
			request.getRequestDispatcher("/views/jsp/admin/AdminMemberSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
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
			response.sendRedirect("/views/jsp/error.jsp");
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
			response.sendRedirect("/views/jsp/error.jsp");
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
			response.sendRedirect("/views/jsp/error.jsp");
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
			response.sendRedirect("/views/error.jsp");
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
//		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsCategory = request.getParameter("healthGoodsCategory");
		String healthGoodsImg = request.getParameter("healthGoodsImg");
		String healthGoodsDetail = request.getParameter("healthGoodsDetail");
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthGoodsDTO dtoHealthGoods = new HealthGoodsDTO(healthGoodsId, healthGoodsName, healthGoodsPrice, healthGoodsCategory, healthGoodsImg, healthGoodsDetail, link);
		
		int resultHealthGoodsUpdate = dao.AdminHealthGoodsUpdate(dtoHealthGoods);
		
		if( resultHealthGoodsUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthGoodsSelect"); //.안붙혀지면 에러!!!!!!!!
		} 
		else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	//관리자) 헬스식품 상세보기
	public void AdminHealthFoodDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hfid = Integer.parseInt(request.getParameter("hfid"));
			
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = dao.AdminHealthFoodDetail(hfid);
        
		HttpSession session;	      
		session = request.getSession();
		
		session.setAttribute("hfid", hfid);
        session.setAttribute("hfName", dtoHealthFood.getHfName());
        session.setAttribute("hfPrice", dtoHealthFood.getHfPrice());
        session.setAttribute("hfCategory", dtoHealthFood.getHfCategory());
        session.setAttribute("hfIMG", dtoHealthFood.getHfIMG());
        session.setAttribute("hfDetail", dtoHealthFood.getHfDetail());
        session.setAttribute("hfDoM", dtoHealthFood.getHfDoM()); //jsp로 출력시킬때 Date타입으로 형변환 필요
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
	    int hfid = Integer.parseInt(request.getParameter("hfid"));
		String hfName = request.getParameter("hfName");
		int hfPrice = Integer.parseInt(request.getParameter("hfPrice"));
//		int hfCategory = Integer.parseInt(request.getParameter("hfCategory"));
		String hfCategory = request.getParameter("hfCategory");
		String hfIMG = request.getParameter("hfIMG");
		String hfDetail = request.getParameter("hfDetail");
		String hfDoM = request.getParameter("hfDoM"); 
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfid, hfName, hfPrice, hfCategory, hfIMG, hfDetail, hfDoM, link);
		
		int resultHealthFoodUpdate = dao.AdminHealthFoodUpdate(dtoHealthFood);
		
		if( resultHealthFoodUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminHealthFoodSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	
	//관리자) 영양제 상세보기
	public void AdminNutrientsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nutrientsID = Integer.parseInt(request.getParameter("nutrientsID"));
			
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = dao.AdminNutrientsDetail(nutrientsID);
		
		HttpSession session;	      
		session = request.getSession();
		
		session.setAttribute("nutrientsID", nutrientsID);
        session.setAttribute("nutrientsName", dtoNutrients.getNutrientsName());
        session.setAttribute("nutrientsPrice", dtoNutrients.getNutrientsPrice());
        session.setAttribute("nutrientsCategory", dtoNutrients.getNutrientsCategory());
        session.setAttribute("nutrientsIMG", dtoNutrients.getNutrientsIMG());
        session.setAttribute("nutrientsDetail", dtoNutrients.getNutrientsDetail());
        session.setAttribute("nutrientsDOM", dtoNutrients.getNutrientsDOM()); //jsp로 출력시킬때 Date타입으로 형변환 필요
        session.setAttribute("dailyInTake", dtoNutrients.getDailyInTake());
        session.setAttribute("numperbottle", dtoNutrients.getNumperbottle());
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
		int nutrientsID = Integer.parseInt(request.getParameter("nutrientsID"));
		String nutrientsName = request.getParameter("nutrientsName");
		int nutrientsPrice = Integer.parseInt(request.getParameter("nutrientsPrice"));
//		int nutrientsCategory = Integer.parseInt(request.getParameter("nutrientsCategory"));
		String nutrientsCategory = request.getParameter("nutrientsCategory");
		String nutrientsIMG = request.getParameter("nutrientsIMG");
		String nutrientsDetail = request.getParameter("nutrientsDetail");
		String nutrientsDOM = request.getParameter("nutrientsDOM");
		String dailyInTake = request.getParameter("dailyInTake");
		int numperbottle = Integer.parseInt(request.getParameter("numperbottle"));
		int remainingNum = Integer.parseInt(request.getParameter("remainingNum"));
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = new NutrientsDTO(nutrientsID, nutrientsName, nutrientsPrice, nutrientsCategory, nutrientsIMG, nutrientsDetail, nutrientsDOM, dailyInTake, numperbottle, remainingNum, link);
		
		int resultNutrientsUpdate = dao.AdminNutrientsUpdate(dtoNutrients);
		if( resultNutrientsUpdate > 0 ) {
			response.sendRedirect("admin?cmd=AdminNutrientsSelect"); //.안붙혀지면 에러!!!!!!!!
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}
	
	
	
	/*************** 상품 삭제 ***************/
	
	// 관리자) 헬스용품 삭제
	public void AdminHealthGoodsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int healthGoodsId = Integer.parseInt(request.getParameter("healthGoodsId"));
		
		GoodsDAO dao = new GoodsDAO();
		
		int resultHealthGoodsDelete = dao.AdminHealthGoodsDelete(healthGoodsId);
		if (resultHealthGoodsDelete > 0) {
			AdminHealthGoodsSelect(request, response); 
		}
	}
	
	
	
	// 관리자) 헬스식품 삭제
	public void AdminHealthFoodDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hfid = Integer.parseInt(request.getParameter("hfid")); 
		GoodsDAO dao = new GoodsDAO();
			
		int resultHealthFoodDelete = dao.AdminHealthFoodDelete(hfid);
		if (resultHealthFoodDelete > 0) {
			AdminHealthFoodSelect(request, response);
		}
	}
	
	
	
	// 관리자) 영양제 삭제
	public void AdminNutrientsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nutrientsID = Integer.parseInt(request.getParameter("nutrientsID"));
				
		GoodsDAO dao = new GoodsDAO();
				
		int resultNutrientsDelete = dao.AdminNutrientsDelete(nutrientsID);
		if (resultNutrientsDelete > 0) {
			AdminNutrientsSelect(request, response);
		}
	}
	
	
	
	/*************** 상품 등록 ***************/
	
	// 관리자) 헬스용품 등록
	public void AdminHealthGoodsInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String healthGoodsName = request.getParameter("healthGoodsName");
		int healthGoodsPrice = Integer.parseInt(request.getParameter("healthGoodsPrice"));
//		int healthGoodsCategory = Integer.parseInt(request.getParameter("healthGoodsCategory"));
		String healthGoodsCategory = request.getParameter("healthGoodsCategory");
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
//		int hfCategory = Integer.parseInt(request.getParameter("hfCategory"));
		String hfCategory = request.getParameter("hfCategory");
		String hfIMG = request.getParameter("hfIMG");
		String hfDetail = request.getParameter("hfDetail");
		
//		SimpleDateFormat SDF = new SimpleDateFormat("yy-MM-dd");
//		String hfDomString = request.getParameter("hfDom");
//		Date hfDom = (Date) SDF.parse(hfDomString);

//		Date hfDom = request.getParameter("hfDom");
		
		String hfDoM = request.getParameter("hfDoM");       
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		HealthFoodDTO dtoHealthFood = new HealthFoodDTO(hfName, hfPrice, hfCategory, hfIMG, hfDetail, hfDoM, link);
		
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
//		int nutrientsCategory = Integer.parseInt(request.getParameter("nutrientsCategory"));
		String nutrientsCategory = request.getParameter("nutrientsCategory");
		String nutrientsIMG = request.getParameter("nutrientsIMG");
		String nutrientsDetail = request.getParameter("nutrientsDetail");
		String nutrientsDOM = request.getParameter("nutrientsDOM");       
		String dailyInTake = request.getParameter("dailyInTake");
		int numperbottle = Integer.parseInt(request.getParameter("numperbottle"));
		int remainingNum = Integer.parseInt(request.getParameter("remainingNum"));
		String link = request.getParameter("link");
		
		GoodsDAO dao = new GoodsDAO();
		NutrientsDTO dtoNutrients = new NutrientsDTO(nutrientsName, nutrientsPrice, nutrientsCategory, nutrientsIMG, nutrientsDetail, nutrientsDOM, dailyInTake, numperbottle, remainingNum, link);
		
		int resultNutrientsInsert = dao.AdminNutrientsInsert(dtoNutrients);
		if (resultNutrientsInsert > 0) {
			response.sendRedirect("admin?cmd=AdminNutrientsSelect");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
		
	}	


	
	
	/*************** 주문 조회 ***************/
	
	// 관리자) 주문 조회
	public void AdminOrderSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PurchaseDAO dao = new PurchaseDAO();
		List<PurchaseDTO> AdminOrderSelect = dao.AdminOrderSelect();

		if (AdminOrderSelect != null) {
			request.setAttribute("AdminOrderSelect", AdminOrderSelect);
			request.getRequestDispatcher("/views/jsp/admin/AdminOrderSelect.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	}	

}
