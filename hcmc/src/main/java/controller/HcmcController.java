package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;
import dto.PageDTO;
import dto.ReplyDTO;
import service.AdminService;
import service.BoardService;
import service.CalendarService;
import service.LoginService;
import service.MainService;
import service.MyPageService;
import service.SearchService;

@Controller
public class HcmcController {
	private MyPageService mservice;
	private CalendarService cservice;
	private AdminService aservice;
	private LoginService loginservice;
	private BoardService bservice;
	private SearchService sservice;
	private MainService mainservice;
	
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
	
	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}
	
	public void setBservice(BoardService bservice) {
		this.bservice = bservice;
	}
	public void setSservice(SearchService sservice) {
		this.sservice = sservice;
	}
	
	public void setMainservice(MainService mainservice) {
		this.mainservice = mainservice;
	}
	
///////////마이페이지////////////////////////////////////////////////////////
	@RequestMapping("/test.do")
	public String test(){
		return "index";
	}//마이페이지 접속테스트용
	
	@RequestMapping("/info.do")
	public ModelAndView memListPage(int mem_num){
		ModelAndView mav = new ModelAndView();
		MemberDTO dto= mservice.memberListProcess(mem_num);
		mav.addObject("dto", dto);
		mav.setViewName("index");
		return mav;
	}//회원 번호를 받아서 마이페이지를 보여줌
	
	@RequestMapping("/myBoardList.do")
	public ModelAndView MyBoardListPage(int mem_num){
		ModelAndView mav = new ModelAndView();
		mav.addObject("mblist",mservice.myBoardListProcess(mem_num));
		mav.setViewName("menu1");
		return mav;
	}//회원 번호를 받아서 내가 쓴 글을 보여줌
	
	@RequestMapping("/myFavorList.do")
	public ModelAndView myFavorListPage(int mem_num){
		ModelAndView mav= new ModelAndView();
		mav.addObject("mflist",mservice.myFavorListProcess(mem_num));
		mav.setViewName("menu2");
		return mav;
	}//회원 번호를 받아서 나의 즐겨찾기 현황을 보여줌
		
	@RequestMapping("/nickUpdate.do")
	public @ResponseBody String nickUpdate(MemberDTO mdto){
		mservice.nickUpdateProcess(mdto);
		System.out.println(mdto.getMem_nickname());
		///*/*/*/*/*/*/*/*/*/*/*/*/*pom.xml에 simplejson 추가/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
		HashMap<String, Object> map = new HashMap<String, Object>();
		//key 나 value값에 한글 넣으면 jsp에서 못 읽음 한글처리 안함
		map.put("msg", "test");
		JSONObject json=new JSONObject(map);
		String jsonmsg=json.toJSONString();
		return jsonmsg;
	}//회원 번호와 입력된 닉네임을 MemberDTO형태로 받아서 닉네임을 업데이트 해줌
	
	@RequestMapping("/pwUpdate.do")
	public MemberDTO passwordUpdate(MemberDTO mdto){
		return mservice.passwordUpdateProcess(mdto);
	}//회원 비밀번호를 업데이트
	

//////////달력부분//////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/calendar.do")
	public ModelAndView cal_start(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calview");
		return mav;
	}//달력페이지 접속용
	
	@RequestMapping("/calendar2.do")
	public @ResponseBody List<FestivalDTO> cal_test(int month, int year){
		return cservice.FestivalList(month, year);
	}//달력페이지의 각 날짜에 뿌려줄 축제정보를 가져옴
	
	@RequestMapping("/finfo.do")
	public @ResponseBody HashMap<String, Object> festival_info(int festival_num){
		cservice.readCountProcess(festival_num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("f", cservice.festivalInfoProcess(festival_num));
		map.put("c", cservice.cityInfoProcess(festival_num));
		return map;
	}//축제정보 페이지에 표시해줄 축제정보와 도시정보를 가져옴
	
/////////관리자페이지///////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/admin.do")
	public ModelAndView admin_page(){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.fListProcess());
		mav.setViewName("admin");
		return mav;
	}//관리자 페이지 접속용 축제정보를 가져오면서 관리자 페이지를 띄움
	
	@RequestMapping("/admin_blist.do")
	public ModelAndView admin_board(){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.bListProcess());
		mav.setViewName("admin/body1");
		return mav;
	}//관리자 페이지의 게시글 관리페이지에 뿌려줄 게시판 정보를 가져옴
	
	
	@RequestMapping("/admin_mlist.do")
	public ModelAndView admin_mem(){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.mListProcess());
		mav.setViewName("admin/body2");
		return mav;
	}//관리자 페이지의 회원 관리페이지에 뿌려줄 게시판 정보를 가져옴
	
	@RequestMapping("/adminFestivalUpdate.do" )
	public String adminFestivalUpdate(FestivalDTO fdto){
		aservice.fUpdateProcess(fdto);
		return "redirect:/admin.do";
	}//관리자 페이지에서 축제정보를 업데이트하는 부분
	
	@RequestMapping("/adminBoardUpdate.do")
	public String adminBoardUpdate(BoardDTO bdto){
		aservice.bUpdateProcess(bdto);
		return "redirect:/admin_blist.do";
	}//관리자 페이지에서 게시글 정보를 업데이트하는 부분
	
	@RequestMapping("/adminMemberUpdate.do")
	public String adminMemberUpdate(MemberDTO mdto){
		aservice.mUpdateProcess(mdto);
		return "redirect:/admin_mlist.do";
	}//관리자 페이지에서 회원정보를 업데이트하는 부분
	
	@RequestMapping("/adminFestivalDelete.do")
	public String adminFestivalDelete(FestivalDTO fdto, HttpServletRequest req){
		aservice.fDeleteProcess(fdto,req);
		return "redirect:/admin.do";
	}//관리자 페이지에서 축제정보를 삭제하는 부분
	
	@RequestMapping("/adminFestivalAdd.do")
	public ModelAndView adminFestivalAdd(FestivalDTO fdto){
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",aservice.fAddProcess(fdto));
		mav.setViewName("admin");
		return mav;
	}//관리자 페이지에서 축제정보를 추가하는 부분
	
