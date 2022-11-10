package com.hwf.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.CartDAO;
import com.hwf.dao.HealthGoodsDAO;
import com.hwf.dao.NutrientsDAO;
import com.hwf.model.CartDTO;
import com.hwf.model.HealthGoodsDTO;
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
		 
		if (cmd.equals("insertCart")) { //장바구니 (영양제)
			insertCart(request, response);
		} 
		else if (cmd.equals("insertbottleCart")) { //장바구니 (영양제)
			insertbottleCart(request, response);
		} 
		else if (cmd.equals("healthGoodsInsertCart")) { //장바구니 (헬스용품)
			healthGoodsInsertCart(request, response);
		}
		else if (cmd.equals("deleteSelete")) { //장바구니 삭제
			deleteSelete(request, response);
		}
		else if (cmd.equals("purchase")) {
			purchase(request, response);
		} 
	}

	
	//insertCart (장바구니 (영양제))
	public void insertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();

			cusId = session.getAttribute("memberid").toString(); // 고객 id

			System.out.println(cusId);

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

		String n;

		if (getMethod.equals("onetime")) {
			n = "1";
		} else {
			n = "2";
		}

		String selectGetDay = request.getParameter("selectgetday"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();

		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(),
				Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		cartdao.insertData(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
				}
			else {
				continue;
			}
		} //end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}

	
	//insertbottleCart (장바구니 (영양제))
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

		String n;

		if (getMethod.equals("onetime")) {
			n = "1";
		} else {
			n = "2";
		}

		String selectGetDay = request.getParameter("selectgetday2"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr2"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(),
				Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		cartdao.insertData(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);
		
		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
				}
			else {
				continue;
			}
		} //end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}

	}
	
	
	//healthGoodsInsertCart (장바구니 (헬스용품))
	public void healthGoodsInsertCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();
			cusId = session.getAttribute("memberid").toString(); // 고객 id

			System.out.println("고객 id : " + cusId);

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		
//		String productsId = request.getParameter("hiddenid"); //제품번호
		String productsId = request.getParameter("healthGoodsId"); //제품번호
		System.out.println(productsId);
		String productsPrice = request.getParameter("onetotal"); //총 가격

		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> list = dao.healthGoodsDetail(Integer.parseInt(productsId));
//		System.out.println(list); //[] 출력
		
		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productsId, list.get(0).getHealthGoodsName(), list.get(0).getHealthGoodsImg(),Integer.parseInt(productsPrice));
		cartdao.insertDataExcept(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}	
	
	
	//deleteSelete (장바구니 삭제)
	public void deleteSelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CartDAO cartdao = new CartDAO();

		String[] arr = request.getParameter("hiddenid").split(",");

		for (int i = 0; i < arr.length; i++) {
			int deleteNum = cartdao.deleteData(Integer.parseInt(arr[i]));
		}

		HttpSession session;
		session = request.getSession();

		String cusId = session.getAttribute("memberid").toString();

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

//		for (CartDTO i : cartsearchDto) {
//			if (i.getReservation().equals("1")) {
//				i.setReservation("한번에 받기");
//			} else 
//				i.setReservation("나눠서 받기");
//		}
		
		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
				}
			else {
				continue;
			}
		} //end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		}
	}

	public void purchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}