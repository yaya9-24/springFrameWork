package test.com.employees;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDAOimpl implements EmpDAO {
	
	@Autowired
	MongoCollection<Document> employees;

	@Override
	public long insertOne(EmpVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateOne(EmpVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteOne(EmpVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpVO findOne(EmpVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
