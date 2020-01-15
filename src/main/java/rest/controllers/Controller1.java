package rest.controllers;

import java.sql.*;
import java.util.ArrayList;

import javax.ws.rs.QueryParam;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;
import rest.dao.DAO;
import rest.dao.vehiculosDAO;
import rest.models.*;

@RestController
/*@RequestMapping("/SpringBoot_Basics-1")*/

public class Controller1 {
	private static ArrayList<Auto> list = new ArrayList<>();

	@PostMapping ("/vehiculosListadoBusquedaExactaPOST")
	public ArrayList<Auto> vehiculosListado3BusquedaExactaPOST(@ModelAttribute("marca") String marca) {
		
		/*ArrayList<Auto> list = new ArrayList<>();*/
		ArrayList<Auto> listResponse = new ArrayList<>();
		
		/* Autos - Datos */	
		vehiculosDAO objvehiculosDAO = new vehiculosDAO();
		ArrayList<Auto> list = objvehiculosDAO.vehiculosRetrieve();	
	    
	    /* Autos - busqueda por marca */
	    int iIndex=0;
	    boolean ffound=false;
	    
	    while (!ffound && iIndex<list.size())
	    {
	    	if (marca.equalsIgnoreCase(list.get(iIndex).getMarca()))
	    	{
	    		Auto auto = new Auto();	
	    		auto.setMarca(list.get(iIndex).getMarca());
	    		auto.setColor(list.get(iIndex).getColor());
	    		ffound=true;
	    		listResponse.add(auto);	
	    	}
	    	
	    	/* Autos - next */
	    	iIndex++;
	    }
    
	    return listResponse;
	}
	
	@GetMapping ("/vehiculosListadoBusquedaParcial")
	public ArrayList<Auto> vehiculosListadoBusquedaParcial(@QueryParam("q") String q) {
		/*ArrayList<Auto> list = new ArrayList<>();*/
		ArrayList<Auto> listResponse = new ArrayList<>();
		
		/* Autos - Datos */	
		vehiculosDAO objvehiculosDAO = new vehiculosDAO();
		ArrayList<Auto> list = objvehiculosDAO.vehiculosRetrieve();
	    
	    /* Autos - busqueda por marca */
	    int iIndex=0;
	    
	    while (iIndex<list.size())
	    {
	    	if (list.get(iIndex).getMarca().indexOf(q)>=0)
	    	{
	    		Auto auto = new Auto();	
	    		
	    		auto.setMarca(list.get(iIndex).getMarca());
	    		auto.setColor(list.get(iIndex).getColor());
	    		listResponse.add(auto);	
	    	}
	    	
	    	/* Autos - next */
	    	iIndex++;
	    }
    
	    return listResponse;
	}
	
	@GetMapping ("/vehiculosListadoBusquedaExacta/{marca}")
	public ArrayList<Auto> vehiculosListado3BusquedaExacta(@PathVariable("marca") String marca) {
		/*ArrayList<Auto> list = new ArrayList<>();*/
		ArrayList<Auto> listResponse = new ArrayList<>();  
		
		/* Autos - Datos */	
		vehiculosDAO objvehiculosDAO = new vehiculosDAO();
		ArrayList<Auto> list = objvehiculosDAO.vehiculosRetrieve();
	    
	    /* Autos - busqueda por marca */
	    int iIndex=0;
	    boolean ffound=false;
	    
	    while (!ffound && iIndex<list.size())
	    {
	    	if (marca.equalsIgnoreCase(list.get(iIndex).getMarca()))
	    	{
	    		Auto auto = new Auto();	
	    		auto.setMarca(list.get(iIndex).getMarca());
	    		auto.setColor(list.get(iIndex).getColor());
	    		ffound=true;
	    		listResponse.add(auto);	
	    	}
	    	
	    	/* Autos - next */
	    	iIndex++;
	    }
    
	    return listResponse;
	}
	
	@GetMapping ("/vehiculosListado2")
	public ArrayList<Auto> vehiculosListado2() {
		ArrayList<Auto> list = new ArrayList<>();
	     
	    for (int ivalue=0;ivalue<=20;ivalue++)
    	{ 
	    	Auto auto = new Auto();		    	
		    auto.setMarca("Citroen " + (int)ivalue);
	    	auto.setColor("Rojo " + (int)ivalue);	    	
	    	list.add(auto);	    	
    	}
	    
	    return list;
	}
	
    @GetMapping("/vehiculosListado")
    public ArrayList<JSONObject> vehiculosListado() {   
    	ArrayList<JSONObject> list = new ArrayList<JSONObject>();
				
    	for (int ivalue=0;ivalue<=20;ivalue++)
    	{
    		
    		JSONObject objJSON = new JSONObject();
    		objJSON.put("Marca", "Ford");
    		objJSON.put("Color", "Rojo");
    		list.add(objJSON);
     	}
    	
    	return list;        
      }
    
    @GetMapping("/helloWorld")
    public String helloworld() {   
    	DAO objDAO = new DAO();
		Connection conn = null;
		String tStr="";
		
		try {
			conn = objDAO.setDBConnection();
			/*System.out.println(conn.getCatalog());*/
			conn.close();
			tStr="Hello world";
			
		} catch (Exception e) {
			System.out.println("Error connection: " + e.getMessage());				
		}
		return tStr;
      }
}