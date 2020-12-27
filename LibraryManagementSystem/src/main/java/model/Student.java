package model;

import java.sql.*;

public class Student {
	
	String id;
	String Status;
	String RegDate;
	String FullName;
	String mNumber;
	String Email;
	String Updation;
		
	public Student(String id, String FullName, String Status,String RegDate,String mNumber,String Email,String Updation) {
		this.id = id;
		this.FullName =FullName;
		this.Status = Status;
		this.RegDate = RegDate;
		this.mNumber = mNumber;
		this.Email = Email;
		this.Updation = Updation;
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return FullName;
	}

	public void setName(String name) {
		this.FullName = name;
	}

	public String getStatus() {
		return Status;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getEmail() {
		return Email;
	}
	public void setUpdation(String Updation) {
		this.Updation = Updation;
	}
	public String getUpdation() {
		return Updation;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	public void setmNumber(String Number) {
		this.mNumber=Number;
	}
	public String getNumber() {
		return mNumber;
	}
   public void setRegDate(String RegDate) {
	   this.RegDate=RegDate;
   }
   public String getRegDate() {
	   return RegDate;
   }

   
   public static Student getStudent(String id) {
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from tblstudents");
			while(rs.next()) { 
			if(rs.getString(2).equals(id) ) {
			
			return new Student(rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(8),rs.getString(5),rs.getString(4),rs.getString(9));
			
			}
		
			}
		
			
		//	con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		return new Student("","", "","","","","");
	}
	
	


}
