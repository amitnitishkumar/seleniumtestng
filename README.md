This repository contains a Selenium TestNG project designed for web automation testing. It utilizes various listeners such as AnnotationTransformer, SuiteListener, TestListener, MethodInterceptor, and IRetryAnalyzer for comprehensive test management and execution. Additionally, it employs Excel sheets for controlling test execution via the RunManager sheet and accessing test data from the DATA sheet.

Selenium TestNG Repository Readme

This repository contains a Selenium TestNG project designed for web automation testing. It utilizes various listeners such as AnnotationTransformer, SuiteListener, TestListener, MethodInterceptor, and IRetryAnalyzer for comprehensive test management and execution. Additionally, it employs Excel sheets for controlling test execution via the RunManager sheet and accessing test data from the DATA sheet.

Project Structure
markdown
Copy code
- src
  - main
  - test
    - java
      - com.example.tests
        - TestClass1.java
        - TestClass2.java
        - ...
    - resources
      - testdata.xlsx
- pom.xml
- testng.xml
Listeners Utilized
AnnotationTransformer: Modifies test class annotations at runtime.
SuiteListener: Performs actions before and after test suite execution.
TestListener: Handles test lifecycle events like test pass, failure, and skip.
MethodInterceptor: Intercepts test method calls before execution.
IRetryAnalyzer: Allows retrying failed test cases based on a predefined condition.

Using Excel Sheets
RunManager Sheet: Controls the test execution flow by specifying which test cases to run.
DATA Sheet: Contains test data to be used during test execution.

Clone and Setup in IntelliJ IDEA
Follow these steps to clone and set up the project in IntelliJ IDEA for execution:

Clone the Repository: Open IntelliJ IDEA and clone the repository using the following steps:

Go to VCS > Git > Clone.
Enter the repository URL.
Choose the directory where you want to clone the repository.
Click Clone.
Open Project: Once cloned, open the project by selecting the directory where it was cloned.

Import Dependencies: IntelliJ IDEA will automatically recognize the project structure and import dependencies specified in the pom.xml file.

Run Tests: Add run config in intellij as follow:
1. Go to Edit COnfiguration.
2. Add testng as runner
3. Give name to the runner e.g. "runuitest"
4. Select "Test Kind" as "Suite"
5. Pass "Test runner params" as testng.xml

To run using command line:
1. Setup maven
2. Navigate to project root folder i.e. seleniumtestng from command line
3. run "mvn test"
