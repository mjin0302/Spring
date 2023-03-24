package com.yedam.app.spring;

import org.springframework.stereotype.Component;

// @Component() : 해당 클래스를 기반으로 설정한 모든 파일들을 빈으로 등록함
// @Component("이름")  : 해당이름을 기반으로 빈을 등록함
@Component("tv")
public class SamsungTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링 방식으로 SamsungTV 켬");
	}

}
