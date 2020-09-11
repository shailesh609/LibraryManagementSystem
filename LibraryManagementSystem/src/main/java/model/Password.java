package model;


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
		

	    
	
	    		try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from tblstudents");
				while(rs.next()) { 
				if(rs.getString(4).equals(Email) && rs.getString(5).equals(mNumber)) {
					passwordforgot( passWord, Email);
			    return new Password(rs.getString(4),rs.getString(5),rs.getString(6));
				}
				
			
				}
			
			      
				}catch(Exception e){ System.out.println(e);} 
                
        
	return null;
	}


static void passwordforgot(String password,String Email) {
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("UPDATE tblstudents SET password ='"+ password+"'	WHERE EmailId='"+Email+"';");
	}catch(Exception e){ System.out.println(e);} 
	
}



public static Password changePassword(String userId,String passWord,String oldpassword) {
	

    

    		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from tblstudents");
			while(rs.next()) { 
			if(rs.getString(2).equals(userId) && rs.getString(6).equals(oldpassword)) {
				passwordchange(userId,passWord);
		    return new Password(rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
		
			}
		
		       con.close();  
			}catch(Exception e){ System.out.println(e);} 
            
    
return null;
}

public static void passwordchange(String userId,String Password) {
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("UPDATE tblstudents SET password ='"+ Password+"'	WHERE StudentId='"+ userId +"';");
	
	}catch(Exception e){ System.out.println(e);} 
	
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
