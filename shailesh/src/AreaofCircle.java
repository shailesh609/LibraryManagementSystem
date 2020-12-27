import java.util.*;
public class AreaofCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int radius;
	      double area;
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Enter the radius of the circle ::");
	      radius = sc.nextInt();
	      area = (radius*radius)*Math.PI;
	      System.out.println("Area of the circle is ::"+area);
	}

}
