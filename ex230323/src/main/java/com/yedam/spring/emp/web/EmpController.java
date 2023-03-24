package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

// 페이지를 반환하기 때문에
@Controller
public class EmpController {
	
	//디비와 연결
	@Autowired
	EmpService empService;
	
	// 규칙임
	// 조회(데이터 조회, 일반페이지 -> GET
	// 등록, 수정, 삭제 -> POST
	
	// 전체조회
	// 페이지 반환
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {
		
		// req.setAttribute와 같음
		model.addAttribute("empList", empService.getEmpAll()); //
		
		return "emp/empList"; //views 밑에있는 jsp페이지를 요청함 
	}
	
	// 단건 조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	
	// 등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {
		
		int empId = empService.insertEmp(empVO);
		
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		} else {
			result = "정상적으로 등록 되었습니다. \n 등록된 사원의 사번은 " + empId + " 입니다.";
		}
		
		rrtt.addFlashAttribute("result", result);
		
		// 컨트롤러 요청함 
		return "redirect:empList";
	}
	
	// 수정 - Process
	// 1) Client - JSON -> Server
	// 2) Server - text -> Client
	@PostMapping("/empUpdate") 
	@ResponseBody // 비동기식으로 만들게따앙아아아라ㅏㅣㅓㅏㅣㅏㅣ
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
		
	}
}
