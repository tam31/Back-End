package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.BoardDTO;
import com.ssafy.board.model.dto.CommentDTO;
import com.ssafy.board.service.BoardService;
import com.ssafy.user.model.dto.MemberDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/comment")
@Tag(name="Comment Controller", description="댓글 조회, 추가, 수정, 삭제")
public class CommentController {
	@Autowired
	private BoardService bservice;
	
	@Operation(summary="댓글 작성", description="댓글 작성 시 DB에 저장")
	@PostMapping(value="/write/{boardIdx}")
	public ResponseEntity<?> write(@RequestBody CommentDTO commentDTO, @PathVariable("boardIdx") int boardIdx) {
		bservice.inputComment(boardIdx, commentDTO);
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary="댓글 수정 페이지 이동", description="댓글 수정 페이지 이동")
	@GetMapping("/update")
	public String update(@RequestParam("commentIdx") int commentIdx, Model model) {
		CommentDTO comment = bservice.readComment(commentIdx);
		model.addAttribute("comment", comment);
		return "index";
	}
	
	@Operation(summary="댓글 수정", description="댓글 수정 요청 시 DB에 저장된 데이터 수정")
	@PostMapping("/update")
	public String update(CommentDTO comment, Model model) {
		if(bservice.updateComment(comment)) {
			model.addAttribute("msg", "수정에 성공하였습니다.");
		} else {
			model.addAttribute("msg", "수정에 실패하였습니다.");
		}
		return "redirect:/board/read";
	}
	
	@Operation(summary="댓글 삭제", description="댓글 삭제 시 DB에 저장된 데이터 삭제")
	@GetMapping("/delete/{idx}")
	public ResponseEntity<?> delete(@PathVariable("idx") int idx) {
		HttpStatus status = HttpStatus.ACCEPTED;
		if(bservice.delete(idx)) {
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
	}
	
	@Operation(summary="댓글 목록", description="댓글 전체 목록 조회")
	@GetMapping("/list/{boardIdx}")
	public ResponseEntity<?> list(@PathVariable("boardIdx") int boardIdx){
		Map<String, List<CommentDTO>> map = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			List<CommentDTO> list =bservice.getComments(boardIdx);
			map.put("commentInfo", list);
			status = HttpStatus.OK;
		}catch(Exception e) {
			exceptionHandling(e);
		}
		return new ResponseEntity<Map<String, List<CommentDTO>>>(map,status); 
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
