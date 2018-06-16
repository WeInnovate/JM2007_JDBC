package com.jm2007.jdbc.dml.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUsingStatementAndBatch {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();

			Scanner scan = new Scanner(System.in);
			String userChoice = "Y";
			while (userChoice.equalsIgnoreCase("Y")) {
				System.out.println("Please enter the data.");

				System.out.print("ID:");
				int id = Integer.parseInt(scan.nextLine());

				System.out.print("Name:");
				String name = scan.nextLine();

				System.out.print("%:");
				double percentage = Double.parseDouble(scan.nextLine());

				stmt.addBatch("INSERT INTO JDBC_TBL VALUES(" + id + ", '" + name + "', " + percentage + ")");

				System.out.print("Do you wish to continue?(Y/N): ");
				userChoice = scan.nextLine();
			}

			int[] resultArr = stmt.executeBatch();
			System.out.println(resultArr.length + " recordes has been inserted.");
			for (int i = 0; i < resultArr.length; i++) {
				System.out.println(resultArr[i]);
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
