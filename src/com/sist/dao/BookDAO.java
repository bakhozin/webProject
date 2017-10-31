package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sist.vo.Book;

public class BookDAO {
	
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
	
	

	
	public int addBook(Book b) { //���� �߰�  
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
				
		String sql = "INSERT INTO BOOK (BOOKINGNUM, TIME_SEQ, SEAT_SEQ, MID, NMID, REGDATE, CANCELCHECK) VALUES (?, ?, ?, ?, ?, SYSDATE, ?)";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, b.getBookingNum());
			ps.setInt(2, b.getTime_seq());
			ps.setInt(3, b.getSeat_seq());
			ps.setString(4, b.getMid());
			ps.setString(5, b.getNmid());
			ps.setString(6, b.getCancelCheck());
			
			
			
			af=ps.executeUpdate();
		} catch (SQLException e) {

			System.out.println("���� �߰� �� �����߻�");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return af;
	}

	
	public Book getBook(String mid) {  //�� ���� ��ȸ  
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book b = null;
		String sql = "SELECT * FROM BOOK WHERE MID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()){
				
				b.setBookingNum(rs.getInt("bookingNum"));
				b.setTime_seq(rs.getInt("time_seq"));
				b.setSeat_seq(rs.getInt("seat_seq"));
				b.setMid(rs.getString("mid"));
				b.setNmid(rs.getString("nmid"));
				b.setRegdate(rs.getString("regdate"));
				b.setCancelCheck(rs.getString("cancelCheck"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ��ȸ �� �����߻�");
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
		return b;
	}
	
	
	
	

	
	
	
	
//	public int deleteBook(Book b) { //���� ���  ?? cancel check�� �ؾߵǳ� 
//		Connection con;
//		PreparedStatement ps = null;
//		int af = 0;
//		String sql = "DELETE BOOK WHERE BOOKINGNUM=?";
//		con=getConn();
//		try {
//			ps=con.prepareStatement(sql);
//			ps.setInt(1, b.getBookingNum());
//			
//			af=ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("���Ż����� �����߻�");
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("�������� ����");
//				e.printStackTrace();
//			}
//		}
//		
//		return af;
//	}
	
	
	

	
	



}
