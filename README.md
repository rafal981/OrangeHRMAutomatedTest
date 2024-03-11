# OrangeHRM Automated Test
This repository contains an automated test script for OrangeHRM using Selenium and TestNG.

## Description
This automated test script verifies the functionality of adding a new administrator account to the OrangeHRM system. It utilizes Selenium for web automation and TestNG for test case management.

## Prerequisites
Java Development Kit (JDK) installed
Maven installed
WebDriver for Chrome

## Running the Test
To execute the test, run the OrangeHrmAutomatedTest class. This will launch a Chrome browser and perform the test scenario.

## Test Scenario
The test scenario includes the following steps:

 &nbsp;&nbsp;* Logging in as an admin. <br>
 &nbsp;&nbsp;* Accessing the administrator module. <br>
 &nbsp;&nbsp;* Adding a new administrator account. <br>
 &nbsp;&nbsp;* Verifying the successful addition of the new administrator account. <br>

## Test Implementation
The test script generates random login credentials and uses Selenium actions to interact with the OrangeHRM web interface. It utilizes TestNG annotations for test setup, execution, and teardown.

## Note
Ensure that the OrangeHRM application is accessible at https://opensource-demo.orangehrmlive.com/web/index.php/auth/login before running the test.

## License
This project is licensed under the MIT License.

&nbsp;&nbsp;

