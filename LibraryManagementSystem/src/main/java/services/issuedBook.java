package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;

import model.Books;

@Path("/issuedbook")
public class issuedBook {
	//http://localhost:9090/LibraryManagementSystem/myApp/issuedbook/getInfo/userId
			@GET
			@Path("/getInfo/{userId}")
			@Produces(MediaType.APPLICATION_JSON)
			public String getTrackInJSON(@PathParam("userId") String userId) {
					
				JSONObject jo = new JSONObject();
				JSONArray array= Books.getIssuedbook(userId);
			
				try {
				jo.put("data"  ,  array);
				}catch(Exception e) {System.out.println(e);}
				
				return jo.toString();
			}

}
