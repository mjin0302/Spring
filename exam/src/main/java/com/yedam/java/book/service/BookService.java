package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	
	// 전체조회
	public List<BookVO> selectBookList();
	
	// 등록하고자 하는 글번호
	public BookVO getBookNo();
	
	// 등록
	public int insertBook(BookVO bookVO);
	
	public List<BookVO> selectBookInfo();
}
