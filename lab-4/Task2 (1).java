import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter no of process:");
        int n = sc.nextInt();
        int[] pid = new int[n];
        int[] arrival_time = new int[n];
        int[] burst_time = new int[n];
        int[] burst_time_initial = new int[n];
        int[] complete_time = new int[n];
        int[] turnaround_time = new int[n];
        int[] waiting_time = new int[n];
        int[] priority = new int[n];
        int[] f = new int[n];
        int st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.println("Enter " + (i + 1) + "th process arrival time: ");
            arrival_time[i] = sc.nextInt();
            System.out.println("Enter " + (i + 1) + "th process burst time: ");
            burst_time[i] = sc.nextInt();
            burst_time_initial[i] = burst_time[i];
            System.out.println("Enter " + (i + 1) + "th priority: ");
            priority[i] = sc.nextInt();
            f[i] = 0;

        }
        while (true) {
            int c = n, min = 999;
            if (tot == n)
                break;
            for(int i = 0; i < n; i++) {
                if ((arrival_time[i] <= st) && (f[i] == 0) && (priority[i] < min)) {
                    min = priority[i];
                    c = i;
                }
            }

            st++;
            if (c != n) {
                burst_time[c]--;
                if(burst_time[c] == 0) {
                    f[c] = 1;
                    complete_time[c] = st;
                    tot++;
                }
            }

            avgta = 0;
            avgwt = 0;
            for (int i = 0; i < n; i++) {
                turnaround_time[i] = complete_time[i] - arrival_time[i];
                waiting_time[i] = turnaround_time[i] - burst_time_initial[i];
            }
        }

        System.out.println("\n pid arrival burst complete turn waiting");
        for (int i = 0; i < n; i++) {
            System.out.print(pid[i] + "  ");
            System.out.print(arrival_time[i] + "  ");
            System.out.print(burst_time_initial[i] + "  ");
            System.out.print(complete_time[i] + "  ");
            System.out.print(turnaround_time[i] + "  ");
            System.out.println(waiting_time[i]);
            avgwt = avgwt + waiting_time[i];
            avgta = avgta + turnaround_time[i];
        }
        avgwt = avgwt / n;
        avgta = avgta / n;
        System.out.println("Average waiting time: " + avgwt);
        System.out.println("Average turnaround time: " + avgta);
        sc.close();
    }
}
