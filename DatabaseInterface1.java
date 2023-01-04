package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInterface1 {
	private static Connection con;
	
	public static void DbConnect() 
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranay", 
									"root", "");			
		
	}
	
	public static void DbDisconnect() 
			throws SQLException {
		con.close();
	}
	
	public static String getAll() throws SQLException {
		String query = "select * from pranay";
		
		Statement stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery(query);
		
		String output = "";
		output += "\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------\n";
		output += "|ID\t|Name\t\t|Roll Number\t|City\n";
		output += "---------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		while(rs.next()) {
			output += "|" + rs.getInt("ID") + 
					"\t|" + rs.getString(2) + 
					
					"\t\t|" + rs.getInt(3) + 
					
					"\t\t|" + rs.getString(4) + "\t\n";
					
		}
		output += "---------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		return output;
	}

	public static String getById(int id) throws SQLException {
		String query = "select * from pranay where ID=?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			output += "\n\n---------------------------------------------------------------------------------------------------------\n";
			output += "|ID\t|Name\t\t|Roll Number\t|City\n";
			output += "------------------------------------------------------------------------------------------------------\n";
			
			
			output += "|" + rs.getInt("ID") + 
						"\t|" + rs.getString(2) + 
						
						"\t\t|" + rs.getInt(3) + 
						
						"\t\t|" + rs.getString(4) + "\t\n";
						
			
			output += "----------------------------------------------------------------------------------------------\n";
		}		
		else
			output += "\n\n **** No Record Found **** \n\n";
		
		return output;
	}

	public static String add(int id, String sname,int rn, String city) 
				throws SQLException {
		String query = "insert into pranay values(?,?,?,?)";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id); 
		ps.setString(2, sname);
		ps.setInt(3, rn);
		ps.setString(4, city);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Insert Successful";
		else
			output += "Insertion Failed";
		
		return output;
	}

	public static String delete(int id) throws SQLException {
		String query = "delete from pranay where ID = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Delete Successful";
		else 
			output += "Delete Failed";
		
		return output;
	}

	public static String updateName(int id, String sname) throws SQLException {
		String query = "update pranay set Name = ? where ID = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, sname);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}

	public static String updateroll(int id, int rn) throws SQLException {
		String query = "update pranay set Roll_Number = ? where ID = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, rn);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}
	
	public static String updatecity(int id, String city) throws SQLException {
		String query = "update pranay set City = ? where ID = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, city);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}

	
	
	

	

	
}
