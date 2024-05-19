package com.ssafy.plan.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.plan.model.dto.ScheduleDTO;


public interface ScheduleDAO {

	public int insert(ScheduleDTO schedule) throws SQLException;
	
	int getLastScheduleOrder(@Param("planIdx") int planIdx);
	
	public int update(ScheduleDTO schedule);
	
	public int delete(int scheduleIdx);
	
	public List<ScheduleDTO> selectList();
	public List<ScheduleDTO> selectOneList(int planIdx);
	
	public ScheduleDTO selectOne(int scheduleIdx);

	public void planScheduleUpdate(ScheduleDTO schedule, int idx, int scheduleIdx);
}
