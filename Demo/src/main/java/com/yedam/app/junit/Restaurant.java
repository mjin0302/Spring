package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	@Autowired // 빈으로 등록된 애가 주입된다는 말
	Chef chef;
	
	public void open() {
		chef.cooking();
	}
}
