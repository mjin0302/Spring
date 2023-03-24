package com.yedam.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void selectAllEmp() {
		List<EmpVO> emplist = empMapper.selectEmpAllList();
		assertNotNull(emplist);
	}
	
	@Test
	public void selectEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	@Test
	public void insertEmpInfo() {
		//등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("San-Ha");
		empVO.setEmail("shKang@google.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(5000);
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);
	}
	
	@Test
	public void updateEmpSal() {
		// 급여 갱신
		int result = empMapper.updateEmpSal(1001,10);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateEmpInfo() {
		// 사원 정보 수정
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		empVO.setEmail("sanH@naver.com");
		empVO.setSalary(6200);
		
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		// 사원 삭제
		int result = empMapper.deleteEmpInfo(1001);
		assertEquals(result, 1);
	}
	
}
