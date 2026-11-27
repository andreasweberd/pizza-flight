# Pizza Flight — Database & SQL Learning Project

Welcome to **Pizza Flight**!

In this multi-step project, you will design and query a database for a fictional 24/7 **automated pizza vending machine** company called **Pizza Flight**. Their smart vending machines are installed at train stations, universities, and airports, baking fresh pizzas on demand in about three minutes.

You will progress step by step — from modeling the ordering workflow, to designing an Entity-Relationship Model (ERM) and a Relational Model, and finally to writing real SQL queries against an H2 database in **DBeaver**.

---

## Project Roadmap

| # | Folder | Topic | Submission |
|---|--------|-------|------------|
| 1 | [`task-01-flowchart/`](task-01-flowchart/TASK.md) | Program Flowchart | Hand-drawn photo (`.jpg` / `.png`) |
| 2 | [`task-02-erm/`](task-02-erm/TASK.md) | Entity-Relationship Model (Chen Notation) | Hand-drawn photo (`.jpg` / `.png`) |
| 3 | [`task-03-relational-model/`](task-03-relational-model/TASK.md) | Relational Model (Tables, PKs, FKs) | Hand-drawn photo (`.jpg` / `.png`) |
| 4 | [`task-04-sql-basics/`](task-04-sql-basics/TASK.md) | Basic SQL Queries (`SELECT`, `WHERE`, `ORDER BY`) | `solutions.sql` |
| 5 | [`task-05-sql-joins/`](task-05-sql-joins/TASK.md) | SQL Joins (`INNER JOIN`, `LEFT JOIN`) | `solutions.sql` |
| 6 | [`task-06-sql-aggregations/`](task-06-sql-aggregations/TASK.md) | Aggregations & Grouping (`GROUP BY`, `HAVING`) | `solutions.sql` |
| 7 | [`task-07-sql-crud/`](task-07-sql-crud/TASK.md) | CRUD Operations (`INSERT`, `UPDATE`, `DELETE`) | `solutions.sql` |
| 8 | [`task-08-sql-ddl/`](task-08-sql-ddl/TASK.md) | DDL & Constraints (`CREATE TABLE`, `ALTER TABLE`) | `solutions.sql` |

> **Important for Tasks 1–3:** Do **not** look inside the `database/` folder before completing Tasks 2 and 3! Design your own ERM and Relational Model first based on the requirements in each task.

---

## Git Workflow Rules (Read Carefully!)

Every pupil works on **their own branch**. The `master` branch is protected — you **cannot** push directly to `master`.

### 1. Clone the repository (first time only)

```bash
git clone https://github.com/andreasweberd/pizza-flight.git
cd pizza-flight
```

### 2. Create and switch to your own branch

Use your own name in lowercase with a hyphen (for example: `max-mustermann`):

```bash
git checkout -b firstname-lastname
```

Verify you are on your own branch (the `*` must be next to your name, **not** `master`):

```bash
git branch
```

### 3. Save and upload your work after each task

```bash
git status
git add .
git commit -m "Complete task 01: flowchart"
git push -u origin firstname-lastname
```

For later commits on the same branch, `git push` is enough.

### Rules for Hand-Drawn Submissions (Tasks 1–3)

- Diagrams **must be drawn by hand** on paper (not with a diagram tool).
- Take a **clear, well-lit, upright photo** (`.jpg` or `.png`) and save it inside the corresponding task folder with the filename specified in `TASK.md`.
- Your handwriting, symbols, and labels **must be easily readable**. Blurry, dark, rotated, or unreadable photos will not be accepted.

---

## Setting Up DBeaver & the Sample Database (Tasks 4–8)

When you reach **Task 4**, follow the step-by-step setup guide in [`database/README.md`](database/README.md) to connect **DBeaver** to the provided H2 database file `database/pizza_flight.mv.db`.
