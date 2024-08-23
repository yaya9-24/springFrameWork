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
		log.info("insert()...", vo);

		return sqlSession.insert("P_INSERT", vo);
	}

	@Override
	public int update(ProductVO vo) {
		log.info("update()...", vo);

		return sqlSession.update("P_UPDATE", vo);
	}

	@Override
	public int delete(ProductVO vo) {
		log.info("delete()...", vo);

		return sqlSession.delete("P_DELETE", vo);
	}

	@Override
	public ProductVO selectOne(ProductVO vo) {
		log.info("selectOne()...", vo);

		return sqlSession.selectOne("P_SELECT_ONE", vo);
	}

	@Override
	public List<ProductVO> selectAll() {
		log.info("selectAll()...");

		return sqlSession.selectList("P_SELECT_ALL");
	}

	@Override
	public List<ProductVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);

		if (searchKey.equals("pname")) {
			return sqlSession.selectList("P_SEARCHLIST_PNAME", "%" + searchWord + "%");
		} else if (searchKey.equals("model")) {
			return sqlSession.selectList("P_SEARCHLIST_MODEL", "%" + searchWord + "%");
		}
		return null;
	}
}
