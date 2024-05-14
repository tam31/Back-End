// package com.ssafy.util;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndViewDefiningException;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component // 이 객체도 스캔할 수 있게
//public class LoginInterceptor implements HandlerInterceptor {
//	// Controller로 가기 전(aop에서는 before라고 했던 부분과 비슷한 처리)
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		if(request.getSession().getAttribute("loginInfo") != null) {
//			return true; // 로그인 완료
//		} else { // 요청한 컨트롤러로 실행하면 안됨
//			ModelAndView mav = new ModelAndView("Alert");
//			mav.addObject("msg", "로그인이 필요합니다.");
//			throw new ModelAndViewDefiningException(mav);
//		}
//	}
//}
