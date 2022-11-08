package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.CartDAO;
import com.hwf.dao.NutrientsDAO;
import com.hwf.model.CartDTO;
import com.hwf.model.NutrientsDTO;

@WebServlet("/cart")
public class CartController extends HttpServlet {

	public CartController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		System.out.println("cmd : " + cmd);

		if (cmd.equals("insertCart")) {
			insertCart(request, response);
		}else if (cmd.equals("insertbottleCart")) {
			insertbottleCart(request, response);
		}
	}

	public void insertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();

			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		String productId = request.getParameter("hiddenid"); // 제품 아이디 번호
		String totalPrice = request.getParameter("onetotal"); // 총 가격
		String totalCount = request.getParameter("countone"); // 총 수량
		String getMethod = request.getParameter("getnu"); // 받는 방법

		int n;

		if (getMethod.equals("onetime")) {
			n = 1;
		} else {
			n = 2;
		}

		String selectGetDay = request.getParameter("selectgetday"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(),
				Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		int count = cartdao.insertData(cartDto);
		System.out.println(count);

		request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);

	}

	public void insertbottleCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();

			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		String productId = request.getParameter("hiddenid"); // 제품 아이디 번호
		String totalPrice = request.getParameter("total"); // 총 가격
		String totalCount = request.getParameter("countnum"); // 총 수량
		String getMethod = request.getParameter("getnuall"); // 받는 방법

		int n;

		if (getMethod.equals("onetime")) {
			n = 1;
		} else {
			n = 2;
		}

		String selectGetDay = request.getParameter("selectgetday2"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr2"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(),
				Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		int count = cartdao.insertData(cartDto);
		System.out.println(count);

		request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);

	}

}
