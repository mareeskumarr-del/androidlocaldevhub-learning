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

---
Previous: day3  |  Next: day5
