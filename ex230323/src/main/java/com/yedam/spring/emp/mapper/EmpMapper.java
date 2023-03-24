package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {

	// 전체 조회
	public List<EmpVO> selectEmpAllList();
	
	// 단건 조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	
	// 수정 - 급여를 정해진 비율로 인상
	// 매개변수가 1개만 넘어올땐 이름이 상관없음 단, 두개가 넘어올땐 어떤걸 어디에쓸건지 이름이 필요함
	// @Param : 마이바티스에서 지원하는 어노테이션
	public int updateEmpSal(@Param("empId") int employeeId, 
							@Param("raise") int raise);
	
	// 수정 - 사원정보 수정
	public int updateEmpInfo(EmpVO empVO);
	
	// 삭제
	public int deleteEmpInfo(int employeeId);
	
}
