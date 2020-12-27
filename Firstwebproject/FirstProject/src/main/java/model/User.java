package model;

import java.util.ArrayList;
import java.sql.*;
public class User {
	
	public int id;
	public String userName;
	public String password;
	public String role; // student / admin / teacher
	
	
	public User(int id, String userName, String password, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		
	}
	
	public static User getUser(String uName, String pw) {
		ArrayList<User> users = getAllUser();
		for(User user : users) {
			if(user.getUserName().equals(uName) && user.getPassword().equals(pw))
				return user;
		}
		return null;
	/*	
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp");
			while(rs.next())  
			if(rs.getString(2).equals(uName) &&  rs.getString(1).equals(pw) ) {
		     User user= new User(11,rs.getString(2),rs.getString(1),"Student");
		     return user;
			}
			else 
				return null;
			con.close();  
			}
		    catch(Exception e){
		    	System.out.println(e);
			}  */
		
		
	}

	public static ArrayList<User> getAllUser(){
		
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
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static void main(String[] args) {
	
	}

}
