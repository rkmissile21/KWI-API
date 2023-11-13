# Java Rest Assured Test Automation Framework with Cucumber and JUnit

This project is a Java-based test automation framework that uses Rest Assured, Cucumber, and JUnit for API testing. It
provides easy-to-use commands to execute tests using Maven, a test runner class, or individual feature files.

## Prerequisites

- Java
- Maven

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/your-repository.git
   ```

2. **Navigate to the Project:**

   ```bash
   cd your-repository
   ```

3. **Run Tests Using Maven:**

   ```bash
   mvn clean test
   ```

4. **Run Tests Using Test Runner Class:**

   Execute the `TestsRunner.java` class located in `src/test/java/com/kwi/base/` using your preferred IDE.

5. **Run Individual Feature File:**

   Execute the desired feature file located in `src/test/resources/features/` using your preferred IDE or command line.

## Reporting

Cucumber reports are generated after executing tests through the test runner class or the command line. The reports are
available at `target/cucumberReport`.

## Execute Tests in Different Environments

Tests can be executed locally or in a CI/CD pipeline with different environments. Use the following command for the
pipeline:

```bash
mvn -s settings.xml -ntp test -pl cucumber-tests -P ${APPENV} -am
```

Replace `${APPENV}` with the desired environment profile.

## Directory Structure

- **src/test/java/com/kwi/base/:** Contains the `TestsRunner.java` class for running tests.

- **src/test/java/com/kwi/stepdefs/:** Contains step definitions for Cucumber scenarios.

- **src/test/java/com/kwi/config/:** Contains utility classes for API testing.

- **src/test/resources/features/:** Contains feature files with Cucumber scenarios.

- **target/:** Contains generated reports and compiled classes.

## Dependencies

- **Rest Assured:** For API testing.

- **Cucumber:** For behavior-driven development.

- **JUnit:** For test execution and assertions.

- **Maven:** For project management and build.

## Notes

- Ensure that the required dependencies are available in your local Maven repository.

- Customize the settings in the `pom.xml` file to match your project requirements.

- Update the test scenarios and step definitions according to your API specifications.

- Adjust the reporting format or location by modifying the `cucumber.options` in the `pom.xml` file.

Feel free to customize and expand this framework according to your specific needs. Happy testing!