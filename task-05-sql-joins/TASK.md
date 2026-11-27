# Task 05 — SQL Queries with Joins (`INNER JOIN`, `LEFT JOIN`)

## Objective

Combine data from multiple related tables in the Pizza Flight database using `INNER JOIN` and `LEFT JOIN`.

---

## Reminder

- Use table aliases (e.g., `orders o`, `machines m`) to keep your queries clean and readable.
- Use `INNER JOIN` when you only want rows that have a match in both tables.
- Use `LEFT JOIN` when you want to keep **all** rows from the left table — even if there is no matching row on the right (such as guest orders without a customer, or pizzas that have never been ordered).

---

## Exercises

Write one SQL query for each of the following 10 questions in `solutions.sql`:

1. **Orders with machine info:** List all orders along with the vending machine's `code` and `city`. Show `order_id`, `code`, `city`, `order_timestamp`, and `total_price`.
2. **Orders with registered customers (`INNER JOIN`):** List all orders placed by **registered** customers. Show `order_id`, `first_name`, `last_name`, `total_price`, and `order_status`.
3. **All orders including guests (`LEFT JOIN`):** List **all** orders (including guest orders where `customer_id` is `NULL`) together with the customer's `first_name` and `last_name` if available. Order by `order_id`.
4. **Machine stock overview:** Show the current stock for every vending machine and pizza: `code` (machine), `city`, `name` (pizza), and `quantity`. Order by `code`, then `name`.
5. **Out-of-stock pizzas:** Using a join on `machine_inventory`, `machines`, and `pizzas`, find all pizzas that currently have `quantity = 0` in a machine. Show `code`, `location_name`, `name` (pizza), and `last_restocked`.
6. **Pizza default toppings (M:N join):** List all pizzas and their default toppings (`pizzas.name` as `pizza_name`, `toppings.name` as `topping_name`). Order by `pizza_name`, then `topping_name`.
7. **Pizzas containing Jalapenos:** Find all pizzas that have `'Jalapenos'` as a default topping. Show `pizza_name` and `base_price`.
8. **Detailed order receipt (3-table join):** For `order_id = 1`, list every pizza ordered along with its `name`, `quantity`, and `unit_price`.
9. **Customers without orders (`LEFT JOIN` + `IS NULL`):** Find all registered customers who have **never** placed an order. Show `customer_id`, `first_name`, `last_name`, and `email`.
10. **Pizzas never ordered (`LEFT JOIN` + `IS NULL`):** Find all pizzas on the menu that have **never** appeared in `order_items`. Show `pizza_id`, `name`, and `base_price`.

---

## Submission Requirements

1. Write all 10 tested SQL queries in `task-05-sql-joins/solutions.sql`.
2. End every SQL statement with a semicolon (`;`).
3. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-05-sql-joins/solutions.sql
   git commit -m "Complete task 05: SQL joins"
   git push
   ```
