
import java.util.Scanner;


class ThreadB extends Thread {
    String name1;

    public ThreadB(String name1) {
        this.name1 = name1;

    }
    public void run() {
        System.out.println("The house name is: " + name1);
        int time = 5000;
        if (name1 == "House Stark" || name1 == "House Targaryen") {
            time = 1000;
        }
        else if (name1 == "House Lannister" || name1== "House Bolton") {
            time = 3000;
        }
        try {
            sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class task2bonus {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ThreadB House_Stark = new ThreadB("House Stark");
        ThreadB House_Targaryen = new ThreadB("House Targaryen");
        ThreadB House_Lannister = new ThreadB("House Lannister");
        ThreadB House_Bolton = new ThreadB("House Bolton");
        ThreadB House_Tyrell = new ThreadB("House Tyrell");

        House_Stark.setPriority(Thread.MAX_PRIORITY);
        House_Bolton.setPriority(Thread.MIN_PRIORITY);
        // Single Threaded
        House_Stark.run();
        House_Targaryen.run();
        House_Lannister.run();
        House_Bolton.run();
        // MultiThreaded
        House_Stark.start();
        House_Tyrell.start();
        House_Lannister.start();
        House_Bolton.start();

        try {
            House_Stark.join();
            House_Lannister.join();
            House_Bolton.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(House_Stark.isAlive()){
            System.out.println("Not Today!");
        }
        if(!House_Bolton.isAlive()){
            System.out.println("You know nothing!");
        }
    }
}
