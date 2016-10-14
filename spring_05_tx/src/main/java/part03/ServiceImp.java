package part03;

import org.springframework.transaction.annotation.Transactional;

public class ServiceImp implements Service{
	private MemDaoImp dao;
	
	public ServiceImp() {

	}
	
	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}
	
	//트랜잭션으로 돌리는 곳에서는 절대로 예외 처리 하지 않는다.
	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() {
		
					dao.insertMethod(new MemDTO(51, "용팔이3", 50, "경기"));
					dao.insertMethod(new MemDTO(52, "유대위3", 20, "대전"));
		
		
	}//end insertProcess()
	
	//트랜잭션이 설정된 메소드에서는 try~catch을 설정하면 안되고
	//메소드를 호출하는 곳에서 try~catch을 한다.
	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void testProcess() throws Exception {

		dao.insertMethod(new MemDTO(53, "용팔이4", 50, "경기"));
		dao.insertMethod(new MemDTO(53, "유대위4", 20, "대전"));

	}
	
}//end class
