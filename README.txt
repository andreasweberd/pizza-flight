==============================================================================
PIZZA FLIGHT - DATABASE & SQL LEARNING PROJECT
==============================================================================

Welcome to Pizza Flight!

In this multi-step project, you will design and query a database for a
fictional 24/7 automated pizza vending machine company called "Pizza Flight".
Their smart vending machines are installed at train stations, universities,
and airports, baking fresh pizzas on demand in about three minutes.

You will progress step by step - from modeling the ordering workflow, to
designing an Entity-Relationship Model (ERM) and a Relational Model, and
finally to writing real ANSI SQL queries against an H2 database in DBeaver.


PROJECT ROADMAP
------------------------------------------------------------------------------
# | Folder                    | Topic                           | Submission
--+---------------------------+---------------------------------+-------------
1 | task-01-flowchart/        | Program Flowchart               | Photo (.jpg)
2 | task-02-erm/              | ERM (Chen Notation)             | Photo (.jpg)
3 | task-03-relational-model/ | Relational Model (Tables/PK/FK) | Photo (.jpg)
4 | task-04-sql-basics/       | Basic SQL Queries (SELECT)      | solutions.sql
5 | task-05-sql-joins/        | SQL Joins (INNER / LEFT JOIN)   | solutions.sql
6 | task-06-sql-aggregations/ | Aggregations (GROUP BY/HAVING)  | solutions.sql
7 | task-07-sql-crud/         | CRUD (INSERT / UPDATE / DELETE) | solutions.sql
8 | task-08-sql-ddl/          | DDL (CREATE / ALTER TABLE)      | solutions.sql

Each folder contains a TASK.txt file with full instructions. Read it with:
    less task-01-flowchart/TASK.txt

IMPORTANT FOR TASKS 1-3:
Do NOT look inside the database/ folder before completing Tasks 2 and 3!
Design your own ERM and Relational Model first based on the requirements in
each TASK.txt.


GIT WORKFLOW RULES (READ CAREFULLY!)
------------------------------------------------------------------------------
Every pupil works on THEIR OWN BRANCH. The "master" branch is protected -
you CANNOT push directly to "master".

1. Clone the repository (first time only):

       git clone https://github.com/andreasweberd/pizza-flight.git
       cd pizza-flight

2. Create and switch to your own branch using your name in lowercase with a
   hyphen (example: max-mustermann):

       git checkout -b firstname-lastname

   Verify you are on your own branch (the "*" must be next to your name,
   NOT "master"):

       git branch

3. Save and upload your work after each task:

       git status
       git add .
       git commit -m "Complete task 01: flowchart"
       git push -u origin firstname-lastname

   For later commits on the same branch, "git push" is enough.


RULES FOR HAND-DRAWN SUBMISSIONS (TASKS 1-3)
------------------------------------------------------------------------------
- Diagrams MUST be drawn by hand on paper (do NOT use a diagram tool).
- Take a clear, well-lit, upright photo (.jpg or .png) and save it inside
  the corresponding task folder with the filename specified in TASK.txt.
- Your handwriting, symbols, and labels MUST be easily readable. Blurry,
  dark, rotated, or unreadable photos will not be accepted.


SETTING UP DBEAVER & THE SAMPLE DATABASE (TASKS 4-8)
------------------------------------------------------------------------------
When you reach Task 4, read database/README.txt for step-by-step instructions
on connecting DBeaver to the provided H2 database file:
    database/pizza_flight.mv.db
