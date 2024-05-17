package com.ssafy.user.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		mdao.saveRefreshToken(map);
	}
	
	public MemberDTO userInfo(String userId) throws Exception {
		return mdao.userInfo(userId);
	}
	
	public MemberDTO getUserInfo(String userId) throws Exception{
		return mdao.getUserInfo(userId);
	}
	
	public Object getRefreshToken(String userId) throws Exception {
		return mdao.getRefreshToken(userId);
	}
	
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		mdao.deleteRefreshToken(map);
	}
	
	public boolean register(MemberDTO member) {
        int result = mdao.insert(member);
        return result > 0;
    }
	
	public MemberDTO detailId(String userId) {
		return mdao.selectUserId(userId);
	}
	
	public List<MemberDTO> list() {
		List<MemberDTO> memberList = mdao.selectList(); 
		return memberList;
	}
	
}
