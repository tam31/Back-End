package com.ssafy.plan.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.plan.model.dto.JoinDTO;


public interface JoinDAO {
	public int selectCountByUserIdAndPlanId(@Param("userId") String userId, @Param("planIdx") int planIdx);
		
	public int insertIfNotExists(JoinDTO join) throws SQLException;
	
	public int delete(int joinIdx);
	
	public List<JoinDTO> selectList();
	
	public JoinDTO selectOne(int joinIdx);
}
