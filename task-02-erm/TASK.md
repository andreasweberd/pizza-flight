# Task 02 — Entity-Relationship Model (ERM) in Chen Notation

## Objective

Analyze the **Pizza Flight** business requirements below and design a complete **Entity-Relationship Model (ERM)** using **Chen notation**.

> **Reminder:** Do **not** look inside the `database/` folder yet! Design the model purely from the specification below.

---

## Business Requirements

**Pizza Flight** operates a network of automated pizza vending machines across multiple cities. The company needs a database to store and manage the following information:

1. **Vending Machines**
   - Each vending machine has a unique **machine ID**, a unique **machine code** (e.g., `PF-BER-01`), the **city** it is located in, a **location name** (e.g., `Central Station North`), a current **status** (`ACTIVE`, `MAINTENANCE`, or `OFFLINE`), and an **installation date**.

2. **Pizzas**
   - Pizza Flight offers a standardized menu of pizzas. Each pizza has a unique **pizza ID**, a unique **name** (e.g., `Margherita`), a **category** (`Classic`, `Meat`, `Vegetarian`, `Special`), a **base price**, a **baking time in seconds**, whether it **is vegetarian**, and its **calories**.

3. **Toppings**
   - Each topping has a unique **topping ID**, a unique **name** (e.g., `Mushrooms`, `Jalapenos`), an **extra price**, and whether it **is vegan**.
   - Every pizza has **zero, one, or many** default toppings, and each topping can be used on **zero, one, or many** pizzas.

4. **Machine Inventory (Stock)**
   - Each vending machine holds a certain stock of pizzas.
   - A vending machine can stock **many** pizzas, and the same pizza type can be stocked in **many** vending machines.
   - For each machine–pizza combination, we must record the current **quantity** in stock and the **last restocked date**.

5. **Customers (Loyalty App Users)**
   - Customers may optionally register in the Pizza Flight loyalty app.
   - Each registered customer has a unique **customer ID**, **first name**, **last name**, unique **email**, **city**, **loyalty points**, and a **registration date**.

6. **Orders**
   - When someone buys pizza at a machine, an order is recorded with a unique **order ID**, an **order timestamp**, a **payment method** (`CARD`, `APP`, or `CASH`), a **total price**, and an **order status** (`COMPLETED` or `CANCELLED`).
   - Every order is placed at **exactly one** vending machine, while a vending machine can have **zero or many** orders.
   - An order may be placed by **at most one** registered customer (walk-up guests order without an account!), and a registered customer can place **zero or many** orders.
   - Each order contains **one or many** pizzas, and each pizza can appear in **zero or many** orders. For each pizza in an order, we record the **quantity** ordered and the **unit price** at the time of purchase.

---

## Required Notation: Chen Notation

Your diagram **must** follow **Chen notation**:

- **Rectangles** for **Entity Types** (e.g., `Machine`, `Pizza`, `Topping`, `Customer`, `Order`)
- **Ovals** for **Attributes**, connected to their entity (or relationship!)
  - **Underline** every **Primary Key** attribute
- **Diamonds** for **Relationships** (use clear verb phrases, e.g., *stocks*, *places*, *contains*, *has*)
  - Attach relationship attributes (like `quantity`, `last_restocked`, `unit_price`) directly to the relationship diamond where appropriate!
- **Cardinalities** clearly written on every relationship (e.g., `1 : N`, `M : N` or `(min, max)` notation — be consistent throughout your diagram).

---

## Submission Requirements

1. **Draw the ERM by hand** on clean paper (A4 or A3 recommended so nothing is cramped). Do **not** use a digital diagram tool.
2. Take a **sharp, well-lit, upright photo** of your drawing.
   - Every entity, attribute, underlined key, diamond, and cardinality **must be clearly readable**.
3. Save the photo in this folder (`task-02-erm/`) as:
   - `erm.jpg` or `erm.png`
4. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-02-erm/erm.jpg
   git commit -m "Complete task 02: ERM in Chen notation"
   git push
   ```
