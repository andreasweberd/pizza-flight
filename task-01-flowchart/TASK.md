# Task 01 — Program Flowchart: Ordering at a Pizza Flight Vending Machine

## Objective

Model the complete step-by-step workflow of a customer ordering a pizza at a **Pizza Flight** vending machine using a **Program Flowchart** (standard flowchart / DIN 66001 symbols).

---

## Scenario

A customer walks up to a **Pizza Flight** vending machine. The machine guides the customer through the following process:

1. **Welcome Screen:** The customer taps the screen to start an order.
2. **Optional Loyalty Login:** The machine asks if the customer wants to scan their **Pizza Flight App** QR code to collect loyalty points.
   - If **yes**, the customer scans the QR code and the machine identifies their account.
   - If **no**, the customer continues as a guest.
3. **Select Pizza:** The customer chooses a pizza from the menu on the touchscreen.
4. **Availability Check:** The machine checks whether the selected pizza is currently in stock.
   - If **out of stock**, the machine displays *"Sorry, sold out!"* and asks the customer to choose a different pizza (loop back to **Select Pizza**).
5. **Extra Toppings (Optional):** The machine asks whether the customer wants to add an extra topping (e.g., Extra Cheese, Jalapenos, Mushrooms).
   - If **yes**, the customer selects a topping and its price is added to the total. The machine asks again if they want another extra topping (loop until **no**).
6. **Payment:** The machine displays the total price and asks the customer to pay (Card, App, or Cash).
   - If the **payment fails**, the machine shows an error and asks whether the customer wants to **retry payment** or **cancel the order**.
   - If the customer **cancels**, the order is aborted and the machine returns to the end state.
7. **Baking & Dispensing:** Once payment succeeds:
   - The machine decreases the pizza stock by 1.
   - The oven bakes the pizza for ~3 minutes while displaying a countdown.
   - When finished, the machine dispenses the hot pizza box through the pickup slot.
   - If the customer scanned their Loyalty App earlier, loyalty points are credited to their account.
8. **Finish:** The machine displays *"Enjoy your Pizza Flight!"* and ends the process.

---

## Required Flowchart Symbols

Use the standard program flowchart symbols:

- **Oval / Rounded Rectangle:** Start / End
- **Parallelogram:** Input / Output (screen display, customer selection, scanning QR code, dispensing pizza)
- **Rectangle:** Processing step (calculate total price, decrease stock, bake pizza, credit loyalty points)
- **Diamond:** Decision / Condition (always label the outgoing arrows clearly with **Yes** / **No**)
- **Arrows:** Flow direction

---

## Submission Requirements

1. **Draw the flowchart by hand** on clean paper (A4 or larger). Do **not** use a digital diagram tool.
2. Take a **sharp, well-lit, upright photo** of your drawing.
   - All text, arrows, and Yes/No labels **must be clearly readable**.
3. Save the photo in this folder (`task-01-flowchart/`) as:
   - `flowchart.jpg` or `flowchart.png`
4. Commit and push to **your own branch** (never `master`):
   ```bash
   git add task-01-flowchart/flowchart.jpg
   git commit -m "Complete task 01: program flowchart"
   git push
   ```
