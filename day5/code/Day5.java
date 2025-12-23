package day5.code;

import java.util.ArrayList;
import java.util.Scanner;

class Accumulators {

    double totalCost = 0;
    double totalQuantity = 0;
    boolean valid = false;
    double entryCost = 0;
    int entryCount = 0;



    ArrayList<Double> totalQuantityArrayList = new ArrayList<>();
    ArrayList<Double> totalCostArrayList = new ArrayList<>();

    ArrayList<Double> quantityArrayList = new ArrayList<>();
    ArrayList<Double> rateArrayList = new ArrayList<>();

    ArrayList<String> entryArrayList = new ArrayList<>();
    // ArrayList<String> finalTotalArrayList = new ArrayList<>(); 
    // ArrayList<String> headingArrayList = new ArrayList<>();


    void finalSummary(){

        int len = entryArrayList.size();

        System.out.println("\n--- Entries ---\n");

        for(int i = 0; i < len;i++){

            System.out.println(entryArrayList.get(i));
        }

        System.out.println("\n--- Final Totals ---\n");
        System.out.println("Total Quantity: " + totalQuantity + "\nTotal Amount: " + totalCost);

    }


    void totalCost(double quantity, double rate, boolean valid, double done){

        entryCost = quantity * rate ;
        if(entryCost >=0 && valid == true && rate != 0){

            totalQuantity += quantity;
            totalCost += entryCost; 
            this.totalQuantityArrayList.add(totalQuantity);
            this.totalCostArrayList.add(totalCost);     
            // this.entryArrayList.add( entryCount+1 + ") " + "Quantity : " + quantityArrayList.get(entryCount) + " | " + "Rate: " + rateArrayList.get(entryCount) + " | " + "Total: " + totalCostArrayList.get(entryCount));
            this.entryArrayList.add( entryCount+1 + ") " + "Quantity : " + quantityArrayList.get(entryCount) + " | " + "Rate: " + rateArrayList.get(entryCount) + " | " + "Total: " + entryCost);
            entryCount++;
        }else {

            System.out.println("Invalid Rate");
        }

        if(done ==0){

            this.finalSummary();
        }
    }


    void inputValidator(double quantity, double rate,double done){

        try(Scanner scanner = new Scanner(System.in)){

            // default
            // rate = 71.1;
            // quantity = 5.2;
            
            System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
            quantity = scanner.nextDouble();
            System.out.print("\n" + "Enter Milk Rate per liter  : ");
            rate = scanner.nextDouble();
            System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
            done = scanner.nextDouble();

            //
            while(done != 0 && done !=1) {

                System.out.println("Invalid Entry Try Again..!\n");      
                System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                done = scanner.nextDouble();
            } 
            
            if ((quantity!=0 && quantity <=100 && quantity >=0.300) && (done == 0 || done == 1) ) {

                this.quantityArrayList.add(quantity);
                this.rateArrayList.add(rate);
                this.totalCost(quantity,rate,true,done);
                
                if(done == 1 && done != 0){
                
                    this.inputValidator(0, 0,0);
                }
                
            }else {
            
                System.out.println("Invalid Quantity try again");
                this.inputValidator(0,0,done);
        }


        }

    }
}


public class Day5 {

    public static void main(String[] args) {


        Accumulators u = new Accumulators();
        u.inputValidator(0, 0, 0);


    }

}