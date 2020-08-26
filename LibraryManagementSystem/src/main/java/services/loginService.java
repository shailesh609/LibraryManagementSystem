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

@Path("/login")
public class loginService {
	
	class LoginResponse {
		String userId;
		int Status;
		public LoginResponse(String userId, int Status) {
			this.userId = userId;
			this.Status = Status;
		}
	}
	
	
	//http://localhost:9090/LibraryManagementSystem/myApp/login/userlogin
	@POST
	@Path("/userlogin")
	@Consumes("application/json")
	public Response createProductInJSON(String myData) {
		
		Gson gson = new Gson();
		LoginResponse res = null;
		String jsonResponse = "";
		
		try {
			JSONObject jo = new JSONObject(myData);	
			String uName = jo.getString("userName");
			String passWord = jo.getString("password");
			
			// Check if user exits
			User user =  User.getUser(uName, passWord);
			
			if(user!=null) {
				res = new LoginResponse(user.getId(), user.getStatus());
			}else {
				res = new LoginResponse("Id not define", -1);
			}
		} catch (Exception e) {
			res = new LoginResponse("Id not define", -1);
			System.out.print(e);
		}
		
		jsonResponse = gson.toJson(res, LoginResponse.class);
		return Response.status(200).entity(jsonResponse).build();	
	}
	

}
