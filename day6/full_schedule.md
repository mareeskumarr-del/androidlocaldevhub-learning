# Day 6 — Daily Aggregation Logic

## 1. Today’s Build Tasks

### Task A — Aggregate Records

Create a file named:

```
Day6.java
```

Program requirements:

- Use the in-memory records created in Day 5 (ArrayList or arrays)
  
- Traverse all stored records
  
- Calculate:
  
  - Total milk quantity (double)
  - Total cost (double)
- Aggregation must be derived **only** from stored records (no recalculation during input)
  

---

### Task B — Count Entries

- Count total number of records entered for the day
- Store this value as total deliveries
- Preserve insertion order of records

---

### Task C — Print Daily Summary

After aggregation, print exactly:

```
Daily Summary
Total Quantity: <totalQuantity>
Total Deliveries: <totalDeliveries>
Total Cost: <totalCost>
```

Values must reflect **all stored records** accurately.

---

### Task D — Save Output

- Run the program with at least 3 stored records
- Save terminal output into:

```
output/day6_output.txt
```

---

## 2. Learning Resources

Topics:

- ArrayList traversal
- Accumulator variables
- Deterministic aggregation
- Deriving totals from stored state

---

## 3. Setup Checklist

Compile:

```
javac Day6.java
```

Run:

```
java Day6
```

Verify:

- Totals are correct
- Entry count matches number of records
- Output format matches exactly

---

## 4. End-of-Day Output Requirement

Required files:

```
Day6.java
day6_output.txt
```

Save terminal output to:

```
output/day6_output.txt
```

---

## 5. Commit Message

```
Day 6: Implemented deterministic daily aggregation from in-memory records
```
