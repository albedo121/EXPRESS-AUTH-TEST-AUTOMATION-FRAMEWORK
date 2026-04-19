# UserAuthFlowAutomation

A Selenium-based test automation framework for validating user authentication flows using Behavior-Driven Development (BDD) with Cucumber. This project automates login scenarios including successful and unsuccessful login attempts, with page object model design pattern implementation.

## 📋 Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Technologies & Tools](#technologies--tools)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Project Architecture](#project-architecture)

## ✨ Features

- ✅ BDD-driven test automation using Cucumber and Gherkin
- ✅ Page Object Model (POM) design pattern implementation
- ✅ Multiple test scenarios for login functionality
- ✅ Comprehensive reporting (HTML, JSON, and JUnit formats)
- ✅ Implicit waits and browser management
- ✅ Cross-browser support (Chrome WebDriver)
- ✅ Clean and maintainable code structure

## 📦 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher
- **Maven**: Version 3.6.0 or higher
- **Git**: For cloning the repository
- **Chrome Browser**: For running tests with ChromeDriver

## 🗂️ Project Structure

```
UserAuthFlowAutomation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── pages/
│       │   │   └── LoginPage.java
│       │   └── StepDefinitions/
│       │       ├── LoginSteps.java
│       │       └── TestRunner.java
│       └── resources/
│           └── Features/
│               └── Login.feature
├── target/
│   └── Reports/
│       ├── Html_report.html
│       ├── Json_report.json
│       └── Junit_report.xml
├── pom.xml
└── README.md
```

## 🛠️ Technologies & Tools

- **Selenium WebDriver**: Web browser automation
- **Cucumber (BDD Framework)**: Behavior-driven development
- **Java**: Programming language
- **Maven**: Build and dependency management
- **JUnit**: Test framework
- **ChromeDriver**: Chrome browser automation

## 🚀 Setup & Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd UserAuthFlowAutomation
```

### 2. Install Dependencies

Navigate to the project directory and run:

```bash
mvn clean install
```

This will download all required dependencies specified in `pom.xml`.

### 3. Verify Installation

```bash
mvn --version
java -version
```

## ▶️ Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Feature File

```bash
mvn test -Dcucumber.filter.tags="@login"
```

### Run with Maven Clean

```bash
mvn clean test
```

## 📊 Test Reports

After running tests, reports are generated in the `target/Reports/` directory:

- **HTML Report**: `Html_report.html` - Open in browser for visual report
- **JSON Report**: `Json_report.json` - For CI/CD integration
- **JUnit Report**: `Junit_report.xml` - Standard format for test frameworks

### View HTML Report

```bash
# Windows
start target/Reports/Html_report.html

# Mac
open target/Reports/Html_report.html

# Linux
xdg-open target/Reports/Html_report.html
```

## 🏗️ Project Architecture

### Page Object Model (POM)

The project follows the Page Object Model design pattern for better maintainability:

- **LoginPage.java**: Contains all UI element locators and interactions for the login page
- **LoginSteps.java**: Contains Cucumber step definitions that use LoginPage methods

### Step Definitions

Step definitions map Gherkin sentences from feature files to Java code:

- `@Given`: Preconditions (e.g., "user is on login page")
- `@When`: User actions (e.g., "user enters email and password")
- `@And`: Additional steps
- `@Then`: Expected outcomes (e.g., "user is logged in and navigated to dashboard")

### Feature Files

Gherkin feature files describe test scenarios in human-readable format:

- **Login.feature**: Contains login test scenarios
  - Successful login scenarios
  - Unsuccessful login scenarios

## 🔧 Configuration

Key configurations in `LoginSteps.java`:

```java
private String url = "https://expressauth-zzn0.onrender.com/";
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
```

Modify these values as needed for your environment.

## 👤 Hooks

The project includes Cucumber hooks for setup and teardown:

- **@Before**: Launches and configures the Chrome browser before each test
- **@After**: Closes the browser after each test

## 📝 Example Test Scenario

```gherkin
Scenario Outline: Successful Login with Valid Credentials
    Given user is on login page
    When user enters valid "<email>" and "<password>"
    And user clicks submit button
    Then user is logged in and navigated to dashboard page

    Examples:
      | email                  | password   |
      | user@example.com       | Password123|
      | admin@expressauth.com  | AdminPass1 |
```

## 🐛 Troubleshooting

### ChromeDriver Version Mismatch

Ensure your ChromeDriver version matches your Chrome browser version. Update via pom.xml dependencies.

### Implicit Wait Timeout

Increase the implicit wait duration in `LoginSteps.java` if elements take longer to load:

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
```

### Port Already in Use

If the application is already running, stop the existing process or change the port in the application configuration.

## 📧 Contact & Support

For issues or questions, please create an issue in the repository or contact the project maintainer.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Happy Testing! 🎉**

