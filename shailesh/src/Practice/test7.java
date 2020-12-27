package Practice;

public class test7 {

	public static void main(String[] args) {
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				if(i%2==0) {
					if(j%2==0) {
						System.out.print("  1  ");
					}
					else System.out.print("  0  ");
				}
				else if(j%2==0) {
					System.out.print("  0  ");
				}
				else System.out.print("  1  ");
			}
			System.out.println();
			}
		}

	}


