package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwf.dao.HealthGoodsDAO;
import com.hwf.model.HealthGoodsDTO;

@WebServlet("/healthgoods")
public class HealthGoodsController extends HttpServlet {
	
	//디폴트 생성자
	public HealthGoodsController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd); //Console창 출력테스트

//		String choiceHealthGoods = "";
//
//		if (cmd.contains("1")) {
//			String[] arr = cmd.split("");
//			cmd = "";
//
//			for (int i = 15; i < 20; i++) {
//				choiceHealthGoods += arr[i];
//			}
//
//			for (int i = 0; i < 15; i++) {
//				cmd += arr[i];
//			}
//			
//			System.out.println( "choiceHealthGoods : " + choiceHealthGoods);
//
//		}

		//헬스용품 - 전체 조회
		if (cmd.equals("healthGoodsList")) {
			healthGoodsList(request, response);
		} 
		
		//헬스용품 - 카테고리 '운동용품' 조회
		else if (cmd.equals("selectDumbbell")) {
			selectDumbbell(request, response);

		} 
		
		//헬스용품 - 카테고리 '벨트' 조회
		else if (cmd.equals("selectBelt")) {
			selectBelt(request, response);
		} 
		
		//헬스용품 - 카테고리 '장갑' 조회
		else if (cmd.equals("selectGloves")) {
			selectGloves(request, response);
		} 
		
		//헬스용품 - 상세보기
		else if (cmd.equals("healthGoodsDetail")) {
			healthGoodsDetail(request, response);
		}
	}


	
	//healthgoodsList (헬스용품 전체 조회)
	public void healthGoodsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> healthGoodsList = dao.healthGoodsList();
		System.out.println(healthGoodsList);

		if (healthGoodsList != null) {
			request.setAttribute("healthGoodsList", healthGoodsList); // data save
			request.getRequestDispatcher("/views/jsp/healthGoods/allListHealthGoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	
	//selectDumbbell (헬스용품 - 카테고리 '운동용품' 조회)
	public void selectDumbbell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> selectDumbbell = dao.selectDumbbell();

		if (selectDumbbell != null) {
			request.setAttribute("healthGoodsList", selectDumbbell); // data save
			System.out.println(selectDumbbell);
			request.getRequestDispatcher("/views/jsp/healthGoods/allListHealthGoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	//selectBelt (헬스용품 - 카테고리 '벨트' 조회)
	public void selectBelt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> selectBelt = dao.selectBelt();

		if (selectBelt != null) {
			request.setAttribute("healthGoodsList", selectBelt); // data save
			request.getRequestDispatcher("/views/jsp/healthGoods/allListHealthGoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	//selectGloves (헬스용품 - 카테고리 '장갑' 조회)
	public void selectGloves(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> selectGloves = dao.selectGloves();

		if (selectGloves != null) {
			request.setAttribute("healthGoodsList", selectGloves); // data save
			request.getRequestDispatcher("/views/jsp/healthGoods/allListHealthGoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}


	//healthGoodsDetail (헬스용품 - 상세보기)
	public void healthGoodsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int healthGoodsId = Integer.parseInt(request.getParameter("healthGoodsId"));
		
		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> healthGoodsDetail = dao.healthGoodsDetail(healthGoodsId);
		
		if (healthGoodsDetail != null) {
			request.setAttribute("healthGoodsList", healthGoodsDetail); // data save
			request.getRequestDispatcher("/views/jsp/healthGoods/detailHealthGoods.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

}
