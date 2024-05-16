package com.ssafy.plan.model.dto;

public class PlanDTO {
	private int planIdx;
	private String planTitle;
	private String planDate;
	
	public PlanDTO() {}

	public PlanDTO(int planIdx, String planTitle, String planDate) {
		super();
		this.planIdx = planIdx;
		this.planTitle = planTitle;
		this.planDate = planDate;
	}

	public int getPlanIdx() {
		return planIdx;
	}

	public void setPlanIdx(int planIdx) {
		this.planIdx = planIdx;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	@Override
	public String toString() {
		return "PlanDTO [planIdx=" + planIdx + ", planTitle=" + planTitle + ", planDate=" + planDate + "]";
	}
}
