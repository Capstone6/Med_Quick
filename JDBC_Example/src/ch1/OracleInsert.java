package ch1;

import java.sql.*;

public class OracleInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##sahmyook";
		String password = "1111";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String sql3 = "SELECT MAX(deptno) FROM dept";
			ResultSet rs = stmt.executeQuery(sql3);

			rs.next();
			int iDeptno = rs.getInt("MAX(deptno)");
			System.out.println(iDeptno);

			String ideptno = "50", sdname = "IT", sloc = "Seoul";
			String sql = "INSERT INTO dept VALUES ('" + (iDeptno + 10) + "','" + sdname + "','" + sloc + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.");
			} else {
				System.out.println("Insert fail.");
			}

			// String sql = "SELECT * FROM dept";
			String sql2 = "SELECT deptno,dname,loc FROM dept";
			ResultSet rs1 = stmt.executeQuery(sql2);

			while (rs1.next()) {
				System.out.printf("%-10s %-10s %-10s\n", rs1.getString("deptno"), rs1.getString("dname"),
						rs1.getString("loc"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("oracle connection fail.");
			e.printStackTrace();
		}
	}
}
