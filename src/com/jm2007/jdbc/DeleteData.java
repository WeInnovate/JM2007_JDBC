package com.jm2007.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM JDBC_TBL WHERE ID = 1002");
			if (i > 0) {
				System.out.println("Record DELETED successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
	if(con != null) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		}
	}

}
