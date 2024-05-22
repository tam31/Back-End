package com.ssafy.plan.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.plan.model.dao.PlanDAO;
import com.ssafy.plan.model.dao.ScheduleDAO;
import com.ssafy.plan.model.dto.PlanDTO;
import com.ssafy.plan.model.dto.ScheduleDTO;


@Service
public class PlanService {
	@Autowired
	private PlanDAO pdao;
	@Autowired
	private ScheduleDAO sdao;

	public void write(PlanDTO plan) throws Exception {
		pdao.insert(plan);
	}

	public boolean update(PlanDTO plan) {
		if (pdao.update(plan) > 0) {
			return true;
		}
		return false;
	}

	public boolean delete(int planIdx) {
		if (pdao.delete(planIdx) > 0) {
			return true;
		}
		return false;
	}

	public PlanDTO read(int planIdx) {
		PlanDTO plan = pdao.selectOne(planIdx);
		plan.setSchedules(sdao.selectOneList(planIdx));
		return plan;
	}

	public Map<String, Object> makePage(int curPage) {
		Map<String, Object> map = new HashMap();

		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;

		int totalCount = pdao.selectTotalCount();
		int totalPage = totalCount / 10;
		if (totalCount % 10 > 0) {
			totalPage++;
		}

		if (totalPage < endPage) {
			endPage = totalPage;
		}

		int startRow = (curPage - 1) * 10;
		int count = 10;
		List<PlanDTO> planList = pdao.selectList(startRow, count); 

		map.put("curPage", curPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("planList", planList);

		return map;
	}
	
	// 사용자 여행계획 리스트
	public Map<String, Object> listPlans(String userId){
		Map<String, Object> map = new HashMap<>();
		List<PlanDTO> plans= pdao.selectPlans(userId);
		System.out.println(plans);
		map.put("planList", plans);
		return map;
	}
	
	// 추가후 plan_idx 뽑기
	public Integer listIdx() {
		return pdao.selectLastIdx();
	}
	
	public ScheduleDTO scheduleWrite(ScheduleDTO schedule) throws Exception {
		int planIdx = schedule.getPlanIdx();
        int lastOrder = sdao.getLastScheduleOrder(planIdx);

        if (lastOrder == 0) {
            // 해당 plan_idx에 대한 Schedule 테이블의 레코드가 없는 경우
            schedule.setScheduleOrder(1);
        } else {
            // 해당 plan_idx에 대한 Schedule 테이블의 마지막 레코드의 schedule_order 값을 가져온 후 1을 더함
            schedule.setScheduleOrder(lastOrder + 1);
        }
		
		sdao.insert(schedule);
		return sdao.getLastInsertedSchedule();
	}

	public boolean scheduleUpdate(ScheduleDTO schedule) {
		if (sdao.update(schedule) > 0) {
			return true;
		}
		return false;
	}

	public boolean scheduleDelete(int scheduleIdx) {
		if (sdao.delete(scheduleIdx) > 0) {
			return true;
		}
		return false;
	}

	public ScheduleDTO scheduleRead(int scheduleIdx) {
		ScheduleDTO schedule = sdao.selectOne(scheduleIdx);
		return schedule;
	}

	public void planScheduleUpdate(ScheduleDTO scheduleDTO, int i, int scheduleIdx) {
		sdao.planScheduleUpdate(scheduleDTO, i, scheduleIdx);		
	}
}
