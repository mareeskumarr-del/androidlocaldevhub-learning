### Task A — Create Day14.java
Create a file named:
```
Day14.java
```
Program requirements:
* Read **multiple daily data files** from the `data/` directory
* Each file follows the format created in Day 13
* Process files in **deterministic order** (sorted by date name, ascending)
* Do not assume files exist for every date
---
### Task B — Aggregate Across Days
From all valid daily files:
* Parse all valid ENTRY records
* Preserve **per-day boundaries**
* Do not modify stored files
For each day, compute:
* Total Entries
* Total Quantity
* Total Cost
Then compute **grand totals** across all days.
---
### Task C — Print Multi-Day Report
Print exactly in this structure:
```
Multi-Day Report
================
Date: YYYY-MM-DD
Entries: <count>
Total Quantity: <quantity>
Total Cost: <cost>
----------------
(repeat per date)
================
Grand Total Entries: <grandCount>
Grand Total Quantity: <grandQuantity>
Grand Total Cost: <grandCost>
```
Rules:
* Dates must appear in sorted order
* Totals must be derived only from parsed entries
* Malformed entries are skipped silently
* Empty `data/` directory prints zero totals
If `data/` directory does not exist, print exactly:
```
Data directory not found
```
And terminate.
---
### Task D — Save Output
* Run the program with **at least two daily files present**
* Save terminal output into:
```
output/day14_output.txt
```
---

---
Previous: day13  |  Next: day15
