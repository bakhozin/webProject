package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.Review;

public class ReviewDAO {
	
	public Connection getConn() {
			
			String url = "jdbc:oracle:thin:@211.238.142.126:1521:orcl";
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
	
	public int addReview(Review r, String mid) { //�����߰� 
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		System.out.println(mid);
		
		
		String sql = "INSERT INTO REVIEW (REVIEW_SEQ, MID, CONTENT, TITLE, REPLY, GPA, STAR, MCODE) VALUES ((SELECT NVL(MAX(TO_NUMBER(REVIEW_SEQ)),0)+1 FROM REVIEW), ?, ?, ?, ?, ?, ?, ?)";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, r.getContent());
			ps.setString(3, r.getTitle());
			ps.setString(4, r.getReply());
			ps.setDouble(5, r.getGPA());
			ps.setString(6, r.getStar());
			ps.setString(7, r.getMcode());		
			
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
	
	public Review getReview(String mid) {  //���� �ۼ��� ������ȸ? 
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Review r = null;

		
		String sql = "SELECT * FROM REVIEW WHERE MID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()){
				
				r.setReview_seq(rs.getInt("REVIEW_SEQ"));
				r.setTitle(rs.getString("title"));
				r.setMid(rs.getString("mid"));
				r.setContent(rs.getString("content"));
				r.setReply(rs.getString("reply"));
				r.setGPA(rs.getDouble("gpa"));
				r.setStar(rs.getString("star"));
				r.setMcode(rs.getString("mcode"));
				
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
		return r;
	}

	public Review getReview(int review_seq) { //���� ������? 
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Review r = null;
		String sql = "SELECT * FROM REVIEW WHERE REVIEW_SEQ=? ORDER BY TO_NUMBER(REVIEW_SEQ) DESC";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, review_seq);
			rs=ps.executeQuery();
			if(rs.next()){
				
				r.setReview_seq(rs.getInt("REVIEW_SEQ"));
				r.setTitle(rs.getString("title"));
				r.setMid(rs.getString("mid"));
				r.setContent(rs.getString("content"));
				r.setReply(rs.getString("reply"));
				r.setGPA(rs.getDouble("gpa"));
				r.setStar(rs.getString("star"));
				r.setMcode(rs.getString("mcode"));
				
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
		return r;
	}
	
	
	public int updateReview(Review r) { // �������
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "UPDATE REVIEW SET TITLE=?, CONTENT=?, REPLY=?, GPA=?, STAR=?, MCODE=? GET WHERE REVIEW_SEQ=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, r.getTitle());
			ps.setString(2, r.getContent());
			ps.setString(3, r.getReply());
			ps.setDouble(4, r.getGPA());
			ps.setString(5, r.getStar());
			ps.setString(6, r.getMcode());	
			ps.setInt(7, r.getReview_seq());	

			
			af = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ���� �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���ӽ���");
				e.printStackTrace();
			}
		}
		return af;
		
	}
	
	public int deleteNotice(Review r) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "DELETE REVIEW WHERE REVIEW_SEQ=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, r.getReview_seq());
			
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ������ �����߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return af;
	}
	
	public ArrayList<Review> allReview(int pg, String field, String query) {
		Connection con;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Review> rList = null;
		int startRN = 1 + (pg-1)*10;
		
		
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM REVIEW WHERE "+field+" LIKE ? ORDER BY TO_NUMBER(REVIEW_SEQ) DESC)N) WHERE RN BETWEEN ? AND ?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			//1. ���������� ���� �Խñ� �� ���� (ex.10)-> 2. ����¡�� ���̴� ������ ���� ����(ex.5)
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, startRN);
			ps.setInt(3, startRN+10);
			rs=ps.executeQuery();
			
			
			rList = new ArrayList<>();
			while(rs.next()) {
				Review r = new Review();
				r.setReview_seq(rs.getInt("REVIEW_SEQ"));
				r.setTitle(rs.getString("title"));
				r.setMid(rs.getString("mid"));
				r.setContent(rs.getString("content"));
				r.setReply(rs.getString("reply"));
				r.setGPA(rs.getDouble("gpa"));
				r.setStar(rs.getString("star"));
				r.setMcode(rs.getString("mcode"));
				
				rList.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ��ȸ �� �����߻�");
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
		return rList;
	}
	
	
	


}
