package com.sist.vo;

public class Book {
	private int bookingNum;
	private int time_seq;
	private int seat_seq;
	private String mid;
	private String nmid;
	private String regdate;
	private String cancelCheck;
	
	
	public int getBookingNum() {
		return bookingNum;
	}
	public void setBookingNum(int bookingNum) {
		this.bookingNum = bookingNum;
	}
	public int getTime_seq() {
		return time_seq;
	}
	public void setTime_seq(int time_seq) {
		this.time_seq = time_seq;
	}
	public int getSeat_seq() {
		return seat_seq;
	}
	public void setSeat_seq(int seat_seq) {
		this.seat_seq = seat_seq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNmid() {
		return nmid;
	}
	public void setNmid(String nmid) {
		this.nmid = nmid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCancelCheck() {
		return cancelCheck;
	}
	public void setCancelCheck(String cancelCheck) {
		this.cancelCheck = cancelCheck;
	}
	
	
}
