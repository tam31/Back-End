package com.ssafy.user.model.dao;

import org.apache.ibatis.annotations.Param;

import com.ssafy.user.model.dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO selectOne(MemberDTO member);
	
    public int insert(MemberDTO member);
	
    public MemberDTO selectUserId(String userId); // 아이디로 회원 정보 조회
}
