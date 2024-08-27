package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAfterAspect {

	//타겟클래스(DAOimpl)의 특정메소드가 동작하기전에 구현하고자하는 로직을 갖는 메소드(Advice)를 정의할 수 있다.
	//@After("포인트컷-패턴")
	@After("execution(public * test..*DAO*.update(..))")
	public void updateAfterAdvice(JoinPoint jp) {
		log.info("updateAfterAdvice()...{}",jp);
	}
}
