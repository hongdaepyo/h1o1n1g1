package service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dto.MemberDTO;

public class LoginServiceImp implements LoginService{
	private LoginDao dao;
	
	public LoginServiceImp() {
		// TODO Auto-generated constructor stub
	}
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@Override
	public String loginCheckProcess(String mem_id, String mem_pass) {
		return null;
	}
	@Override
	public String memberRegisterProcess(MemberDTO mdto, HttpServletRequest req) {
		//회원가입시 중복아이디 체크
		if(dao.LoginCount(mdto)){
			return "아이디 중복";
		}else{
			dao.memberRegisterMethod(mdto);
			return "비인증 회원";
		}
		//비인증 회원 상태로 회원을 등록
	}
	
	/////은지////////////////////////////////////////////////////////////////
	@Override
	public void loginInsertProcess(MemberDTO mdto) {
		dao.LoginInsert(mdto);
	}//id와 password를 MemberDTO에 담아 전달해서 등록// 아직 쓰이는 곳 없음

	@Override
	public MemberDTO loginSelectProcess(String mem_id) {	
		return dao.LoginSelect(mem_id);
	}//id를 넘겨주고 일치하는 회원의 모든 정보를 가져와서 리턴


	@Override
	public String loginCheckProcess(MemberDTO mdto, HttpServletRequest req) {
		System.out.println(mdto.getMem_id()+"service");
		MemberDTO memdto=dao.LoginSearch(mdto);
		if(dao.LoginCount(mdto)){ //입력된 아이디와 비밀번호가 일치하는 회원이 있는지를 판단하는 조건
			char memAdmin=dao.LoginSelect(mdto.getMem_id()).getMem_admin(); //로그인한 계정의 권한(0=관리자, 1=일반회원, 2=비인증회원)
			if(memAdmin=='1'){//일반회원
			req.getSession().setAttribute("chk", 1); //세션에 일반회원이라는 것을 표시하는 chk를 저장
			req.getSession().setAttribute("mem_num", memdto.getMem_num()); //세션에 회원번호 저장
			req.getSession().setAttribute("id", mdto.getMem_id()); //세션에 id저장 (로그인 후 헤더부분에 표시용도)
			req.getSession().setAttribute("mem_nick", memdto.getMem_nickname()); //세션에 닉네임저장(게시판에 표시용도)
			}else if(memAdmin=='2'){//비인증 회원
				req.getSession().setAttribute("chk", 2); //세션에 비인증회원이라는 것을 표시하는 chk저장
				service.MailService mail=new service.MailService();
				String mailaddr=mdto.getMem_id(); //로그인을 하기 위해 입력한 id가 메일을 받게되는 주소가 됨
				int mem_num=memdto.getMem_num();  //인증메일에 담아서 보낼 회원번호
				mail.MailSend(mailaddr,mem_num, req); //메일 서비스로 id와 mem_num을 전달
			}
			return "redirect:/main.do";
		}else{ //입력된 아이디와 비밀번호가 일치하는 회원이 없을 경우 아래 부분을 실행
			return "redirect:/test.do";
		}
	}
	
	@Override
	public void loginSearchProcess(MemberDTO mdto, HttpServletRequest request) {
		
		
	}
	
	@Override
	public String AuthorChange(String ecode, int mem_num, HttpServletRequest req) {
	service.MailService mail=new service.MailService();
	MemberDTO mdto=dao.Login_Mem_Num(mem_num);
	String mcode=mail.SHA256(mdto.getMem_id());//DB에 저장되어 있는 이메일주소를 암호화
		if(ecode.equals(mcode)){ //인증메일에 보내어진 암호화된 메일주소와 DB에 저장되어 있는 암호화된 이메일주소가 일지하는 지를 물음
			dao.AuthUpdate(mem_num); //비인증회원의 권한을 일반회원으로 바꿈
			req.getSession().setAttribute("chk", 1); //일반회원이라는 정보를 세션에 저장
			req.getSession().setAttribute("mem_num", mdto.getMem_num()); //회원정보 세션에 저장
			req.getSession().setAttribute("id", mdto.getMem_id()); //회원아이디 세션에 저장
			return "redirect:/main.do"; //메인으로 리다이렉트
		}else{
			return "인증실패";
		}
	}//end AuthorChange 발송된 인증메일의 링크를 눌러 들어오면 해당 회원의 권한을 일반회원으로 바꾸어줌
	
}
