import java.util.Scanner;

public class sjf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int  wait[], turn[], i,  flag[], completeTime[], rt[], st = 0, t = 0;
        float avgwait = 0,avgturn = 0;

        wait = new int[10];
        turn = new int[10];
        flag = new int[10];
        completeTime = new int[10];
        rt = new int[10];

        System.out.print("Enter the number of process : ");
        int no = sc.nextInt();
        int[] process = new int[no];

        for (i = 0; i < no; i++) {
            process[i] = i + 1;
        }


        System.out.print("Enter arrival time for process: ");
        int[] ar = new int[5];
        for (i = 0; i < no; i++) {
            ar[i] = sc.nextInt();
        }

        System.out.print("Enter burst time for processes:");
        int[] burstTime = new int[5];
        for (i = 0; i < no; i++) {
            burstTime[i] = sc.nextInt();
            rt[i] = burstTime[i];
        }

        while (true) {
            int x = no,min = 2147483647;
            if (t == no)
                break;

            for (i = 0; i < no; i++) {
                if ((ar[i] <= st) && (flag[i] == 0) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    x = i;
                }
            }

            st++;
            if (x != no) {
                burstTime[x]--;
                if (burstTime[x] == 0) {
                    flag[x] = 1;
                    completeTime[x] = st;
                    t++;
                }
            }

            avgwait = 0;
            avgturn = 0;
            for (i = 0; i < no; i++) {
                wait[i] = turn[i] - rt[i];
                turn[i] = completeTime[i] - ar[i];

            }
        }



            System.out.println(" Completion time\t" + " Waiting time\t" + " Turn around time");


            for (i = 0; i < no; i++) {
                System.out.print("\n   " + completeTime[i] + "\t\t      " + wait[i] + "\t\t     " + turn[i] + "\n");
                avgwait += wait[i];
                avgturn += turn[i];
            }

            avgwait /= no;
            avgturn /= no;
            System.out.println("Average waiting time = " + avgwait);
            System.out.println("Average turn around time = " + avgturn);




}
}
