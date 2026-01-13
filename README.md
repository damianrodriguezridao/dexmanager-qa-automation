# Dex Manager - QA Challenge (Selenium + Java + TestNG)

This repository contains a small automation project to validate login into Dex Manager as requested in the QA challenge.

## Tech stack
- Java 17
- Selenium WebDriver
- TestNG
- WebDriverManager
- Maven

## How to run
### 1) Prerequisites
Make sure you have Java 17+ and Maven installed.

### 2) Execute tests (default: Chrome)
```bash
mvn test
```

### Run in headless mode
```bash
mvn test -Dheadless=true
```

### Change browser (chrome | firefox)
```bash
mvn test -Dbrowser=firefox
```

## Configuration
Defaults match the challenge:
- baseUrl: https://demo4.dexmanager.com/
- username: challengeqa
- password: Abcd1234

You can override via Maven system properties:
```bash
mvn test -DbaseUrl=https://demo4.dexmanager.com/ -Dusername=challengeqa -Dpassword=Abcd1234
```

## Notes
- Uses explicit waits (WebDriverWait) for stability.
- On failure, a screenshot is saved into `target/screenshots/`.
- Post-login validation uses a robust fallback strategy (e.g., Content menu / sidebar).
