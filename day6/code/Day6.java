import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Accumulators {

    double totalCost = 0;
    double totalQuantity = 0;
    boolean valid = false;
    double entryCost = 0;
    int entryCount = 0;
    String temp ="";



    // ArrayList<Double> totalQuantityArrayList = new ArrayList<>();
    // ArrayList<Double> totalCostArrayList = new ArrayList<>();

    // ArrayList<Double> quantityArrayList = new ArrayList<>();
    // ArrayList<Double> rateArrayList = new ArrayList<>();

    // ArrayList<String> entryArrayList = new ArrayList<>();
    // ArrayList<String> finalTotalArrayList = new ArrayList<>(); 
    // ArrayList<String> headingArrayList = new ArrayList<>();


    void finalSummary(){

        // int len = entryArrayList.size();

        // System.out.println("\n--- Entries ---\n");

        // for(int i = 0; i < len;i++){

        //     System.out.println(entryArrayList.get(i));
        // }
        try {

            Path wPath = Paths.get(
                System.getProperty("user.dir"),
                "day5",
                "output",
                "day5_output.txt"
            );
           if(Files.exists(wPath)){
               List<String> lines = Files.readAllLines(wPath);

              
           
               for (String line : lines) {   
                    
                    Pattern pattern = Pattern.compile(
                    "(\\d+)\\) Quantity: (\\d+\\.\\d+) \\| Rate: (\\d+\\.\\d+) \\| Total: (\\d+\\.\\d+)"
                    );
                    Matcher m = pattern.matcher(line);
                  

                    // totalCost += numberCost;
                    // totalQuantity += numberQuantity;
                    //1) Quantity: 1.0 | Rate: 70.0 | Total: 70.0
                    

                    
                    if (m.matches()) {
                        int number = Integer.parseInt(m.group(1));
                        entryCount = Math.max(entryCount, number);

                        // int index = Integer.parseInt(m.group(1));
                        totalQuantity += Double.parseDouble(m.group(2));
                        totalCost += Double.parseDouble(m.group(4));
                        // double rate = Double.parseDouble(m.group(3));
                    }


                    // System.out.println(line);
                
                }    
            }else{
            // System.out.println("Files Not Exist");
            System.out.println("not there");
            } 
        } catch (Exception e) {
            // System.out.println("Something happen.. when Reading File ");
            // temp = "Something happen.. when Reading File ";
        }

        System.out.println("\n\n--- Daily Summary ---\n");
        System.out.println("Total Quantity: " + totalQuantity + "\nTotal Deliveries: " + entryCount + "\nTotal Amount: " + totalCost + "\n\n");
        // System.out.println("\n---");

        // System.out.println("\n" + temp + "\n");


    }


    void totalCost(double quantity, double rate){

        entryCost = quantity * rate ;
        // if(entryCost >=0 && valid == true && rate != 0){

        //     totalQuantity += quantity;
        //     totalCost += entryCost; 
        //     this.totalQuantityArrayList.add(totalQuantity);
        //     this.totalCostArrayList.add(totalCost);     
        //     // this.entryArrayList.add( entryCount+1 + ") " + "Quantity : " + quantityArrayList.get(entryCount) + " | " + "Rate: " + rateArrayList.get(entryCount) + " | " + "Total: " + totalCostArrayList.get(entryCount));
        //     this.entryArrayList.add( entryCount+1 + ") " + "Quantity : " + quantityArrayList.get(entryCount) + " | " + "Rate: " + rateArrayList.get(entryCount) + " | " + "Total: " + entryCost);
        // entryCount++;
        // }else {

        //     System.out.println("Invalid Rate");
        // }
        // temp = "nothing da";

        
        try {

            Path wPath = Paths.get(
                System.getProperty("user.dir"),
                "day5/output/day5_output.txt"
            );

            

            if(Files.exists(wPath)){

                List<String> lines = Files.readAllLines(wPath);
       
                for (String line : lines) {
                    int idx = line.indexOf(")");
                    if(idx > 0){

                        String numPart = line.substring(0, idx);
                        int number = Integer.parseInt(numPart.trim());
                        entryCount = Math.max(entryCount, number);
                    }
                }
                entryCount++;
                Files.createDirectories(wPath.getParent());
                Files.writeString(
                wPath,
                entryCount + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost + "\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
                );  


            }else{
                entryCount++;
                System.out.println("Files Not Exist");
                Files.createDirectories(wPath.getParent());
                Files.writeString(
                wPath,
                entryCount + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost + "\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
                );  
                System.out.println("Files Created Now..!");
            }


                  

            // if (Files.exists(path)) {
            //     System.out.println("File exists");
            //     System.out.println("Written Success");
            // }else{

            //     System.out.println("NO files Here");
            //     temp = "No File";
            // }
        
            
            
        } catch (Exception e) {
            System.out.println("Something happen..");
            temp = "Something happen..";
        }

    }


    void inputValidator(double quantity, double rate){

        if ((quantity <=100 && quantity >=0.300 && rate >0 )) {

            // quantityArrayList.add(quantity);
            // this.rateArrayList.add(rate);
            // this.totalCost(quantity,rate,true,done);
            
            this.totalCost(quantity,rate);
            
        }else if(!(quantity <=100 && quantity >=0.300) &&  (rate >0)) {

            System.out.println("Invalid Quantity try again..");
            System.out.println("Entry Rejected !");
        }else {
            System.out.println("Invalid Rate try again..");
            System.out.println("Entry Rejected !");
        }

    }

    void inputData(){

        try(Scanner scanner = new Scanner(System.in)){

            // default
            // rate = 71.1;
            // quantity = 5.2;
            double done = 1 ;

            while (done != 0 && done == 1) {
                System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
                double quantity = scanner.nextDouble();
                System.out.print("\n" + "Enter Milk Rate per liter  : ");
                double rate = scanner.nextDouble();
                System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                done = scanner.nextDouble();
                this.inputValidator(quantity, rate);

                while(done != 0 && done !=1) {

                    System.out.println("Invalid Entry Try Again..!\n");      
                    System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                    done = scanner.nextDouble();
                }   
                
            }
        }

    }
        
}


public class Day6 {

    public static void main(String[] args) {


        Accumulators u = new Accumulators();
        // u.inputValidator(0, 0);
        u.finalSummary();




    }

}