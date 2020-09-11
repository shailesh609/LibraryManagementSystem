package model;


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
		

	    		try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString(4).equals(Email) ) {
				
			    return new signupUser(rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5));
				}
			}
			
				setUser( Name, Email, passWord, mNumber);
				con.close();  
				
	    		}catch(Exception e){ System.out.println(e);} 
                
          
	return null;
	}
	

	    

	    public static void setUser(String Name,String Email,String passWord,String mNumber){
	    	try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("insert into tblstudents value(password ='"+ passWord+"'	WHERE EmailId='"+Email+"');");
	    	
	    	}catch(Exception e){ System.out.println(e);} 
	  
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
