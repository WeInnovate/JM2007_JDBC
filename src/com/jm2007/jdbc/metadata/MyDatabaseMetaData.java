package com.jm2007.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDatabaseMetaData {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Product Version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());

			ResultSet rs = dbmd.getTables(null, null, "%_TBL", null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
			
			System.out.println("URL: "+ dbmd.getURL());
			System.out.println("User Name: "+ dbmd.getUserName());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
