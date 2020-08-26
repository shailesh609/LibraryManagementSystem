package model;

import java.sql.*;

public class User {
	
	public String id;
	public String userName;
	public int status; 
	
	
	public User(String id, String userName,  int status) {
		this.id = id;
		this.userName = userName;
		this.status = status;
		
	}
	
	public static User getUser(String uName, String pw) {
	
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString("EmailId").equals(uName) &&  rs.getString("Password").equals(pw)) {
				
				return new User(rs.getString("StudentId"),rs.getString("FullName"),rs.getInt("Status"));
				
				}
			
				}
				//con.close();  
				}catch(Exception e){ System.out.println(e);}  
				  
		
		return null;
	}
	
	public  String getId(){
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	/*public static void main(String[] arg) {
		User user=getUser("test@gmail.com", "test@123");
		System.out.println(user.getStatus());
	}*/
}
