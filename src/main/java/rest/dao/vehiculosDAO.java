package rest.dao;

import java.sql.*;
import java.util.ArrayList;
import rest.models.Auto;

public class vehiculosDAO {
	public ArrayList<Auto> vehiculosRetrieve()
    {
		/* DB - connection */
		DAO objDAO = new DAO();
		Connection conn = objDAO.setDBConnection();
	
		/* DB - Vehiculos */
		ArrayList<Auto> list = new ArrayList<>();	
		
		try {			
			Statement statement = conn.createStatement();  
			ResultSet rsData = statement.executeQuery("select * from vehiculos");  
			
			while(rsData.next())  
			{
				Auto auto = new Auto();		
				auto.setMarca(rsData.getString("marca"));
				auto.setColor(rsData.getString("color"));
				
			    /*auto.setMarca("Ford " + (int)ivalue);
		    	auto.setColor("Negro " + (int)ivalue);	
		    	*/    	
		    	list.add(auto);	 
			}		
			
			conn.close();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
	      
		}
		return list;
	}	
}
