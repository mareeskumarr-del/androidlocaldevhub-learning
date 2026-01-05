# Day 9 — File Persistence (Read)

## 1. Today’s Build Tasks

### Task A — Create Day9.java

Create a file named:

```
Day9.java
```

Program requirements:

* Read the data file created in Day 8
* File path must be fixed and deterministic (no user input for path)
* Read the file line by line
* Print each record exactly as read (no modification, no recalculation)

---

### Task B — Parse Summary Section

* Identify the summary section written at the end of the file
* Extract:

  * Total quantity
  * Total deliveries
  * Total cost
* Print the summary again after reading, exactly in this format:

```
Daily Summary
Total Quantity: <totalQuantity>
Total Deliveries: <totalDeliveries>
Total Cost: <totalCost>
```

(No recomputation — values must come from file)

---

### Task C — Validate Integrity

* Ensure:

  * Order of records is preserved
  * No lines are skipped
  * Summary values match the file content
* If file is missing, print exactly:

```
Data file not found
```

---

### Task D — Save Output

* Run the program using the file generated in Day 8
* Save terminal output into:

```
output/day9_output.txt
```

---

## 2. Learning Resources

Topics:

* File reading in Java (FileReader / BufferedReader)
* Line-by-line parsing
* Data integrity validation
* Separating computation from persistence

---

## 3. Setup Checklist

Compile:

```
javac Day9.java
```

Run:

```
java Day9
```

Verify:

* File is read successfully
* Printed records exactly match file
* Summary values are read, not recalculated
* Error handling works if file is missing

---

## 4. End-of-Day Output Requirement

Required files:

```
Day9.java
day9_output.txt
```

Save terminal output to:

```
output/day9_output.txt
```

---

## 5. Commit Message

```
Day 9: Implemented deterministic file read and summary restoration
```
