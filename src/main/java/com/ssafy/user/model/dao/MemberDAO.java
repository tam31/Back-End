package com.ssafy.user.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.user.model.dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO selectOne(MemberDTO member);
	
    public int insert(MemberDTO member);
	
    public MemberDTO selectUserId(String userId); // 아이디로 회원 정보 조회
    

    public void saveRefreshToken(Map<String, String> map);
    public Object getRefreshToken(String userid) throws SQLException;
    public void deleteRefreshToken(Map<String, String> map) throws SQLException;
    public MemberDTO userInfo(String userId) throws SQLException;
}
