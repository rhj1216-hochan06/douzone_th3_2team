package com.hwf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwf.dao.CartDAO;
import com.hwf.model.NutrientsDTO;

@RestController
public class CartController {

	@Autowired
	private CartDAO cartdao;

	@RequestMapping(value = "/views/jsp/buy/cart", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "cart";
	}

	@RequestMapping(value = "/HwF/nutrients" , method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> buydaycart(Locale locale, Model model, HttpServletRequest request) {

		System.out.println("123");
		HashMap<String, String> result = new HashMap<String, String>();

		String productsName = request.getParameter("productsName");

		List<NutrientsDTO> list = cartdao.selectusename(productsName);

		System.out.println(list.get(0));

		return result;

	}
}
