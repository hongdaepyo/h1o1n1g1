package dto;

import java.util.Date;
import java.util.List;

public class ReplyDTO {
	private int rep_num;
	private int board_num;
	private int mem_num;
	private String rep_content;
	private Date rep_date;
	private List<MemberDTO> rmemList;

	public ReplyDTO() {
	}

	public int getRep_num() {
		return rep_num;
	}

	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public Date getRep_date() {
		return rep_date;
	}

	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}

	public List<MemberDTO> getRmemList() {
		return rmemList;
	}

	public void setRmemList(List<MemberDTO> rmemList) {
		this.rmemList = rmemList;
	}

}// end class