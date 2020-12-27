package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import model.User;

@Path("/login")
public class loginService {
	
	class LoginResponse {
		int userId;
		String role;
		public LoginResponse(int userId, String role) {
			this.userId = userId;
			this.role = role;
		}
	}
	
	
	//http://localhost:8080/FirstProject/myApp/login/userlogin
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
			User user = User.getUser(uName, passWord);
			
			if(user!=null) {
				res = new LoginResponse(user.getId(), user.getRole());
			}else {
				res = new LoginResponse(-1, "doNotExits");
			}
		} catch (Exception e) {
			res = new LoginResponse(-1, "doNotExits");
			System.out.print(e);
		}
		
		jsonResponse = gson.toJson(res, LoginResponse.class);
		return Response.status(200).entity(jsonResponse).build();	
	}
	

}
