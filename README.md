## Fedex automation

This repository contains a project that demonstrate automation testing of https://www.fedex.com/en-gb/home.html as a part of interview assignment.
Project is using the latest Cucumber(v 7.8.1) BDD framework with Java as programming language and Selenium (v 4.4.0) as a web based automation tool. 
It generate Allure, HTML and JSON reporters as well. 
It also generate screen shots for your tests if you enable it and also generate error shots for your failed test cases as well.

## Installation (pre-requisites)

1. Intellij IDEA with cucumber plugin installed
2. JDK 11
3. Maven
4. Git

This project is using these important dependencies(libraries):

1. `selenium-java`: to enable web based automation
2. `cucumber-java`: BDD cucumber support for Java programming language
3. `junit-jupiter-api`: to run scenario as Junit5 tests
4. `assertj-core`: For assertions
5. `cucumber-picocontainer`: Dependency injection module. It’s important to prevent state created by one scenario from leaking into others. 
Leaking state makes your scenarios brittle, and difficult to run in isolation. Project will benefit from a dependency injection (DI) module to organize your code better and to share state between step definitions. 
Picocontainer DI will manage lifecycle of objects. Picocontainer is recommended one if your application doesn’t use another DI module.
6. `webdrivermanager`: To manage driver download and installation of web browser drivers. If for example chromedriver is missing webdrivermanager will download it and put it in system path.
7. `allure-junit5`: For reporting


## How to run

1. Clone repository locally 
2. Navigate to project directory or open it with IntellijIDE
3. To run tests: `mvn clean test`
4. Optional environment variables are available: 
   a. `browser`: Default is Chrome. Supported browsers are: Chrome and Firefox.
   b. `base_url`: In case of different environments base url needs to be separated. Default is `https://www.fedex.com`
   c. `timeout`: To define implicit timeout wait. Default 20 seconds.
5. To run with firefox: `mvn clean test -Dbrowser=firefox` 
6. To see reports in allure run command: `mvn allure:serve`


## Features and Scenarios
 
In the features folder there are 10 scenarios for potential regression tests which needs to be extended with real test data
1. AccountPage.feature contains following scenarios Open Account Page: Enter new account details
2. HomePage.feature contains following scenarios Verify home page Elements, Verify Track Search is working and returns error message for invalid search, Verify Rate transit Time navigation is working, Verify Custom Tools  navigation is working, Verify when user clicks ship he is redirected to login, Verify duties and taxes navigation,Verify service news page is loaded
3. LoginPage.feature  contains following scenarios Open Account Page: Verify login page shows error message for invalid credentials, Verify successful login


## The Page Object Design Pattern
`Page Object Model (POM)` is a design pattern, popularly used in test automation that creates Object Repository for web UI elements. The advantage of the model is that it reduces code duplication and improves test maintenance.
Page Object Model is applied using Selenium PageFactory : Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver and it is very optimized.
In general, every page in our application will be represented by a unique class of its own and the page element inspection will be implemented in every class.
In the project: Header is page object model which is used on LoginPage, HomePage, etc...

Integration with cucumber:
1. feature file
2. PageStep implementation
3. Page implementation