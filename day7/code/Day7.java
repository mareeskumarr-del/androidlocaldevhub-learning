package day7.code;


// import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
    String temp = "";
    int entryMin = 0;
    int entryMax = 0;
    double rate = 0;
    double quantity = 0;
    String before = "";
    String afterOverRide = "no";
    int overRideIndex = 0;


    Pattern pattern = Pattern.compile(
        "(\\d+)\\) Quantity: (\\d+\\.\\d+) \\| Rate: (\\d+\\.\\d+) \\| Total: (\\d+\\.\\d+)"
    );
    ArrayList<String> entryArrayList = new ArrayList<>();
    Path wPath = Paths.get(
        System.getProperty("user.dir"),
        "day5",
        "output",
        "day5_output.txt"
    );
    // ArrayList<String> entryArrayOverRideList = new ArrayList<>();



    void overRide(String afterOverRide,int count,int overRideIndex){


        try(Scanner scanner = new Scanner(System.in)){

            List<String> lines = Files.readAllLines(wPath);

            if(afterOverRide == "no" && count > 0){

                for(String line : lines){
                    this.entryArrayList.add(line);
                }
                for(int i = 0 ; i < lines.size() ; i++){
                        System.out.println(entryArrayList.get(i));
                }
                entryMax = this.entryArrayList.size();
                if (entryMax >= 1){
                    entryMin = 1;
                }

                System.out.println("Select Entry by Number that you need to edit ?\n" + "Min ->" +  entryMin + "\nMax ->" + entryMax);
                overRideIndex = scanner.nextInt();


                while((overRideIndex <= 0 || overRideIndex > entryMax)){
                    System.out.println("\nEntry Not Found .. Try again !\n");
                    System.out.println("Select Entry by Number that you need to edit ?\n" + "Min ->" +  entryMin + "\nMax ->" + entryMax);
                    overRideIndex = scanner.nextInt();
                }
                int idx = overRideIndex -1;
                // Matcher m = pattern.matcher(entryArrayList.get(idx));
                // System.out.println("index :" + idx + "\n");

                // if (m.matches()) {
                //     // idx = Integer.parseInt(m.group(1));
                //     quantity = Double.parseDouble(m.group(2));
                //     rate = Double.parseDouble(m.group(3));
                //     // entryCost = Double.parseDouble(m.group(4));
                // }

                System.out.println("Selected option is " + overRideIndex);
                before = entryArrayList.get(idx);
                System.out.println("\nStarting.. To Edit \n" + before);

                System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
                quantity = scanner.nextDouble();
                System.out.print("\n" + "Enter Milk Rate per liter  : ");
                rate = scanner.nextDouble();
                this.inputValidator(quantity, rate, true,overRideIndex);

            }else if(afterOverRide != "no" && count != 1){

                int idx = overRideIndex -1;
                // for(String line : lines ){
                //     System.out.println(line);    
                //     // this.entryArrayList.add(line);
                // }

                // System.out.println("index :" + idx + "Matcher" + this.entryArrayList.get(idx) + "\n");
                try {

                    if(idx < this.entryArrayList.size() ){

                        Matcher m = pattern.matcher(this.entryArrayList.get(idx));
                        if(m.find()){
                            this.entryArrayList.set(idx, m.replaceAll(
                                afterOverRide
                            ));
                            // lines.set(idx, afterOverRide);
                            // entryArrayList.set(idx, afterOverRide);
                        }
                    }
                }catch (Exception e){

                }
                Files.createDirectories(wPath.getParent());
                Files.write(wPath, new byte[0]);
                for(int i = 0 ; i < this.entryArrayList.size() ; i++){

                    afterOverRide = this.entryArrayList.get(i);

                    if(Files.exists(wPath)){

                        Files.writeString(
                            wPath,
                            this.entryArrayList.get(i) + "\n",
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                        );
                        if(i == idx){
                            System.out.println("\nWrited : " + afterOverRide + "\n" );
                        }

                    }

                }

                // System.out.println(m.group(1));
                // System.out.println(m.group(2));

                // System.out.println(wPath);
                // System.out.println("-------\n" + overRideRate);
                // System.out.println(overRideQuantity + "\n-------");


                before = entryArrayList.get(idx);

                System.out.println("After Edit : " + before);

                System.out.println("\n--- Entries ---\n");
                for(int i = 0 ; i < this.entryArrayList.size() ; i++){
                    System.out.println(this.entryArrayList.get(i));
                }

                this.finalSummary(true);
            }


        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Not Over writen");
        }

    }

    void finalSummary(boolean overRide){

        System.out.println("\n--- Entries ---\n");

        try {

           if(Files.exists(wPath)){   
                List<String> lines = Files.readAllLines(wPath);

                for (String line : lines) {
                    entryCount++;
                    // totalCost += numberCost;
                    // totalQuantity += numberQuantity;
                    //1) Quantity: 1.0 | Rate: 70.0 | Total: 70.0
                    Matcher m = pattern.matcher(line);
                    if (m.matches()) {
                        // int index = Integer.parseInt(m.group(1));
                        totalQuantity += Double.parseDouble(m.group(2));
                        // double rate = Double.parseDouble(m.group(3));
                        totalCost += Double.parseDouble(m.group(4));
                    }
                    this.entryArrayList.add(line);
                    // System.out.println(line);
                }

                for(int i = 0 ; i < lines.size() ; i++){
                    System.out.println(entryArrayList.get(i));
                }

                // this.overRide();

            }else{
            System.out.println("Files Not Exist");
            }


        } catch (Exception e) {
            System.out.println("Something happen.. when Reading File ");
            temp = "Something happen.. when Reading File ";
        }

        // System.out.println("\n--- Final Totals ---\n");
        // System.out.println("Total Quantity: " + totalQuantity + "\nTotal Amount: " + totalCost);
        // System.out.println(entryMin);
        // System.out.println(entryMax);
        // System.out.println("\n" + temp + "\n");

        if(overRide != false){
            System.out.println("\n\nUpdated Daily Summary\n");
            System.out.println("Total Quantity: " + totalQuantity + "\nTotal Deliveries: " + entryCount + "\nTotal Cost: " + totalCost + "\n\n");
            // System.out.println("\n---");
        }

    }


    void totalCost(double quantity, double rate,boolean overRide,int overRideIndex){

        entryCost = quantity * rate ;
        if(overRide != true){
            try {
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
            } catch (Exception e) {
                System.out.println("Something happen..");
                temp = "Something happen..";
            }

        }
        else if(overRide != false){


            afterOverRide = overRideIndex + ") Quantity: " + quantity + " | Rate: " + rate + " | Total: " + entryCost;
            this.overRide(afterOverRide,0,overRideIndex);

        }
    }


    void inputValidator(double quantity, double rate,boolean overRide,int overRideIndex){

        if(overRide != true){

            if ((quantity <=100 && quantity >=0.300 && rate >0 )) {
                this.totalCost(quantity,rate,false,0);
            }else if(!(quantity <=100 && quantity >=0.300) &&  (rate >0)) {
                System.out.println("Invalid Quantity try again..");
                System.out.println("Entry Rejected !");
            }else {
                System.out.println("Invalid Rate try again..");
                System.out.println("Entry Rejected !");
            }

        }

        if(overRide != false){

            if ((quantity <=100 && quantity >=0.300 && rate >0 )) {
                this.totalCost(quantity,rate,true,overRideIndex);
            }else if(!(quantity <=100 && quantity >=0.300) &&  (rate >0)) {
                System.out.println("Invalid Quantity ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(true);
            }else {
                System.out.println("Invalid Rate ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(true);
            }
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
                this.inputValidator(quantity, rate, false,0);

                while(done != 0 && done !=1) {

                    System.out.println("Invalid Entry Try Again..!\n");      
                    System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                    done = scanner.nextDouble();
                }   
            }
        }
    }    
}

public class Day7 {
    public static void main(String[] args) {
        Accumulators u = new Accumulators();
        // u.inputData();
        // u.finalSummary();
        u.overRide("no",1,0);
    }
}