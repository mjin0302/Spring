package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;

	// 전체조회
	@Override
	public List<BookVO> selectBookList() {

		return bookMapper.selectBookList();

	}

	// 등록 하고자 하는 책번호
	@Override
	public BookVO getBookNo() {

		return bookMapper.getBookNo();
	}

	// 수정
	@Override
	public int insertBook(BookVO bookVO) {

		int result = bookMapper.insertBook(bookVO);

		if (result == 1) {
			return bookVO.getBookNo();
		} else {
			return -1;
		}
	}

	@Override
	public List<BookVO> selectBookInfo() {
		// TODO Auto-generated method stub
		return bookMapper.selectBookInfo();
	}

}
