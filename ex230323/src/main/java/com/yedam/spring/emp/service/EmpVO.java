package com.yedam.spring.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	// Key => employeeId
	// 포맷 => int, String 등등
	// value => 
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate; // java.util.Date -> yyyy/MM/dd
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
