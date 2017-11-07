package com.sist.controller;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.dao.CardDAO;
import com.sist.dao.GiftyconAccountDAO;
import com.sist.dao.GiftyconDAO;
import com.sist.dao.MemberDAO;
import com.sist.vo.Card;
import com.sist.vo.Giftycon;
import com.sist.vo.GiftyconAccount;
import com.sist.vo.Member;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private GiftyconDAO gdao;
	@Autowired
	public void setGdao(GiftyconDAO gdao) {
		this.gdao = gdao;
	}

	private GiftyconAccountDAO gadao;
	@Autowired
	public void setGadao(GiftyconAccountDAO gadao) {
		this.gadao = gadao;
	}

	private MemberDAO mdao;
	@Autowired
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	
	private CardDAO cdao;
	@Autowired
	public void setCdao(CardDAO cdao) {
		this.cdao = cdao;
	}


	@RequestMapping(value={"shopMain.do"}, method=RequestMethod.GET)
	public String shopMain(Model model, String type){
		
		if(type==null){
			type="C";
		}else{
			type = type.substring(0,1);
		}

		ArrayList<Giftycon> giftyconList = gdao.getGiftycons(type);
		model.addAttribute("giftyconList", giftyconList);
		
		return "shopMain.jsp";
	}
	


	@RequestMapping(value={"giftyconList.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String comboList(String type, Model model){
		
		System.out.println("giftyconList.do , type="+type);
		
		type = type.substring(0,1);
		
		ArrayList<Giftycon> giftyconList = gdao.getGiftycons(type);
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
		
		Giftycon giftycon = gdao.getGiftycon(giftyconCode);
		
		model.addAttribute("giftycon", giftycon);
		model.addAttribute("content1", giftycon.getContent().split("/")[0]);
		model.addAttribute("content2", giftycon.getContent().split("/")[1]);
		
		return "giftyconDetail.jsp";
	}

	@RequestMapping(value={"giftyconBuy.do"}, method=RequestMethod.GET)
	public String giftyconBuy(Model model, String giftyconCode, String gift, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		if(mid==null){
			return "redirect:login.do";
		}else{
			
			/*if(gift==null||gift.equals("")){
				model.addAttribute("gift","X");
			}*/
			
			Member m = mdao.getMember(mid);
			
			Giftycon giftycon = gdao.getGiftycon(giftyconCode);
			model.addAttribute("giftycon", giftycon);
			//model.addAttribute("gift", "O");
			model.addAttribute("content1", giftycon.getContent().split("/")[0]);
			model.addAttribute("content2", giftycon.getContent().split("/")[1]);
			model.addAttribute("m", m);
			
			return "giftyconBuy.jsp";
		}
	}
	
	@RequestMapping(value={"giftyconBuyProc.do"}, method=RequestMethod.POST)
	public String giftyconBuy(String[] rphone, String giftyconCode, String buyPhone, HttpServletRequest request, Model model, String total, String amount){
		
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		ArrayList<GiftyconAccount> list = new ArrayList<>();
		
		for(int i=0; i<rphone.length; i++){
			if(!rphone[i].equals("")){
				System.out.println(rphone[i]);
				GiftyconAccount ga = new GiftyconAccount();
				ga.setMid(mid);
				ga.setGiftyconCode(giftyconCode);
				ga.setRecipient(rphone[i]);
				
				int af = gadao.addShopAccount(ga);
				System.out.println("af:"+af);
				list.add(ga);
			}
		}
		
		Giftycon giftycon = gdao.getGiftycon(giftyconCode);
		Member m = mdao.getMember(mid);
		
		model.addAttribute("list", list);
		model.addAttribute("giftycon", giftycon);
		model.addAttribute("total", total);
		model.addAttribute("amount", amount);
		model.addAttribute("m", m);
		
		return "buyResult.jsp";
	}

	@RequestMapping(value={"phoneCheck.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String phoneCheck(String phone){
		
		Member m = mdao.getPhone(phone);
		if(m==null){
			return "checkX";
		}else{
			return "checkO";
		}
	}
	
	@RequestMapping(value={"login.do"}, method=RequestMethod.GET)
	public String login(){
		
		return "login.jsp";
	}

	@RequestMapping(value={"login.do"}, method=RequestMethod.POST)
	public String login(String mid, String pwd, HttpServletRequest request){
		Member m = mdao.getMember(mid);
		if(m==null){
			System.out.println("회원없음");
		}else if(m.getPwd().equals(pwd)){
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
		}
		
		return "redirect:shopMain.do";
	}

	@RequestMapping(value={"payment.do"}, method=RequestMethod.GET)
	public String payment(){
		
		return "payment.jsp";
	}

	@RequestMapping(value={"payment.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String payment(String cardNum, String pwd, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		System.out.println("cardNum : "+cardNum);
		Card card = cdao.getCard(cardNum);
		if(card==null){
			System.out.println("cardX");
			return "cardX";
		}else if(!card.getMid().equals(mid)){
			System.out.println("midX");
			return "midX";
		}else if(card.getPwd().equals(pwd)){
			System.out.println("success");
			return "success";
		}else{
			System.out.println("pwdX");
			return "cardX";
		}
		
	}

	@RequestMapping(value={"addCard.do"}, method=RequestMethod.GET)
	public String addCard(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		model.addAttribute("mid",mid);
		
		return "addCard.jsp";
	}
	
	@RequestMapping(value={"addCard.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String addCard(Card card){
		
		if(cdao.getCard(card.getCardNum())!=null){
			System.out.println("cardCKX");
			return "cardCKX";
		}else{
			int af = cdao.addCard(card);
			
			if(af==1){
				System.out.println("addSuccess");
				return "addSuccess";
			}else{
				
				return "addFail";
			}
		}
	}
}
