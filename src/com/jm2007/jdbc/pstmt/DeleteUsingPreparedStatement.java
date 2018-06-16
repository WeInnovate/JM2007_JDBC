package com.jm2007.jdbc.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUsingPreparedStatement {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");) {
			// JDBC Code
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM JDBC_TBL WHERE ID = ?");

			Scanner scan = new Scanner(System.in);
			String userChoice = "Y";
			while (userChoice.equalsIgnoreCase("Y")) {
				System.out.println("Please enter the data.");

				System.out.print("ID:");
				int id = Integer.parseInt(scan.nextLine());

				// JDBC Code
				pstmt.setInt(1, id);

				int i = pstmt.executeUpdate();
				if (i > 0) {
					System.out.println("Record DELETED successfully using PreparedStatement!");
				}

				System.out.print("Do you wish to continue?(Y/N): ");
				userChoice = scan.nextLine();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}