package model;

import java.util.ArrayList;
import java.sql.*;

public class User {
	
	public String id;
	public String userName;
	public String password;
	public int status; // student / admin / teacher
	
	
	public User(String id, String userName, String password, int status) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.status = status;
		
	}
	
	public static User getUser(String uName, String pw) {
	/*	ArrayList<User> users = getAllUser();
	    for(User user : users) {
			if(user.getUserName().equals(uName) && user.getPassword().equals(pw))
				return user;*/
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString(4).equals(uName) &&  rs.getString(6).equals(pw)) {
				
				return new User(rs.getString(2),rs.getString(3),rs.getString(6),rs.getInt(7));
				}
			
				}
			
				
			//	con.close();  
				}catch(Exception e){ System.out.println(e);}  
				  
		
		return null;
	}

/*	public static ArrayList<User> getAllUser(){
		
		ArrayList<User> userList = new ArrayList<User>();
		User user1 = new User(1, "s1", "123" , "Student");
		User user2 = new User(2, "Student2", "S1234" , "Student");
		User user3 = new User(3, "Student3", "S12345" , "Student");
		User user4 = new User(4, "Teacher1", "T123" , "Teacher");
		User user5 = new User(5, "Admin1", "A123" , "Admin");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		return userList;
	}*/
 
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
		  
		
	

	public static void main(String[] args) {

	}

}
