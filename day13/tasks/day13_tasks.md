### Task A — Create Day13.java
Create a file named:
```
Day13.java
```
Program requirements:
* Introduce **date-based storage**
* Each day’s data must be stored in a **separate file**
* File naming must be **deterministic**
Required file name format:
```
data/YYYY-MM-DD.txt
```
Example:
```
data/2025-01-13.txt
```
The program must:
* Ask the user for a date (`YYYY-MM-DD`)
* Use this date to determine the file to read/write
* Create the file if it does not exist
---
### Task B — Append Entries to a Specific Day
For the selected date:
* Append delivery entries in the same ENTRY format used earlier
* Each entry must include:
  * Quantity
  * Cost
Rules:
* Never overwrite existing files
* Never mix entries from different dates
* Same date → same file → deterministic behavior
---
### Task C — Daily File Integrity
Ensure:
* Only entries for the selected date are written to that file
* Reading a date loads **only that date’s records**
* File structure is consistent across all days
If the date format is invalid, print exactly:
```
Invalid date format
```
And terminate.
---
### Task D — Save Output
* Run the program for at least **two different dates**
* Append multiple entries to each date
* Save terminal output into:
```
output/day13_output.txt
```
---

---
Previous: day12  |  Next: day14
