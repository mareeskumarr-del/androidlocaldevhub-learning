package day13.code;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedWriter;
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

// Day 13 Java starter file
public class Day13 {
    public static void main(String[] args) {
        // System.out.println("Day 13: Start coding here");
            // Path wPath = Paths.get(
            // System.getProperty("user.dir"),
            // "day8",
            // "output",
            // "day8_records.txt");

        Accumulators u = new Accumulators();
        u.inputData();
        // try {
        // Thread.sleep(3000);
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // }
        // u.finalSummary(wPath,false, 0);
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
    double done = 0;
    int Deliveries = 0;
    LocalDate entryDate;
    boolean exit=false;
    String dailySummaryHeader = "\nDaily Report\n-------------\n";
    String dailySummaryBody = "";
    String dailySummaryFooter = "-------------\n" +
            "Total Entries: <count>\n" +
            "Total Quantity: <totalQuantity>\n" +
            "Total Cost: <totalCost>";

    // Pattern newPattern = Pattern.compile(
    // "(\\d+)\\) Quantity: (\\d+\\.\\d+) \\| Rate: (\\d+\\.\\d+) \\| Total:
    // (\\d+\\.\\d+)"
    // );

    Pattern newPattern = Pattern.compile(
            "ENTRY\n" +
                    "Quantity: (\\d+\\.\\d+)\n" +
                    "Rate: (\\d+\\.\\d+)\n" +
                    "Cost: (\\d+\\.\\d+)\n",
            Pattern.MULTILINE);

    
    // int day = 0;
    // int month = 0;
    // int year = 0;

   

    static Scanner sc = new Scanner(System.in);
    public static int getInt() {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // System.out.print("Invalid int.");
            }
        }
    }

    public static double getDouble() {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                // System.out.print("Invalid double.");
            }
        }
    }

    public static String getString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            // System.out.print("Empty string not allowed.");
        }
    }

    void getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        
        // while (true) {
            String input = sc.nextLine().trim();
            try {
                entryDate = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("\nInvalid date format\n");
                exit = true;
                // System.out.print("\nEnter Date of Entry (yyyy-MM-dd):  ");
            }
        // }
    }
    


    ArrayList<String> entryArrayList = new ArrayList<>();
    // Path wPath = Paths.get(
    //         System.getProperty("user.dir"),
    //         "day13",
    //         "data",
    //         entryDate+".txt");

    Path wPath = null;

    void loadData(){

        this.getDate();
        // day = today.getDayOfMonth();
        // month = today.getMonthValue();
        // year = today.getYear();
    
        // System.out.println("");

        if(exit != true){

            wPath = Paths.get(
                    System.getProperty("user.dir"),
                    "day13",
                    "data",
                    entryDate+".txt");
            done = 0;

            try {
                Files.createDirectories(wPath.getParent());
                if (!(Files.exists(wPath))) {
                    Files.createFile(wPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("failed to create file/directory");
            }


            try {


                if (Files.exists(wPath)) {

                    // while (done != 0 && done == 1) {
                    System.out.print("\n" + "Enter Milk quantity: \nmax:100\nmin: 0.300\n> ");
                    double quantity = Accumulators.getDouble();
                    System.out.print("\n" + "Enter Milk Rate per liter  : ");
                    double rate = Accumulators.getDouble();
                    // System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                    // done = scanner.nextDouble();
                    int now = (int) done;
                    // System.out.println(entryDate);
                    // while(done != 0 && done !=1) {

                    // System.out.println("Invalid Entry Try Again..!\n");
                    // System.out.print("\n" + "Add another entry?\n1.yes\n0.no > ");
                    // done = scanner.nextDouble();
                    // }
                    // }
                    this.inputValidator(quantity, rate, false, 0, now);

                } else {
                    System.out.println("\nData file not found\n");
                }
            } catch (Exception e) {

                System.out.println("unable to call scanner\n");

            }

        }



    }

    public void finalSummary(Path wPath,boolean overRide, int done) {

        if ((done != 1) && (overRide != true) && (done == 0)) {

            try {

                if (Files.exists(wPath)) {
                    List<String> lines = Files.readAllLines(wPath);
                    String entryPattern = String.join("\n", lines);
                    Deliveries = 0;
                    Matcher readLines = newPattern.matcher(entryPattern);
                    System.out.println("\n");

                    while (readLines.find()) {
                        entry = readLines.group();
                        entryArrayList.add(entry);
                        // System.out.println(readLines.groupCount());
                    }

                    for (int i = 0; i < entryArrayList.size(); i++) {
                        Matcher m = newPattern.matcher(entryArrayList.get(i));
                        // System.out.println("is: "+ this.entryArrayList.get(i));
                        if (m.find()) {

                            Deliveries++;
                            quantity = Double.parseDouble(m.group(1));
                            entryCost = Double.parseDouble(m.group(3));
                            // System.out.println(entryArrayList.get(i));
                            totalQuantity += quantity;
                            totalCost += entryCost;
                            dailySummaryBody += "Entry " + Deliveries + ": Quantity=" + quantity + ", Cost=" + entryCost
                                    + "\n";

                        }

                    }

                    if (Deliveries <= 0) {

                        dailySummaryBody += "No entries found\n...\n";
                    }

                    // Daily Report
                    // -------------
                    // Entry 1: Quantity=<q1>, Cost=<c1>
                    // Entry 2: Quantity=<q2>, Cost=<c2>
                    // ... // if no Entries found
                    // -------------
                    // Total Entries: <count>
                    // Total Quantity: <totalQuantity>
                    // Total Cost: <totalCost>

                    dailySummaryHeader = "\nDaily Report\n-------------\n";
                    // dailySummaryBody = "";
                    dailySummaryFooter = "-------------\n" +
                            "Total Entries: " + Deliveries + "\n" +
                            "Total Quantity: " + totalQuantity + "\n" +
                            "Total Cost: " + totalCost + "\n";

                    System.out.println(dailySummaryHeader + dailySummaryBody + dailySummaryFooter);

                } else {
                    System.out.println("\nData file not found");
                }

            } catch (Exception e) {
                System.out.println(e);
                testing = "Something happen.. when Reading File ";
            }
        }

        if ((overRide != false) && (done != 1)) {

            if (Files.exists(wPath)) {
                try {

                    if (entryMin != 0) {

                        // String dailySummary = "\n--- Daily Summary ---\n\nTotal Quantity: " +
                        // totalQuantity + "\nTotal Deliveries: " + entryCount + "\nTotal Amount: " +
                        // totalCost + "\n\n--- End Of Summary ---";
                        Files.write(wPath, new byte[0]);
                        for (int i = 0; i < entryArrayList.size(); i++) {
                            System.out.println(entryArrayList.get(i));
                            entry = entryArrayList.get(i);
                            Files.writeString(
                                    wPath,
                                    "\n" + afterOverRide + "\n",
                                    // StandardOpenOption.CREATE,
                                    StandardOpenOption.APPEND);
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    void totalCost(double quantity, double rate, boolean overRide, int overRideIndex, int done) {

        

        entryCost = quantity * rate;
        if (overRide != true) {
            try {

                if (Files.exists(wPath)) {

                    List<String> lines = Files.readAllLines(wPath);
                    entryCount = 0;
                    entryMax = 0;

                    String entryPattern = String.join("\n", lines);
                    Deliveries = 0;
                    Matcher m = newPattern.matcher(entryPattern);
                    while (m.find()) {
                        Deliveries++;
                        // int index = Integer.parseInt(m.group(1));
                        // totalQuantity += Double.parseDouble(m.group(1));
                        // double rate = Double.parseDouble(m.group(3));
                        // totalCost += Double.parseDouble(m.group(3));
                    }

                    String newEntry = "ENTRY\n" +
                            "Quantity: " + quantity + "\n" +
                            "Rate: " + rate + "\n" +
                            "Cost: " + entryCost + "\n\n";
                    entry = String.format(newEntry, quantity, rate, entryCost);
                    try (BufferedWriter writer = Files.newBufferedWriter(
                            wPath,
                            CREATE,
                            WRITE,
                            APPEND)) {
                        writer.write(entry);
                        writer.newLine();
                    } catch (Exception e) {
                        System.out.println("Unable to write on file\n");
                        System.err.println(e);

                    }

                    // Files.write(wPath, new byte[0]);

                    this.finalSummary(wPath,false, done);
                } else {

                    System.out.println("\nData file not found\n");

                }

            } catch (Exception e) {
                System.out.println("Something happen..");
                testing = "Something happen..";
            }

        } else if (overRide != false) {

            String newEntry = "ENTRY\n" +
                    "Quantity: " + quantity + "\n" +
                    "Rate: " + rate + "\n" +
                    "Cost: " + entryCost + "\n\n";
            afterOverRide = String.format(newEntry, quantity, rate, entryCost);

        }

    }

    void inputValidator(double quantity, double rate, boolean overRide, int overRideIndex, int done) {

        if (overRide != true) {

            if ((quantity <= 100 && quantity >= 0.300 && rate > 0)) {
                this.totalCost(quantity, rate, false, 0, done);
            } else if (!(quantity <= 100 && quantity >= 0.300) && (rate > 0)) {
                System.out.println("Invalid Quantity try again..");
                System.out.println("Entry Rejected !\n");
                this.finalSummary(wPath,overRide, done);

            } else {
                System.out.println("Invalid Rate try again..");
                System.out.println("Entry Rejected !\n");
                this.finalSummary(wPath,overRide, done);

            }

        }

        if (overRide != false) {

            if ((quantity <= 100 && quantity >= 0.300 && rate > 0)) {
                this.totalCost(quantity, rate, true, overRideIndex, done);
            } else if (!(quantity <= 100 && quantity >= 0.300) && (rate > 0)) {
                System.out.println("Invalid Quantity ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(wPath,true, 0);
            } else {
                System.out.println("Invalid Rate ..");
                System.out.println("Entry Rejected !");
                this.finalSummary(wPath,true, 0);
            }
        }

    }

    void inputData() {

        // default
        // rate = 71.1;
        // quantity = 5.2;


        System.out.print("\nEnter Date of Entry (yyyy-MM-dd):  ");
        this.loadData();
    }
}
