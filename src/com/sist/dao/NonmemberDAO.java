package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.NonMember;

public class NonmemberDAO {
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
	
	//비회원전체조회
	public ArrayList<NonMember> gNonmember() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<NonMember> nonList = null;
		String sql = "SELECT * FROM NONMEMBER";
		con=getConn();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			nonList = new ArrayList<NonMember>();
			while(rs.next()) {
				NonMember non = new NonMember();
				non.setNmid(rs.getString("nmid"));
				non.setName(rs.getString("name"));
				non.setPhone(rs.getString("phone"));
				non.setGender(rs.getString("gender"));
				non.setBirthday(rs.getString("birthday"));
				non.setPwd(rs.getString("pwd"));
				nonList.add(non);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("비회원 전체 조회 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nonList;
	}
	
	//비회원 정보 조회
	public NonMember getNonMember(String nmid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		NonMember non = null;
		String sql = "SELECT * FROM NONMEMBER WHERE NMID=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, nmid);
			rs=ps.executeQuery();
			if(rs.next()) {
				non = new NonMember();
				non.setNmid(rs.getString("nmid"));
				non.setName(rs.getString("name"));
				non.setPhone(rs.getString("phone"));
				non.setGender(rs.getString("gender"));
				non.setBirthday(rs.getString("birthday"));
				non.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("비회원 정보 조회 중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return non;
	}
	
	//비회원 정보 추가
	public int addNonMember(NonMember non) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "INSERT INTO NONMEMBER VALUES ((SELECT NVL(MAX(TO_NUMBER(NMID)),0)+1 FROM NONMEMBER), ?, ?, ?, ?, ?)";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, non.getName());
			ps.setString(2, non.getName());
			ps.setString(3, non.getPhone());
			ps.setString(4, non.getGender());
			ps.setString(5, non.getBirthday());
			ps.setString(6, non.getPwd());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("비회원 정보 추가 중 오류 발생");
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
