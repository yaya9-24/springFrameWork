package test.com.aop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {

	@Autowired
	TestDAO dao;
	
	public int insert(TestVO vo) {
		log.info("insert()...{}",vo);
		return dao.insert(vo);
	}
	public int update(TestVO vo){
		log.info("update()...{}",vo);
		return dao.update(vo);
	}
	public int delete(TestVO vo){
		log.info("delete()...{}",vo);
		return dao.delete(vo);
	}
	public TestVO selectOne(TestVO vo){
		log.info("selectOne()...{}",vo);
		return dao.selectOne(vo);
	}
	public List<TestVO> selectAll(){
		log.info("selectAll()...");
		return dao.selectAll();
	}
	public List<TestVO> searchList(String searchKey,String searchWord){
		log.info("searchList()...");
		return dao.searchList(searchKey,searchWord);
	}
	public TestVO idCheck(TestVO vo){
		log.info("idCheck()...{}",vo);
		return dao.idCheck(vo);
	}
}
