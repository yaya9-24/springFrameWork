package test.com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TestBean2 {
	
	private Person person;
	
	public TestBean2() {
		log.info("TestBean2()...");
	}
	
	public TestBean2(Person person) {
		log.info("TestBean(Person person)...");
		this.person = person;
	}
}
