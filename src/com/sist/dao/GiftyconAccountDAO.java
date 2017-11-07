package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.sist.vo.Giftycon;
import com.sist.vo.GiftyconAccount;

@Component
public class GiftyconAccountDAO {
	
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
	
	//기프티콘 구매시 거래내역 추가
	public int addShopAccount(GiftyconAccount shopAccount){
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		con = getConn();
		String sql = "INSERT INTO GIFTYCONACCOUNT(G_DEALNUM, GIFTYCONCODE, MID, RECIPIENT) VALUES((select to_number(nvl2((max(to_number(G_DEALNUM))),max(to_number(G_DEALNUM))+1, 1)) from GIFTYCONACCOUNT),?,?,(select mid from member where phone=?))";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, shopAccount.getGiftyconCode());
			ps.setString(2, shopAccount.getMid());
			ps.setString(3, shopAccount.getRecipient());
			
			af = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return af;
	}
	
	//해당 회원의 거래내역 리턴
	public ArrayList<GiftyconAccount> getShopAccount(String mid){
		
		ArrayList<GiftyconAccount> list = new ArrayList<GiftyconAccount>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();

		String sql = "SELECT * FROM GIFTYCONACCOUNT WHERE MID = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				GiftyconAccount shopAccount = new GiftyconAccount();
				
				shopAccount.setGiftyconCode(rs.getString("giftyconCode"));
				shopAccount.setMid(rs.getString("mid"));
				shopAccount.setRecipient(rs.getString("recipient"));
				shopAccount.setG_dealNum(rs.getInt("G_dealnum"));
				shopAccount.setRegdate(rs.getString("regdate"));
				shopAccount.setExpireDate(rs.getString("expireDate"));
				
				list.add(shopAccount);
				
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
