package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.BoardPicDTO;
import dto.FavorDTO;
import dto.FestivalDTO;
import dto.PageDTO;
import dto.ReplyDTO;

public class BoardDAOImp implements BoardDAO {
	private SqlSessionTemplate sqlSession;

	public BoardDAOImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardDTO> boardListMethod(PageDTO pdto) {
		return sqlSession.selectList("board.board_list",pdto);
	}

	@Override
	public void boardInsertMethod(BoardDTO dto) {
		sqlSession.insert("board.board_insert", dto);
	}

	@Override
	public void repInsertMethod(ReplyDTO rdto) {
		sqlSession.insert("board.rep_insert", rdto);
	}
	
	@Override
	public void boardDeleteMethod(int board_num) {
		sqlSession.delete("board.board_delete", board_num);
	}
	
	@Override
	public void repDeleteMethod(int rep_num) {
		sqlSession.delete("board.rep_delete", rep_num);
	}

	@Override
	public void boardUpdateMethod(BoardDTO bdto) {
		sqlSession.update("board.board_update", bdto);
		if(!bdto.getBoard_filename()[0].getOriginalFilename().equals("")){
			sqlSession.delete("board.board_pic_delete", bdto);
			sqlSession.insert("board.board_pic_insert",bdto);
		}
	}
	
	@Override
	public void repUpdateMethod(ReplyDTO rdto) {
		sqlSession.update("board.rep_update", rdto);
	}

	@Override
	public List<FestivalDTO> fesListMethod() {
		return sqlSession.selectList("board.board_fesList");
	}

	@Override
	public int count() {
		return sqlSession.selectOne("board.board_count");
	}

	@Override
	public List<BoardPicDTO> PicViewMethod(int board_num) {
		return sqlSession.selectList("board.board_pic", board_num);
	}

	@Override
	public void favorInsertMethod(FavorDTO fdto) {
		sqlSession.insert("board.favor_insert", fdto);
	}

}// end class