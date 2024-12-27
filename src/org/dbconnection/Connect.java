package org.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","sindhuSQL");
		    String s = "select * from employees";
		    PreparedStatement st = cn.prepareStatement(s);
		    ResultSet result = st.executeQuery();
		    
		    while (result.next()) {
		    	String name = result.getString("first_name");
		    	System.out.println(name);
		    	int sal = result.getInt("salary");
		    	System.out.println(sal);
		    }
		    
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
