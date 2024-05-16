package com.ssafy.plan.model.dto;

import java.util.List;

public class PlanDTO {
	private int planIdx;
	private String planTitle;
	private String planDate;
	private List<ScheduleDTO> schedules;
	
	public PlanDTO() {}

	public PlanDTO(int planIdx, String planTitle, String planDate, List<ScheduleDTO> schedules) {
		super();
		this.planIdx = planIdx;
		this.planTitle = planTitle;
		this.planDate = planDate;
		this.schedules = schedules;
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

	public List<ScheduleDTO> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleDTO> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "PlanDTO [planIdx=" + planIdx + ", planTitle=" + planTitle + ", planDate=" + planDate + ", schedules="
				+ schedules + "]";
	}
}
