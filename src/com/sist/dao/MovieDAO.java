package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sist.vo.Movie;
public class MovieDAO {
	
	public Connection getConn() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "CHARLIE";
		String pwd = "111111";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속실패, 계정명과 비밀번호를 확인하세요.");
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public Movie getMovie(String mcode) {  //영화 조회  
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Movie m = null;
		String sql = "SELECT * FROM MOVIE WHERE MCODE=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mcode);
			rs=ps.executeQuery();
			if(rs.next()){
				
				m.setMcode(rs.getString("mcode"));
				m.setTitle(rs.getString("title"));
				m.setRelease(rs.getString("release"));
				m.setRate(rs.getString("rate"));
				m.setSummary(rs.getString("summary"));
				m.setGPA(rs.getDouble("gpa"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("영화 조회 중 오류발생");
			e.printStackTrace();
		} finally {
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
		return m;
	}
	
	
	
	public ArrayList<Movie> allMovie() { //전체 영화 조회 
		Connection con;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Movie> mList = null;
		
		String sql = "SELECT * FROM MOVIE";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			mList = new ArrayList<>();
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMcode(rs.getString("mcode"));
				m.setRelease(rs.getString("release"));
				m.setRate(rs.getString("rate"));
				m.setSummary(rs.getString("summary"));
				m.setTitle(rs.getString("title"));
				m.setGPA(rs.getDouble("gpa"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("전체 영화조회 중 오류발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_GPA() { //평점 순 조회 
		Connection con;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Movie> mList = null;
		
		String sql = "SELECT * FROM MOVIE ORDER BY GPA ASC";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			mList = new ArrayList<>();
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMcode(rs.getString("mcode"));
				m.setRelease(rs.getString("release"));
				m.setRate(rs.getString("rate"));
				m.setSummary(rs.getString("summary"));
				m.setTitle(rs.getString("title"));
				m.setGPA(rs.getDouble("gpa"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("전체 영화조회 중 오류발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_RATE(String rate) { //등급 별 조회 
		Connection con;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Movie> mList = null;
		
		String sql = "SELECT * FROM MOVIE WHERE RATE=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, rate);
			rs=ps.executeQuery();
			
			mList = new ArrayList<>();
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMcode(rs.getString("mcode"));
				m.setRelease(rs.getString("release"));
				m.setRate(rs.getString("rate"));
				m.setSummary(rs.getString("summary"));
				m.setTitle(rs.getString("title"));
				m.setGPA(rs.getDouble("gpa"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("등급 별 영화 조회중 오류발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_RELEASE() { //최신 개봉작
		Connection con;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Movie> mList = null;
		
		String sql = "SELECT * FROM MOVIE ORDER BY RELEASE ASC";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			mList = new ArrayList<>();
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMcode(rs.getString("mcode"));
				m.setRelease(rs.getString("release"));
				m.setRate(rs.getString("rate"));
				m.setSummary(rs.getString("summary"));
				m.setTitle(rs.getString("title"));
				m.setGPA(rs.getDouble("gpa"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("최신 개봉작 조회 중 오류발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return mList;
	}

}
