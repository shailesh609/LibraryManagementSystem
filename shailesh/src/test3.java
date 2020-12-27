public class test3{
public static void main(String args[]){
        int a=45,b=25,c=33,d=35,e;
        e=a>b?(a>c?(a>d?a:d):(c>d?c:d)):(b>c?(b>d?b:d):(c>d?c:d));
        System.out.println("Greatest of four no. is "+e);
        }
        }