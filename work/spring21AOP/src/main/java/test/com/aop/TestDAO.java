package test.com.aop;

import java.util.List;

import org.springframework.stereotype.Repository;



public interface TestDAO {

	public int insert(TestVO vo);
	public int update(TestVO vo);
	public int delete(TestVO vo);
	public TestVO selectOne(TestVO vo);
	public TestVO idCheck(TestVO vo);
	public List<TestVO> selectAll();
	public List<TestVO> searchList(String searchKey,String searchWord);
	
}
