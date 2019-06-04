package xingkong.framework.log;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author xingkong
 *
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
	// 这个切点的表达式需要根据自己的项目来写
	@Pointcut("execution(public * com.szzt.custom.web.business.page..*(..)) || execution(public * com.szzt.custom.web.business.controller..*(..))")
	public void log() {

	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 参数
		String paramterStr = "";
		Enumeration<String> paramter = request.getParameterNames();
		while (paramter.hasMoreElements()) {
			String paramName = (String) paramter.nextElement();
			paramterStr += "[" + paramName + "=" + request.getParameter(paramName) + "]";
		}
		// url
		log.info("url={}, method={}, ip={},classMethod={}, paramter={} ", request.getRequestURI(), request.getMethod(),
				request.getRemoteAddr(),
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), paramterStr);

	}

	@After("log()")
	public void doAfter() {
	}

	@Around("log()")
	public Object doAround (ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = pjp.proceed();
		long executeTime = System.currentTimeMillis() - startTime;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("executeTime", executeTime);
		return result;
	}

}
