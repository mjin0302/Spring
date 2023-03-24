package com.yedam.spring.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Data
public class UserVO {
	// 필드명이 중요함
	private String name;
	private Integer age;
	
	// java.util.Date 할때 주의
	// util은 서양쪽으로 맞춰져있음
	// 따라서 우리가 처리할때 그냥 입력받으면 안됨 (ex. 부메랑에서 2023-03-23 하면 에러남)
	// 왜냐면 오라클쪽 포맷과 자바쪽포맷 처리가 다르기때문
	// input태그를 통해서 데이터를 입력받으면 /로 맞춰줘야 서버쪽에서 처리할수있음
	// => @DateTimeFormat(pattern="yyyy-MM-dd") : 그걸 해결(보완하기 위해서) 스프링에서 지원해주는 어노테이션
	// @DateTimeFormat(pattern="yyyy-MM-dd")은 출력과는 전혀 상관없음 , 입력받을때 나는 util이 가지는 기존 포맷말고
	// yyyy-MM-dd 형식으로 입력받겠다라는 말
	// @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 이렇게 시간까지 입력받을수 있음
	
	// yyyy/MM/dd hh:mm:ss
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date today;
	
}



