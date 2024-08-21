package test.com.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class TestConfiguration4 {

	//Car, MissionBean 생성 및 출력하기
	
	@Bean
	public Car car() {
		Car car = new Car();
		car.setPrice(9999);
		car.setModel("VOLVO");
		
		return car;
	}
	
	@Bean
	public MissionBean mission() {
		MissionBean mission = new MissionBean();
		mission.setCar(car());
		return mission;
	}
}
