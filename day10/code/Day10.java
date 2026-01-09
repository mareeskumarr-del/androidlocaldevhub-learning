package day10.code;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedWriter;
import java.io.IOException;
// import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {
    public static void main(String[] args){


        Accumulators u = new Accumulators();
        u.inputData();

        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     Thread.currentThread().interrupt();
        // }

        // u.finalSummary(false,0);
        // u.overRide("no",1,0,0); Removed
    }
}


class Accumulators {

    double totalCost = 0;
    double totalQuantity = 0;
    boolean valid = false;
    double entryCost = 0;
    int entryCount = 0;
    String testing = "";
    int entryMin = 0;
    int entryMax = 0;
    double rate = 0;
    double quantity = 0;
    String before = "";
    String afterOverRide = "no";
    int overRideIndex = 0;
    String entry = "";
    double done = 0 ;
    int Deliveries = 0;
    String dailySummary = "";

    // Pattern newPattern = Pattern.compile(
        // "(\\d+)\\) Quantity: (\\d+\\.\\d+) \\| Rate: (\\d+\\.\\d+) \\| Total: (\\d+\\.\\d+)"
    // );


    Scanner scanner = new Scanner(System.in);
    Pattern newPattern = Pattern.compile(
        "ENTRY\n"+
        "Quantity: (\\d+\\.\\d+)\n"+
        "Rate: (\\d+\\.\\d+)\n" +
        "Cost: (\\d+\\.\\d+)\n",
        Pattern.MULTILINE
    );

                    


    // "\n--- Daily Summary ---\n\nTotal Quantity: " + totalQuantity + "\nTotal Deliveries: " + entryCount + "\nTotal Amount: " + totalCost + "\n\n--- End Of Summary ---";
    // Pattern quantityPattern = Pattern.compile(
    //     "Total Quantity: (\\d+\\.\\d+)"
    // );
    // Pattern deliveryPattern = Pattern.compile(
    //     "Total Deliveries: (\\d+)"
    // );
    // Pattern costPattern = Pattern.compile(
    //     "Total Amount: (\\d+\\.\\d+)"
    // );



    ArrayList<String> entryArrayList = new ArrayList<>();
    Path wPath = Paths.get(
        System.getProperty("user.dir"),
        "day8",
        "output",
        "day8_records.txt"
    );


