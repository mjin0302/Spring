package com.yedam.app.spring;

public class LGTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링으로 LG TV 켬");
	}

}
