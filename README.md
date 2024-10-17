# Zoho CRM Leads Module Automation

## Project Overview
This project automates the Leads module in Zoho CRM using Selenium WebDriver and TestNG. The tests include creating, editing, filtering, and deleting leads. The framework follows the Page Object Model (POM) for better maintainability and scalability.

### Features Covered
- **Create a New Lead**
- **Edit a Lead**
- **Filter Leads**
- **Delete a Lead**

---

## Prerequisites

Before setting up and running the tests, ensure you have the following installed:

1. **Java**: JDK 11 or higher  
   [Download Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
   Verify installation:
   ```bash
   java -version


## Project Structure

```bash
/src
  /main
    /java
      /pages
        - LoginPage.java         # Handles login page actions
        - LeadsPage.java         # Handles leads module actions
      /utils
        - WebDriverUtils.java    # WebDriver setup and teardown
  /test
    /java
      /tests
        - LeadsTest.java         # Contains test cases for the Leads module
    /resources
      - testng.xml               # TestNG configuration file
pom.xml                          # Maven configuration file



