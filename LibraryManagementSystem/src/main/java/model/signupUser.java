package model;

import java.util.ArrayList;
import java.sql.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class signupUser {
	
	public String Name;
	public String Email;
	public String password;
	public String mNumber;
	
	public signupUser(String Name, String Email, String password ,String mNumber) {
		this.Name=Name;
		this.password=password;
		this.Email=Email;
		this.mNumber=mNumber;
	}
	
	
	public static signupUser userSignup(String Name,String Email,String passWord,String mNumber) {
		
/*	ArrayList<signupUser> users = getAllUser();
	    for(signupUser user : users) {
			if(user.getEmail().equals(Email) ) 
				return user;
	    }
	    
	    setUser( Name, Email, passWord, mNumber);
	*/
	    		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString(4).equals(Email) ) {
				
			    return new signupUser(rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5));
				}
				
			
				}
			
			       con.close();  
				}catch(Exception e){ System.out.println(e);} 
                
                //SetUser() is used to enter data into database
                            
                // setUser( Name, Email, passWord, mNumber);       
                            
			
	    
	return null;
	}
	
	static ArrayList<signupUser> userList = new ArrayList<signupUser>();
	    
/*	public static ArrayList<signupUser> getAllUser(){
			
	
			signupUser user1 = new signupUser("s1", "123" , "Student","342422");
			signupUser user2 = new signupUser("Student2", "S1234@gmail.com" , "Student","32342424");
			signupUser user3 = new signupUser("Student3", "S12345@gmail.com" , "Student","233243");
			signupUser user4 = new signupUser("Teacher1", "T123" , "Teacher","323422");
			signupUser user5 = new signupUser("Admin1", "A123" , "Admin","232322");
			
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			userList.add(user4);
			userList.add(user5);
			
			return userList;
		}*/
	    public static void setUser(String Name,String Email,String passWord,String mNumber){
	    	
	    	signupUser user1 = new signupUser(Name, Email , passWord,mNumber);
	    userList.add(user1);
	    	
	    }
	
	    public static String userUpdate(String Name,String Email,String mNumber) {
	    	
	    	try{  
	    		 
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
	    		String date=dtf.format(now);
				
				 String query1 = "update tblstudents set FullName='"+ Name + "', MobileNumber='"+mNumber+"' ,UpdationDate='"+date+"' where EmailId='"+Email+"'";
				  stmt.executeUpdate(query1);
				
					return "Update Success";
				
				
					}
			
			      catch(Exception e){ System.out.println(e);} 
	    	return null;
	    }	
	    
	    
	    
	    public  String getmNumber(){
			return mNumber;
		}

		public void setId(String mNumber) {
			this.mNumber = mNumber;
		}

		public String getEmail() {
			return Email;
		}

		public void setName(String Name) {
			this.Name=Name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return Name;
		}

		public void setEmail(String Email) {
			this.Email = Email;
		}

}
