package com.ssafy.plan.controller;

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

import com.ssafy.plan.model.dto.PlanDTO;
import com.ssafy.plan.model.dto.ScheduleDTO;
import com.ssafy.plan.model.service.PlanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
@Tag(name="Plan Controller", description="플랜 조회, 추가, 수정, 삭제")
public class PlanController {
	@Autowired
	private PlanService pservice;
	@Autowired
	private ServletContext servletContext;

	@Operation(summary="플랜 목록", description="플랜 전체 목록 조회")
	@GetMapping("/list")
	public Map<String, Object> getPlanList(@RequestParam(value="page", defaultValue = "1") int page) {
		return pservice.makePage(page);
	}
	
	@Operation(summary="플랜 작성", description="플랜 작성 요청 시 DB에 저장")
	@PostMapping("/write")
	public ResponseEntity<?> write(@RequestBody @Parameter(description = "작성 플랜 정보", required = true) PlanDTO plan){
		try {
			pservice.write(plan);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="플랜 수정", description="플랜 수정 요청 시 DB에 저장된 데이터 수정")
	@PostMapping("/update")
	public String update(@RequestBody @Parameter(description = "수정할 플랜 정보", required = true) PlanDTO plan, Model model) {
		if(pservice.update(plan)) {
			model.addAttribute("msg", "수정에 성공하였습니다.");
		} else {
			model.addAttribute("msg", "수정에 실패하였습니다.");
		}
		return "redirect:/plan/list";
	}
	
	@Operation(summary="플랜 조회", description="플랜 조회")
	@GetMapping("/read/{planIdx}")
    public ResponseEntity<PlanDTO> read(@PathVariable("planIdx") @Parameter(name = "planIdx", description = "얻어올 플랜의 번호", required = true) int planIdx) {
		return new ResponseEntity<PlanDTO>(pservice.read(planIdx), HttpStatus.OK);
    }
	
	@Operation(summary="플랜 삭제", description="플랜 삭제 시 DB에 저장된 데이터 삭제")
	@DeleteMapping("/delete/{planIdx}")
	public ResponseEntity<?> delete(@PathVariable("planIdx") @Parameter(name = "planIdx", description = "삭제할 플랜의 번호", required = true) int planIdx) {
		try {
			pservice.delete(planIdx);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="스케줄 작성", description="스케줄 작성 요청 시 DB에 저장")
	@PostMapping("/write_schedule")
	public ResponseEntity<?> scheduleWrite(@RequestBody @Parameter(description = "작성 스케줄 정보", required = true) ScheduleDTO schedule){
		try {
			pservice.scheduleWrite(schedule);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="스케줄 수정", description="스케줄 수정 요청 시 DB에 저장된 데이터 수정")
	@PostMapping("/update_schedule")
	public ResponseEntity<?> scheduleUpdate(@RequestBody @Parameter(description = "수정할 스케줄 정보", required = true) ScheduleDTO schedule, Model model) {
		try {
			pservice.scheduleUpdate(schedule);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary="스케줄 조회", description="스케줄 조회")
	@GetMapping("/read_schedule/{scheduleIdx}")
    public ResponseEntity<ScheduleDTO> scheduleRead(@PathVariable("scheduleIdx") @Parameter(name = "scheduleIdx", description = "얻어올 스케줄의 번호", required = true) int scheduleIdx) {
		return new ResponseEntity<ScheduleDTO>(pservice.scheduleRead(scheduleIdx), HttpStatus.OK);
    }
	
	@Operation(summary="스케줄 삭제", description="스케줄 삭제 시 DB에 저장된 데이터 삭제")
	@DeleteMapping("/delete_schedule/{scheduleIdx}")
	public ResponseEntity<?> scheduleDelete(@PathVariable("scheduleIdx") @Parameter(name = "scheduleIdx", description = "삭제할 스케줄의 번호", required = true) int scheduleIdx) {
		try {
			pservice.scheduleDelete(scheduleIdx);
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