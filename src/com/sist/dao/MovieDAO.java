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
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ӽ���, ������� ��й�ȣ�� Ȯ���ϼ���.");
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public Movie getMovie(String mcode) {  //��ȭ ��ȸ  
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
			System.out.println("��ȭ ��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return m;
	}
	
	
	
	public ArrayList<Movie> allMovie() { //��ü ��ȭ ��ȸ 
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
			System.out.println("��ü ��ȭ��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_GPA() { //���� �� ��ȸ 
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
			System.out.println("��ü ��ȭ��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_RATE(String rate) { //��� �� ��ȸ 
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
			System.out.println("��� �� ��ȭ ��ȸ�� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	public ArrayList<Movie> searchMovie_RELEASE() { //�ֽ� ������
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
			System.out.println("�ֽ� ������ ��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return mList;
	}

}