    void finalSummary(boolean overRide,int done){


        if((done != 1) && (overRide != true) && (done == 0) ){


            try {

               if(Files.exists(wPath)){ 
                    List<String> lines = Files.readAllLines(wPath);
                    String entryPattern = String.join("\n", lines);
                    Deliveries = 0;
                    Matcher m = newPattern.matcher(entryPattern);
                    while(m.find()) {
                        Deliveries++;
                        // this.entryArrayList.add(m.group());
                        // int index = Integer.parseInt(m.group(1));
                        totalQuantity += Double.parseDouble(m.group(1));
                        // double rate = Double.parseDouble(m.group(3));
                        totalCost += Double.parseDouble(m.group(3));
                        System.out.println(m.group());

                    }
                    dailySummary ="\nDaily Summary\nTotal Quantity: " + totalQuantity +"\nTotal Deliveries: " + Deliveries + "\nTotal Cost: " + totalCost;
                    System.out.println(dailySummary);

                }else{
                    System.out.println("\nData file not found");
                }


            } catch (Exception e) {
                System.out.println(e);
                testing = "Something happen.. when Reading File ";
            }
        }

        if((overRide != false) && (done != 1)){

            

            if(Files.exists(wPath)){   
                try {

                    if(entryMin != 0){                        
                        
                        // String dailySummary = "\n--- Daily Summary ---\n\nTotal Quantity: " + totalQuantity + "\nTotal Deliveries: " + entryCount + "\nTotal Amount: " + totalCost + "\n\n--- End Of Summary ---";
                        Files.write(wPath, new byte[0]);
                        for(int i = 0 ; i < entryArrayList.size() ; i++){
                            System.out.println(entryArrayList.get(i)); 
                            entry = entryArrayList.get(i);
                            Files.writeString(
                                wPath,
                                "\n"+ afterOverRide +"\n",
                                // StandardOpenOption.CREATE,
                                StandardOpenOption.APPEND
                            );  
                        }
                    
                    }
                
                
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }


    void totalCost(double quantity, double rate,boolean overRide,int overRideIndex,int done){

        entryCost = quantity * rate ;
        if(overRide != true){
            try {
                
                if(Files.exists(wPath)){

                    List<String> lines = Files.readAllLines(wPath);
                    entryCount = 0;
                    entryMax = 0;

                    String entryPattern = String.join("\n", lines);
                    Deliveries = 0;
                    Matcher m = newPattern.matcher(entryPattern);
                    while(m.find()) {
                        Deliveries++;
                        // int index = Integer.parseInt(m.group(1));
                        // totalQuantity += Double.parseDouble(m.group(1));
                        // double rate = Double.parseDouble(m.group(3));
                        // totalCost += Double.parseDouble(m.group(3));
                    }


                    // for (String line : lines) {
                    //     Matcher m = newPattern.matcher(line);
                    //     if (m.matches()) {
                    //         this.entryArrayList.add(line);
                    //         entryMax++;
                    //         int index = Integer.parseInt(m.group(1));
                    //         totalQuantity += Double.parseDouble(m.group(2));
                    //         double rate = Double.parseDouble(m.group(3));
                    //         totalCost += Double.parseDouble(m.group(4));
                    //     }

                    //     int idx = line.indexOf(")");
                    //     if(idx > 0){
                    //         String numPart = line.substring(0, idx);
                    //         int number = Integer.parseInt(numPart.trim());
                    //         entryCount = Math.max(entryCount, number);
                    //     }

                    // }

                    String newEntry =
                    "ENTRY\n"+
                    "Quantity: "+ quantity +"\n"+
                    "Rate: "+ rate +"\n" +
                    "Cost: "+ entryCost +"\n\n";
                    entry = String.format(newEntry,quantity,rate,entryCost); 
                    // String path  = wPath.toString(); 
                    
                    // System.out.println(path);
                    try (BufferedWriter writer =
                    Files.newBufferedWriter(
                                wPath,
                                CREATE,
                                WRITE,
                                APPEND
                            )) {
                        writer.write(entry);
                        writer.newLine();
                    }catch(Exception e){
                        System.out.println("Unable to write on file\n");
                        System.err.println(e);    
                    
                    }
                        
                    // entryCount++;
                    // entry = entryCount + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost;
                    // this.entryArrayList.add(entry);
                    // Files.createDirectories(wPath.getParent());
                    // Files.writeString(
                    // wPath,
                    // entryCount + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost + "\n",
                    // StandardOpenOption.CREATE,
                    // StandardOpenOption.APPEND
                    // );

                    // Files.write(wPath, new byte[0]);
                    // for(int i = 0; i < entryArrayList.size(); i++){

                    // Files.writeString(
                    // wPath,
                    // entryArrayList.get(i) + "\n",
                    // StandardOpenOption.CREATE,
                    // StandardOpenOption.APPEND
                    // );
                    // }
                    
                    this.finalSummary(false, done);
                }else{
                    // entryCount++;
                    // System.out.println("Files Not Exist");
                    // Files.createDirectories(wPath.getParent());
                    // Files.writeString(
                    // wPath,
                    // entryCount + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost + "\n\n",
                    // StandardOpenOption.CREATE,
                    // StandardOpenOption.APPEND
                    // );  
                    // System.out.println("Files Created Now..!");
                    // this.finalSummary(false, done);
                    System.out.println("\nData file not found\n");

                }  

                
            }catch (Exception e) {
                System.out.println("Something happen..");
                testing = "Something happen..";
            }

        }
        else if(overRide != false){

            String newEntry =
            "ENTRY\n"+
            "Quantity: "+ quantity +"\n"+
            "Rate: "+ rate +"\n" +
            "Cost: "+ entryCost +"\n\n";
            afterOverRide = String.format(newEntry,quantity,rate,entryCost);      
            // afterOverRide = overRideIndex + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost;
            // this.overRide(afterOverRide,0,overRideIndex,done);

        }
       
    }


    void inputValidator(double quantity, double rate,boolean overRide,int overRideIndex,int done){

        if(overRide != true){

            if ((quantity <=100 && quantity >=0.300 && rate >0 )) {
                this.totalCost(quantity,rate,false,0,done);
            }else if(!(quantity <=100 && quantity >=0.300) &&  (rate >0)) {
                System.out.println("Invalid Quantity try again..");
                System.out.println("Entry Rejected !\n");
                this.finalSummary(overRide, done);

            }else {
                System.out.println("Invalid Rate try again..");
                System.out.println("Entry Rejected !\n");
                this.finalSummary(overRide, done);

            }

        }

        if(overRide != false){

            if ((quantity <=100 && quantity >=0.300 && rate >0 )) {
                this.totalCost(quantity,rate,true,overRideIndex,done);
            }else if(!(quantity <=100 && quantity >=0.300) &&  (rate >0)) {
                System.out.println("Invalid Quantity ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(true,0);
            }else {
                System.out.println("Invalid Rate ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(true,0);
            }
        }

    }

    void inputData(){
        
        try{
        
            // default
            // rate = 71.1;
            // quantity = 5.2;
            done = 0 ;

            if(Files.exists(wPath)){

                // while (done != 0 && done == 1) {
                System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
                double quantity = scanner.nextDouble();
                System.out.print("\n" + "Enter Milk Rate per liter  : ");
                double rate = scanner.nextDouble();
                // System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                // done = scanner.nextDouble();
                int now = (int) done;            
                // while(done != 0 && done !=1) {

                //     System.out.println("Invalid Entry Try Again..!\n");      
                //     System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                //     done = scanner.nextDouble();
                // }  
                // }
                this.inputValidator(quantity, rate, false,0,now);  


            }else {
                System.out.println("\nData file not found\n");
            }
        }catch(Exception e){

            System.out.println("unable to call scanner\n");

        }
    }    
}
