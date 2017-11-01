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
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속 실패, 계정명과 비밀번호 확인");
			e.printStackTrace();
		}
		return con;
	}
	
	//회원 전체 조회
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
			System.out.println("전체 회원 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	//회원 정보 조회
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
			System.out.println("회원 정보 조회 중 오류 발생");
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
		return m;
	}
	//회원 추가
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
			System.out.println("회원 추가 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return af;
	}
	//회원 정보 수정
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
			System.out.println("회원 정보 수정 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return af;
	}
	//회원 탈퇴
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
			System.out.println("회원 탈퇴 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return af;
	}
}
