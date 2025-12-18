package day4.code;

import java.util.Scanner;


class Accumulators {

    //State Live Here!
    private double totalQuantity;
    private double totalCost;
    
    //Default
    // double quantity = 10;
    double rate = 70;

    //New Entry..
    void newEntry() {

        try(Scanner scanner = new Scanner(System.in)){
            while (true) {

                int done;
                System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
                double quantity = scanner.nextDouble();
                // System.out.print("\n" + "Enter Milk Rate per liter  : ");
                // double rate = scanner.nextDouble();

                System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                done = scanner.nextInt();

                while (done > 1 || done < 0) {

                    System.out.println("Wrong Entry ..\n");
                    System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                    done = scanner.nextInt();

                }

                if ( done == 1){

                    inputValidator(quantity, rate, done);

                }else if(done == 0){

                    inputValidator(quantity, rate, done);
                    break;

                }



            }
            scanner.close();
        }
        

    }

    void summaryState(double quantity, double rate,boolean valid,int done){

        if(valid == true){

            double entryCost = quantity * rate;
            totalQuantity += quantity;
            totalCost += entryCost;

        }

        if(done != 1 && done == 0){

            finalSummary(true);

        }
            
    }

    void inputValidator(double quantity,double rate,int done){

        //Session Start
        if((quantity <= 100 && quantity >=0.300  ) && (done == 1 || done == 0)  ){

            summaryState(quantity, rate, true,done);

        }else{
            System.out.println("Last Entry has Invalid Quantity(Not in Applicable Rage)...");
            summaryState(quantity, rate, false,done);
        }

    }

    void finalSummary(boolean eEntry) {
        System.out.println("\n Daily Summary \n");
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.println("Total Cost: " + totalCost);
    }
}


public class Day4 {

    public static void main(String[] args) {

        Accumulators ac = new Accumulators();
        ac.newEntry();

        
 
    }
}
