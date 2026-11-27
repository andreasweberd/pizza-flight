# Task 06 — SQL Aggregations & Grouping (`COUNT`, `SUM`, `AVG`, `MIN`, `MAX`, `GROUP BY`, `HAVING`)

## Objective

Answer real business analytics questions for Pizza Flight using aggregate functions, `GROUP BY`, `HAVING`, and joins.

---

## Exercises

Write one SQL query for each of the following 10 questions in `solutions.sql`:

1. **Total number of orders:** Count the total number of rows in the `orders` table.
2. **Completed revenue:** Calculate the total revenue (`SUM(total_price)`) of all `COMPLETED` orders.
3. **Pizza price statistics:** Find the minimum (`MIN`), maximum (`MAX`), and average (`AVG`, rounded to 2 decimal places with `ROUND(..., 2)`) `base_price` of all pizzas.
4. **Pizzas per category (`GROUP BY`):** Count how many pizzas exist in each `category`. Show `category` and `pizza_count`, ordered by `pizza_count` descending.
5. **Orders per payment method:** For each `payment_method`, show how many `COMPLETED` orders were paid that way and the total revenue (`SUM(total_price)`).
6. **Revenue per vending machine:** Join `machines` and `orders` to calculate total revenue (`SUM(total_price)`) per machine for `COMPLETED` orders only. Show `code`, `city`, and `total_revenue`, ordered by `total_revenue` descending.
7. **All machines including those with zero orders (`LEFT JOIN` + `COALESCE`):** List **every** vending machine (`code`, `city`) and its number of orders (`COUNT(o.order_id)`). Machines without orders must appear with `0`.
8. **Most popular pizzas:** Join `pizzas`, `order_items`, and `orders` to find the total `quantity` sold for each pizza across `COMPLETED` orders. Show `name` and `total_sold`, ordered by `total_sold` descending.
9. **Frequent customers (`HAVING`):** Find all registered customers who have placed **at least 2** `COMPLETED` orders. Show `first_name`, `last_name`, and `order_count`.
10. **Low total stock per machine (`HAVING`):** Using `machine_inventory` and `machines`, calculate the total number of pizzas currently in stock (`SUM(quantity)`) for each machine, and show only machines with **fewer than 25** pizzas in stock. Show `code`, `city`, and `total_stock`.

---

## Submission Requirements

1. Write all 10 tested SQL queries in `task-06-sql-aggregations/solutions.sql`.
2. End every SQL statement with a semicolon (`;`).
3. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-06-sql-aggregations/solutions.sql
   git commit -m "Complete task 06: SQL aggregations and grouping"
   git push
   ```
