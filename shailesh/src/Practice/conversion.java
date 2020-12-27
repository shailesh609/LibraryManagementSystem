package Practice;

public class conversion {
    public static void Conversiontoint(String na){
          char j[]=new char[100];
         int no=0,b=1;
       // j = na.toCharArray();
		
		
        for(int i=na.length()-1;i>-1;i--){
           no = no + (( na.charAt(i) -48)*b);
           b=(b*10);
        }
        System.out.println("conversion of string is--> " +no);
    }
    public static void main(String args[]){
        String a="567";
        Conversiontoint(a);
    }
}
