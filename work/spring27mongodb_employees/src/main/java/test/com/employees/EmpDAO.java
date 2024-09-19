package test.com.employees;

import java.util.List;

public interface EmpDAO {
	
	public long insertOne(EmpVO vo);
	public long updateOne(EmpVO vo);
	public long deleteOne(EmpVO vo);
	
	public List<EmpVO> findAll(int page,int limit);
	public List<EmpVO> searchList(String searchKey,String searchWord,int page,int limit);
	public EmpVO findOne(EmpVO vo);

}
