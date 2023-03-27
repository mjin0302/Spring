package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

// 페이지를 반환하기 때문에
// 메소드 상관없이 모든 방식의 경로 요청을 처리할 수 있음
@Controller
public class EmpController {

	// 디비와 연결
	@Autowired
	EmpService empService;

	// 규칙임
	// 조회(데이터 조회, 일반페이지 -> GET
	// 등록, 수정, 삭제 -> POST

	// 전체조회
	// 페이지 반환
	// 필드명이 Key -> 타입에 따른 포맷으로 값을 보내야함
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {

		// req.setAttribute와 같음
		model.addAttribute("empList", empService.getEmpAll()); //

		return "emp/empList"; // views 밑에있는 jsp페이지를 요청함
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
		if (empId == -1) {
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
	// 서버에서 정의한 방식으로 클라이언트는 요청 할 수 있음
	@PostMapping("/empUpdate")
	@ResponseBody // 비동기식으로 만들게따앙아아아라ㅏㅣㅓㅏㅣㅏㅣ
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);

	}

	// 삭제
	// 2~3 양이 한꺼번에 들어온다 그럼 커맨드 객체
	// 1~2개라면 @RequestParam
	@PostMapping("/empDelete")
	// 데이터 보내는 애(무조건 JSON형식이 아님)
	// 디폴트가 스트링타입임
	// 단, 페이지는 아니여야 함
	// 단순히 Body 부분에 데이터를 뿌려주는 역할
	@ResponseBody
	// @RequestParam 
	public String empDeleteProcess(@RequestParam int employeeId) {
		Map<String, String> map = empService.deleteEmp(employeeId);
		return map.get("결과");
	}
}
