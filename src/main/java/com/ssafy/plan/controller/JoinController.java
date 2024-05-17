package com.ssafy.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.plan.model.dto.JoinDTO;
import com.ssafy.plan.model.service.JoinService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;

@RestController
@RequestMapping("/join")
@CrossOrigin("*")
@Tag(name="Join Controller", description="회원 초대 테이블 조회, 수정, 삭제")
public class JoinController {
	@Autowired
	private JoinService jservice;
	@Autowired
	private ServletContext servletContext;

	@Operation(summary="조인 목록", description="조인 전체 목록 조회")
	@GetMapping("/list")
	public List<JoinDTO> getJoinList() {
		return jservice.list();
	}
	
	@Operation(summary="조인 추가", description="조인 추가 요청 시 DB에 저장")
	@PostMapping("/write")
	public ResponseEntity<?> write(@RequestBody @Parameter(description = "추가 조인 정보", required = true) JoinDTO join){
		try {
			jservice.write(join);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="조인 조회", description="조인 조회")
	@GetMapping("/read/{joinIdx}")
    public ResponseEntity<JoinDTO> read(@PathVariable("joinIdx") @Parameter(name = "joinIdx", description = "얻어올 조인의 번호", required = true) int joinIdx) {
		return new ResponseEntity<JoinDTO>(jservice.read(joinIdx), HttpStatus.OK);
    }
	
	@Operation(summary="조인 삭제", description="조인 삭제 시 DB에 저장된 데이터 삭제")
	@DeleteMapping("/delete/{joinIdx}")
	public ResponseEntity<?> delete(@PathVariable("joinIdx") @Parameter(name = "joinIdx", description = "삭제할 조인의 번호", required = true) int joinIdx) {
		try {
			jservice.delete(joinIdx);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
