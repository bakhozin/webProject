package com.sist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.dao.ReviewDAO;
import com.sist.vo.Giftycon;
import com.sist.vo.Review;

@Controller
@RequestMapping("/movie/*")
public class MovieController {
	
	@Autowired
	private ReviewDAO rdao;
	
	
	@RequestMapping(value={"review.do"}, method=RequestMethod.GET)
	public String review(Model model){
		
	/*	List<Review> rList = rdao.allReview(pg, field, query);
		
		String star = null;
		
		model.addAttribute("star", star);*/

		
		
		
		return "shopMain.jsp";
	}
	
	@RequestMapping(value={"reviewReg.do"}, method=RequestMethod.GET)
	public String reviewReg(){
		
		
		
		
		return "reviewReg.jsp";
	}
	
	@RequestMapping(value={"reviewReg.do"}, method=RequestMethod.POST)
	public String reviewReg(Model model,Review r,String mid){
			
		String star=null;
		if(r.getGPA() <= 1){
			star = "star_score_01.png";
		}else if(1.0 < r.getGPA() && r.getGPA() <= 2.0){
			star = "star_score_02.png";			
		}else if(2.0< r.getGPA() && r.getGPA() <= 3.0){
			star = "star_score_03.png";
		}else if(3.0< r.getGPA() && r.getGPA() <= 4.0){
			star = "star_score_04.png";
		}else if(4.0< r.getGPA() && r.getGPA() <= 5.0){
			star = "star_score_05.png";
		}else if(5.0< r.getGPA() && r.getGPA() <= 6.0){
			star = "star_score_06.png";
		}else if(6.0< r.getGPA() && r.getGPA() <= 7.0){
			star = "star_score_07.png";
		}else if(7.0< r.getGPA() && r.getGPA() <= 8.0){
			star = "star_score_08.png";
		}else if(8.0< r.getGPA() && r.getGPA() <= 9.0){
			star = "star_score_09.png";
		}else if(9.0< r.getGPA() && r.getGPA() <= 10.0){
			star = "star_score_10.png";
		};
		
		r.setStar(star);
		rdao.addReview(r, mid);
		
		return "redirect:review.jsp";
	}
	


}
