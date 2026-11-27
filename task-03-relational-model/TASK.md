# Task 03 — Relational Model (Relational Schema & Diagram)

## Objective

Transform your **Entity-Relationship Model** from Task 02 into a **Relational Model** (tables, columns, primary keys, foreign keys, and resolved `M:N` relationships) ready to be implemented in a relational database.

> **Reminder:** Do **not** look inside the `database/` folder yet! Derive the relational model from your own ERM in Task 02 first.

---

## Transformation Rules to Apply

Follow the standard ERM → Relational Model mapping rules:

1. **Entities → Tables**
   - Each entity type becomes a table with all of its attributes as columns.
   - **Underline** the **Primary Key (PK)** column(s) of every table.

2. **`1 : N` Relationships → Foreign Keys**
   - Add the Primary Key of the `1`-side table as a **Foreign Key (FK)** column on the `N`-side table.
   - Clearly mark every Foreign Key (e.g., write `(FK)` or draw a dashed underline) and draw an arrow pointing from the FK to the referenced PK.
   - Note which Foreign Keys may be `NULL` (for example, guest orders without a registered customer).

3. **`M : N` Relationships → Junction (Associative) Tables**
   - Every `M : N` relationship **must** be resolved into its own junction table!
   - Include the Primary Keys of both connected tables as Foreign Keys (forming a composite Primary Key, or using a dedicated surrogate Primary Key).
   - Move any relationship attributes (such as `quantity`, `last_restocked`, `unit_price`) into the junction table.
   - Check all three `M : N` relationships from Task 02:
     - `Pizza` ↔ `Topping`
     - `Machine` ↔ `Pizza` (inventory/stock)
     - `Order` ↔ `Pizza` (order items)

4. **Check Normalization (up to 3NF)**
   - No repeating groups or multi-valued attributes (1NF).
   - No partial dependencies on part of a composite key (2NF).
   - No transitive dependencies between non-key columns (3NF).

---

## What Your Diagram Should Show

Draw each table as a clean box with:
- The **table name** in the header
- All **column names** listed inside
- **Primary Keys** clearly marked (`PK` / underlined)
- **Foreign Keys** clearly marked (`FK`) with **arrows** connecting each Foreign Key to the Primary Key it references

---

## Submission Requirements

1. **Draw the Relational Model by hand** on clean paper (A4 or A3 recommended). Do **not** use a digital diagram tool.
2. Take a **sharp, well-lit, upright photo** of your drawing.
   - All table names, column names, `PK`/`FK` markings, and arrows **must be clearly readable**.
3. Save the photo in this folder (`task-03-relational-model/`) as:
   - `relational_model.jpg` or `relational_model.png`
4. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-03-relational-model/relational_model.jpg
   git commit -m "Complete task 03: relational model"
   git push
   ```
