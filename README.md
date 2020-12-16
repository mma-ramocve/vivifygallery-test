# Testing Vivify Ideas Gallery App - Automation

## Project 

<https://gallery-app.vivifyideas.com/>

This is a project to demonstrate automated testing process on Vivify Ideas Gallery App. Concept applied is Page Object Model (POM).

- There are 9 automated tests, divided in 3 classes.
- Testing involves deleting test data and restoring the initial state.
- There is testng.xml file created to allow all tests to run one after the other.

## Test scenarios and test cases

### Test home page
-	Test if click on Register tab takes to correct page
-	Test if click on Gallery App tab takes to home page

### Test login
-	Test if click on Login tab takes to correct page
-	Test login with valid credentials

### Test creating a new gallery
-	Test if click on Create Gallery as logged in user takes to correct page
-	Test to create a gallery as logged in user
-	Test if new gallery is created
-	Delete new gallery
-	Logout

## System resource
-   IntelliJ IDEA 2020.2.3 (Community Edition) 

-   Chrome web driver – version 87.0.4280.20 

-   Libraries: 
    * activation-1.1.1.jar 
    * commons-codec-1.13.jar 
    * commons-collections4-4.4.jar 
    * commons-compress-1.19.jar 
    * commons-logging-1.2.jar 
    * commons-math3-3.6.1.jar 
    * curvesapi-1.06.jar 
    * jaxb-api-2.3.1.jar 
    * jaxb-core-2.3.0.1.jar 
    * jaxb-impl-2.3.2.jar 
    * junit-4.12.jar 
    * log4j-1.2.17.jar 
    * poi-4.1.1.jar 
    * poi-examples-4.1.1.jar 
    * poi-excelant-4.1.1.jar 
    * poi-ooxml-4.1.1.jar 
    * poi-ooxml-schemas-4.1.1.jar 
    * poi-scratchpad-4.1.1.jar 
    * xmlbeans-3.1.0.jar
