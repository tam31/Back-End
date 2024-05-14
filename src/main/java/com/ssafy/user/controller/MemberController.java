package com.ssafy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.dto.MemberDTO;
import com.ssafy.user.model.service.JwtService;
import com.ssafy.user.model.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Tag(name="User Controller", description="사용자 회원가입, 로그인, 로그아웃, 중복체크 기능")
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@Autowired
	private JwtService jservice;
	
	@Operation(summary="로그인", description="아이디, 비밀번호를 통한 로그인 기능")
	@PostMapping("/login")
	public String login(@RequestBody MemberDTO member) {
		try {
			MemberDTO user = mservice.login(member);
	        if(user != null) {
	            String token = jservice.createToken(user);
	            return "login Ok : " +token;
	        } else {
	            return "login Fail";
	        }
	    } catch(Exception e) {
	        return null;
	    }
	}
	

	@Operation(summary="로그아웃", description="로그아웃 시 세션 종료")
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "logout 되었습니다.");
		return "Alert";
	}
	
	@Operation(summary="회원가입 페이지 이동", description="회원가입 페이지 이동")
    @GetMapping("/register")
    public String showRegisterForm() {
        return "index";
    }

    // 회원가입 요청 처리
	@Operation(summary="회원가입 요청", description="회원가입 요청 시 DB에 저장")
    @PostMapping("/register")
    public String register(@RequestParam("userId") String userId,
                           @RequestParam("userPw") String userPw,
                           @RequestParam("userName") String userName,
                           @RequestParam("userTel") String userTel,
                           @RequestParam("zipCode") int zipCode,
                           @RequestParam("userAddress") String userAddress,
                           @RequestParam("userAddressDetail") String userAddressDetail,
                           @RequestParam("userProfile") String userProfile,
                           Model model) {
        MemberDTO member = new MemberDTO();
        member.setUserId(userId);
        member.setUserPw(userPw);
        member.setUserName(userName);
        member.setUserTel(userTel);
        member.setZipCode(zipCode);
        member.setUserAddress(userAddress);
        member.setUserAddressDetail(userAddressDetail);
        member.setUserProfile(userProfile);

        boolean result = mservice.register(member);

        if (result) { // 회원가입 성공
            return "redirect:/";
        } else { // 회원가입 실패
            model.addAttribute("msg", "회원가입에 실패하였습니다.");
            return "Alert"; 
        }
    }
    
	@Operation(summary="ID 중복체크", description="겹치는 ID 중복 체크 및 생성 가능 아이디 글자수 제한")
    @GetMapping(value = "/{userId}", produces = "application/json")
    @ResponseBody
    public String checkUserId(@PathVariable("userId") String userId) {
        boolean isDuplicate = mservice.checkUserId(userId);
        if (isDuplicate) {
            return "duplicate";
        } else {
            return "available";
        }
    }
}
