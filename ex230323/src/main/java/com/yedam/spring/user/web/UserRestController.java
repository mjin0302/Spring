package com.yedam.spring.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.spring.user.service.UserListVO;
import com.yedam.spring.user.service.UserVO;

@CrossOrigin
// 데이터를 반환하는 컨트롤러
// 필드명이 중요함
// @RestController => @Contoller + @ResponseBody => 해당 클래스 내의 모든 컨트롤러는 객체를 반환(데이터를 반환)
@RestController
public class UserRestController {
	// @RequestMapping의 value : 경로 , method : 통신방식
	// 이때 글자로 post라고 안쓰고 RequestMethod.POST라는 전역 번수를 씀
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {

		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());

		return userVO;
	}

	@RequestMapping("/insertUsers")
	public List<UserVO> insertUserList(UserListVO userListVO) {
		for (UserVO user : userListVO.getList()) {
			System.out.println(user);
		}
		return userListVO.getList();
	}

	@RequestMapping("/getUserData")

	// @RequestParam String name : 필수 값이고 이름은 매개변수 이름과 같음
	// @RequestParam("id") String name : 필수 값이고 이름은 id임
	// @RequestParam(required=false) Integer age : 필수값이 아니고 이름은 매개변수와 같음

	// RequestParam은 값이 무조건 있어야함 따라서 ⇒ 디폴트 값이 거의 필수적임
	// 값이 무조건 들어가지 않아도 되면(필수값이 아니라면) required=false로 주면 됨
	// int타입이라면 defaultValue로 값을 넣어줄수 있음
	public UserVO getUserData(@RequestParam("id") String name,
			@RequestParam(defaultValue = "0", required = false) int age) {
		UserVO userVO = new UserVO();
		userVO.setName(name);
		// 만약 int값이 필요한 경우 삼항 연산자 사용
		// userVO.setAge(age==null ? 0 : age);
		// defaultValue 로 값을 넣어줄수 있음 => @RequestParam(defaultValue="0", required=false)
		// int age
		userVO.setAge(age);

		return userVO;
	}

	@GetMapping("/getDataList")
	public String getDataList(@RequestParam Map<String, Object> map) {
		String message = null;
		if (map.isEmpty()) {
			message = "데이터가 존재하지 않습니다.";
		} else {
			message = "데이터가 생성되었습니다.";
			Set<Map.Entry<String, Object>> entryList = map.entrySet();
			for (Map.Entry<String, Object> entry : entryList) {
				System.out.print("Key : " + entry.getKey());
				System.out.println(", Value : " + entry.getValue());
			}
		}
		return message;
	}

	@RequestMapping("/getNames")
	// @RequestParam List<String> name : 동일한 파라미터 이름이 매개변수 이름이어야함
	public Map<String, Object> getNames(@RequestParam List<String> name) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", name);
		return map;
	}

	@RequestMapping("/getEmpInfo/{employeeId}")
	public UserVO getEmpInfo(@PathVariable String employeeId) {
		UserVO userVO = new UserVO();
		userVO.setName(employeeId);
		return userVO;
	}

	// html파일로 실습함
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) {
		return userVO;
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestPart MultipartFile[] pic) {
		// System.out.println(userVO);
		// System.out.println("name : " + userVO.getName());
		// System.out.println("file : " + userVO.getPic().getOriginalFilename());
		
		System.out.println(pic[0].getOriginalFilename());
		
		return "Upload Complete!";
	}

}
