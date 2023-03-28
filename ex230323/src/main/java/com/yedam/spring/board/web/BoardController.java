package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

import oracle.jdbc.proxy.annotation.Post;

// request, mapping가 가능함 
@Controller
//@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 - URI-getBoardList, RETURN = board/boardList
	@GetMapping("/getBoardList")
	// Model => req, res 한번에 묶어서 스프링에서 제공하는 ..? 
	public String selectBaordList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		
		return "board/boardList";
	}

	// 단건조회 - URI - getBoardInfo, RETURN = board/boardInfo
	@GetMapping("/getBoardInfo")
	public String selectBoardInfo(BoardVO boardVO, Model model) {
		
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		
		return "board/boardInfo";
	}

	// 등록 - 페이지 - URI - boardInsert, RETURN = board/boardInsert
	@GetMapping("/boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("boardInfo", boardService.getBoardNo());
		//model.addAttribute("bno", boardService.getBoardNo().getBno());
		
		return "board/boardInsert";
	}
	
	// 등록 - 처리 - URI - boardInsert, RETURN = 전체조회 다시 호출
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		
		// 경로를 호출하는것 
		// post일때는 잘 사용하지 않음
		return "redirect:getBoardList";
	}
	
	// 수정 - 페이지 - URI - boardUpdate, RETURN = board/boardUpdate
 	@GetMapping("/boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
 		
 		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
 		
 		return "board/boardUpdate";
 	}
	// 수정 - 처리 - URI - boardUpdate, RETURN = 단건조회 다시 호출
 	@PostMapping("/boardUpdate")
 	public String boardUpdateProcess(BoardVO boardVO) {
 		
 		boardService.updateBoardInfo(boardVO);
 		
 		return "redirect:getBoardInfo?bno="+boardVO.getBno();
 	}
	
	// 삭제 - URI - boardDelete, RETURN = 전체조회 다시 호출
	@GetMapping("/boardDelete")
	public String boardDeleteProcess(@RequestParam int bno) {
		boardService.deleteBoardInfo(bno);
//		int boardNO = boardService.deleteBoardInfo(bno);
//		
//		String result = null;
//		if (boardNO == -1) {
//			result = "삭제 안됨.";
//		} else {
//			result = "삭제 완료. \n 삭제된 사원의 사번은 " + boardNO + " 입니다.";
//		}
		return "redirect:getBoardList";
	}
	
}
