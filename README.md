🚀 Playwright Java Automation Framework
📌 Overview

A scalable UI automation framework built using Playwright (Java) with TestNG and Maven, following the Page Object Model (POM) architecture.
The framework supports multi-browser execution, parallel testing, and HTML reporting.

🛠 Tech Stack
Playwright (Java)
TestNG
Maven
Extent Reports
Page Object Model (POM)
ThreadLocal for parallel execution

🔥 Key Features
Multi-browser support (Chromium / Firefox / WebKit)
XML-based test configuration
Thread-safe browser management
Screenshot capture on failure
Extent HTML reporting
Clean and scalable project structure

🏗 Project Structure
src
 ├── main
 │    └── java
 │         ├── base
 │         ├── config
 │         ├── factory
 │         ├── pages
 │         └── utils
 │
 └── test
      └── java
           ├── base
           ├── listeners
           └── tests
▶ How to Run

Run using TestNG XML:
src/test/resources/testng.xml
Or via Maven:
mvn clean test

📊 Reporting
After execution, Extent report is generated under:
/target/

🧠 Architecture Highlights
Centralized PlaywrightFactory for browser lifecycle management
ThreadLocal implementation for safe parallel execution
Page classes encapsulate locators and actions
Listener-based reporting integration
