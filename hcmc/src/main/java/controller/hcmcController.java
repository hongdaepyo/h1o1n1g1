package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MyPageServiceImp;

@Controller
public class hcmcController {
	private MyPageServiceImp service;
	
	public hcmcController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/nickNameMethod")
	public ModelAndView nickNameMethod(){
		ModelAndView mav= new ModelAndView();
		return mav;
	}
	
	
	@RequestMapping("/index.do")
	public String mypageProcess(){
		return "index";
	}//end mypageProcess()
	
	@RequestMapping("/detail.do")
	public String detailProcess(){
		return "datail";
	}//end detailProcess()
	
	@RequestMapping("/menu1.do")
	public String menuProcess_1(){
		return "menu1";
	}
	
	@RequestMapping("/menu2.do")
	public String menuProcess_2(){
		return "menu2";
	}
	
	@RequestMapping("/menu3.do")
	public String menuProcess_3(){
		return "menu3";
	}
	
	@RequestMapping("/menu4.do")
	public String menuProcess_4(){
		return "menu4";
	}

}// end class