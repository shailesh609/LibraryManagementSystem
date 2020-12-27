package Practice;

public class Demo{
    int a=1; 
    int b=2; 
    int c=3;
     Demo(){ 
         this(0);
         show();
         System.out.println("red");
}


Demo(int a) { 
   this(a, 1);
   show(); 
   System.out.println("blue");
}
Demo(int a, int b){
    this(a, b, 2);
    System.out.println("green");
    a=5;
    b=6;
    c=7;
}

{
   System.out.println("black"); 
   a=9;
   b=10;
   c=12;
}
static{
System.out.println("welcome");
new Demo().show();
}

void show(){
System.out.println(a+b+c);
} 
public static void main(String[] args) 
{ 
    System.out.println("Dog"); 
new Demo (8,3,4).show();
new Demo (6,9).show();
System.out.println("cat");

}
Demo (int a,int b,int c){
   show(); 
this.a=a;
this.b=b; 
this.c=c;
}
}
