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

---
Previous: day8  |  Next: day10
