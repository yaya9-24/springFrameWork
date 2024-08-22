package test.com.product.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProductDAOimpl implements ProductDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(ProductVO vo) {
		log.info("insert()...");
		log.info("vo:{}",vo);
		
		return sqlSession.insert("P_INSERT",vo);
	}

	@Override
	public int update(ProductVO vo) {
		log.info("update()...");
		log.info("vo:{}",vo);
		
		return sqlSession.update("P_UPDATE",vo);
	}

	@Override
	public int delete(ProductVO vo) {
		log.info("delete()...");
		log.info("vo:{}",vo);
		
		return sqlSession.delete("P_DELETE",vo);
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		log.info("selectOne()...");
		log.info("vo:{}",vo);
		
		ProductVO vo2 = sqlSession.selectOne("P_SELECT_ONE",vo);
		
		return vo2;
	}

	@Override
	public List<ProductVO> selectAll() {
		log.info("selectAll()...");
		
		List<ProductVO> list = sqlSession.selectList("P_SELECT_ALL");
		
		return list;
	}

	@Override
	public List<ProductVO> searchList(String searchKey, String searchWord) {
		log.info("selectAll()...");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<ProductVO> list = null;
		if(searchKey.equals("pname")) {
			list = sqlSession.selectList("P_SEARCHLIST_PNAME","%"+searchWord+"%");
		} else if(searchKey.equals("model")) {
			list = sqlSession.selectList("P_SEARCHLIST_MODEL","%"+searchWord+"%");
		}
		return list;
	}

}
