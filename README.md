## Validated get help with paying with NHS costs Online Service

### Technologies Used
BDD
Cucumber
Maven
Java
TestNG
IntelliJ IDE

### How to run?
Issue the below commands in project root directory

##### Maven
```javascript
mvn clean test
```
Or
```javascript
 mvn clean test -D"cucumber.options=--tag @regression -Dbrowser=firefox
 mvn clean test -D"cucumber.options=--tag @regression -Dbrowser=chrome
 By default it takes Chrome as Drvicer to execute the project
```

Currently supported browsers are 
* chrome
* firefox
