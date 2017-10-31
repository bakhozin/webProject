package com.sist.vo;

public class Seat {

	private int Seat_seq;
	private int TheaterNo;
	private int seatNum;
	private String status;
	public int getSeat_seq() {
		return Seat_seq;
	}
	public void setSeat_seq(int seat_seq) {
		Seat_seq = seat_seq;
	}
	public int getTheaterNo() {
		return TheaterNo;
	}
	public void setTheaterNo(int theaterNo) {
		TheaterNo = theaterNo;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
