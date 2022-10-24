import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int wait[], turn[], i, flag[], completeTime[], rt[], st = 0, t = 0;
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
        int[] ar = new int[no];
        for (i = 0; i < no; i++) {
            ar[i] = sc.nextInt();
        }

        System.out.print("Enter burst time for processes:");
        int[] burstTime = new int[no];
        for (i = 0; i < no; i++) {
            burstTime[i] = sc.nextInt();
            rt[i] = burstTime[i];
        }
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(burstTime));
        while (true) {
            int x = no;
            int min = 2147483647;
            if (t == no)
                break;

            for (i = 0; i < no; i++) {
                if ((ar[i] <= st) && (flag[i] == 0) && (rt[i] < min)) {
                    min = rt[i];
                    x = i;
                }
            }

            st++;
            if (x != no) {
                rt[x]--;
                if (rt[x] == 0) {
                    flag[x] = 1;
                    completeTime[x] = st;
                    t++;
                }
            }

            avgwait = 0;
            avgturn = 0;
            for (i = 0; i < no; i++) {
                turn[i] = completeTime[i] - ar[i];
                wait[i] = turn[i] - burstTime[i];
            }
        }
        System.out.println(" Completion time\t" + " Waiting time\t" + " Turn around time");

        for (i = 0; i < no; i++) {
            System.out.print("\n   " + completeTime[i] + "\t\t      "         + wait[i] + "\t\t     " + turn[i] + "\n");
            avgwait = avgwait + wait[i];
            avgturn = avgturn + turn[i];
        }
        avgwait /= no;
        avgturn /= no;
        System.out.println("Average waiting time = " + avgwait);
        System.out.println("Average turn around time = " + avgturn);
    }
}