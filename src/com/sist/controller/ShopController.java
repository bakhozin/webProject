package com.sist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.dao.GiftyconAccountDAO;
import com.sist.dao.GiftyconDAO;
import com.sist.vo.Giftycon;
import com.sist.vo.GiftyconAccount;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private GiftyconDAO gdao;
	@Autowired
	public void setGdao(GiftyconDAO gdao) {
		this.gdao = gdao;
	}

	private GiftyconAccountDAO gadao;
	public void setGadao(GiftyconAccountDAO gadao) {
		this.gadao = gadao;
	}

	
	@RequestMapping(value={"shopMain.do"}, method=RequestMethod.GET)
	public String shopMain(Model model, String type){
		
		type = type.substring(0,1);
		if(type==null){
			type="C";
		}
		ArrayList<Giftycon> giftyconList = gdao.getShops(type);
		model.addAttribute("giftyconList", giftyconList);
		
		return "shopMain.jsp";
	}
	
	@RequestMapping(value={"giftyconList.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String comboList(String type, Model model){
		
		System.out.println("giftyconList.do , type="+type);
		
		type = type.substring(0,1);
		
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
	
	@RequestMapping(value={"giftyconDetail.do"}, method=RequestMethod.GET)
	public String giftyconDetail(String giftyconCode, Model model){
		
		Giftycon giftycon = gdao.getShop(giftyconCode);
		
		model.addAttribute("giftycon", giftycon);
		model.addAttribute("content1", giftycon.getContent().split("/")[0]);
		model.addAttribute("content2", giftycon.getContent().split("/")[1]);
		
		return "giftyconDetail.jsp";
	}

	@RequestMapping(value={"giftyconBuy.do"}, method=RequestMethod.GET)
	public String giftyconBuy(Model model){
		return "";
	}
	
	@RequestMapping(value={"giftyconBuy.do"}, method=RequestMethod.POST)
	public String giftyconBuy(GiftyconAccount ga){
		return "";
	}

}
