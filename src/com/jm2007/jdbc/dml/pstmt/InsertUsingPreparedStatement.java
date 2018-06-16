package com.jm2007.jdbc.dml.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPreparedStatement {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");) {
			// JDBC Code
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO JDBC_TBL VALUES(?, ?, ?)");

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

				// JDBC Code
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setDouble(3, percentage);

				int i = pstmt.executeUpdate();
				if (i > 0) {
					System.out.println("Record inserted successfully using PreparedStatement!");
				}

				System.out.print("Do you wish to continue?(Y/N): ");
				userChoice = scan.nextLine();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}