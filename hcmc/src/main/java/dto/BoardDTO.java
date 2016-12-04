package dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int board_num;
	private int festival_num;
	private int mem_num;
	private String board_head;
	private String board_content;
	private Date board_date;
	private List<ReplyDTO> replyList;
	private List<MemberDTO> memList;
	private List<FestivalDTO> fesList;
	private List<String> board_pic;
	private MultipartFile[] board_filename;

	public BoardDTO() {
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getFestival_num() {
		return festival_num;
	}

	public void setFestival_num(int festival_num) {
		this.festival_num = festival_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getBoard_head() {
		return board_head;
	}

	public void setBoard_head(String board_head) {
		this.board_head = board_head;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public List<ReplyDTO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyDTO> replyList) {
		this.replyList = replyList;
	}

	public List<MemberDTO> getMemList() {
		return memList;
	}

	public void setMemList(List<MemberDTO> memList) {
		this.memList = memList;
	}

	public List<FestivalDTO> getFesList() {
		return fesList;
	}

	public void setFesList(List<FestivalDTO> fesList) {
		this.fesList = fesList;
	}
	
	public List<String> getBoard_pic() {
		return board_pic;
	}

	public void setBoard_pic(List<String> board_pic) {
		this.board_pic = board_pic;
	}

	public MultipartFile[] getBoard_filename() {
		return board_filename;
	}

	public void setBoard_filename(MultipartFile[] board_filename) {
		this.board_filename = board_filename;
	}
}// end class