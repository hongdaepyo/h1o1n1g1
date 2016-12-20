package dao;

import java.util.List;

import dto.BoardDTO;
import dto.BoardPicDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.PageDTO;
import dto.ReplyDTO;

public interface BoardDAO {

	public List<BoardDTO> boardListMethod(PageDTO pdto);

	public void boardInsertMethod(BoardDTO bdto);
	
	public void repInsertMethod(ReplyDTO rdto);

	public void boardDeleteMethod(int board_num);
	
	public void repDeleteMethod(int rep_num);

	public void repUpdateMethod(ReplyDTO rdto);
	
	public void boardUpdateMethod(BoardDTO bdto);

	public List<FestivalDTO> fesListMethod();
	
	public int count();

	public List<BoardPicDTO> PicViewMethod(int board_num);
	
	public void favorInsertMethod(FavorDTO fdto);
	
	public void favorUpdateMethod(FavorDTO fdto);
	
	public BoardDTO boardboardMethod(int board_num);
	
	public ReplyDTO reprepMethod(int rep_num);
	
}// end interface