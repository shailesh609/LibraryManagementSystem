package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import model.Student;

@Path("/user")
public class userResource {
	
	//http://localhost:9090/LibraryManagementSystem/myApp/user/getInfo/userId
	@GET
	@Path("/getInfo/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON(@PathParam("userId") String userId) {
			
		JSONObject jo = new JSONObject();
		
		Student student = Student.getStudent(userId);
		
		try {
			jo.append("name", student.getName());
			jo.append("status", student.getStatus());
			jo.append("RegDate", student.getRegDate());
			jo.append("mNumber", student.getNumber());
			jo.append("Email", student.getEmail());
			jo.append("Id", student.getId());
			jo.append("Updation", student.getUpdation());
			jo.append("message", "success");
		} catch (Exception e) {
		
		}
		
		return jo.toString();
	}


}
