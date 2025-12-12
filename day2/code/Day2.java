import java.util.Scanner;


public class Day2 {
    public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)){

        System.out.print("\n" + "Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Score: ");
        int score = scanner.nextInt();
        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        System.out.print("\n" +"Title: " + title + "\n");
        System.out.print("Score: " + score + "\n");
        System.out.print("Balance: " + balance + "\n");

        try (Scanner scanner1 = new Scanner(System.in)){

            System.out.print("\n" + "Enter Name: ");
            String name = scanner1.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner1.nextInt();
            System.out.print("\n" +"You entered: " + name + "," + age + "\n");
            }
        
        
        }
    }
}
