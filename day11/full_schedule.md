# Day 11 — File Persistence (Rebuild Summary)

## 1. Today’s Build Tasks

### Task A — Create Day11.java

Create a file named:

```
Day11.java
```

Program requirements:

* Use the same fixed data file path used in Day 8–10
* Read the entire file line by line
* Identify all `ENTRY` blocks
* From each entry, extract:

  * Quantity
  * Cost

Do NOT trust any existing summary in the file.

---

### Task B — Recompute Summary

Using only the extracted entries:

* Recalculate:

  * Total Quantity
  * Total Deliveries (number of ENTRY blocks)
  * Total Cost

After computation, print exactly:

```
Daily Summary
Total Quantity: <totalQuantity>
Total Deliveries: <totalDeliveries>
Total Cost: <totalCost>
```

This summary must be computed fresh every run.

---

### Task C — Validation Rules

Ensure:

* Only valid ENTRY blocks are counted
* Partial or malformed entries are ignored
* Order of reading does not affect totals

If file is missing, print exactly:

```
Data file not found
```

And terminate.

---

### Task D — Save Output

* Run the program using a file that contains multiple appended entries
* Save terminal output into:

```
output/day11_output.txt
```

---

## 2. Learning Resources

Topics:

* Stateful file parsing
* Defensive parsing logic
* Separating stored data from derived data
* Rebuilding system state from persistence

---

## 3. Setup Checklist

Compile:

```
javac Day11.java
```

Run:

```
java Day11
```

Verify:

* Totals match manual calculation
* Delivery count equals ENTRY count
* No duplication or carryover from previous runs

---

## 4. End-of-Day Output Requirement

Required files:

```
Day11.java
day11_output.txt
```

Save terminal output to:

```
output/day11_output.txt
```

---

## 5. Commit Message

```
Day 11: Rebuilt daily summary by parsing persisted delivery records
```
