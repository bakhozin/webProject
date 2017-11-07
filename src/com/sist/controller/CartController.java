package com.sist.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.dao.GiftyconDAO;
import com.sist.vo.Giftycon;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	private GiftyconDAO gdao;
	@Autowired
	public void setGdao(GiftyconDAO gdao) {
		this.gdao = gdao;
	}
	
	@RequestMapping(value={"addCart.do"},method=RequestMethod.GET)
	public String addCart(HttpServletRequest request, String giftyconCode, Model model){
		
		HttpSession session = request.getSession();
		Giftycon giftycon = gdao.getGiftycon(giftyconCode);
		
		ArrayList<Giftycon> cartList = (ArrayList<Giftycon>) session.getAttribute("cartList");
		if(cartList==null){
			cartList = new ArrayList<>();
			session.setAttribute("cartList", cartList);
			cartList.add(giftycon);
			model.addAttribute("cartList",cartList);
			return "cartSuccess";
		}else{
			for(Giftycon g : cartList){
				if(g.getGiftyconCode().equals(giftycon.getGiftyconCode())){
					model.addAttribute("cartList",cartList);
					return "cartFail";
				}else{
					cartList.add(giftycon);
					model.addAttribute("cartList",cartList);
					return "cartSuccess";
				}
			}
		}
		return "";
	}
	
	@RequestMapping(value={"cartCheck.do"}, method=RequestMethod.GET)
	public String cartCheck(String giftyconCode){
		
		
		return "";
	}
}
