package test.com.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	EmpDAO dao;
	public long insertOne(EmpVO vo) {
		return dao.insertOne(vo);
	}

	
	public long updateOne(EmpVO vo) {		
		return dao.updateOne(vo);
	}

	
	public long deleteOne(EmpVO vo) {		
		return dao.deleteOne(vo);
	}

	
	public List<EmpVO> findAll(int page, int limit) {		
		return dao.findAll(page,limit);
	}

	
	public List<EmpVO> searchList(String searchKey, String searchWord, int page, int limit) {		
		return dao.searchList(searchKey,searchWord,page,limit);
	}

	
	public EmpVO findOne(EmpVO vo) {		
		return dao.findOne(vo);
	}
}
