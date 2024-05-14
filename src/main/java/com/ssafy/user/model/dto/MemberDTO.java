package com.ssafy.user.model.dto;

public class MemberDTO {
	private String userId;
	private String userPw;
	private String userName;
	private String userTel;
	private int zipCode;
	private String userAddress;
	private String userAddressDetail;
	private String userProfile;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String userId, String userPw, String userName, String userTel, int zipCode, String userAddress,
			String userAddressDetail, String userProfile) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userTel = userTel;
		this.zipCode = zipCode;
		this.userAddress = userAddress;
		this.userAddressDetail = userAddressDetail;
		this.userProfile = userProfile;
	}
	
	

	public MemberDTO(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserAddressDetail() {
		return userAddressDetail;
	}

	public void setUserAddressDetail(String userAddressDetail) {
		this.userAddressDetail = userAddressDetail;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userTel=" + userTel
				+ ", zipCode=" + zipCode + ", userAddress=" + userAddress + ", userAddressDetail=" + userAddressDetail
				+ ", userProfile=" + userProfile + "]";
	}
}
