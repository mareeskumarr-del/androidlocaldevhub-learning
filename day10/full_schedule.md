# Day 10 — File Persistence (Append & Structured Records)

## 1. Today’s Build Tasks

### Task A — Create Day10.java

Create a file named:

```
Day10.java
```

Program requirements:

* Use the **same fixed file path** used in Day 8 and Day 9
* Do NOT overwrite existing data
* Open the file in **append mode**
* Add a new delivery record in this exact format:

```
ENTRY
Quantity: <quantity>
Rate: <rate>
Cost: <cost>
```

Values must be taken from user input.

---

### Task B — Controlled Input

Ask the user for:

* Milk quantity (double)
* Rate per liter (double)

Calculate:

```
cost = quantity * rate
```

Append **only one entry per run**.

No loops today.

---

### Task C — Preserve File Integrity

Ensure:

* Existing records remain unchanged
* New entry is added **after** previous content
* Summary section (if present) is NOT modified or duplicated

If file does not exist, print exactly:

```
Data file not found
```

And terminate.

---

### Task D — Save Output

* Run the program twice to confirm appending works
* Save terminal output into:

```
output/day10_output.txt
```

---

## 2. Learning Resources

Topics:

* FileWriter append mode
* Data persistence vs overwrite
* Record-based file design
* Preventing accidental data loss

---

## 3. Setup Checklist

Compile:

```
javac Day10.java
```

Run:

```
java Day10
```

Verify:

* File grows with each run
* Old data is preserved
* New entry format is exact
* Error handling works correctly

---

## 4. End-of-Day Output Requirement

Required files:

```
Day10.java
day10_output.txt
```

Save terminal output to:

```
output/day10_output.txt
```

---

## 5. Commit Message

```
Day 10: Implemented append-only file persistence with structured records
```
