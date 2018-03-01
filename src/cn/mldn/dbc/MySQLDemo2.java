package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLDemo2 {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	private static final String DBUSER = "root";
	private static final String PASSWORD = "";
	public static void main(String[] args) throws Exception{
		Class.forName(DBDRIVER);
		Connection conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		int currentPage = 2;
		int lineSize = 10;
		String sql = "SELECT mid,name,age,birthday,note FROM member LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (currentPage-1)*lineSize);
		pstmt.setInt(2, lineSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+"、"+rs.getString(2));
		}
		conn.close();
	}
}
