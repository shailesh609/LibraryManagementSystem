public class test5 {
    public  static void main(String args[]){
        int a=7,i,m=0,flag=0;
        m=a/2;
        if(a==0||a==1){
            System.out.println("no. is not prime");
        }
        else{
            for(i=2;i<m;i++){
                if(a%i==0){
                    System.out.println("no. is not prime");
                    flag=1;
                    break;
                }
            }
           if(flag==0) System.out.println("no.is prime");
        }
    }
}
