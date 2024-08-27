package test.com.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;


	@Override
	public int insert(MemberVO vo) {
		log.info("insert()...");
		log.info("vo:{}", vo);
		
		return sqlSession.insert("M_INSERT",vo);
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()...");
		log.info("vo:{}", vo);
		
		return sqlSession.update("M_UPDATE",vo);
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()...");
		log.info("vo:{}", vo);
		int flag = sqlSession.delete("M_DELETE",vo);
		
		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()...");
		log.info("vo:{}", vo);
		MemberVO vo2 = sqlSession.selectOne("M_SELECT_ONE",vo);

		
		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()...");

		List<MemberVO> list = sqlSession.selectList("M_SELECT_ALL");

		return list;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:" + searchKey);
		log.info("searchWord:" + searchWord);

		List<MemberVO> list = null;

		if (searchKey.equals("name")) {
			list = sqlSession.selectList("M_SELECT_LIST_NAME", "%" + searchWord + "%");
		} else if (searchKey.equals("id")) {
			list = sqlSession.selectList("M_SELECT_LIST_ID", "%" + searchWord + "%");
		}
		return list;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		log.info("idCheck()...");
		log.info("vo:{}", vo);
		
		MemberVO vo2 = null;
		vo2 = sqlSession.selectOne("M_IDCHECK",vo);
		return vo2;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		log.info("login()...");
		log.info("vo:{}", vo);
		
		MemberVO vo2 = null;
		vo2 = sqlSession.selectOne("M_LOGIN",vo);
		return vo2;
	}
}
