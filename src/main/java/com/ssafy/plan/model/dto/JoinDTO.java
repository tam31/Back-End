package com.ssafy.plan.model.dto;

import java.util.List;

public class JoinDTO {
	private int joinIdx;
	private String userId;
	private int planIdx;
	
	public JoinDTO() {}

	public JoinDTO(int joinIdx, String userId, int planIdx) {
		super();
		this.joinIdx = joinIdx;
		this.userId = userId;
		this.planIdx = planIdx;
	}

	public int getJoinIdx() {
		return joinIdx;
	}

	public void setJoinIdx(int joinIdx) {
		this.joinIdx = joinIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPlanIdx() {
		return planIdx;
	}

	public void setPlanIdx(int planIdx) {
		this.planIdx = planIdx;
	}

	@Override
	public String toString() {
		return "JoinDTO [joinIdx=" + joinIdx + ", userId=" + userId + ", planIdx=" + planIdx + "]";
	}
}
