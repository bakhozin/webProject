package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.sist.vo.Card;
import com.sist.vo.Giftycon;

@Component
public class CardDAO {
	
	public Connection getConn(){

		String url = "jdbc:oracle:thin:@211.238.142.126:1521:orcl";
		String user = "CHARLIE";
		String pwd = "111111";

		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ӽ���, ������� ��й�ȣ�� Ȯ���ϼ���");
			e.printStackTrace();
		}

		return con;
	}

	//������ ī�� ���
	public int addCard(Card card){
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		con = getConn();
		String sql = "INSERT INTO CARD(CARDNUM,MID,PWD) VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, card.getCardNum());
			ps.setString(2, card.getMid());
			ps.setString(3, card.getPwd());
			
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
	
	//�ش��ȣ�� ��ϵǾ��ִ� ī�� ����
	public Card getCard(String cardNum){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConn();
		
		Card card = null;
		
		String sql = "SELECT * FROM CARD WHERE CARDNUM = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cardNum);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				card = new Card();
				card.setCardNum(rs.getString("cardnum"));
				card.setMid(rs.getString("mid"));
				card.setPwd(rs.getString("pwd"));
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
		
		return card;		
	}

}
