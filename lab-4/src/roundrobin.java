import java.util.Scanner;
public class roundrobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wait[], turn[], i, totalwait,  rm[];
        float avgwait=0, avgturn=0 ;

        wait = new int[10];
        turn = new int[10];
        rm = new int[10];


        System.out.print("Enter the number of process : ");
        int no = sc.nextInt();
        int[] process = new int[no];

        for (i = 0; i < no; i++) {
            process[i] = i + 1;
        }

        System.out.print("Enter the quantum no : ");
        int quantum = sc.nextInt();

        System.out.print("Enter burst time for processes:");
        int[] burstTime = new int[5];
        for (i = 0; i < no; i++) {
            burstTime[i] = sc.nextInt();
            rm[i] = burstTime[i];
        }

        do {
            for (i = 0; i < no; i++) {
                    if (burstTime[i] > quantum) {
                        for (int j = 0; j < no; j++) {
                            if (j != i && burstTime[j] != 0) {
                                wait[j] += quantum;
                            }
                        }
                        burstTime[i] -= quantum;
                    }
                    else {
                        for (int j = 0; j < no; j++) {
                            if (j != i && burstTime[j] != 0) {
                                wait[j] += burstTime[i];
                            }
                        }
                        burstTime[i] = 0;
                    }
                }

            totalwait = 0;
            for (i = 0; i < no; i++) {
                turn[i] = wait[i] + rm[i];
                totalwait += burstTime[i];
            }
        }


            while (totalwait != 0) ;

            System.out.println(" Waiting time\t" + " Turn around time");
            for (i = 0; i < no; i++) {
                System.out.print("\n   " + wait[i] + "\t\t     " + turn[i] + "\n");
                avgwait += wait[i];
                avgturn += turn[i];
            }

            avgwait /= no;
            avgturn /= no;
            System.out.println("Average waiting time = " + avgwait);
            System.out.println("Average turn around time = " + avgturn);

    }
}