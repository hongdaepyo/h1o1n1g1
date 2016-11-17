package controller;

import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.FestivalDTO;
import dto.MemDTO;
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
		System.out.println(mem_num+"번 회원 정보 들어왔다");
		ModelAndView mav = new ModelAndView();
		MemDTO dto= service.memberListProcess(mem_num);
		mav.addObject("dto", dto);
		mav.setViewName("index");
		return mav;
	}//회원 번호를 받아서 마이페이지를 보여줌
	
	@RequestMapping("/nickUpdate.do")
	public @ResponseBody String nickUpdate(MemDTO mdto){
		service.nickUpdateProcess(mdto);
		System.out.println(mdto.getMem_nickname());
		///*/*/*/*/*/*/*/*/*/*/*/*/*pom.xml에 simplejson 추가/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
		HashMap<String, Object> map = new HashMap<String, Object>();
		//key 나 value값에 한글 넣으면 jsp에서 못 읽음 한글처리 안함
		map.put("msg", "test");
		JSONObject json=new JSONObject(map);
		String jsonmsg=json.toJSONString();
		return jsonmsg;
	}//회원 번호와 입력된 닉네임을 MemDTO형태로 받아서 닉네임을 업데이트 해줌
	
	@RequestMapping("/pwUpdate.do")
	public MemDTO passwordUpdate(MemDTO mdto){
		return service.passwordUpdateProcess(mdto);
	}//회원 비밀번호를 업데이트
	
	@RequestMapping("/finfo.do")
	public @ResponseBody FestivalDTO festival_info(int festival_num){
		return service.festivalInfoProcess(festival_num);
	}
	
	@RequestMapping("/test2.do")
	public @ResponseBody MemDTO testList(MemDTO mdto){
		System.out.println("++test2++++"+mdto);
		//return service.testListProcess(mdto);
		return null;
	}

}//end class
