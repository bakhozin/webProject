package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sist.vo.Seat;
import com.sist.vo.Theater;

public class SeatDAO {
	
	public Connection getConn(){

		String url = "jdbc:oracle:thin:@211.238.142.126:1521:orcl";
		String user = "CHARLIE";
		String pwd = "111111";

		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속실패, 계정명과 비밀번호를 확인하세요");
			e.printStackTrace();
		}

		return con;
	}

	//해당상영관의 좌석들을 리턴
	public ArrayList<Seat> getSeats(String theaterNo){

		ArrayList<Seat> list = new ArrayList<Seat>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		

		String sql = "SELECT * FROM SEAT WHERE THEATERNO = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, theaterNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Seat seat = new Seat();
				
				seat.setSeat_seq(rs.getInt("seat_seq"));
				seat.setSeatNo(rs.getInt("seatNo"));
				seat.setStatus(rs.getString("status"));
				seat.setTheaterNo(rs.getInt("theaterNo"));
				
				list.add(seat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
		
	}

	//번호에 해당하는 좌석 리턴 
	public Seat getSeat(String seatSeq){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		
		Seat seat = null;
		
		String sql = "SELECT * FROM SEAT WHERE SEAT_SEQ = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seatSeq);
			
			if(rs.next()){
				seat = new Seat();
				seat.setSeat_seq(rs.getInt("seat_seq"));
				seat.setSeatNo(rs.getInt("seatNo"));
				seat.setStatus(rs.getString("status"));
				seat.setTheaterNo(rs.getInt("theaterNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seat;
		
	}

	//예매완료/취소 시 status변경(status: 'X' or 'O')
	public int updateStatus(String seatSeq, String status){
		
		Connection con = null;
		PreparedStatement ps = null;
		con = getConn();
		int af=0;
		
		
		String sql = "UPDATE SEAT SET STATUS = '?' WHERE SEQ=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, seatSeq);
			
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return af;
		
	}

	
}

