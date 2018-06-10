package com.jm2007.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {

	public static void main(String[] args) {
		System.out.println("Hello");
		Connection con = null;
		try {
			// connect to the db
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// create command
			Statement stmt = con.createStatement();

			// execute command
			ResultSet rs = stmt.executeQuery("SELECT * FROM JDBC_TBL");

			// process result
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double percentage = rs.getDouble(3);
				System.out.println(id + " " + name + " " + percentage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
