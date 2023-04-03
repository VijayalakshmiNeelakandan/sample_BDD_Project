## Automation of get help with paying for NHS costs Online Service

### Features of the Framework
Page Object Model
BDD and Cucumber
Selenium Java
Maven Build Model

### Currently supported browsers are 
* Chrome
* Firefox

### Pre-Requisites
* Browsers - Chrome and Firefox
* IntelliJ IDE to write the Test Scripts (along with Git, Cucumber, Gherkin Plugins )
* Java JDK 1.8
* Maven Model
* Git Bash or Git Desktop to clone or manage both Local and Remote Repositories
* TestNG


### How to run?
* Download or clone the project
* Navigate to the Root Folder of the Project
* Install the dependencies and execute the below maven command through the command line prompt
##### Maven
```javascript
 mvn test
 By default it takes Chrome as Driver to execute the project
  or
 mvn clean test -Dtags= @regression -Dbrowser=firefox
 mvn clean test -Dtags= @regression -Dbrowser=chrome
 ```

### Reports
After the test execution completed, you can see Cucumber Basic HTML reports under `target` directory


### Test Coverage
Tests are covered for all the below requirement:
 1. User is validated for UK Citizenship
 2. User's current web URL is validated against UK Based URL for NHS Checker Tool 
 3. Validated all the Questionaires for its labels and the Values and navigated based on the chosen answers
 4. Final Result Page is validated for its Label, Result page URL, Eligible Help Option received

### Re-Usable PageObjects and Methods written in the Framework
Page Objects:
questionLabel - which was used multiple times in the re-usable methods
cookieAcceptBtn
nextCta
noRadioBtn

Re-Usable Methods:
clickNextCta() - this was used 13 times across the Test Suite
setNoOption() - this was used 9 times across the Test Suite
verifyQnLabel() - this was used 12 times across the Test Suite

### Element Locators Used 
css and id Attributes