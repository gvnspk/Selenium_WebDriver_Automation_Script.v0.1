

---

# Selenium WebDriver Automation Script v0.1

This repository contains a sample end-to-end automation script for a demo shopping website. The script is implemented using:

* **Selenium WebDriver**
* **Data-Driven Framework**
* **Page Object Model (POM)**
* **Page Factory**
* **Cucumber BDD**
* **Maven Build Tool**

---

## Commit 1 Overview

### E2E Testing Steps Covered:

1. Opening the website
2. Searching for a product
3. Selecting a product
4. Adding the product to the cart
5. Proceeding to checkout
6. Completing payment transactions

---

### Key Features:

* A single feature file is used for the test scenario.
* Customer details are provided as input.
* Test data is passed via a **JSON** file.
* Configuration parameters such as:

  * WebDriver path
  * Browser path
  * Base URL
  * Implicit wait time
  * Headless mode (boolean)
    are specified in the `configuration.properties` file.

---

### Project Structure:

* `src/test/resources`

  * Contains **feature files**, **configuration files**, and **test data files**

* `src/test/java`

  * Contains **step definition files**, **page object classes**, **reader classes**, and other supporting classes

---
