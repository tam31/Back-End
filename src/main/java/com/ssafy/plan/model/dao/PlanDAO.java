package com.ssafy.plan.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.plan.model.dto.PlanDTO;


public interface PlanDAO {

	public int insert(PlanDTO plan) throws SQLException;
	
	public int update(PlanDTO plan);
	
	public int delete(int planIdx);
	
	public int selectTotalCount();
	
	public List<PlanDTO> selectList(@Param("sr") int startRow, @Param("cc") int count);
	
	public PlanDTO selectOne(int planIdx);

	public Integer selectLastIdx();
	public List<PlanDTO> selectPlans(String userId);
}
