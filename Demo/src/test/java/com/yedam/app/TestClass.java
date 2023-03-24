package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;


//빈이 제대로 생성되었는지 보려면 컨테이너에서 들고와야함
// 하지만 jUnit은 컨테이너를 다룰수있는 내용이 없음
// => 따라서 pom.xml에서 spring-test라는 보조라이브러리가 필요함

// =========================================



//xml을 읽어 들여도 컨테이너를 읽어 들이지 못함 따라서 RunWith를 설정해주어야함
// SpringJUnit4ClassRunner.class : 테스트를 할때 xml 정보를 읽어들여서 컨테이너를 만들수있게해줌
@RunWith(SpringJUnit4ClassRunner.class)
//pom.xml에서 spring-test라는 보조라이브러리가 작성되어져 있어야함
//컨테이너에대한 정보를 끌고들어와주는 어노테이션
//컨테이너를 만들어주는 class정보
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestClass {

	// 빈으로써 구현클래스를 사용할땐 사용하는 위치의 타입을 인터페이스로 쓰기 
	// ★★ @Autowired 밑에있는 타입은 대체로 인터페이스임 ★★
	//@Autowired 
	//ApplicationContext ctx;
	
	// 컨테이너를 변수로 할당할 필요없고
	// 빈을 필드로써 지정해줌
	@Autowired
	Restaurant res;
	
	@Test
	public void beanTest() {
		// 아까 빈등록시 이름을 지정해주지 않아서 ctx.getBean(Restaurant.class);로 해야함
		//Restaurant res = ctx.getBean(Restaurant.class);
		assertNotNull(res);
	}
	
}
