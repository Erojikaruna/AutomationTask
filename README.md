# Gmail Account Registration Automation

This project automates the Gmail account registration process using **Java**, **Selenium WebDriver**, and **Apache POI** for Excel data input.

##  Features

- Automates the Gmail sign-up flow
- Inputs user details from an Excel file
-  using `Actions` for dropdown
- Handles dynamic elements like gender selection
- Cross-browser support ready (Chrome by default)
- Designed with readability and maintainability

## Technologies Used

- Java
- Selenium WebDriver
- Apache POI (for Excel reading)
- WebDriverManager
-Maven

##  Project Structure

  AutomationTask/
│
├── src/
│ └── test/
│ └── java/
│ └── Task/
│ └── GmailRegistration.java
├── src/
│ └── test/
│ └── resources/
│ └── Gmail.xlsx
└── pom.xml (if using Maven)

## Dependencies

<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.7.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.3</version>
    </dependency>
</dependencies>

