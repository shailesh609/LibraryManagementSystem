package Practice;
//import java.util.Scanner;

/*public class Demo1 {
	static int ab(int num) {
		  if(num<0) {
			 num=(-1)*num;
			 return num;
		 }
		 else { return num;}
		
		return num<0?  -num: num;
		
	}
	public static void main(String args[]) {
	
		//*Scanner s= new Scanner(System.in); 
	
	//int num =new Scanner(System.in).nextInt(); 
	
//	System.out.println("Enter number"+" "+ ab(new Scanner(System.in).nextInt() ));
		//int num;
	 
	System.out.println(Math.abs(new java.util.Scanner(System.in).nextInt()));

	//System.out.print( Integer.parseInt(args[0]=new java.util.Scanner(System.in).nextLine())<0? -Integer.parseInt(args[0]) :Integer.parseInt(args[0]));
	
	if(num>=0 && (System.out.printf("" +num)==null)){}
	
	else if(num<0  && (System.out.printf(""+(-num))==null)) {}
	 

}
}*/
class Animal { 
    void show() {

System.out.println("animal");
}
}
class Dog extends Animal
{
void show() {

System.out.println("dog");
}
}
 class Demo1{

public static void main(String []args)
{ Animal a=new Animal();

a.show();
}
}