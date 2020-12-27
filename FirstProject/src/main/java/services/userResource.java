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
	
	//http://localhost:8080/FirstProject/myApp/user/getInfo/1
	@GET
	@Path("/getInfo/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON(@PathParam("userId") int userId) {
			
		JSONObject jo = new JSONObject();
		
		Student student = Student.getStudent(userId);
		
		try {
			jo.append("name", student.getName());
			jo.append("rollNo", student.getRollNo());
			jo.append("message", "success");
		} catch (Exception e) {
		
		}
		
		return jo.toString();
	}
	
/*	@GET
	@Path("/textFormat")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	// This method is called if XML is request
	@GET
	@Path("/xmlFormat")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Path("/htmlFormat")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {

		System.out.println("For debugging purpose");

		return "<html> " + "<title>" + "Hello Jersey. This is a get api response" + "</title>"
		+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}*/

}
