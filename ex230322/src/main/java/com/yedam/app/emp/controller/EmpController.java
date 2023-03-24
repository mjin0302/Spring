package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// FrontController와 같은 역할
// 스프링에선 각각 기능별로 controller를 세분화 시킴
@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	@RequestMapping("/getEmpInfo")
	// 페이지를 리턴하지 않고 리턴되는 대상을 바디에 출력함
	// 객체 => 텍스트로 변환 (직렬화)
	// 객체에 대한 직렬화 작업 => jackSon 직렬화 databind
	@ResponseBody
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empService.getEmpInfo(empVO);
	}
}
