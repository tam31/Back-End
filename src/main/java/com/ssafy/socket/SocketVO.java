package com.ssafy.socket;

import lombok.AllArgsConstructor;
import lombok.Data;

////Data 어노테이션은 getter, setter를 자동 생성합니다.
//@Data
//
////AllArgsConstructor 어노테이션은 생성자를 자동 생성합니다.
//@AllArgsConstructor
//public class SocketVO {
// // 유저의 이름을 저장하기 위한 변수
// private String userName;
//
// // 메시지의 내용을 저장하기 위한 변수
// private String content;
//}

public class SocketVO {
	// 유저의 이름을 저장하기 위한 변수
	private String userName;

	// 메시지의 내용을 저장하기 위한 변수
	private String content;
	
	public SocketVO() {}

	public SocketVO(String userName, String content) {
		this.userName = userName;
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}