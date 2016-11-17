package dto;

import java.util.List;

public class MapDTO {
	private int map_num;
	private int map_phone;
	private String map_name;
	private String map_category;
	private int city_num;
	private List<CityDTO> cityList;
	
	public MapDTO(){
		
	}

	public int getMap_num() {
		return map_num;
	}

	public void setMap_num(int map_num) {
		this.map_num = map_num;
	}

	public int getMap_phone() {
		return map_phone;
	}

	public void setMap_phone(int map_phone) {
		this.map_phone = map_phone;
	}

	public String getMap_name() {
		return map_name;
	}

	public void setMap_name(String map_name) {
		this.map_name = map_name;
	}

	public String getMap_category() {
		return map_category;
	}

	public void setMap_category(String map_category) {
		this.map_category = map_category;
	}

	public int getCity_num() {
		return city_num;
	}

	public void setCity_num(int city_num) {
		this.city_num = city_num;
	}

	public List<CityDTO> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityDTO> cityList) {
		this.cityList = cityList;
	}
	
	
	
}
