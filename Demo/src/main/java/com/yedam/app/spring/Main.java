package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		// GenericXmlApplicationContext
		// => 파일시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너
		
		// classpath : 기본 경로 => src/main/resources를 가리킴
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 빈등록 방법
		// 1. applicationContext.xml에서 등록한 id 값을 가져오면됨 => getBean("id")
		// 2. 어노테이션 기반 => @Component("이름")  : 해당이름을 기반으로 빈을 등록함
		// 오브젝트 타입 일치시켜줘야함 (TV)
		// 컨테이너 안에 있는것은 빈들의 모음 => 빈(bean)은 객체임
		// 나중에 수정이 필요할때 Main은 건드리지 않고 applicationContext.xml에서 수정해주면됨
		TV tv = (TV)ctx.getBean("tv"); 
		tv.on();
	}
}
