package test.com.bean;

import lombok.Data;

@Data
public class MissionBean {

	private Car car;
	
	
	//root-context4.xml
	//Car클래스(속성-price,model) 빈으로 등록할 것
	//MissionBean 빈으로 등록할 것
	
	//HomeController에서 DI하고 출력
}
