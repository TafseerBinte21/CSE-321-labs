import java.io.*;
import java.util.*;

public class DeadlockPrevention {

    public static void main(String[] args) throws Exception {
        try (BufferedReader buffer = new BufferedReader(
                new FileReader("DeadlockPrevention.txt"))) {
            int row = Integer.parseInt(buffer.readLine());
            int column = Integer.parseInt(buffer.readLine());
            String[] process = new String[row];
            int[][] max = new int[row][column];
            int[][] allocation = new int[row][column];
            int[][] need = new int[row][column];
            int[][] available = new int[row + 1][column];
            LinkedList<Integer> track = new LinkedList<Integer>();

            String str = buffer.readLine();

            StringTokenizer strToken = new StringTokenizer(str, " ");
            int n = 0;
            while (strToken.hasMoreTokens()) {
                process[n] = strToken.nextToken();
                n++;
            }

            for (int i = 0; i < row; i++) {
                String line = buffer.readLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                for (int j = 0; j < column; j++) {
                    max[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                String line = buffer.readLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                for (int j = 0; j < column; j++) {
                    allocation[i][j] = Integer.parseInt(st.nextToken());
                    need[i][j] = max[i][j] - allocation[i][j];
                }
            }

            System.out.print("Need Matrix:");
            for (int i = 0; i < row; i++) {
                System.out.println();
                for (int j = 0; j < column; j++) {
                    System.out.print(need[i][j] + " ");
                }
            }

            System.out.println();
            String line = buffer.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            int counter = 0;
            while (st.hasMoreTokens()) {
                available[0][counter] = Integer.parseInt(st.nextToken());
                counter++;
            }

            counter = 0;
            for (int i = 0;; i++) {
                i = i % row;
                boolean flag = true;
                for (int j = 0; j < column; j++) {
                    if (need[i][j] <= available[counter][j]) {

                    } else {
                        flag = false;
                        break;
                    }
                    if (flag && j == (column - 1) && !track.contains(i)) {
                        for (int k = 0; k < column; k++) {
                            available[counter + 1][k] = available[counter][k] + allocation[i][k];
                        }
                        track.addLast(i);
                        counter++;
                    }
                }
                if (track.size() == row) {
                    break;
                }
            }

            System.out.println();
            System.out.println("Safe Sequence: ");
            for (int i = 0; i < track.size(); i++) {
                System.out.print(process[track.get(i)] + " ");
            }
            System.out.println();
            System.out.println();
            System.out.print("Change in available resource matrix: ");
            for (int i = 1; i < available.length; i++) {
                System.out.println();
                for (int j = 0; j < column; j++) {
                    System.out.print(available[i][j] + " ");
                }
            }
        }

        System.out.println();
    }
}