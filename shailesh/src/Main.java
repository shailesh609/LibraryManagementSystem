import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	int n=scanner.nextInt();
        int[] A = new int[n];
        int p = 0;
        int r = A.length -1;
        for(int i=0;i<A.length;i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("Unsorted array");
        printA(A);
        mergeSort(A,p,r);
        System.out.println("sorted array");
        printA(A);
    }

    private static void mergeSort(int[] A,int p,int r){
        if(p<r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }
    private static void merge(int[] A,int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i=0;i<n1;i++){
            L[i] = A[p + i];
        }
        for(int j =0;j<n2;j++){
            R[j]= A[q+j+1];
        }
        L[n1]= Integer.MAX_VALUE;
        R[n2]= Integer.MAX_VALUE;
        int i =0,j=0;
        /*while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }*/
        for(int k=p;k<=r;k++){
            if(L[i]<=R[j]){
                A[k] = L[i];
                i++;
            }else{
                A[k] = R[j];
                j++;
            }
        }
    }
    private static void printA(int[] A){
        for(int x: A){
            System.out.println(x);
        }
    }
}
