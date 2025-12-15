package day3.code;

import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)){

        System.out.print("\n" + "Enter Milk quantity : ");
        double Quantity = scanner.nextDouble();

        if (Quantity > 1.0 ) {

            System.out.print("\n" + "Large order" + "\n");            
        }
        else if (Quantity == 1.0 ) {

            System.out.print("\n" + "Standard order" + "\n"); 
        }
        else {

          System.out.print("\n" + "Small order" + "\n"); 
        
        }

        //Add Billing Check
        System.out.print("\n" + "Enter Milk Rate per liter  : ");
        double rate = scanner.nextDouble();
        System.out.print("\n" + "Total cost: " + Quantity*rate + "\n"); 


    }

}
    
}
