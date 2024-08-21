package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {
	
	private String address;
	private String tel;
	
	public Person() {
		log.info("Person()...");
	}
	
	public Person(String address,String tel) {
		log.info("Person(String address,String tel)...");
		this.address = address;
		this.tel = tel;
	}
}
