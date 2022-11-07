package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwf.dao.NutrientsDAO;
import com.hwf.model.NutrientsDTO;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	public CartController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		System.out.println("cmd : " + cmd);

		if (cmd.equals("list")) {
			list(request, response);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 메소드 시작
	//////////////////////////////////////////////////////////////////////////////////////
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NutrientsDAO dao = new NutrientsDAO();
		List<NutrientsDTO> list = dao.selectAll();

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

}
