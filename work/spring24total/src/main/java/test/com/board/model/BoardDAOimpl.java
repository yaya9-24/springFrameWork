package test.com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()...");
		log.info("vo:{}", vo);
		
		return sqlSession.insert("B_INSERT",vo);
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()...");
		log.info("vo:{}", vo);
		
		return sqlSession.update("B_UPDATE",vo);
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()...");
		log.info("vo:{}", vo);
		
		return sqlSession.delete("B_DELETE",vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()...");
		log.info("vo:{}", vo);
		BoardVO vo2 = sqlSession.selectOne("B_SELECT_ONE",vo);
		
		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()...");
		List<BoardVO> list = sqlSession.selectList("B_SELECT_ALL");

		return list;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info(searchKey);
		log.info(searchWord);

		List<BoardVO> list = null;
		if (searchKey.equals("title")) {
			list = sqlSession.selectList("B_SEARCHLIST_TITLE","%"+searchWord+"%");

		} else if (searchKey.equals("content")) {
			list = sqlSession.selectList("B_SEARCHLIST_CONTENT","%"+searchWord+"%");
		}
		return list;
	}

}
