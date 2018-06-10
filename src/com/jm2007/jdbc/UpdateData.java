package com.jm2007.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("UPDATE JDBC_TBL SET PERCENTAGE = 60.10 WHERE ID = 1001");
			if (i > 0) {
				System.out.println("Record updated successfully");
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
