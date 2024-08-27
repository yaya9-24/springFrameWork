package test.com.aop;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TestDAOimpl implements TestDAO {

	@Override
	public int insert(TestVO vo) {
		log.info("insert()...{}",vo);
		return 0;
	}

	@Override
	public int update(TestVO vo) {
		log.info("update()...{}",vo);
		return 0;
	}

	@Override
	public int delete(TestVO vo) {
		log.info("delete()...{}",vo);
		return 0;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		log.info("selectOne()...{}",vo);
		return null;
	}

	@Override
	public List<TestVO> selectAll() {
		log.info("selectAll()...");
		return null;
	}

	@Override
	public List<TestVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...{},{}",searchKey,searchWord);
		return null;
	}

	@Override
	public TestVO idCheck(TestVO vo) {
		log.info("idCheck()...{}",vo);
		return null;
	}

}
