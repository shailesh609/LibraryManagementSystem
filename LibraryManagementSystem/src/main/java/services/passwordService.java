package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.google.gson.Gson;

import model.Password;



@Path("/password")
public class passwordService {
	
	class forgotPassword{
		 String password;
	       int Status;
	       
	     public  forgotPassword(String password,int Status){
	    	   this.password=password;
	    	   this.Status=Status;
	       }
	}
	class changePassword{
		 String password;
	       int Status;
	       
	     public  changePassword(String password,int Status){
	    	   this.password=password;
	    	   this.Status=Status;
	       }
	}
	
	
	//http://localhost:9090/LibraryManagementSystem/myApp/password/forgotPassword
		@POST
		@Path("/forgotPassword")
		@Consumes("application/json")
		public Response createProductInJSON(String myData) {
			
			Gson gson = new Gson();
			 forgotPassword res = null;
			String jsonResponse = "";
			
			try {
				JSONObject jo = new JSONObject(myData);	
				
				String mNumber = jo.getString("mNumber");
				String Email = jo.getString("Email");
				String passWord = jo.getString("password");
				
				// Check if user exits
				Password user =Password.forgotPassword(Email,passWord,mNumber);
				
				if(user!=null) {
					res = new  forgotPassword("Password Changed", 1);
				}else {
					res = new  forgotPassword("Password change request Fail", -1);
				}
			} catch (Exception e) {
				res = new  forgotPassword("Enter valid email", -1);
				System.out.print(e);
			}
			
			jsonResponse = gson.toJson(res,forgotPassword.class);
			return Response.status(200).entity(jsonResponse).build();	
		}
			
		
		//http://localhost:9090/LibraryManagementSystem/myApp/password/changePassword
			@POST
			@Path("/changePassword")
			@Consumes("application/json")
			public Response createResponseInJSON(String myData) {
				
				Gson gson = new Gson();
				changePassword res = null;
				String jsonResponse = "";
				
				try {
					JSONObject jo = new JSONObject(myData);	
					
					String UserId = jo.getString("userId");
					String oldPassword = jo.getString("currentPassword");
					String passWord = jo.getString("password");
					
					// Check if user exits
					Password user =Password.changePassword(UserId,passWord,oldPassword);
					
					if(user!=null) {
						res = new changePassword("Password Changed", 1);
					}else {
						res = new changePassword("Password change request Fail", -1);
					}
				} catch (Exception e) {
					res = new changePassword("Enter valid email", -1);
					System.out.print(e);
				}
				
				jsonResponse = gson.toJson(res,changePassword.class);
				return Response.status(200).entity(jsonResponse).build();	
			
			
		}
	
	
	

}
