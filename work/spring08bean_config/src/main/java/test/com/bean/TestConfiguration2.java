package test.com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*pom.xml
<!-- https://mvnrepository.com/artifact/cglib/cglib -->
	<dependency>
		<groupId>cglib</groupId>
		<artifactId>cglib</artifactId>
		<version>3.2.8</version>
	</dependency>*/

@Configuration
public class TestConfiguration2 {

	//Person 빈으로 등록하기
	@Bean
	public Person p01() {
		return new Person();
	}
	
	@Bean
	public Person p02() {
		return new Person("경기","031");
	}
	
	@Bean
	public Person p03(){
		Person p = new Person();
		p.setAddress("seoul");
		p.setTel("02");
		return p;
	}
	
	//TestBean2 빈으로 등록하기
	@Bean
	public TestBean2 tb04() {
	
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 tb05() {

		return new TestBean2(p02());
	}
	
	@Bean
	public TestBean2 tb06() {
		
		TestBean2 t04 = new TestBean2();
		t04.setPerson(p03());
		return t04;
	}
}
