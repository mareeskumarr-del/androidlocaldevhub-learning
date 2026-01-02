# Day 7 — Correction & Adjustment

## 1. Today’s Build Tasks

### Task A — Edit an Entry by Index

Create a file named:

```
Day7.java
```

Program requirements:

- Use the in-memory records from Day 5
  
- Display all existing records with their index numbers
  
- Ask the user to select a record by index
  
- Allow editing of:
  
  - Milk quantity
  - Rate per liter
- Update the selected record in memory
  

---

### Task B — Recompute Totals

- After editing, recompute **all totals** by iterating over stored records:
  
  - Total milk quantity (double)
  - Total deliveries
  - Total cost (double)
- Do not reuse old totals
  
- No silent mutation allowed
  

---

### Task C — Print Updated Daily Summary

After recomputation, print exactly:

```
Updated Daily Summary
Total Quantity: <totalQuantity>
Total Deliveries: <totalDeliveries>
Total Cost: <totalCost>
```

Values must reflect the updated records accurately.

---

### Task D — Save Output

- Run the program with at least 3 initial records
- Perform at least 1 edit operation
- Save terminal output into:

```
output/day7_output.txt
```

---

## 2. Learning Resources

Topics:

- ArrayList index-based access
- Updating structured records
- Full recomputation vs incremental update
- Deterministic correction logic

---

## 3. Setup Checklist

Compile:

```
javac Day7.java
```

Run:

```
java Day7
```

Verify:

- Correct record is edited
- Totals update correctly after edit
- Output format matches exactly

---

## 4. End-of-Day Output Requirement

Required files:

```
Day7.java
day7_output.txt
```

Save terminal output to:

```
output/day7_output.txt
```

---

## 5. Commit Message

```
Day 7: Added record correction by index with deterministic total recomputation
```
