package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardServiceImp implements BoardService {
	private BoardDao dao;

	public BoardServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BoardDTO> boardListProcess() {
		// TODO Auto-generated method stub
		return dao.boardListMethod();
	}

	@Override
	public BoardDTO boardViewProcess(int bno) {

		return dao.boardViewMethod(bno);
	}

	@Override
	public List<ReplyDTO> replyListProcess(ReplyDTO rdto) {
		dao.replyInsertMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}

	@Override
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto, HttpServletRequest req) {
		String rupload=dao.getFile(rdto.getRno());
		if(rupload!=null){
			String root=req.getSession().getServletContext().getRealPath("/");
			String saveDirectory=root+"temp"+File.separator;
			File fe=new File(saveDirectory, rupload);
			fe.delete();
		}
		dao.replyDeleteMethod(rdto.getRno());
		return dao.replyListMethod(rdto.getBno());
	}

	@Override
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto, HttpServletRequest req) {
		String filename=dao.getFile(rdto.getRno());
		String root=req.getSession().getServletContext().getRealPath("/");
		String saveDirectory=root+"temp"+File.separator;
		MultipartFile file=rdto.getFilename();
		if(!file.isEmpty()){
			UUID random=UUID.randomUUID();
			if(filename!=null){
				File fe=new File(saveDirectory, filename);
				fe.delete();
			}
			
			String fileName=file.getOriginalFilename();
			rdto.setRupload(random+"_"+filename);
			
			File ff=new File(saveDirectory,random+"_"+filename);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}

	@Override
	public ReplyDTO downloadProcess(int rno) {
		// TODO Auto-generated method stub
		return null;
	}
}
