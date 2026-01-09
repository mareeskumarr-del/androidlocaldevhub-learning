# Day 12 — Daily Report Generation (Full Audit View)

## 1. Today’s Build Tasks

### Task A — Create Day12.java

Create a file named:

```
Day12.java
```

Program requirements:

* Use the same persisted data file used in Day 8–11
* Read the file sequentially from top to bottom
* Parse and preserve **all valid ENTRY records** in memory
* Preserve original insertion order
* Do not compute totals while reading

---

### Task B — Structured Report Generation

After loading all valid entries, generate a **full daily report**.

The report must include:

1. Header
2. Each individual entry printed in order
3. Final aggregated totals derived strictly from stored entries

Print exactly in this structure:

```
Daily Report
-------------
Entry 1: Quantity=<q1>, Cost=<c1>
Entry 2: Quantity=<q2>, Cost=<c2>
...
-------------
Total Entries: <count>
Total Quantity: <totalQuantity>
Total Cost: <totalCost>
```

Rules:

* Entry numbering starts at 1
* Totals must be computed only after all entries are loaded
* No rounding unless already present in stored values

---

### Task C — Defensive Handling

Ensure:

* Malformed entries are skipped silently
* Order of valid entries is preserved
* Empty file prints only header + totals (zeros)

If file is missing, print exactly:

```
Data file not found
```

And terminate.

---

### Task D — Save Output

* Run the program with a file containing multiple valid entries
* Save terminal output into:

```
output/day12_output.txt
```

---

## 2. Learning Resources

Topics:

* Report-style output formatting
* Separating data loading from presentation
* Deterministic reporting
* Audit-friendly system views

---

## 3. Setup Checklist

Compile:

```
javac Day12.java
```

Run:

```
java Day12
```

Verify:

* All entries appear in correct order
* Totals match manual calculation
* Output format matches exactly

---

## 4. End-of-Day Output Requirement

Required files:

```
Day12.java
day12_output.txt
```

Save terminal output to:

```
output/day12_output.txt
```

---

## 5. Commit Message

```
Day 12: Generated full daily report with ordered entries and audited totals
```
