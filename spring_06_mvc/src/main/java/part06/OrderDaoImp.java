package part06;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class OrderDaoImp implements OrderDao{
	private SqlSessionTemplate sqlSession;
	
	public OrderDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertMethod(OrderDTO dto) {
		sqlSession.insert("order.ins",dto);
		
	}

	@Override
	public List<OrderDTO> selectMethod() {
		
		return sqlSession.selectList("order.all");
	}
}
