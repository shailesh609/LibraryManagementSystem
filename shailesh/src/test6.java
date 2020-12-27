public class test6 {
   static int isprime( int a){
       int flag=1;
            if(a==1||a==0){
                return 0;
            }
            else for(int i=2;i<a/2;i++){
                if(a%2==0) {
                    flag=0;
                    break;
                }
            }
            return flag;
        }
    public static void main(String args[]) {
        int p=7;
        System.out.println(isprime(p));
    }
}
