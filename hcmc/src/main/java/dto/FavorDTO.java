package dto;

public class FavorDTO {
	private int mem_num;
	private int festival_num;
	private float favor_star;
	
	public FavorDTO() {
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getFestival_num() {
		return festival_num;
	}

	public void setFestival_num(int festival_num) {
		this.festival_num = festival_num;
	}

	public float getFavor_star() {
		return favor_star;
	}

	public void setFavor_star(float favor_star) {
		this.favor_star = favor_star;
	}
}
