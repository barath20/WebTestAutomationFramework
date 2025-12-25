# Selenium Framework - RedCardinal

This project is a Selenium Test Automation Framework using Java, TestNG, and Maven.

## Prerequisites

1.  **Java Development Kit (JDK) 11 or higher**.
    *   Verify with: `java -version`
2.  **Maven**.
    *   Verify with: `mvn -version`
    *   If not installed:
        *   **Mac (Homebrew)**: `brew install maven`
        *   **Windows/Linux**: Download from [maven.apache.org](https://maven.apache.org/download.cgi).

## How to Run

### Option 1: Command Line (Recommended)

To run the default test suite (`testng.xml`):

```bash
mvn clean test
```

This command will:
1.  Clean previous builds.
2.  Compile the code.
3.  Automatically download necessary drivers (via Selenium Manager).
4.  Execute the tests.
5.  Generate reports in the `Report` folder.

### Option 2: IDE (Eclipse / IntelliJ / VS Code)

1.  **Import** the project as a **Maven Project**.
2.  Let the IDE resolve dependencies (it might take a minute to download Selenium 4 and other libraries).
3.  Navigate to `testng.xml`.
4.  Right-click the file and select **Run As > TestNG Suite**.

## Project Structure

*   `src/main/java/framework`: Core framework components (Driver, Reporting, Setup).
*   `src/main/java/pages`: Page Object Models (POM).
*   `src/test/java`: Test classes and TestNG XML suites.
*   `Report`: Generated ExtentReports.
*   `screenshots`: Captured screenshots on failure/pass.

## Key Features

*   **Selenium 4**: Uses the latest Selenium features and automated driver management.
*   **Cross-Platform**: Runs on Windows, Mac, and Linux.
*   **ExtentReports 5**: Rich HTML reporting.
*   **Log4j 2**: Secure and robust logging.
