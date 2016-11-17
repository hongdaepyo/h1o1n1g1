package dto;

import java.util.Date;

public class FestivalDTO {
private int festival_num;
private int city_num;
private String festival_name;
private Date festival_start;
private Date festival_end;
private String festival_pic;
private String festival_hpage;
private String festival_theme;
private String festival_time;
private int festival_count;
private String festival_content;
private int star;


public FestivalDTO() {
}

public int getFestival_num() {
	return festival_num;
}

public void setFestival_num(int festival_num) {
	this.festival_num = festival_num;
}

public int getCity_num() {
	return city_num;
}

public void setCity_num(int city_num) {
	this.city_num = city_num;
}

public String getFestival_name() {
	return festival_name;
}

public void setFestival_name(String festival_name) {
	this.festival_name = festival_name;
}

public Date getFestival_start() {
	return festival_start;
}

public void setFestival_start(Date festival_start) {
	this.festival_start = festival_start;
}

public Date getFestival_end() {
	return festival_end;
}

public void setFestival_end(Date festival_end) {
	this.festival_end = festival_end;
}

public String getFestival_pic() {
	return festival_pic;
}

public void setFestival_pic(String festival_pic) {
	this.festival_pic = festival_pic;
}

public String getFestival_hpage() {
	return festival_hpage;
}

public void setFestival_hpage(String festival_hpage) {
	this.festival_hpage = festival_hpage;
}

public String getFestival_theme() {
	return festival_theme;
}

public void setFestival_theme(String festival_theme) {
	this.festival_theme = festival_theme;
}

public String getFestival_time() {
	return festival_time;
}

public void setFestival_time(String festival_time) {
	this.festival_time = festival_time;
}

public int getFestival_count() {
	return festival_count;
}

public void setFestival_count(int festival_count) {
	this.festival_count = festival_count;
}

public String getFestival_content() {
	return festival_content;
}

public void setFestival_content(String festival_content) {
	this.festival_content = festival_content;
}

public int getStar() {
	return star;
}

public void setStar(int star) {
	this.star = star;
}



}//end class