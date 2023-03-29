package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	
	// 전체조회
	public List<BookVO> selectBookList();
	
	// 등록 하고자 하는 글번호
	public BookVO getBookNo();
	
	// 등록
	public int insertBook(BookVO bookVO);
	
	// 대여 총 합계, 대여권수 조회
	public List<BookVO> selectBookInfo();
	
}
