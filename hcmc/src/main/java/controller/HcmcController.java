package controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDTO;
import service.MyPageService;

@Controller
public class HcmcController {
	private MyPageService service;
	
	public HcmcController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(MyPageService service) {
		this.service = service;
	}
	
	@RequestMapping("/test.do")
	public String test(){
		return "index";
	}
	
	@RequestMapping("/info.do")
	public ModelAndView memListPage(int mem_num){
		ModelAndView mav = new ModelAndView();
		MemberDTO dto= service.memberListProcess(mem_num);
		System.out.println(dto.getMem_nickname());
		mav.addObject("dto", dto);
		mav.setViewName("index");
		return mav;
	}
	
/*	public ModelAndView update(HashMap<Integer, String> map){
		
		return mav;
	}*/
	
	@RequestMapping("/test2.do")
	public ModelAndView testList(int mem_num){
		System.out.println(1+"++test2++++"+mem_num);
		ModelAndView mav = new ModelAndView();
		System.out.println(service.testProcess(mem_num)+"/////");
		mav.addObject("list",service.testProcess(mem_num));
		mav.setViewName("index");
		return mav;
	}

}//end class
