package com.sist.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.sist.vo.Giftycon;


@Component
public class GiftyconDAO {

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

	//타입별 상품 리턴 (type: C-콤보  S-스낵  B-음료  M-영화관람권)
	public ArrayList<Giftycon> getGiftycons(String type){
		
		ArrayList<Giftycon> list = new ArrayList<Giftycon>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();

		String sql = "SELECT * FROM GIFTYCON WHERE GIFTYCONCODE LIKE ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+type+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Giftycon giftycon = new Giftycon();
				
				giftycon.setGiftyconCode(rs.getString("GIFTYCONCODE"));
				giftycon.setGiftyconName(rs.getString("GiftyconName"));
				giftycon.setContent(rs.getString("content"));
				giftycon.setPrice(rs.getInt("price"));
				giftycon.setImage(rs.getString("image"));
				
				list.add(giftycon);			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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

	//코드와 일치하는 상품 리턴
	public Giftycon getGiftycon(String giftyconCode){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		
		Giftycon giftycon = null;
		
		String sql = "SELECT * FROM GIFTYCON WHERE GIFTYCONCODE = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, giftyconCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				giftycon = new Giftycon();
				giftycon.setGiftyconCode(rs.getString("giftyconCode"));
				giftycon.setGiftyconName(rs.getString("GiftyconName"));
				giftycon.setContent(rs.getString("content"));
				giftycon.setPrice(rs.getInt("price"));
				giftycon.setImage(rs.getString("image"));
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
		return giftycon;
	}
}
