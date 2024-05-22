package com.ssafy.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.dto.BoardDTO;
import com.ssafy.board.model.dto.FileDTO;
import com.ssafy.board.service.BoardService;
import com.ssafy.user.model.dto.MemberDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/board")
@CrossOrigin("*")
@Tag(name="Board Controller", description="게시글 조회, 추가, 수정, 삭제")
public class BoardController {
	@Autowired
	private BoardService bservice;
	@Autowired
	private ServletContext servletContext;

	@Operation(summary="게시글 목록", description="게시글 전체 목록 조회")
	@GetMapping("/list")
	public Map<String, Object> getBoardList(@RequestParam(value="page", defaultValue = "1") int page) {
		return bservice.makePage(page);
	}
	
	@Operation(summary="게시글 작성 페이지 이동", description="회원가입 페이지 이동")
	@GetMapping("/write")
	public String write() {
		return "index";
	}
	
	@Operation(summary="게시글 작성", description="게시글 작성 요청 시 DB에 저장")
	@PostMapping("/write")
	public ResponseEntity<?> write(@RequestBody @Parameter(description = "작성글 정보", required = true) BoardDTO board){
		try {
			bservice.write(board);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="게시글 수정 페이지 이동", description="게시글 수정 페이지 이동")
	@GetMapping("/update")
	public String update(@RequestParam("boardIdx") int boardIdx, Model model) {
		BoardDTO board = bservice.read(boardIdx);
		model.addAttribute("board", board);
		return "index";
	}
	
	@Operation(summary="게시글 수정", description="게시글 수정 요청 시 DB에 저장된 데이터 수정")
	@PostMapping("/update")
	public String update(@RequestBody @Parameter(description = "수정할 글정보.", required = true) BoardDTO board, Model model) {
		if(bservice.update(board)) {
			model.addAttribute("msg", "수정에 성공하였습니다.");
		} else {
			model.addAttribute("msg", "수정에 실패하였습니다.");
		}
		return "redirect:/board/list";
	}
	
	@Operation(summary="게시글 조회 페이지 이동", description="게시글 조회 페이지 이동")
	@GetMapping("/read/{boardId}")
    public ResponseEntity<BoardDTO> read(@PathVariable("boardId") @Parameter(name = "boardId", description = "얻어올 글의 글번호.", required = true) int boardId) {
		return new ResponseEntity<BoardDTO>(bservice.read(boardId), HttpStatus.OK);
    }
	
	@Operation(summary="파일 다운로드", description="게시글 조회 시 파일 다운로드")
	@GetMapping("/download")
    public void download(@RequestParam ("fileIdx") int fileIdx, HttpServletResponse resp) throws IOException {
        FileDTO fileInfo = bservice.getFileInfo(fileIdx);
        
        resp.setHeader("Content-Disposition", "attachment; filename=\""+ new String(fileInfo.getFileOriginalName().getBytes("UTF-8"), "ISO-8859-1")+"\";");
    
        resp.setHeader("Content-Transfer-Encoding", "binary");
        
        File savedFile = new File(fileInfo.getFilePath()); // 서버한테 저장되어 있는 파일을 읽기
        FileInputStream fis = new FileInputStream(savedFile);
        OutputStream os = resp.getOutputStream();
        FileCopyUtils.copy(fis, os);
    }
	
	@Operation(summary="게시글 삭제", description="게시글 삭제 시 DB에 저장된 데이터 삭제")
	@GetMapping("/delete/{boardId}")
	public ResponseEntity<?> delete(@PathVariable("boardId") @Parameter(name = "boardId", description = "살제할 글의 글번호.", required = true) int boardId) {
		try {
			bservice.deleteBoard(boardId);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	// 검색
//	@GetMapping("/search")
//    public String search(@RequestParam("keyword") String keyword, Model model) {
//        List<BoardDTO> searchResults = bservice.searchBoards(keyword); // 검색 기능을 수행하는 서비스 메소드 호출
//        model.addAttribute("pageInfo", searchResults); // 검색 결과를 모델에 추가하여 뷰로 전달
//        return "SearchResult"; // 검색 결과를 표시하는 페이지로 이동
//    }
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
