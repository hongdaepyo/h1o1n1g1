package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.AdminDao;
import dto.BoardDTO;
import dto.FestivalDTO;
import dto.MemberDTO;
import dto.MemberDTO;

public class AdminServiceImp implements AdminService{
	private AdminDao dao;
	
	public AdminServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public List<FestivalDTO> fListProcess() {
		return dao.fListMethod();
	}//모든 축제 정보를 축제 정보 순서로 정렬하여 가져와서 리턴
	
	@Override
	public List<BoardDTO> bListProcess() {
		return dao.bListMethod();
	}//모든 게시글 정보를 게시글 번호순으로 정렬하여 가져와서 리턴

	@Override
	public List<MemberDTO> mListProcess() {
		return dao.mListMethod();
	}//모든 회원 정보를 회원번호 순으로 정렬하여 가져와서 리턴

	@Override
	public void fUpdateProcess(FestivalDTO fdto, HttpServletRequest req) {
		List<String> sList = new ArrayList<String>();
		if(fdto.getFestival_filename() != null){
			for(int i=0; i<fdto.getFestival_filename().length;i++){
				MultipartFile file= fdto.getFestival_filename()[i];
				if(!file.isEmpty()){
					String fileName = file.getOriginalFilename();
					//중복파일명을 처리하기 위해 난수 발생
					UUID random = UUID.randomUUID();
					String root = req.getSession().getServletContext().getRealPath("/");
					String saveDirectory = root + "temp" + File.separator;
					File fe=new File(saveDirectory);
					if(!fe.exists()){
						fe.mkdirs();
					}
					File ff= new File(saveDirectory, random+"_"+fileName);
					try {
						FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					sList.add(random+"_"+fileName);
				}
			}
			fdto.setFestival_pic(sList);
			System.out.println("adminservice:"+sList.toString());
		}
		dao.fUpdateMethod(fdto);	
	}//파일을 배열로 담아와서 스트링 리스트로 바꾼후 업데이트

	@Override
	public void bUpdateProcess(BoardDTO bdto) {
		dao.bUpdateMethod(bdto);
	}//BoardDTO에 수정된 게시글 정보를 담아와서 업데이트
	
	@Override
	public void mUpdateProcess(MemberDTO mdto) {
		dao.mUpdateMethod(mdto);		
	}//MemberDTO에 수정된 회원 정보를 담아와서 업데이트

	@Override
	public void fDeleteProcess(FestivalDTO fdto, HttpServletRequest req) {
		dao.fDeleteMethod(fdto);
		
	}//FestivalDTO에 축제번호를 담아와서 해당 축제를 삭제???

	@Override
	public List<FestivalDTO> fAddProcess(FestivalDTO fdto) {
		dao.fAddMethod(fdto);
		return dao.fListMethod();
	}//축제추가 폼에 입력된 정보를 FestivalDTO로 담아와서 입력하고 축제 정보를 다시 받아와서 리턴

	@Override
	public void fInsProcess(FestivalDTO fdto, HttpServletRequest req) {
		List<String> sList = new ArrayList<String>();
		if(fdto.getFestival_filename() != null){
			for(int i=0; i<fdto.getFestival_filename().length;i++){
				MultipartFile file= fdto.getFestival_filename()[i];
				if(!file.isEmpty()){
					String fileName = file.getOriginalFilename();
					//중복파일명을 처리하기 위해 난수 발생
					UUID random = UUID.randomUUID();
					String root = req.getSession().getServletContext().getRealPath("/");
					String saveDirectory = root + "temp" + File.separator;
					File fe=new File(saveDirectory);
					if(!fe.exists()){
						fe.mkdirs();
					}
					File ff= new File(saveDirectory, random+"_"+fileName);
					try {
						FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					sList.add(random+"_"+fileName);
				}
			}
			fdto.setFestival_pic(sList);
			System.out.println("adminservice:"+sList.toString());
		}
		dao.fInsMethod(fdto);		
	}//파일을 배열로 담아와서 스트링 리스트로 바꾼후 인서트.
	
}
