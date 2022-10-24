import java.util.Scanner;

class Threads2 extends Thread {
    String name2;

    public Threads2(String name2) {

        this.name2 = name2;
    }

    public void run() {

        long sum = 0, c = 0;
        if (name2 == "meanOdd1") {
            for (int i = 0; i < 25; i++) {
                if (Task3.fibseries[i] % 2 == 1) {
                    sum += Task3.fibseries[i];
                    c++;
                }
            }
            Task3.avg1+=  sum / c;
            System.out.println(Task3.avg1);
        } else if (name2 == "meanEven1") {
            for (int i = 0; i < 25; i++) {
                if (Task3.fibseries[i] % 2 == 0) {
                    sum += Task3.fibseries[i];
                    c++;
                }
            }
            Task3.avg1+= sum / c;
            System.out.println(Task3.avg1);

        } else if (name2 == "meanOdd2") {
            for (int i = 25; i < 50; i++) {
                if (Task3.fibseries[i] % 2 == 1) {
                    sum += Task3.fibseries[i];
                    c++;
                }
            }
            Task3.avg1+=  sum / c;
            System.out.println(Task3.avg1);

        } else if (name2 == "meanEven2") {
            for (int i = 25; i < 50; i++) {
                if (Task3.fibseries[i] % 2 == 0) {
                    sum += Task3.fibseries[i];
                    c++;
                }
            }
            Task3.avg1+=  sum / c;
            System.out.println(Task3.avg1);
        }

        else if (name2 == "average") {
            long s = Task3.avg1 / 4;
            System.out.println("The average of 4 mean: " + s);
        }

    }
}

    public class Task3 {

        public static long[] fibseries;
        public  static  long avg1;
        public static void main(String[] args) {

            fibseries = new long[50];

            fibseries[1] = 1;
            for (int i = 2; i <50; i++) {
                fibseries[i] = fibseries[i - 1] + fibseries[i - 2];
            }

            Scanner scanner = new Scanner(System.in);


            Threads2 meanOdd1 = new Threads2("meanOdd1");
            Threads2 meanEven1 = new Threads2("meanEven1");
            Threads2 meanOdd2 = new Threads2("meanOdd2");
            Threads2 meanEven2 = new Threads2("meanEven2");
            Threads2 average = new Threads2("average");

            meanOdd1.start();
            meanEven1.start();
            meanOdd2.start();
            meanEven2.start();

            try {
                meanOdd1.join();
                meanEven1.join();
                meanOdd2.join();
                meanEven2.join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            average.start();

        }
    }











