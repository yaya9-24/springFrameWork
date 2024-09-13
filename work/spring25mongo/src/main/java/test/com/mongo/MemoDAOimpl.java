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
public class MemoDAOimpl implements MemoDAO {

	@Autowired
	MongoCollection<Document> testcollection;

	@Override
	public long insertOne(MemoVO vo) {
		log.info("insertOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			//{age:101,name:"kim1",office:"multi",phone:"0201"}
			Document doc = new Document();
			doc.put("age", vo.getAge());
			doc.put("name", vo.getName());
			doc.put("office", vo.getOffice());
			doc.put("phone", vo.getPhone());
			
			testcollection.insertOne(doc);
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
	public long updateOne(MemoVO vo) {
		log.info("updateOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			//{age:102},{$set:{name:"lee8",office:"multi8",phone:"0388"}}
			Document doc = new Document();
			doc.put("age", vo.getAge());
			doc.put("name", vo.getName());
			doc.put("office", vo.getOffice());
			doc.put("phone", vo.getPhone());
			
			Bson set = new Document("$set",doc);
			
			flag = testcollection.updateOne(new Document("age",vo.getAge()),set).getModifiedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long updateMany(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteOne(MemoVO vo) {
		log.info("deleteOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			//db.testcollection.deleteOne({age:101})

			flag = testcollection.deleteOne(new Document("age",vo.getAge())).getDeletedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long deleteMany(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemoVO> findAll() {
		log.info("findAll()...");

		// ~~~.find({}).sort({age:-1})
		FindIterable<Document> docs = testcollection.find().sort(new Document("age", -1));

		List<MemoVO> list = new ArrayList<MemoVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemoVO vo = new MemoVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setAge(doc.getInteger("age", 0));
			vo.setName(doc.getString("name"));
			vo.setOffice(doc.getString("office"));
			vo.setPhone(doc.getString("phone"));
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
	public List<MemoVO> findAll2(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemoVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		// ~~~.find({name:/nn/}).sort({age:-1})
		// ~~~.find({phone:/10/}).sort({age:-1})
		Bson filter = Filters.regex(searchKey, searchWord);
		FindIterable<Document> docs = testcollection.find(filter).sort(new Document("age", -1));

		List<MemoVO> list = new ArrayList<MemoVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemoVO vo = new MemoVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setAge(doc.getInteger("age", 0)); //0은 default 값이다.
			vo.setName(doc.getString("name"));
			vo.setOffice(doc.getString("office"));
			vo.setPhone(doc.getString("phone"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<MemoVO> searchList2(String searhKey, String searchWord, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemoVO findOne(MemoVO vo) {
		log.info("findOne()...");

		// ~~~.find({age:11})
		FindIterable<Document> docs = testcollection.find(new Document("age", vo.getAge()));

		MemoVO vo2 = new MemoVO();
		for (Document doc : docs) {
			log.info(doc.toJson());
			
			vo2.setMid(doc.get("_id").toString());
			vo2.set_id(doc.get("_id").toString());
			vo2.setAge(doc.getInteger("age", 0));
			vo2.setName(doc.getString("name"));
			vo2.setOffice(doc.getString("office"));
			vo2.setPhone(doc.getString("phone"));
		}

		return vo2;
	}

	@Override
	public Document findOneDoc(MemoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}