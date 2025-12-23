# Day 5 — In-Memory Records and Structured Entries

## 1. Today’s Build Tasks

### Task A — Create Day5.java

Create a file named:

```
Day5.java
```

Program requirements:

- Use a loop to accept **multiple milk entries**
  
- For each entry, collect:
  
  - Quantity (double)
    
  - Rate (double)
    
  - Total (computed)
    
- Store **each entry in memory** using:
  
  - arrays **or**
    
  - `ArrayList`
    

---

### Task B — Structured Record Output

After input ends, print **all stored entries in order**:

```
--- Entries ---
1) Quantity: <q> | Rate: <r> | Total: <t>
2) Quantity: <q> | Rate: <r> | Total: <t>
...
```

Order must exactly match input order.

---

### Task C — Final Aggregates (Derived Only)

After listing entries, print:

```
--- Final Totals ---
Total Quantity: <totalQuantity>
Total Amount: <totalAmount>
```

Rules:

- Totals **must be derived from stored records**
  
- No parallel counters during input
  
- No recalculation shortcuts
  

---

## 2. Determinism Rules (Mandatory)

- Same inputs in same order → identical output
  
- All summaries derived from in-memory data
  
- No extra prints before or after summary
  

---

## 3. Setup Checklist

Compile:

```
javac Day5.java
```

Run:

```
java Day5
```

Verify:

- All entries are stored
  
- Output order is deterministic
  
- Totals match summed records
  
- No data loss
  

---

## 4. End-of-Day Output Requirement

Required files:

```
Day5.java
output/day5_output.txt
```

Save **one full session with 3+ entries** to:

```
output/day5_output.txt
```

---

## 5. Commit Message

```
Day 5: Stored multiple milk entries in memory and generated structured summaries
```
