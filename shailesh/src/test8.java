
public class test8 {

	public static void main(String[] args) {
		int a=0;
		for(int i=3;i>=1;i--) {
			for(int j=i; j<3; j++)
	        {
	           System.out.print(" ");
	        }
			for(int j=1;j<=i;j++) {
				
					if(a==0) {
						a=1;
						System.out.print(a);
					}
					else {
						a=0;
						System.out.print(a);
				}
			
			
			}
			System.out.println();
  }
}
}

/* 1 0 1
     1 0
       1 */
