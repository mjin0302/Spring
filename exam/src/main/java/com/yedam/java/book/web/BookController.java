package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	//전체조회
	@GetMapping("/getBookList")
	public String selectBookList(Model model) {
		model.addAttribute("bookList", bookService.selectBookList());
		
		return "book/bookList";
	}
	
	//전체조회
	@GetMapping("/bookListInfo")
	public String selectBookInfo(Model model) {
		model.addAttribute("bookListInfo", bookService.selectBookInfo());
		
		return "book/bookListInfo";
	}
	
	// 등록	
	@GetMapping("/bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookInfo", bookService.getBookNo());
		
		return "book/bookInsert";
	}
	
	// 등록 - 처리
	@PostMapping("/bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.insertBook(bookVO);
		
		return "redirect:getBookList";
	}
}
