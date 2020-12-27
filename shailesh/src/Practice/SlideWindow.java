package Practice;
import java.io.*;
import java.util.Scanner;

public class SlideWindow {

	public static void main(String[] args) 
		// TODO Auto-generated method stub
		{
		    int w,i,f;
		    int frames[]=new int[50];
		 Scanner sc=new Scanner(System.in);
		    System.out.println("Enter window size: ");
		    w=sc.nextInt();
		 
		  System.out.println("Enter number of frames to transmit: ");
		    f=sc.nextInt();
		 
		    System.out.println("Enter "+f+ " frames: " );
		 
		    for(i=1;i<=f;i++)
		      frames[i]=sc.nextInt();
		 
		    System.out.println("With sliding window protocol the frames will be sent in the following manner (assuming no corruption of frames)\n");
		  System.out.println("After sending " + w +  " frames at each stage sender waits for acknowledgement sent by the receiver\n\n" );
		 
		    for(i=1;i<=f;i++)
		    {
		        if(i%w==0)
		        {
		           System.out.println(frames[i]);
		            System.out.println("Acknowledgement of above frames sent is received by sender\n\n");
		        }
		        else
		           System.out.println(frames[i]);
		    }
		 
		    if(f%w!=0)
		        System.out.println("\nAcknowledgement of above frames sent is received by sender\n");
		 
		 sc.close();
	
		}
	

}
