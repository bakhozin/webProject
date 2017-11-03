package com.sist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.dao.GiftyconDAO;
import com.sist.vo.Giftycon;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private GiftyconDAO gdao;

	@Autowired
	public void setGdao(GiftyconDAO gdao) {
		this.gdao = gdao;
	}

	@RequestMapping(value={"shopMain.do"}, method=RequestMethod.GET)
	public String shopMain(Model model){
		
		ArrayList<Giftycon> giftyconList = gdao.getShops("C");
		model.addAttribute("giftyconList", giftyconList);
		
		return "shopMain.jsp";
	}
	
	@RequestMapping(value={"giftyconList.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String comboList(String type, Model model){
		
		System.out.println("giftyconList.do , type="+type);
		
		ArrayList<Giftycon> giftyconList = gdao.getShops(type);
		//model.addAttribute("giftyconList", giftyconList);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(giftyconList);
		
		System.out.println(jsonStr);
		/*for(Giftycon g : giftyconList){
			System.out.println(g.toString());
		}*/
		
		
		return jsonStr;
	}
	
	
}
