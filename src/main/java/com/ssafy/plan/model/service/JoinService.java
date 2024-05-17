package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.plan.model.dao.JoinDAO;
import com.ssafy.plan.model.dto.JoinDTO;

@Service
public class JoinService {
	@Autowired
	private JoinDAO jdao;

	public boolean write(JoinDTO join) throws Exception {
		int count = jdao.selectCountByUserIdAndPlanId(join.getUserId(), join.getPlanIdx());
        if (count == 0) {
            jdao.insertIfNotExists(join);
            return true;
        }
        return false;
	}

	public boolean delete(int joinIdx) {
		if (jdao.delete(joinIdx) > 0) {
			return true;
		}
		return false;
	}

	public JoinDTO read(int joinIdx) {
		JoinDTO join = jdao.selectOne(joinIdx);
		return join;
	}

	public List<JoinDTO> list() {
		List<JoinDTO> joinList = jdao.selectList(); 
		return joinList;
	}
}
