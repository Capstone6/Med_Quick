package dao;

import java.sql.*;
import java.util.ArrayList;
import vo.MemberVo;

public class MemberDAO_Search {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##sahmyook";
	String password = "1111";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> list(String name) {

		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM emp ";
			if (name != null) {
				query += "where ename='" + name.toUpperCase() + "'";
			}
			System.out.println("SQL :" + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getROW() :" + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("Data Not Found");
			} else {
				System.out.println(rs.getRow() + " row selected.");
				rs.previous();
				while (rs.next()) {
					String empno = rs.getString("empno");
					String ename = rs.getString("ename");
					int sal = rs.getInt("sal");

					MemberVo data = new MemberVo(empno, ename, sal);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			//stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("stmt create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
