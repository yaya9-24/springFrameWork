package test.com.component;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//pom.xml
//<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
//<dependency>
//    <groupId>org.projectlombok</groupId>
//    <artifactId>lombok</artifactId>
//    <version>1.18.30</version>
//    <scope>provided</scope>
//</dependency>


@Component
@Slf4j
public class TestComponent {

	private String name;
	private int age;
	
	
	
	public TestComponent() {
		log.info("TestComponent()...");
		name = "kim";
		age = 33;
		
	}



	@Override
	public String toString() {
		return "TestComponent [name=" + name + ", age=" + age + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
}
