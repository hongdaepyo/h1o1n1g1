package part02;

public class ServiceImp implements Service{
	private MemDaoImp dao;
	
	public ServiceImp() {

	}
	
	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}
	

	@Override
	public void insertProcess() {
		
					dao.insertMethod(new MemDTO(49, "용팔이2", 50, "경기"));
					dao.insertMethod(new MemDTO(50, "유대위2", 20, "대전"));
		
		
	}//end insertProcess()
	
}//end class
