package Practice;
import java.io.*;
public class search {
    public static void main(String[] args) throws Exception{
        System.out.println("no.of element in array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] integersInString = br.readLine().split(" ");
        int a[] = new int[integersInString.length];
        for(int i=0;i<integersInString.length;i++){
            a[i]=Integer.parseInt(integersInString[i]);
        }
        int y=a[0];
        for(int i=0;i<integersInString.length;i++){
           y=(y ^ a[i]);
        }
        System.out.println("non repeated--->"+y);
    }
}
