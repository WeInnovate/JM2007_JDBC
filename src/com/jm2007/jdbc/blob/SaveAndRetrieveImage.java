package com.jm2007.jdbc.blob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveAndRetrieveImage {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
			// save
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO JDBC_PROFILE_TBL VALUES(?, ?)");

			FileInputStream fin = new FileInputStream("images//java-input.png");

			pstmt.setString(1, "Java Input");
			pstmt.setBinaryStream(2, fin, fin.available());

			 int i = pstmt.executeUpdate();
			
			 if (i > 0) {
			 System.out.println("Image inserted successfully!");
			 }

			// retrieve
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IMAGE FROM JDBC_PROFILE_TBL WHERE NAME = 'Java Input'");
			rs.next();
			Blob blob = rs.getBlob(1);
			byte[] byteArr = blob.getBytes(1, (int) blob.length());

			FileOutputStream fos = new FileOutputStream("images/java-output.png");
			fos.write(byteArr);
			fos.close();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
