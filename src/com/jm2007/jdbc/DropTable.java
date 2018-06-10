package com.jm2007.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			boolean bool = stmt.execute("DROP TABLE JDBC_TBL");
			if(bool == false) {
				System.out.println("Table dropped successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
