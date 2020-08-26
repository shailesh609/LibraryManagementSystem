package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;

public class Books {

	
	
	
	  public static JSONArray getIssuedbook(String id) {
		  JSONArray array = new JSONArray();
		  try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT tblbooks.BookName,tblbooks.ISBNNumber, tblissuedbookdetails.IssuesDate, tblissuedbookdetails.ReturnDate,  tblissuedbookdetails.fine\r\n" + 
						"FROM tblbooks\r\n" + 
						"INNER JOIN tblissuedbookdetails ON tblissuedbookdetails.BookID=tblbooks.id where tblissuedbookdetails.StudentID='"+id+"';");
				while(rs.next()) { 
				 
					JSONObject record = new JSONObject();
					record.put("Bookname"  ,   rs.getString("BookName"));
					record.put("ISBNNumber", rs.getString("ISBNNumber"));
					record.put("Issuesdate", rs.getString("IssuesDate"));
					record.put("Returndate", rs.getString("ReturnDate"));
					record.put("Fine"      ,       rs.getString("fine"));
					
					array.put(record);
				
				}
			
				
				}catch(Exception e){ System.out.println(e); }  
	  
		
	
	return array;
	 
	  }	
}
