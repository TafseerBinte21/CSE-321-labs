import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process: ");
        int n = sc.nextInt();
        int[] burst_time = new int[n];
        int[] burst_time_initial = new int[n];
        int total_waiting_time;
        int[] turnaround_time = new int[n];
        System.out.println("Enter the quantum number: ");
        int quantum = sc.nextInt();
        int[] waiting_time = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th process burst time: ");
            burst_time[i] = sc.nextInt();
            burst_time_initial[i] = burst_time[i];
        }

        do {
            for (int i = 0; i < n; i++) {
                if (burst_time[i] > quantum) {
                    for (int j = 0; j < n; j++) {
                        if (j != i && burst_time[j] != 0) {
                            waiting_time[j] += quantum;
                        }
                    }
                    burst_time[i] -= quantum;

                }
                else {
                    for (int j = 0; j < n; j++) {
                        if (j != i && burst_time[j] != 0) {
                            waiting_time[j] += burst_time[i];
                        }
                    }
                    burst_time[i] = 0;
                }
            }

            total_waiting_time = 0;
            for (int i = 0; i < n; i++) {
                turnaround_time[i] = waiting_time[i] + burst_time_initial[i];
                total_waiting_time += burst_time[i];
            }
        }
        while (total_waiting_time != 0);
        System.out.println("Process Turnaround waiting");
        float total_wait = 0;
        float total_turnaround = 0;
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + " ");
            System.out.print(turnaround_time[i] + " ");
            System.out.println(waiting_time[i]);
            total_wait += waiting_time[i];
            total_turnaround += turnaround_time[i];
        }
        System.out.println("Average waiting time is: " + (total_wait / n));
        System.out.println("Average turnaround time is: " + (total_turnaround / n));
        sc.close();
    }
}
