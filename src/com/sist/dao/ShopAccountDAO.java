package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sist.vo.Giftycon;
import com.sist.vo.ShopAccount;

public class ShopAccountDAO {
	
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
	public int addShopAccount(ShopAccount shopAccount){
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		con = getConn();
		String sql = "INSERT INTO SHOPACCOUNT(S_DEALNUM, GIFTYCONCODE, MID, RECIPIENT, REGDATE, EXPIREDATE) VALUES((select to_number(nvl2((max(to_number(seq))),max(to_number(seq))+1, 1)) from SHOPACCOUNT),?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, shopAccount.getGiftyconCode());
			ps.setString(2, shopAccount.getMid());
			ps.setString(3, shopAccount.getRecipient());
			ps.setString(4, shopAccount.getRegdate());
			ps.setString(5, shopAccount.getExpireDate());
			
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
	public ArrayList<ShopAccount> getShopAccount(String mid){
		
		ArrayList<ShopAccount> list = new ArrayList<ShopAccount>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();

		String sql = "SELECT * FROM SHOPACCOUNT WHERE MID = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ShopAccount shopAccount = new ShopAccount();
				
				shopAccount.setGiftyconCode(rs.getString("giftyconCode"));
				shopAccount.setMid(rs.getString("mid"));
				shopAccount.setRecipient(rs.getString("recipient"));
				shopAccount.setS_dealNum(rs.getInt("S_dealnum"));
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
