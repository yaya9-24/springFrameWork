package test.com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TestBean {

	private String name;
	private int age;
	
	public TestBean() {
		log.info("TestBean()...");
	}
	
	public TestBean(String name,int age) {
		log.info("TestBean(String name,int age)...");
		this.name = name;
		this.age = age;
	}
}
