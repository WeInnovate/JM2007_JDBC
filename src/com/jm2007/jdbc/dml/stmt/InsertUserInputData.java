package com.jm2007.jdbc.dml.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUserInputData {

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
				// int id = scan.nextInt();

				System.out.print("Name:");
				String name = scan.nextLine();

				System.out.print("%:");
				double percentage = Double.parseDouble(scan.nextLine());
				// double percentage = scan.nextDouble();

				int i = stmt
						.executeUpdate("INSERT INTO JDBC_TBL VALUES(" + id + ", '" + name + "', " + percentage + ")");
				if (i > 0) {
					System.out.println("Record inserted successfully");
				}

				System.out.print("Do you wish to continue?(Y/N): ");
				userChoice = scan.nextLine();
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
