package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestBeforeAspect {

	//타겟클래스(DAOimpl)의 특정메소드가 동작하기전에 구현하고자하는 로직을 갖는 메소드(Advice)를 정의할 수 있다.
	//@Before("포인트컷-패턴")
	
	@Before("execution(public * test..*DAO*.selectAll(..))")
	public void selectAllBeforeAdvice(JoinPoint jp) {
		log.info("selectAllBeforeAdvice()...{}",jp);
	}
	
	@Before("execution(public * test..*DAO*.insert(..))")
	public void insertBeforeAdvice(JoinPoint jp) {
		log.info("insertBeforeAdvice()...{}",jp);
	}
	
	@Before("execution(public * test..*DAO*.searchList(..))")
	public void searchListBeforeAdvice(JoinPoint jp) {
		log.info("searchListBeforeAdvice()...{}",jp);
	}
}
