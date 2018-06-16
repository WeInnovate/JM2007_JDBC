package com.jm2007.jdbc.dml.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("INSERT INTO JDBC_TBL VALUES(1002, 'Sehbag', 80.18)");
			if (i > 0) {
				System.out.println("Record inserted successfully");
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
