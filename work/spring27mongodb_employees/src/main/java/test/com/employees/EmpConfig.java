package test.com.employees;

import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EmpConfig {

	
	@Bean
	public MongoDatabase mongoDatabase() {
		log.info("Create Bean MongoDatabase...");
		
		MongoClient client = new MongoClient("localhost",27017);
		
		return client.getDatabase("testdb");
	}
	
	@Bean
	public MongoCollection<Document> employees(){
		log.info("Create Bean Employees");
		
		return mongoDatabase().getCollection("employees");
	}
}