////////로그인페이지//////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister(MemberDTO mdto, HttpServletRequest req){
		loginservice.memberRegisterProcess(mdto, req);
		return "redirect:/main.do";
	}//회원 가입을 시도하면 접속되는 부분
	
	@RequestMapping("/loginCheck.do")
	public String loginCheck(String mem_id, String mem_pass){
		return null;
	}//아직 쓰는 곳 없음
	
	@RequestMapping("/logincheck.do")
	public String login(){
		return "login";
	}//아직 쓰는 곳 없음
	
	
	
	@RequestMapping("/main.do")
	public ModelAndView mainprocess(){
		System.out.println(mainservice.mainProcess());
		ModelAndView mav = new ModelAndView();
		mav.addObject("board_mem",mainservice.mainProcess());
		mav.setViewName("main");
		return mav;				
	}//메인화면 접속하는 곳
	
	@RequestMapping("/search.do")
	public ModelAndView search(String city_name, String festival_theme, String festival_start, PageDTO pv){	
		
		ModelAndView mav = new ModelAndView();	
		int totalRecord =sservice.totalProcess(city_name,festival_theme,festival_start);
		
		if(totalRecord >=1 ){
			if(pv.getCurrentPage()==0)
				currentPage=1;
			else
				currentPage=pv.getCurrentPage();
			
			//페이지번호 값 구하기
			pdto = new PageDTO(currentPage,totalRecord);
			
			//list.jsp에서 페이지번호를 사용하기위해 pdto를 pv라는 이름으로 넘겨준다.	
			mav.addObject("pv",pdto);
			mav.addObject("aList", sservice.searchProcess(city_name,festival_theme,festival_start));
		}
		
		mav.addObject("month", sservice.monthProcess());
		mav.setViewName("search");
		return mav;
		
	}//메인화면에서 검색화면으로 넘어가면서 필요한 정보를 가져오는 부분
	
	@RequestMapping("/loginSearch.do")
	public @ResponseBody MemberDTO loginSearch(MemberDTO mdto){	
		loginservice.loginInsertProcess(mdto);
		return loginservice.loginSelectProcess(mdto.getMem_id());
	}
	

	@RequestMapping("/loginpro.do")
	public String logCheckProcess(String returnUrl, MemberDTO dto, HttpServletRequest req) {
		return loginservice.loginCheckProcess(dto, req);
	}// end logCheckProcess() //로그인 할때 mem_id와 mem_pass를 MemberDTO로 받아옴
	
	@RequestMapping("/login.do")
	public MemberDTO login(MemberDTO dto, HttpSession session){
		return null;
	}//아직 쓰는 곳 없음
	
	@RequestMapping("/logout.do")
	   public String logoutPage(HttpSession session){
	      session.invalidate();
	      return "redirect:/main.do";
	   }//로그아웃 버튼을 누르면 모든 세션을 제거하고 메인화면으로 리다이렉트
	
	@RequestMapping("/hub.do")
	public String hubpage(HttpServletRequest req){
		return "hub";
	}//인증 메일의 링크를 누르면 잠시 들어와 조건에 맞는 곳으로 이동시켜주는 중간 지점
	
	@RequestMapping("/authChange.do")
	public String authChange(String ecode, int mem_num, HttpServletRequest req){
		System.out.println("authChange"+ecode+"/////"+mem_num);
		loginservice.AuthorChange(ecode, mem_num, req);
		return "redirect:/main.do";
	}//비인증 회원이 인증메일의 링크를 누르면 회원등급을 바꿔줌

	
