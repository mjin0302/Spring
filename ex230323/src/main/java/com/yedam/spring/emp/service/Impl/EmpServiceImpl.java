package com.yedam.spring.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

// @Service(value="") 이름을 직접 지정해줄수 있음 이때 이름은 변수명으로 사용됨
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectEmpAllList();
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		if(result == 1) {
			return empVO.getEmployeeId();
		}else {
			return -1;
		}
	}

	@Override
	public String updateEmpSal(int empId, int raise) {
		String message = null;
		
		int result = empMapper.updateEmpSal(empId, raise);
		if(result == 1) {
			message = "정상적으로 급여를 갱신하였습니다.";
		}else {
			message = "작업이 실패했습니다. 사원번호를 확인해주세요.";
		}
		return message;
	}

	@Override
	public Map<String,String> updateEmp(EmpVO empVO) {
		Map<String,String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empVO.getEmployeeId()));
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}		
		return map;
	}

	@Override
	public Map<String, String> deleteEmp(int empId) {
		Map<String,String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empId));
		
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}		
		return map;
	}

}
