package com.ssafy.plan.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.plan.model.dao.PlanDAO;
import com.ssafy.plan.model.dto.PlanDTO;


@Service
public class PlanService {
	@Autowired
	private PlanDAO pdao;

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
}
