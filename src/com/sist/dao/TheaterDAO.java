package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sist.vo.Theater;

public class TheaterDAO {
	
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

	//모든 상영관 정보 리턴
	public ArrayList<Theater> getTheaters(String location){
		
		ArrayList<Theater> list = new ArrayList<Theater>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		
		Theater theater = null;

		String sql = "SELECT * FROM THEATER WHERE LOCATION = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, location);
			
			rs = ps.executeQuery();
			while(rs.next()){
				theater = new Theater();
				theater.setInformation(rs.getString("information"));
				theater.setLocation(rs.getString("location"));
				theater.setTheaterNo(rs.getInt("TheaterNo"));
				theater.setTheaterName(rs.getString("theaterName"));
				
				list.add(theater);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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

	//지역별 영화관정보 리턴 상영관X
	public ArrayList<Theater> getLocInfo(){

		ArrayList<Theater> list = new ArrayList<Theater>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		
		Theater theater = null;
		
		String sql = "select distinct location, information from theater";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				theater = new Theater();
				theater.setInformation(rs.getString("information"));
				theater.setLocation(rs.getString("location"));
				theater.setTheaterNo(rs.getInt("TheaterNo"));
				theater.setTheaterName(rs.getString("theaterName"));
				
				list.add(theater);
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

}
