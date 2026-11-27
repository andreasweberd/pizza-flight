# Task 04 — Basic SQL Queries (`SELECT`, `WHERE`, `ORDER BY`, `LIMIT`)

## Objective

Connect **DBeaver** to the Pizza Flight H2 sample database and practice writing fundamental `SELECT` queries.

---

## Setup

1. Follow [`database/README.md`](../database/README.md) to connect DBeaver to `database/pizza_flight.mv.db`.
2. Open `task-04-sql-basics/solutions.sql` in DBeaver (or any text editor) and write your SQL query beneath each numbered comment.
3. **Test every query in DBeaver** against `pizza_flight` before committing!

---

## Exercises

Write one SQL query for each of the following 10 questions in `solutions.sql`:

1. **All pizzas:** Select all columns from the `pizzas` table.
2. **Selected columns:** List the `name`, `category`, and `base_price` of all pizzas.
3. **Simple filter (`WHERE`):** Find all vending machines located in `'Berlin'`. Show `code`, `location_name`, and `status`.
4. **Boolean & numeric filter:** Find all **vegetarian** pizzas (`is_vegetarian = TRUE`) that cost **less than 8.50**. Show `name` and `base_price`.
5. **Sorting (`ORDER BY`):** List all customers (`first_name`, `last_name`, `loyalty_points`) ordered by `loyalty_points` from **highest to lowest**.
6. **Top N (`ORDER BY` + `LIMIT`):** Find the **3 most expensive** pizzas. Show `name` and `base_price`.
7. **Distinct values (`DISTINCT`):** List all unique `city` names where Pizza Flight has vending machines, sorted alphabetically (`A` to `Z`).
8. **Pattern matching (`LIKE`):** Find all customers whose `email` starts with the letter `'l'` (hint: `LOWER(email) LIKE 'l%'` or `email LIKE 'l%'`). Show `first_name`, `last_name`, and `email`.
9. **Range & list filters (`BETWEEN` / `IN`):** Find all `COMPLETED` orders placed in **March 2026** (between `TIMESTAMP '2026-03-01 00:00:00'` and `TIMESTAMP '2026-03-31 23:59:59'`). Show `order_id`, `order_timestamp`, `payment_method`, and `total_price`.
10. **Checking for `NULL` (`IS NULL`):** Find all **guest orders** (orders where `customer_id` is `NULL`). Show `order_id`, `machine_id`, `order_timestamp`, and `total_price`.

---

## Submission Requirements

1. Write all 10 tested SQL queries in `task-04-sql-basics/solutions.sql`.
2. End every SQL statement with a semicolon (`;`).
3. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-04-sql-basics/solutions.sql
   git commit -m "Complete task 04: basic SQL queries"
   git push
   ```
