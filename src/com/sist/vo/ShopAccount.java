package com.sist.vo;

public class ShopAccount {
	private int S_dealNum;
	private String giftyconCode;
	private String regdate;
	private String mid;
	private String recipient;
	private String expireDate;
	
	public int getS_dealNum() {
		return S_dealNum;
	}
	public void setS_dealNum(int s_dealNum) {
		S_dealNum = s_dealNum;
	}
	public String getGiftyconCode() {
		return giftyconCode;
	}
	public void setGiftyconCode(String giftyconCode) {
		this.giftyconCode = giftyconCode;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	
}
