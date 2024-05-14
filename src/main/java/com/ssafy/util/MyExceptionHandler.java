package com.ssafy.util;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice // aop에서 공통 처리 클래스인데 적용 대상이 controller인 애들 찾아서 자동 적용
//public class MyExceptionHandler {
//	@ExceptionHandler(Exception.class) // after throwing
//	public ModelAndView error() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "에러");
//		mav.setViewName("Alert");
//		
//		return mav;
//	}
//}