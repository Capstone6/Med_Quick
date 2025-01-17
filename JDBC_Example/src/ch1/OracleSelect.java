package ch1;

import java.sql.*;


public class OracleSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##sahmyook";
		String password = "1111";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM dept";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("deptno")+" ");
				System.out.println(rs.getString("dname")+ " ");
				System.out.println(rs.getString("loc")+ " ");
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("oracle connection fail.");
			e.printStackTrace();
		}
	}
}
