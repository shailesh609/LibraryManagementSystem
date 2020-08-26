package model;

import java.util.ArrayList;
import java.sql.*;

public class Password {
	
	public String Email;
	public String password;
	public String mNumber;
	
	public Password( String Email, String password ,String mNumber) {
		
		this.password=password;
		this.Email=Email;
		this.mNumber=mNumber;
	}
	
	
public static Password forgotPassword(String Email,String passWord,String mNumber) {
		
		/*ArrayList<Password> users = getAllUser();
	    for( Password  user : users) {
			if(user.getEmail().equals(Email) ) {
				user.setPassword(passWord);
				return user;
			}
	    }*/
	    
	
	    		try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString(4).equals(Email) ) {
				
			    return new Password(rs.getString(4),rs.getString(5),rs.getString(6));
				}
				
			
				}
			
			       con.close();  
				}catch(Exception e){ System.out.println(e);} 
                
        
	return null;
	}

static ArrayList< Password > userList = new ArrayList< Password >();


/*public static ArrayList< Password > getAllUser(){
	
	
	 Password  user1 = new  Password ("123" , "Student","342422");
	 Password  user2 = new  Password ("S1234" , "Student","32342424");
	 Password  user3 = new  Password ("S12345" , "Student","233243");
	 Password  user4 = new  Password ( "T123" , "Teacher","323422");
	 Password  user5 = new  Password ("A123" , "Admin","232322");
	
	userList.add(user1);
	userList.add(user2);
	userList.add(user3);
	userList.add(user4);
	userList.add(user5);
	
	return userList;
}*/

public static Password changePassword(String Email,String passWord,String mNumber) {
	
	/*ArrayList<Password> users = getAllUser();
    for( Password  user : users) {
		if(user.getEmail().equals(Email) ) {
			user.setPassword(passWord);
			return user;
		}
    }*/
    

    		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from tblstudents");
			while(rs.next()) { 
			if(rs.getString(4).equals(Email) ) {
			
		    return new Password(rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
		
			}
		
		       con.close();  
			}catch(Exception e){ System.out.println(e);} 
            
    
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


	public String getPassword() {
		return password;
	}

	public  void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	
	
}
