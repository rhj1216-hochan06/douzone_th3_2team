package com.hwf.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.CartDAO;
import com.hwf.dao.HealthFoodDAO;
import com.hwf.dao.HealthGoodsDAO;
import com.hwf.dao.NutrientsDAO;
import com.hwf.dao.PurchaseDAO;
import com.hwf.model.CartDTO;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;
import com.hwf.model.PurchaseDTO;

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
		} else if (cmd.equals("insertbottleCart")) {
			insertbottleCart(request, response);
		} else if (cmd.equals("deleteSelete")) {
			deleteSelete(request, response);
		} else if (cmd.equals("purchase")) {
			purchase(request, response);
		} else if (cmd.equals("creditpurchase")) {
			creditpurchase(request, response);
		} else if (cmd.equals("success")) {
			success(request, response);
		} else if (cmd.equals("fail")) {
			fail(request, response);
		}
	}

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
			} else {
				continue;
			}
		}

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
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
			} else {
				continue;
			}
		}

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}

	}

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

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
		}
		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		}
	}

	public void purchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		String[] idarr = id.split(",");

		CartDAO cartdao = new CartDAO();

		int price = 0; // 총 가격

		for (int i = 0; i < idarr.length; i++) {
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));

			price += searchPriceDto.get(0).getProductsPrice();

		}

		HttpSession session;
		session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);

		session.setAttribute("cartId", id);

		request.setAttribute("totalPrice", price);

		request.getRequestDispatcher("/views/jsp/cart/kakaopay.jsp").forward(request, response);

	}
	
	public void creditpurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		String[] idarr = id.split(",");

		CartDAO cartdao = new CartDAO();

		int price = 0; // 총 가격

		for (int i = 0; i < idarr.length; i++) {
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));

			price += searchPriceDto.get(0).getProductsPrice();

		}

		HttpSession session;
		session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);

		session.setAttribute("cartId", id);

		request.setAttribute("totalPrice", price);

		request.getRequestDispatcher("/views/jsp/cart/creditcard.jsp").forward(request, response);

	}

	public void success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();

		String cusId = session.getAttribute("memberid").toString(); // 고객 id

		String[] idarr = session.getAttribute("cartId").toString().split(","); // id 배열

		CartDAO cartdao = new CartDAO();

		HealthFoodDAO healthfooddao = new HealthFoodDAO();

		HealthGoodsDAO healthgoodsdao = new HealthGoodsDAO();

		PurchaseDAO purchasedao = new PurchaseDAO();
		PurchaseDTO purchasedto;

		for (int i = 0; i < idarr.length; i++) {
			// 장바구니 cartId로 조회
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));
			String memberid = searchPriceDto.get(0).getMemberId(); // 회원 id
			int price = searchPriceDto.get(0).getProductsPrice(); // 총 가격
			String number = searchPriceDto.get(0).getProductsId(); // 제품 아이디

			// id 첫 글자로 insert 구별
			int num = Integer.parseInt(searchPriceDto.get(0).getProductsId().substring(0, 1));

			switch (num) {
			case 3: // 영양제

				// 수령 방식
				String getMethod = searchPriceDto.get(0).getReservation();

				// 수령시작날짜
				String selectGetDay = searchPriceDto.get(0).getPurchasetime().substring(0, 10);
				// 수령 기간 -- > 끝나는 날짜에서 시작 날짜뺴야 함
				LocalDate selectGetDate = LocalDate.parse(selectGetDay);
				LocalDate finishDay = LocalDate.parse(searchPriceDto.get(0).getEndtime().substring(0, 10));

				Period period = Period.between(selectGetDate, finishDay);
				int difference = period.getDays(); // 수령 기간

				int nutrid = Integer.parseInt(searchPriceDto.get(0).getProductsId());

				purchasedto = new PurchaseDTO(price, getMethod, selectGetDay, difference, nutrid, memberid);
				purchasedao.purchaseNutr(purchasedto);

				break;

			case 2: // 식품

				List<HealthFoodDTO> healthfooddto = healthfooddao.healthFoodDetail(Integer.parseInt(number));
				int thisprice = price / healthfooddto.get(0).getHfPrice(); // --> 갯수

				// 식품 아이디
				int foodid = Integer.parseInt(searchPriceDto.get(0).getProductsId());

				purchasedto = new PurchaseDTO(thisprice, price, foodid, memberid);
				purchasedao.purchaseHealthFood(purchasedto);

				break;
			case 1: // 용품

				List<HealthGoodsDTO> healthgoodsdto = healthgoodsdao.healthGoodsDetail(Integer.parseInt(number));
				int subprice = price / healthgoodsdto.get(0).getHealthGoodsPrice(); // --> 갯수

				// 용품 아이디
				int goodsid = Integer.parseInt(searchPriceDto.get(0).getProductsId());

				String diff = null;

				purchasedto = new PurchaseDTO(subprice, price, diff, goodsid, memberid);
				purchasedao.purchaseHealthFood(purchasedto);

				break;

			}

		}

		purchasedao.deleteData(cusId);

		request.getRequestDispatcher("/views/jsp/cart/purchaseSuccess.jsp").forward(request, response);
	}

	public void fail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDAO cartdao = new CartDAO();

		HttpSession session;
		session = request.getSession();

		String cusId = session.getAttribute("memberid").toString();

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation().equals("1")) {
				i.setReservation("한번에 받기");
			} else
				i.setReservation("나눠서 받기");
		}

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		}
	}
}
