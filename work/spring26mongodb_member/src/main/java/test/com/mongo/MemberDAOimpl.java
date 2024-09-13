package test.com.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {
	
	@Autowired
	MongoCollection<Document> member;

	@Override
	public long insertOne(MemberVO vo) {
		log.info("insertOne()....");
		log.info("vo:{}", vo);
		long flag = 0;
		
		try {
			Document doc = new Document();
			doc.put("num", vo.getNum());
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			
			member.insertOne(doc);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long insertMany() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateOne(MemberVO vo) {
		log.info("updateOne()....");
		log.info("vo:{}", vo);
		long flag = 0;
		
		try {
			Document doc = new Document();
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			
			Bson set = new Document("$set",doc);
			
			flag = member.updateOne(new Document("num",vo.getNum()),set).getModifiedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long updateMany(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteOne(MemberVO vo) {
		log.info("deleteOne()....");
		log.info("vo:{}", vo);
		long flag = 0;
		
		try {
			
			flag = member.deleteOne(new Document("num",vo.getNum())).getDeletedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long deleteMany(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> findAll() {
		log.info("findAll()....");
		
		FindIterable<Document> docs = member.find().sort(new Document("num",-1));
		List<MemberVO> list = new ArrayList<MemberVO>();
		for(Document doc : docs) {
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<Document> findAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> findAll2(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		Bson filter = Filters.regex(searchKey, searchWord);
		
		FindIterable<Document> docs = member.find(filter).sort(new Document("num",-1));
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(Document doc : docs) {
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<MemberVO> searchList2(String searchKey, String searchWord, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findOne(MemberVO vo) {
		log.info("findOne()....");
			
		FindIterable<Document> docs = member.find(new Document("num",vo.getNum()));
		MemberVO vo2 = new MemberVO();
		for(Document doc : docs) {
			vo2.setMid(doc.get("_id").toString());
			vo2.set_id(doc.get("_id").toString());
			vo2.setNum(doc.getInteger("num", 0));
			vo2.setId(doc.getString("id"));
			vo2.setPw(doc.getString("pw"));
			vo2.setName(doc.getString("name"));
			vo2.setTel(doc.getString("tel"));
		}
		return vo2;
	}

	@Override
	public Document findOneDoc(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
