import java.util.Scanner;
public class priority {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int max,  wait[], turn[], i, complete[];
        float avgwait=0, avgturn=0 ;


        wait = new int[10];
        turn = new int[10];
        complete = new int[10];


        System.out.print("Enter the number of process : ");
        int no = sc.nextInt();
        int[] process = new int[5];

        for (i = 0; i < no; i++) {
            process[i] = i + 1;
        }


        System.out.print("Enter burst time for processes:");
        int[] burstTime = new int[5];
        for (i = 0; i < no; i++) {
            burstTime[i] = sc.nextInt();
        }

        System.out.print("Enter Priority for process: ");
        int[] pr = new  int[5];
        for (i = 0; i < no; i++) {
            pr[i] = sc.nextInt();
        }



        for (i = 0; i < no - 1; i++) {
            for (int j = i + 1; j < no; j++) {
                if (pr[i] > pr[j]) {
                    max = pr[i];
                    pr[i] = pr[j];
                    pr[j] = max;

                    max = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = max;

                    max = process[i];
                    process[i] = process[j];
                    process[j] = max;
                }
            }
        }

        wait[0] = 0;
        avgwait = 0;
        turn[0] = burstTime[0];
        avgturn = turn[0];
        for (i = 1; i < no; i++) {
            wait[i] = turn[i - 1];
            avgwait += wait[i];
            turn[i] = wait[i] + burstTime[i];
            complete[i] = turn[i];
            avgturn += turn[i];
        }



        System.out.print("\n\nWait Time \t Turn Around\n");
        for (i = 0; i < no; i++)
            System.out.print("\n   " + wait[i] + "\t\t     " + turn[i] + "\n");
        avgwait /= no;
        avgturn /= no;
        System.out.print("\n Average Wait Time : " + avgwait);
        System.out.print("\n Average Turn Around Time : " + avgturn);


    }
}