# API Automation Framework

A BDD-based API automation testing framework built using **Java, REST Assured, Cucumber, JUnit, and Maven**.

The framework is designed to automate REST API scenarios with reusable components, request/response specifications, POJO-based payloads, configuration management, and test reporting.

---

## 🛠️ Tech Stack

- **Java**
- **REST Assured**
- **Cucumber BDD**
- **JUnit**
- **Maven**
- **Git & GitHub**
- **JSON**
- **HTML Reporting**

---

## 📌 Framework Features

- API automation using REST Assured
- BDD-style test scenarios using Cucumber
- Reusable Request Specification
- Reusable Response Specification
- POJO classes for request payload creation
- Reusable API resource paths
- Configuration using properties files
- Reusable test data generation
- Cucumber Hooks
- Request and response validation
- Status code validation
- JSON response validation
- Cucumber JSON and HTML reports
- Maven-based test execution

---

## 📂 Project Structure

```text
APIFramework
│
├── src
│   ├── main
│   │   └── java
│   │       └── Pojo
│   │           ├── AddPlace.java
│   │           └── Location.java
│   │
│   └── test
│       └── java
│           ├── cucumber.options
│           │   └── TestRunner.java
│           │
│           ├── Features
│           │   └── placeValidations.feature
│           │
│           ├── Resources
│           │   ├── APIResources.java
│           │   ├── global.properties
│           │   ├── TestDataBuild.java
│           │   └── Utils.java
│           │
│           └── stepDefinitions
│               ├── Hooks.java
│               └── StepDefinitions.java
│
├── .gitignore
├── logging.txt
├── pom.xml
└── README.md
