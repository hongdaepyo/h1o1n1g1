package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tools.ant.taskdefs.condition.Http;

import dto.BoardDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.PageDTO;
import dto.ReplyDTO;

public interface BoardService {

	public List<BoardDTO> boardListProcess(PageDTO pdto);

	public void boardInsertProcess(BoardDTO dto, HttpServletRequest request);

	public void repInsertProcess(ReplyDTO rdto, HttpServletRequest request);

	public void boardDeleteProcess(int board_num, HttpServletRequest request);

	public void repDeleteProcess(int rep_num, HttpServletRequest request);

	public void boardUpdateProcess(BoardDTO bdto, HttpServletRequest request);

	public void repUpdateProcess(ReplyDTO rdto, HttpServletRequest request);
	
	public List<FestivalDTO> FesListProcess();
	
	public int countProcess();
	
	public void favorInsertProcess(FavorDTO fdto, HttpServletRequest request);
	
	public void favorUpdateProcess(FavorDTO fdto, HttpServletRequest request);
	
	public BoardDTO boardboardProcess(int board_num, HttpServletRequest request);
	
	public ReplyDTO reprepProcess(int rep_num, HttpServletRequest request);
	
}// end interface