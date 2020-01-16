package rest.dao;
import java.sql.*;

public class DAO {

	public Connection setDBConnection()
	{	
		Connection conn = null; 
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* dev */
			String connStr = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(connStr,"root","");
			/*System.out.println(conn.getCatalog());*/
			
		} catch (Exception e) {
	        System.out.println("Error connection: " + e.getMessage());			
		}		
		
		return conn;
	}
}
