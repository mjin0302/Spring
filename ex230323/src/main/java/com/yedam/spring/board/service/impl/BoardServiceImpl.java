package com.yedam.spring.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;
import com.yedam.spring.emp.mapper.EmpMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	// 전체조회
	@Override
	public List<BoardVO> getBoardList() {
		
		return boardMapper.selectBaordList();
		
	}

	// 단건 조회
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		
		return boardMapper.selectBoardInfo(boardVO);
		
	}

	// 등록 하고자 하는 글번호
	@Override
	public BoardVO getBoardNo() {
		
		return boardMapper.getBoardNo();
		
	}

	// 등록
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		
		int result = boardMapper.insertBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		} else {
			return -1;
		}
		
	}

	// 수정
	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		
		int result = boardMapper.updateBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		} else {
			return -1;
		}
		
	}

	// 삭제
	@Override
	public int deleteBoardInfo(int boardNo) {
		
		int result = boardMapper.deleteBoard(boardNo);

		if (result == 1) {
			return boardNo;
		} else {
			return -1;
		}
		
	}

}
