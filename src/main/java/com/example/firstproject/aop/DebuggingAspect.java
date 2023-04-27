package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //AOP 클래스 선언: 부가 기능을 주입하는 클래스
@Component //Ioc 컨테이너가 해당 객체를 생성 및 관리
@Slf4j
public class DebuggingAspect {

    //대상 메소드 선택: CommentService#create()
    @Pointcut("execution(* com.example.firstproject.service.CommentService.*(..))") //찔러 넣어주겠다
    private void cut(){}

    //실행 시점 설정: cut()의 대상이 수행되기 이전
    @Before("cut()")
    public void loggingArgs(JoinPoint joinPoint){ //cut()의 대상 메소드
        //입력값 가져오기
        Object[] args = joinPoint.getArgs();
        //클래스명
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();
        //메소드명
        String methodName = joinPoint.getSignature()
                .getName();
        //입력값 로깅하기
        for (Object obj : args) { //foreach문
            log.info("{}#{}의 입력값 => {}", className, methodName, obj);
        }

    }

    //cut()에 지정된 대상 호출 성공 후!
    @AfterReturning(value = "cut()", returning = "returnObj") //return 이름 지정해줘야 함
    public void loggingReturnValue(JoinPoint joinPoint,//cut()의 대상 메소드
                                   Object returnObj) { //리턴값
        //클래스명
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();
        //메소드명
        String methodName = joinPoint.getSignature()
                .getName();
        //반환값 로깅
        log.info("{}#{}의 반환값 => {}", className, methodName, returnObj);
    }
}
