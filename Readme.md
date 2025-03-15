# Test Automation Framework automationpractice.pl

This is a Java-based test automation framework.

The framework leverages various libraries and tools to facilitate data-driven testing, logging, reporting, and integration with cloud-based testing platforms like LambdaTest.

## 🚀 About Me
Hi, My Name is Utkarsh Howale, and I have 3+ years of experience in Automation Testing using technologies like Selenium WebDriver.

My major expertise is in Java Programming Language.

## Authors

- Utkarsh Howale
[Linked In](www.linkedin.com/in/utkarsh-howale-b96142218)

## Prerequisites
Before running this framework, ensure the following software is installed on your system:

- **Java 11** - Make sure Java is installed and the `JAVA_HOME` environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.  
  📥 [Download Maven](https://maven.apache.org/download.cgi)

## Features
- **Data-Driven Testing**: Uses OpenCSV, Apache POI, and Gson for reading test data from CSV, Excel files, and JSON.
- **Cross-Browser Testing**: Supports running tests on different browsers.
- **Headless Mode**: Faster execution by running tests in headless mode.
- **Cloud Testing**: Integrated with LambdaTest to run tests on the cloud.
- **Logging**: Uses Log4j for detailed logs.
- **Reporting**: Generates detailed reports using Extent Reports.

## Technologies Used
- Java 11
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports

## Setup Instructions
### Clone the Repository:
```sh
 git clone https://github.com/UtkarshHowale/Test_Automation_Framework_automationpractice.pl.git
 cd Test_Automation_Framework_automationpractice.pl
```

### Running Tests on LambdaTest:
```sh
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

### Running Tests on Chrome Browser on Local Machine in Headless Mode:
```sh
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```

## Reports & Logs
- **Reports:** After execution, a detailed HTML report will be generated at `./report.html`.
  - The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.
- **Logs:**
  - Logs are created during the test execution and stored in the `./logs/` directory.

## Integrated GitHub Actions
This automation framework is integrated with GitHub Actions. The tests will be executed at **11:30 PM IST** every single day.

### View Reports
The reports will be archived in the `gh-pages` branch. You can view the HTML reports at:
📄 [Test_Automation_Framework_automationpractice.pl](https://utkarshhowale.github.io/Test_Automation_Framework_automationpractice.pl/report.html)
