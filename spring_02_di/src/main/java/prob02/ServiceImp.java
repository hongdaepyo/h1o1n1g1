package prob02;

public class ServiceImp implements Service {
	private MemDaoImp dao;
	
	public ServiceImp() {

	}
	
	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}

	@Override
	public void prn() {
		dao.insertMethod();
	}
}
