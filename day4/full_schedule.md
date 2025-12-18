# Day 4 — Session Aggregation and Daily Summary

## 1. Today’s Build Tasks

### Task A — Create Day4.java

Create a file named:

```
Day4.java
```

Program requirements:

- Use a loop to accept multiple milk entries
  
- For each entry, ask:
  
  - Milk quantity (double)
    
  - Rate per liter (double)
    
- After each entry, ask:
  
  ```
  Add another entry? (yes/no)
  ```
  
- Loop continues only if user enters `yes`
  

---

### Task B — Aggregate Data

During the session, track:

- Total quantity (double)
  
- Total cost (double)
  

For each entry:

```
entryCost = quantity * rate
```

Accumulate:

```
totalQuantity += quantity
totalCost += entryCost
```

---

### Task C — Print Daily Summary

When user exits the loop, print exactly:

```
Daily Summary
Total Quantity: <totalQuantity>
Total Cost: <totalCost>
```

---

### Task D — Save Output

- Run the program with at least 3 entries
  
- Save terminal output into:
  

```
output/day4_output.txt
```

---

## 2. Learning Focus

- `while` loop
  
- Accumulators
  
- Session-based logic
  
- Deterministic summaries
  

---

## 3. Setup Checklist

Compile:

```
javac Day4.java
```

Run:

```
java Day4
```

Verify:

- Loop behaves correctly
  
- Totals are accurate
  
- Output format matches exactly
  

---

## 4. End-of-Day Output Requirement

Required files:

```
Day4.java
day4_output.txt
```

Save terminal output to:

```
output/day4_output.txt
```

---

## 5. Commit Message

```
Day 4: Implemented session-based aggregation and daily summary
```
