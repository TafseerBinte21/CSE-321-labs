import java.util.Scanner;

class Threads extends Thread {
    String name;
    int num1;
    int num2 ;

    public Threads(String name, int num1, int num2) {
        this.name = name;
        this.num1 = num1;
        this.num2 = num2;
    }

    public Threads(String avg) {
    }

    public void run() {
        if(name == "add") {
            int addition = num1 + num2;
            System.out.println(addition);
            System.out.println( Threads.currentThread().getName());
        }

        else if(name == "sub") {
            int subtraction = num1-num2;
            System.out.println(subtraction);
            System.out.println( Threads.currentThread().getName());
        }

        else if(name == "mul") {
            int multiplication = num1*num2;
            System.out.println(multiplication);
            System.out.println( Threads.currentThread().getName());
        }

        else if(name == "div") {
            float division = num1/num2;
            System.out.println(division);
            System.out.println( Threads.currentThread().getName());
        }

        else{
            System.out.println("No valid operator");
            System.out.println( Threads.currentThread().getName());
        }
    }



}

public class Task1 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Two Numbers : ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        Threads add = new Threads("add",num1,num2);
        Threads sub = new Threads("sub",num1,num2);
        Threads mul = new Threads("mul",num1,num2);
        Threads div = new Threads("div",num1,num2);
        Threads oth = new Threads("oth",num1,num2);

        add.start();
        sub.start();
        mul.start();
        div.start();
        oth.start();



    }
}
