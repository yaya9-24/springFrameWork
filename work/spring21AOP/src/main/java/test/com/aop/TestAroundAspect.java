package test.com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAroundAspect {

	//타겟클래스(DAOimpl)의 특정메소드가 동작하기전에 구현하고자하는 로직을 갖는 메소드(Advice)를 정의할 수 있다.
	//@Around("포인트컷-패턴")
	@Around("execution(public * test..*DAO*.delete(..))")
	public Object deleteAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("deleteAroundAdvice()...start.{}",pjp);
		Object obj = null;
		try {
			log.info("before pjp.proceed()...");
			obj= pjp.proceed();
			
			log.info("after pjp.proceed()...");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("deleteAroundAdvice()...end.{}",pjp);
		return obj;
	}
	
	@Around("execution(public * test..*DAO*.selectOne(..))")
	public Object selectOneAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("selectOneAroundAdvice()...start.{}",pjp);
		Object obj = null;
		try {
			log.info("before pjp.proceed()...");
			obj= pjp.proceed();
			
			log.info("after pjp.proceed()...");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("selectOneAroundAdvice()...end.{}",pjp);
		return obj;
	}
	
	//selectOne Around aop
	//searchList before aop
}
