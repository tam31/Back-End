package com.ssafy.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.dao.MemberDAO;
import com.ssafy.user.model.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO mdao;
	
	public MemberDTO login(MemberDTO member) {
		return mdao.selectOne(member);
	}
	
	public boolean register(MemberDTO member) {
        int result = mdao.insert(member);
        return result > 0;
    }
	
	public boolean checkUserId(String userId) {
        MemberDTO member = mdao.selectUserId(userId);
        return member != null;
    }
	
}
