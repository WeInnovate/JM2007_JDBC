package com.jm2007.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MyResultSetMetaData {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// connect to the db
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// create command
			Statement stmt = con.createStatement();

			// execute command
			ResultSet rs = stmt.executeQuery("SELECT * FROM JDBC_TBL");

			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("No. of Columns: " + rsmd.getColumnCount());
			System.out.print(rsmd.getColumnName(1) + "(" + rsmd.getColumnTypeName(1) + ")");
			System.out.print(" " + rsmd.getColumnName(2) + "(" + rsmd.getColumnTypeName(2) + ")");
			System.out.println(" " + rsmd.getColumnName(3) + "(" + rsmd.getColumnTypeName(3) + ")");

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
