package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sist.vo.TimeTable;

public class TimeTableDAO {
	
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@211.238.142.126:1521:orcl";
		String user = "CHARLIE";
		String pwd = "111111";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속 실패, 계정명과 비밀번호 확인");
			e.printStackTrace();
		}
		return con;
	}
	
	//상영관과 영화에 따른 영화시간표
	public TimeTable getTimeTable(int theaterNo, String mcode) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TimeTable tt = null;
		String sql = "SELECT * FROM TIMETABLE WHERE THEATERNO = ? AND MCODE=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, theaterNo);
			ps.setString(2, mcode);
			rs=ps.executeQuery();
			if(rs.next()) {
				tt = new TimeTable();
				tt.setTime_seq(rs.getInt("time_seq"));
				tt.setTheaterNo(rs.getInt("theaterNo"));
				tt.setMcode(rs.getString("mcode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("영화시간표 조회 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return tt;
	}
}
