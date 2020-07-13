package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import model.*;


@Path("/signup")
public class signupService {
	
     class	signupResponse{
	      String Signup;
	       int Status;
	
	    public signupResponse(String Signup,int Status){
	      	this.Signup=Signup;
	     	this.Status=Status;
       	}
     }
	    class	updateResponse{
		      String update;
		       int Status;
		
		    public updateResponse(String update,int Status){
		      	this.update=update;
		     	this.Status=Status;
	       	}
	
 }
	
	//http://localhost:9090/LibraryManagementSystem/myApp/signup/userSignup
	@POST
	@Path("/userSignup")
	@Consumes("application/json")
	public Response createProductInJSON(String myData) {
		
		Gson gson = new Gson();
		signupResponse res = null;
		String jsonResponse = "";
		
		try {
			JSONObject jo = new JSONObject(myData);	
			String Name = jo.getString("userName");
			String mNumber = jo.getString("mNumber");
			String Email = jo.getString("Email");
			String passWord = jo.getString("password");
			
			// Check if user exits
			signupUser user = signupUser.userSignup(Name,Email,passWord,mNumber);
			
			if(user==null) {
				res = new signupResponse("Registration Success", 1);
			}else {
				res = new signupResponse("Registration Fail", -1);
			}
		} catch (Exception e) {
			res = new signupResponse("Id not define", -1);
			System.out.print(e);
		}
		
		jsonResponse = gson.toJson(res, signupResponse.class);
		return Response.status(200).entity(jsonResponse).build();	
	}
	
	//http://localhost:9090/LibraryManagementSystem/myApp/signup/userUpdate
	@POST
	@Path("/userUpdate")
	@Consumes("application/json")
	public Response createReponseInJSON(String myData) {
		
		Gson gson = new Gson();
		updateResponse res = null;
		String jsonResponse = "";
		
		try {
			JSONObject jo = new JSONObject(myData);	
			String Name = jo.getString("userName");
			String mNumber = jo.getString("mNumber");
			String Email = jo.getString("Email");
		
			
			
			// Check if user exits
			String user = signupUser.userUpdate(Name,Email,mNumber);
			
			if(user!=null) {
				res = new updateResponse("Updation Success", 1);
			}else {
				res = new updateResponse("Updation Fail", -1);
			}
		} catch (Exception e) {
			res = new updateResponse("Id not define", -1);
			System.out.print(e);
		}
		
		jsonResponse = gson.toJson(res, updateResponse.class);
		return Response.status(200).entity(jsonResponse).build();	
	}
	

}


