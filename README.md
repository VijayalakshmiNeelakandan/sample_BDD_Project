## Automation of get help with paying with NHS costs Online Service

### Features of framework
Page Object Model
BDD and Cucumber
Selenium Java

### Currently supported browsers are 
* chrome
* firefox

### Pre-Requisite
Browsers Chrome and Firefox
IntelliJ IDE for coding the Tests (along with Git, Cucumber, Maven Plugins )
Java
Maven
Git


### How to run?
* Download or clone the project
* Navigate to the Root Folder of the Project
* Install the dependencies and execute the below maven command through the command line prompt
##### Maven
```javascript
 mvn clean test -D"cucumber.options=--tag @regression -Dbrowser=firefox
 mvn clean test -D"cucumber.options=--tag @regression -Dbrowser=chrome
 By default it takes Chrome as Drvicer to execute the project
```

### Reports
After the test execution completed, you can see Cucumber Basic HTML reports under `target` directory


### Test Coverage
Tests are covered for all the below requirement:
 1. User is validated for UK Citizenship
 2. User's current web URL is validated against UK Based URL for NHS Checker Tool 
 3. Validated all the Questionalires for its labels and the Values and navigated based on the chosen answers
 4. Final Reesult Page is validated for its Label, Result page URL, Eligible Help Option received

