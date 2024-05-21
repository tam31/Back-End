package com.ssafy.socket;

import lombok.AllArgsConstructor;
import lombok.Data;

//getter, setter 자동 생성
@Data
//생성자 자동 생성
@AllArgsConstructor
public class SocketVO {
	private int planIdx;
	private int scheduleIdx;
	private double scheduleLat;
	private double scheduleLon;
	private String scheduleLocation;
	private String scheduleMemo;
	private int scheduleOrder;
}