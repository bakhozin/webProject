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
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ����, ������� ��й�ȣ Ȯ��");
			e.printStackTrace();
		}
		return con;
	}
	
	//�󿵰��� ��ȭ�� ���� ��ȭ�ð�ǥ
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
			System.out.println("��ȭ�ð�ǥ ��ȸ �� ���� �߻�");
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
		return tt;
	}
}
