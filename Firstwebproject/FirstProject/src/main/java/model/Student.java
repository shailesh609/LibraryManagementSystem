package model;

import java.util.ArrayList;

public class Student {
	
	int id;
	String name;
	int rollNo;
		
	public Student(int id, String name, int rollNo) {
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public static Student getStudent(int id) {
		
		ArrayList<Student> al = getAllStudentList();
		
		for(Student st : al) {
			if(st.id == id)
				return st;
		}
		
		return new Student(-1, "", -1);
	}
	
	
	public static ArrayList<Student> getAllStudentList(){
		
		ArrayList<Student> studentList = new ArrayList<Student>();
						
		Student student1 = new Student(1, "Shailesh" , 11);
		Student student2 = new Student(2, "Shivem" , 5);
		Student student3 = new Student(3, "Sachin" , 10);
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		return studentList;	
	}

}
