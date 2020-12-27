package Practice;

import java.util.Random;

public class SheetChecker implements Runnable{

    //ArrayList<Integer> answers;
    //ArrayList<Integer> answerKey;
    int rollNo;
    int totalMarks;

    public SheetChecker(int rollNo) {
        this.rollNo = rollNo;
    }

    public void run() {

        long startTime = System.currentTimeMillis();

        // Read answer from file and store into list
        // Here we will randomly generate intead of reading
        Random r = new Random();

        // This code is just use some computation power
        for(int i=0;i< 500000000 ;i++) {
            // Could do any other task
            int result = r.nextInt(100-0) + 0;
        }

        // Just randomly generate some mark
        // To generate random number between 1 to 4
        int low = 0;
        int high = 101;
        totalMarks = r.nextInt(high-low) + low;

        long endTime = System.currentTimeMillis();
        System.out.println("Student roll number is : " + this.rollNo + " and total marks are " + totalMarks + " and runtime is "  +  (endTime-startTime));

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Sequentialy
        long startTime = System.currentTimeMillis();
		/*for(int i=1;i<=12;i++) {
			SheetChecker sheetChecker = new SheetChecker(i);
			// This is calling as normal function, not as a thread
			sheetChecker.run();

		}*/
        long endTime = System.currentTimeMillis();
        //System.out.println("Sequential Time is : " +   (endTime-startTime));


        //Using threads
        startTime = System.currentTimeMillis();
        int k = 1;
        for(int j=0;j<=1;j++) {
            // Make 4 thread
            Thread t1 = new Thread(new SheetChecker(k));
            k++;
            Thread t2 = new Thread(new SheetChecker(k));
            k++;
			Thread t3 = new Thread(new SheetChecker(k));
			k++;
			Thread t4 = new Thread(new SheetChecker(k));
			k++;
            Thread t5 = new Thread(new SheetChecker(k));
            k++;
            Thread t6 = new Thread(new SheetChecker(k));
            k++;

            t1.start();
            t2.start();
			t3.start();
			t4.start();
            t5.start();
            t6.start();
            try {
                t1.join();
                t2.join();
				t3.join();
				t4.join();
                t5.join();
                t6.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


        endTime = System.currentTimeMillis();
        System.out.println("Parallel Time is : " +   (endTime-startTime));



    }

}

