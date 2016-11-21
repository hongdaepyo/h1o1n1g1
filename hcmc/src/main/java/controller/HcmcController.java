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
import service.AdminService;
import service.CalendarService;
import service.MyPageService;

@Controller
public class HcmcController {
	private MyPageService mservice;
	private CalendarService cservice;
	private AdminService aservice;
	
	public HcmcController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMservice(MyPageService mservice) {
		this.mservice = mservice;
	}
	
	public void setCservice(CalendarService cservice) {
		this.cservice = cservice;
	}
	
	public void setAservice(AdminService aservice) {
		this.aservice = aservice;
	}
	
	
	@RequestMapping("/test.do")
	public String test(){
		return "index";
	}
	
	@RequestMapping("/info.do")
	public ModelAndView memListPage(int mem_num){
		ModelAndView mav = new ModelAndView();
		MemDTO dto= mservice.memberListProcess(mem_num);
		mav.addObject("dto", dto);
		mav.setViewName("index");
		return mav;
	}//회원 번호를 받아서 마이페이지를 보여줌
	
	@RequestMapping("/nickUpdate.do")
	public @ResponseBody String nickUpdate(MemDTO mdto){
		mservice.nickUpdateProcess(mdto);
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
		return mservice.passwordUpdateProcess(mdto);
	}//회원 비밀번호를 업데이트
	
	@RequestMapping("/finfo.do")
	public @ResponseBody FestivalDTO festival_info(int festival_num){
		return mservice.festivalInfoProcess(festival_num);
	}
	

//////////달력부분//////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/calendar.do")
	public ModelAndView cal_start(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",cservice.FestivalList());
		mav.setViewName("calview");
		return mav;
	}
	
	@RequestMapping("/calendar2.do")
	public @ResponseBody List<FestivalDTO> cal_test(){
		return cservice.FestivalList();
	}
	
/////////관리자페이지///////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/admin.do")
	public ModelAndView admin_page(){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.fListProcess());
		mav.setViewName("admin");
		return mav;
	}
	
	@RequestMapping("/body1.do")
	public String testt(){
		return "admin/body1";
	}
	
	
	@RequestMapping("/admin_mlist.do")
	public ModelAndView admin_mem(){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.mListProcess());
		mav.setViewName("admin/body2");
		return mav;
	}
	

}//end class
