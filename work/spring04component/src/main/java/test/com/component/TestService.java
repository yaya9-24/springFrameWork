package test.com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

//pom.xml
//<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
//<dependency>
//    <groupId>org.projectlombok</groupId>
//    <artifactId>lombok</artifactId>
//    <version>1.18.30</version>
//    <scope>provided</scope>
//</dependency>

@Service
@Slf4j
public class TestService {

	@Autowired
	TestDAO dao;

	public TestService() {
		log.info("TestService()...");

	}
	
	public int insert() {
		log.info("insert()...");
		return dao.insert();
	}

}
