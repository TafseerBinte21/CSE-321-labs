import java.util.Scanner;

class Threads1 extends Thread {
    String name;


    public Threads1(String name) {
        this.name = name;

    }

    public  void run() {
        System.out.println("The house name is: " + name);
    }
}

    public class Task2 {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
            }




            Threads1 HouseStark = new Threads1("House Stark");
            Threads1 HouseTargaryen = new Threads1("House Targaryen");
            Threads1 HouseLannister = new Threads1("House Lannister");
            Threads1 HouseBolton = new Threads1("House Bolton");
            Threads1 HouseTyrell = new Threads1("House Tyrell");

            HouseStark.setPriority(Thread.MAX_PRIORITY);
            HouseBolton.setPriority(Thread.MIN_PRIORITY);
            // Single Threaded
            HouseStark.run();
            HouseTargaryen.run();
            HouseLannister.run();
            HouseBolton.run();
            // MultiThreaded
            HouseStark.start();
            HouseTyrell.start();
            HouseLannister.start();
            HouseBolton.start();

            try {
                HouseStark.join();
                HouseLannister.join();
                HouseBolton.join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (HouseStark.isAlive()) {
                System.out.println("Not Today!");
            }
            if (!HouseBolton.isAlive()) {
                System.out.println("You know nothing!");

            }
        }
    }


