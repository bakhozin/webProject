package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.Member;

public class MemberDAO {

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
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ����, ������� ��й�ȣ Ȯ��");
			e.printStackTrace();
		}
		return con;
	}
	
	//ȸ�� ��ü ��ȸ
	public ArrayList<Member> gMember() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> mList = null;
		String sql = "SELECT * FROM MEMBER";
		con=getConn();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			mList= new ArrayList<Member>();
			while(rs.next()) {
				Member m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ü ȸ�� �� ���� �߻�");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	//ȸ�� ���� ��ȸ
	public Member getMember(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "SELECT * FROM MEMBER WHERE MID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPhone(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ȸ�� ���� ��ȸ �� ���� �߻�");
			e.printStackTrace();
		}finally {
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
	//ȸ�� �߰�
	public int addMember(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?)";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getGender());
			ps.setString(6, m.getBirthday());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ȸ�� �߰� �� ���� �߻�");
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
	//ȸ�� ���� ����
	public int updateMember(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "UPDATE MEMBER SET PWD=?, PHONE=? WHERE MID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setString(2, m.getPhone());
			ps.setString(3, m.getMid());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ȸ�� ���� ���� �� ���� �߻�");
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
	//ȸ�� Ż��
	public int delMember(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "DELETE MEMBER WHERE MID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ȸ�� Ż�� �� ���� �߻�");
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
}
