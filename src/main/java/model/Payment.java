package model;

import java.sql.*;

public class Payment {
	
	//connection
	private Connection connect() { 
		 
		Connection con = null; 
 
		try { 

			Class.forName("com.mysql.jdbc.Driver"); 
 
 
			//Provide the correct details: DBServer/DBName, username, password 
 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/items", "root", "15263"); 
			System.out.println("----Connection Succsuss !----");
		} 
 
		catch (Exception e) {
			e.printStackTrace();} 
		System.err.println("----Connection Error !----");
			return con; 
		
		} 
	
	//Payment
	public String PaymentAdd(String Name, String CardNo, String HlderName, String CVV, String Exdate) { 
		 
		String output = ""; 
 
		try { 
 
			Connection con = connect(); 
 
			if (con == null) {
				
				return "Error while connecting to the database for inserting."; 
			
			} 
 
				// create a prepared statement
 
				String query = " insert into payment (`id`,`Name`,`CardNo`,`HlderName`,`CVV`,`Exdate`)" + " values (?, ?, ?, ?, ?, ?)"; 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
 
				// binding values
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, Name); 
				preparedStmt.setString(3, CardNo); 
				preparedStmt.setString(4, HlderName); 
				preparedStmt.setString(5, CVV); 
				preparedStmt.setString(6, Exdate);
				
				// execute the statement
				preparedStmt.execute(); 
				con.close();
 
				output = "Inserted successfully"; 
 
		} 
 
		catch (Exception e) {
 
			output = "Error while inserting the item."; 
 
			System.err.println(e.getMessage());
			System.err.println("----- Insert Error ! -----");
 
		} 
 
		return output; 
 
	} 
	
	//View Payments
	public String readPayment() { 
		 
		String output = ""; 
 
		try { 
 
			Connection con = connect(); 
 
			if (con == null) {
				
				System.err.println("----- Connection Error for Read ! -----");
				return "Error while connecting to the database for reading."; 
			
			} 
 
			// Prepare the html table to be displayed
			output = "<table class='table table-hover MeeterReadTable'><tr class ='Tabletr'><th>Payment ID</th><th>Name</th><th>Card Number</th>" + "<th>Holder Name</th>" + "<th>CVV</th><th>Ex Date</th>" + "<th>Update</th><th>Remove</th></tr>"; 
 
			String query = "select * from payment"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
 
			// iterate through the rows in the result set
 
			while (rs.next()) { 
				String id = Integer.toString(rs.getInt("id")); 
				String Name = rs.getString("Name"); 
				String CardNo = rs.getString("CardNo"); 
				String HlderName = rs.getString("HlderName"); 
				String CVV = rs.getString("CVV");
				String Exdate = rs.getString("Exdate"); 
 
				// Add into the html table
				output += "<tr><td>" + id + "</td>"; 
				output += "<td>" + Name + "</td>"; 
				output += "<td>" + CardNo + "</td>"; 
				output += "<td>" + HlderName + "</td>"; 
				output += "<td>" + CVV + "</td>"; 
				output += "<td>" + Exdate + "</td>";
 
				// buttons
				output += "<td><input name='btnUpdate' id='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>" + "<td><input name='btnRemovee' id='btnRemovee' type='button' value='Remove' class='btnRemovee btn btn-danger'></td></tr>"; 
			} 
			con.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the Payment."; 
			System.err.println(e.getMessage()); 
			System.err.println("----- Error for Read ! -----");
		} 
		return output; 
	} 
	
	//update Payment
	public String updatePayment(String Name, String CardNo, String HlderName, String CVV, String Exdate) { 
		 
		String output = ""; 
 
		try
 
		{ 
 
			Connection con = connect(); 
 
			if (con == null) {
				
				return "Error while connecting to the database for updating."; 
			
			} 
 
			// create a prepared statement
 
			String query = "UPDATE payment SET Name=?,HlderName=?,CVV=?,Exdate=? WHERE CardNo=?"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
 
			// binding values
 
			preparedStmt.setString(1, Name); 
			preparedStmt.setString(2, HlderName); 
			preparedStmt.setString(3, CVV);
			preparedStmt.setString(4, Exdate);
			preparedStmt.setString(5, CardNo); 
 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Updated successfully"; 
 
		} 
 
		catch (Exception e) { 
 
			output = "Error while updating the item."; 
 
			System.err.println(e.getMessage()); 
 
		} 
 
		return output; 
 
	} 
	
	public String deletePayment(String ID) { 
		 
		String output = ""; 
 
		try { 
 
			Connection con = connect(); 
 
			if (con == null) {
				
				return "Error while connecting to the database for deleting."; 
			
			} 
 
			// create a prepared statement
			String query = "delete from Payment where id=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID)); 
 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Deleted successfully"; 
 
		} 
 
		catch (Exception e) { 
 
			output = "Error while deleting the item."; 
 
			System.err.println(e.getMessage()); 
 
		} 
 
		return output; 
 
	} 
}
