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

import dao.BoardDAO;
import dto.BoardDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.PageDTO;
import dto.ReplyDTO;

public class BoardServiceImp implements BoardService {
	private BoardDAO dao;

	public BoardServiceImp() {
	}

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<BoardDTO> boardListProcess(PageDTO pdto) {
		return dao.boardListMethod(pdto);
	}// end boardListProcess();

	@Override
	public void boardInsertProcess(BoardDTO dto, HttpServletRequest request) {
		List<String> sList = new ArrayList<String>();
		if(dto.getBoard_filename() != null){
			for (int i = 0; i < dto.getBoard_filename().length; i++) { 
				MultipartFile file = dto.getBoard_filename()[i]; 
				if (!file.isEmpty()) { 
					String fileName = file.getOriginalFilename(); 
					// 중복파일명을 처리하기 위해 난수 발생 
					UUID random = UUID.randomUUID(); 
					String root = request.getSession().getServletContext().getRealPath("/"); 
					// root + "temp/" 
					String saveDirectory = root + "temp" + File.separator; 
					File fe = new File(saveDirectory); 
					if (!fe.exists()) { 
						fe.mkdir(); 
					} 
					File ff = new File(saveDirectory, random + "_" + fileName); 
					try { 
						FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff)); 
						} catch (FileNotFoundException e) { 
							e.printStackTrace(); 
						} catch (IOException e) { 
							e.printStackTrace(); 
						} 
						sList.add(random + "_" + fileName);
					}
				}
				dto.setBoard_pic(sList);
			}
			dao.boardInsertMethod(dto);
		} 
	
	@Override
	public void repInsertProcess(ReplyDTO rdto, HttpServletRequest request) {
		dao.repInsertMethod(rdto);
	}

	@Override
	public void boardDeleteProcess(int board_num, HttpServletRequest request) {
		dao.boardDeleteMethod(board_num);
	}// end boardDeleteProcess

	@Override
	public void repDeleteProcess(int rep_num, HttpServletRequest request) {
		dao.repDeleteMethod(rep_num);
	}

	@Override
	public void boardUpdateProcess(BoardDTO bdto, HttpServletRequest request) {
		List<String> sList = new ArrayList<String>();
		if(bdto.getBoard_filename() != null){
			for (int i = 0; i < bdto.getBoard_filename().length; i++) { 
				MultipartFile file = bdto.getBoard_filename()[i]; 
				if (!file.isEmpty()) { 
					String fileName = file.getOriginalFilename(); 
					// 중복파일명을 처리하기 위해 난수 발생 
					UUID random = UUID.randomUUID(); 
					String root = request.getSession().getServletContext().getRealPath("/"); 
					// root + "temp/" 
					String saveDirectory = root + "temp" + File.separator; 
					File fe = new File(saveDirectory); 
					if (!fe.exists()) { 
						fe.mkdir(); 
					} 
					File ff = new File(saveDirectory, random + "_" + fileName); 
					try { 
						FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff)); 
						} catch (FileNotFoundException e) { 
							e.printStackTrace(); 
						} catch (IOException e) { 
							e.printStackTrace(); 
						} 
						sList.add(random + "_" + fileName);
					}
				}
				bdto.setBoard_pic(sList);
			}
			dao.boardUpdateMethod(bdto);
		} 
	
	@Override
	public void repUpdateProcess(ReplyDTO rdto, HttpServletRequest request) {
		dao.repUpdateMethod(rdto);
	}// end boardUpdateProcess();

	@Override
	public List<FestivalDTO> FesListProcess() {
		return dao.fesListMethod();
	}

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public void favorInsertProcess(FavorDTO fdto, HttpServletRequest request) {
		dao.favorInsertMethod(fdto);
	}

	@Override
	public void favorUpdateProcess(FavorDTO fdto, HttpServletRequest request) {
		dao.favorUpdateMethod(fdto);
	}

	@Override
	public BoardDTO boardboardProcess(int board_num, HttpServletRequest request) {
		return dao.boardboardMethod(board_num);
	}

	@Override
	public ReplyDTO reprepProcess(int rep_num, HttpServletRequest request) {
		return dao.reprepMethod(rep_num);
	}

}// end class