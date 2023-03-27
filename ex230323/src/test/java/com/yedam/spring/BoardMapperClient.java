package com.yedam.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class BoardMapperClient {
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void selectBaordList() {
		List<BoardVO> boardlist = boardMapper.selectBaordList();
		assertNotNull(boardlist);
	}
	
	@Test
	public void selectBoardInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
		assertEquals(findVO.getWriter(), "King");
	}
	
	@Test
	public void insertBoard() {
		//등록
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(5);
		boardVO.setWriter("King");
		boardVO.setContents("vueㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ");
		boardVO.setTitle("개ㅑㄷ저]");
		
		boardMapper.insertBoard(boardVO);
		assertNotEquals(boardVO.getBno(), 0);
	}
	
	@Test
	public void updateBoard() {
		// 사원 정보 수정
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
		System.out.println(findVO);
		
		boardVO.setWriter("Minjin");
		boardVO.setContents("fkldsjfsdklfjsdklfnsdlvksdnkljgshjefiorweujtopwej");
		
		int result = boardMapper.updateBoard(boardVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteBoard() {
		// 사원 삭제
		int result = boardMapper.deleteBoard(1);
		assertEquals(result, 1);
	}
}
