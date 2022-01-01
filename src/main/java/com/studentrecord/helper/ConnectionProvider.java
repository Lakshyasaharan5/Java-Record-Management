package com.studentrecord.helper;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionProvider {
	
	private static Connection con;
	
	public static Connection getConnection() throws IOException {
		try {
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				


				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/J", "root", "chandan1997");
				
			}
        } catch (Exception e) {
            e.printStackTrace();
        }

		return con;
	}
	
	public static ArrayList<String> getName() {
		
		ArrayList<String> names = new ArrayList<String>(10);
		try {
			
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/J", "root", "chandan1997");
            Statement st = con.createStatement();
//            String query = "insert into student value (?,?)";
//            String deleteQuery = "DELETE FROM student WHERE name = ? or name = ?";
//            PreparedStatement pstm = con.prepareStatement(deleteQuery);
//            pstm.setInt(1, 10);
//            pstm.setInt(2, 11);
//            pstm.execute();
//            String query = "delete from student where course='oh yeah'";
//            st.execute(query);
            ResultSet resultSet = st.executeQuery("select * from student");
            
            while (resultSet.next()) {
                names.add(resultSet.getString("course"));
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

		
		return names;
	}
}
