package test.com.employees;

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
public class EmpDAOimpl implements EmpDAO {
	
	@Autowired
	MongoCollection<Document> employees;

	@Override
	public long insertOne(EmpVO vo) {
		log.info("insertOne()...");
		log.info("vo:{}",vo);
		
		long flag = 0;
		
		try {
			Document doc = new Document();
			doc.put("employee_id", vo.getEmployee_id());
			doc.put("first_name", vo.getFirst_name());
			doc.put("last_name", vo.getLast_name());
			doc.put("email", vo.getEmail());
			
			employees.insertOne(doc);
			
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public long updateOne(EmpVO vo) {
		log.info("updateOne()...");
		log.info("vo:{}",vo);
		
		long flag = 0;
		
		try {
			Document doc = new Document();
			doc.put("first_name", vo.getFirst_name());
			doc.put("last_name", vo.getLast_name());
			doc.put("email", vo.getEmail());
			
			Bson set = new Document("$set",doc);
			
			flag = employees.updateOne(new Document("employee_id",vo.getEmployee_id()), set).getModifiedCount();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public long deleteOne(EmpVO vo) {
		log.info("deleteOne()...");
		log.info("vo:{}",vo);
		
		long flag = 0;
		
		try {

			flag = employees.deleteOne(new Document("employee_id",vo.getEmployee_id())).getDeletedCount();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<EmpVO> findAll(int page, int limit) {
		log.info("findAll()...");
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		FindIterable<Document> docs = employees.find().sort(new Document("employee_id",-1)).skip((page-1)*limit).limit(limit);
		List<EmpVO> list = new ArrayList<EmpVO>();
		for(Document doc : docs) {
			EmpVO vo = new EmpVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setEmployee_id(doc.getInteger("employee_id", 0));
			vo.setFirst_name(doc.getString("first_name"));
			vo.setLast_name(doc.getString("last_name"));
			vo.setEmail(doc.getString("email"));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<EmpVO> searchList(String searchKey, String searchWord, int page, int limit) {
		log.info("searchList()...");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		Bson filter = Filters.regex(searchKey, searchWord);
		
		FindIterable<Document> docs = employees.find(filter)
				.sort(new Document("employee_id",-1)).skip((page-1)*limit).limit(limit);
		
		List<EmpVO> list = new ArrayList<EmpVO>();
		for(Document doc : docs) {
			EmpVO vo = new EmpVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setEmployee_id(doc.getInteger("employee_id", 0));
			vo.setFirst_name(doc.getString("first_name"));
			vo.setLast_name(doc.getString("last_name"));
			vo.setEmail(doc.getString("email"));
			list.add(vo);
		}
		return list;
	}

	@Override
	public EmpVO findOne(EmpVO vo) {
		log.info("findOne()...");
		log.info("vo:{}",vo);

		FindIterable<Document> docs = 
				employees.find(new Document("employee_id",vo.getEmployee_id())).sort(new Document("employee_id",-1));

		EmpVO vo2 = new EmpVO();
		for(Document doc : docs) {
			vo2.setMid(doc.get("_id").toString());
			vo2.set_id(doc.get("_id").toString());
			vo2.setEmployee_id(doc.getInteger("employee_id", 0));
			vo2.setFirst_name(doc.getString("first_name"));
			vo2.setLast_name(doc.getString("last_name"));
			vo2.setEmail(doc.getString("email"));
		}
		return vo2;
	}

}
