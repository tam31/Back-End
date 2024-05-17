package com.ssafy.plan.model.dto;

import java.util.Date;

public class ScheduleDTO {
	private int scheduleIdx;
	private String scheduleLocation;
	private double scheduleLat;
	private double scheduleLon;
	private String scheduleMemo;
	private int planIdx;
	private int scheduleOrder;
	
	public ScheduleDTO() {}

	public ScheduleDTO(int scheduleIdx, String scheduleLocation, double scheduleLat, double scheduleLon,
			String scheduleMemo, int planIdx, int scheduleOrder) {
		super();
		this.scheduleIdx = scheduleIdx;
		this.scheduleLocation = scheduleLocation;
		this.scheduleLat = scheduleLat;
		this.scheduleLon = scheduleLon;
		this.scheduleMemo = scheduleMemo;
		this.planIdx = planIdx;
		this.scheduleOrder = scheduleOrder;
	}

	public int getScheduleIdx() {
		return scheduleIdx;
	}

	public void setScheduleIdx(int scheduleIdx) {
		this.scheduleIdx = scheduleIdx;
	}

	public String getScheduleLocation() {
		return scheduleLocation;
	}

	public void setScheduleLocation(String scheduleLocation) {
		this.scheduleLocation = scheduleLocation;
	}

	public double getScheduleLat() {
		return scheduleLat;
	}

	public void setScheduleLat(double scheduleLat) {
		this.scheduleLat = scheduleLat;
	}

	public double getScheduleLon() {
		return scheduleLon;
	}

	public void setScheduleLon(double scheduleLon) {
		this.scheduleLon = scheduleLon;
	}

	public String getScheduleMemo() {
		return scheduleMemo;
	}

	public void setScheduleMemo(String scheduleMemo) {
		this.scheduleMemo = scheduleMemo;
	}

	public int getPlanIdx() {
		return planIdx;
	}

	public void setPlanIdx(int planIdx) {
		this.planIdx = planIdx;
	}

	public int getScheduleOrder() {
		return scheduleOrder;
	}

	public void setScheduleOrder(int scheduleOrder) {
		this.scheduleOrder = scheduleOrder;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [scheduleIdx=" + scheduleIdx + ", scheduleLocation=" + scheduleLocation + ", scheduleLat="
				+ scheduleLat + ", scheduleLon=" + scheduleLon + ", scheduleMemo="
				+ scheduleMemo + ", planIdx=" + planIdx + ", scheduleOrder=" + scheduleOrder + "]";
	}
}