//////메인화면///////////////////////////////////////////////////////////////////////////////////////
	
	
	
/////게시판///////////////////////////////////////////////////////////////
	private int currentPage;
	private PageDTO pdto;
		
		@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView boardListPage(PageDTO pv) {
			ModelAndView mav = new ModelAndView();
			int totalRecoed = bservice.countProcess(); //게시글 총 갯수
			if(totalRecoed >= 1){ //게시글이 하나라도 있는지 물음
				if(pv.getCurrentPage() == 0)// pageDTO에 현재페이지가 0이면 currentPage에 1을 저장
					currentPage = 1;
				else
					currentPage = pv.getCurrentPage();//pageDTO의 현재페이지가 0이 아니면 그 값을 currentPage에 저장
				pdto = new PageDTO(currentPage, totalRecoed);//pageDTO생성자중 인자값이 두개인 생성자에 현재 페이지와 게시글 총 갯수를 넘기면서 객체 생성
				mav.addObject("pv",pdto); //생성된 pdto를 pv라는 이름으로 mav에 추가
				mav.addObject("list", bservice.boardListProcess(pdto)); //현재페이지에 뿌려줄 게시글만 가져와서 list란 이름으로 mav에 추가
			}
			mav.setViewName("BoardView");
			return mav;
		}//게시판에 페이지 구분해서 리스트 뿌림
		
		@RequestMapping(value="/boardWrite.do", method = RequestMethod.POST)
		public String write(BoardDTO dto, HttpServletRequest request) {
			if(dto.getBoard_head().equals("일반") || dto.getBoard_head().equals("문의"))
				dto.setFestival_num(1); //게시글의 종류가 일반이나 문의라면 축제번호를 1로 지정
			bservice.boardInsertProcess(dto, request);
			return "redirect:/boardList.do";
		}// end writeMethod() //게시글 등록
		
		@RequestMapping(value="/repWrite.do", method = RequestMethod.POST)
		public String repWrite(ReplyDTO dto, HttpServletRequest request) {
			bservice.repInsertProcess(dto, request);
			return "redirect:/boardList.do";
		}// end repwriteMethod() //댓글 등록
		
		@RequestMapping(value="/boardUpdate.do", method = RequestMethod.POST)
		public String boardUpdateMethod(BoardDTO dto, HttpServletRequest request) {
			if(dto.getBoard_head().equals("일반") || dto.getBoard_head().equals("문의"))
				dto.setFestival_num(1); //게시글의 종류가 일반이나 문의라면 축제번호를 1로 지정
			bservice.boardUpdateProcess(dto, request);
			return "redirect:/boardList.do";
		}//end boardUpdateMethod() //게시글 수정

		@RequestMapping(value="/repUpdate.do", method = RequestMethod.POST)
		public String repUpdateMethod(ReplyDTO rdto, HttpServletRequest request) {
			bservice.repUpdateProcess(rdto, request);
			return "redirect:/boardList.do"; 
		}//댓글 수정
		
		@RequestMapping("/boardDelete.do")
		public @ResponseBody String boardDeleteMethod(int board_num, HttpServletRequest request) {
			bservice.boardDeleteProcess(board_num, request);
			return "redirect:/boardList.do"; 
		}//게시글 삭제
		
		@RequestMapping("/repDelete.do")
		public @ResponseBody String repDeleteListMethod(int rep_num, HttpServletRequest request) {
			bservice.repDeleteProcess(rep_num, request);
			return "redirect:/boardList.do";
		}//댓글 삭제
		
		// <img src="image.do?filename=사진이름" alt="Upload Image" /> 재민신의 도움
		@RequestMapping(value = "/image.do", method = RequestMethod.GET) 
		public void showImage(String filename, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException { 
			String filePath = request.getSession().getServletContext().getRealPath(File.separator) + "/temp/" + filename; //게시판에 뿌려줄 사진 경로
			byte[] a = readFile(filePath); //readFile메소드에 filePath를 담아서 호출하고 리턴값을 바이트배열로 저장
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif"); //이미지 파일에 확장자를 붙여줌
		 	response.getOutputStream().write(a); 
		 	response.getOutputStream().close();
		 } 
		private byte[] readFile(String fileName) throws IOException { 
			String path = fileName; 
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path)); 
			int length = bis.available(); 
		 	byte[] bytes = new byte[length]; 
			bis.read(bytes); 
		 	bis.close(); 
		 	return bytes; 
		}
		
		@RequestMapping("/FesList.do")
		public @ResponseBody List<FestivalDTO> FesListMethod(FestivalDTO dto, HttpServletRequest request){
			return bservice.FesListProcess();
		}	//축제 번호와 이름 가져옴
	
	
}//end class
