package ccc.hut.c2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection con;
	
	public static Connection getConn(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookmanager?characterEncoding=UTF-8",
                    "root", "admin");
			return con;
		}
		catch(ClassNotFoundException e)
		{

			e.printStackTrace();
			return null;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConn(){
		try{
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
