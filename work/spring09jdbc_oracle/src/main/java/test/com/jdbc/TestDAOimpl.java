package test.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TestDAOimpl implements TestDAO{
	
	private static final String DRIVER_NAME="oracle.jdbc.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
	
	public TestDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			log.info("Driver successed...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TestVO vo) {
		log.info("insert()...",vo);
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			log.info("conn successed...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
