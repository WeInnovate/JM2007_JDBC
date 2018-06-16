package com.jm2007.jdbc.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			boolean bool = stmt.execute("CREATE TABLE JDBC_TBL(ID NUMBER, NAME VARCHAR, PERCENTAGE DECIMAL)");
			if(bool == false) {
				System.out.println("Table created successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
