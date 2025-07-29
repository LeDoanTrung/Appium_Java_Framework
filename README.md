# Appium Java Test Automation Framework

A comprehensive test automation framework for mobile application testing using Appium, Java, TestNG, and Maven. This framework supports both local device testing and cloud testing via BrowserStack.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Framework Architecture](#framework-architecture)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [BrowserStack Integration](#browserstack-integration)
- [Contributing](#contributing)

## 🎯 Project Overview

This framework is designed to test an e-commerce mobile application with the following key features:

- **Cross-platform Support**: Android and iOS testing capabilities
- **Page Object Model (POM)**: Clean and maintainable test structure
- **Data-Driven Testing**: JSON-based test data management
- **Parallel Execution**: Multiple device testing support
- **Rich Reporting**: ExtentReports integration for detailed test reports
- **Cloud Testing**: BrowserStack integration for device cloud testing
- **Emulator Management**: Automated Android emulator handling

### Target Application
- **Package**: `com.studiobluelime.ecommerceapp`
- **Main Activity**: `com.studiobluelime.ecommerceapp.WelcomeActivity`
- **Type**: E-commerce mobile application

## 🏗️ Framework Architecture

The framework follows a layered architecture pattern:

```
┌─────────────────────┐
│    Test Layer       │  ← LoginTest, RegisterTest
├─────────────────────┤
│    Page Layer       │  ← HomePage, WelcomePage, etc.
├─────────────────────┤
│    Core Layer       │  ← Driver, Config, Utils
├─────────────────────┤
│    Data Layer       │  ← JSON test data files
└─────────────────────┘
```

### Key Design Patterns Used:
- **Page Object Model (POM)**: Separates page elements and actions
- **Factory Pattern**: Driver creation and management
- **Builder Pattern**: Configuration management
- **Data Provider Pattern**: Test data management

## 📁 Project Structure

```
Appium_Java_Framework/
├── src/
│   ├── main/
│   │   ├── java/com/
│   │   │   ├── constant/           # Application constants
│   │   │   │   ├── FilePathConstant.java
│   │   │   │   ├── MenuBarConstant.java
│   │   │   │   ├── MessageConstant.java
│   │   │   │   └── SettingConstant.java
│   │   │   ├── core/               # Core framework components
│   │   │   │   ├── config/         # Configuration management
│   │   │   │   ├── driver/         # Appium driver management
│   │   │   │   ├── element/        # Element interaction utilities
│   │   │   │   ├── emulator/       # Emulator management
│   │   │   │   ├── enumobj/        # Enum objects
│   │   │   │   ├── report/         # Reporting utilities
│   │   │   │   └── util/           # Common utilities
│   │   │   └── setting/
│   │   │       └── appSetting.json # App configuration
│   │   └── resources/
│   │       └── app/
│   │           └── app.apk         # Application under test
│   └── test/
│       ├── java/com/
│       │   ├── dataprovider/       # TestNG data providers
│       │   │   └── AccountDataProvider.java
│       │   ├── model/              # Data models
│       │   │   └── Account.java
│       │   ├── page/               # Page Object classes
│       │   │   ├── BasePage.java
│       │   │   ├── HomePage.java
│       │   │   ├── MenuBar.java
│       │   │   ├── MyAccountPage.java
│       │   │   ├── MyDetailsPage.java
│       │   │   ├── RegisterPage.java
│       │   │   └── WelcomePage.java
│       │   ├── test/               # Test classes
│       │   │   ├── BaseTest.java
│       │   │   ├── LoginTest.java
│       │   │   └── RegisterTest.java
│       │   └── testdata/           # Test data files
│       │       └── account.json
│       └── resources/
│           └── testng.xml          # TestNG configuration
├── target/                         # Maven build output
├── browserstack.yml                # BrowserStack configuration
├── pom.xml                        # Maven dependencies
└── README.md                      # This file
```

## 🔧 Prerequisites

Before setting up the framework, ensure you have the following installed:

### Required Software:
1. **Java Development Kit (JDK)** - Version 22 or higher
2. **Apache Maven** - Version 3.6.0 or higher
3. **Node.js** - Version 14.0 or higher
4. **Appium Server** - Version 2.0 or higher
5. **Android Studio** (for Android testing)
6. **Android SDK** and **Platform Tools**

### Optional:
- **Xcode** (for iOS testing on macOS)
- **BrowserStack Account** (for cloud testing)

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/LeDoanTrung/Appium_Java_Framework.git
cd Appium_Java_Framework
```

### 2. Install Java JDK 22
- Download and install Java JDK 22 from [Oracle](https://www.oracle.com/java/technologies/downloads/)
- Set `JAVA_HOME` environment variable
- Add Java to your system PATH

### 3. Install Maven
```bash
# Windows (using Chocolatey)
choco install maven

# macOS (using Homebrew)
brew install maven

# Verify installation
mvn --version
```

### 4. Install Node.js and Appium
```bash
# Install Node.js from https://nodejs.org/

# Install Appium globally
npm install -g appium

# Install Appium drivers
appium driver install uiautomator2
appium driver install xcuitest

# Verify Appium installation
appium --version
```

### 5. Android Setup
1. Download and install [Android Studio](https://developer.android.com/studio)
2. Install Android SDK and Platform Tools
3. Set environment variables:
   ```bash
   ANDROID_HOME=C:\Users\YourUsername\AppData\Local\Android\Sdk
   ```
4. Add to PATH:
   ```bash
   %ANDROID_HOME%\platform-tools
   %ANDROID_HOME%\tools
   %ANDROID_HOME%\tools\bin
   ```

### 6. Install Project Dependencies
```bash
# Navigate to project directory
cd Appium_Java_Framework

# Install Maven dependencies
mvn clean install -DskipTests
```

### 7. Verify Setup
```bash
# Check Java
java --version

# Check Maven
mvn --version

# Check Appium
appium --version

# Check Android setup
adb version
```

## 🔧 Configuration

### App Configuration (`src/main/java/com/setting/appSetting.json`)
```json
{
    "platformName": "Android",
    "platformVersion": "11.0",
    "deviceName": "emulator-5554",
    "appPackage": "com.studiobluelime.ecommerceapp",
    "appActivity": "com.studiobluelime.ecommerceapp.WelcomeActivity",
    "automationName": "UiAutomator2",
    "commandTimeout": "60",
    "appiumServerURL": "http://localhost:4723"
}
```

### Test Data Configuration (`src/test/java/com/testdata/account.json`)
```json
{
  "name": "TrungLe",
  "mobile": "0123456789",
  "email": "trungletest@gmail.com",
  "password": "trung1999"
}
```

### TestNG Configuration (`src/test/resources/testng.xml`)
- Configures test suites and classes
- Manages test execution order
- Handles parallel execution settings

## 🚀 Running Tests

### Prerequisites Before Running Tests:
1. **Start Appium Server**:
   ```bash
   appium
   ```

2. **Start Android Emulator** (if testing locally):
   ```bash
   # List available AVDs
   emulator -list-avds
   
   # Start specific emulator
   emulator -avd YourAVDName
   ```

3. **Install APK** (if not already installed):
   ```bash
   adb install src/main/resources/app/app.apk
   ```

### Running Tests Locally

#### Method 1: Using Maven Commands
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn clean test -Dtest=LoginTest

# Run specific test method
mvn clean test -Dtest=LoginTest#testValidLogin

# Run tests with custom TestNG suite
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

#### Method 2: Using TestNG XML
```bash
# Run using TestNG XML configuration
mvn clean test -DsuiteXmlFile=testng.xml
```

#### Method 3: Using IDE
- Right-click on test class/method in IDE
- Select "Run" or "Run as TestNG Test"

### Running Tests with Different Configurations

#### Custom Device Configuration:
```bash
mvn clean test -DplatformName=Android -DplatformVersion=12.0 -DdeviceName=Pixel5
```

#### Debug Mode:
```bash
mvn clean test -Dmaven.surefire.debug=true
```

#### Parallel Execution:
Modify `testng.xml` to enable parallel execution:
```xml
<suite name="Parallel Tests" parallel="methods" thread-count="2">
```

## 📊 Reporting

The framework uses **ExtentReports** for comprehensive test reporting:

### Report Features:
- **Test execution summary** with pass/fail statistics
- **Detailed test steps** with screenshots
- **Error logs and stack traces** for failed tests
- **Device and environment information**
- **Interactive charts and graphs**

### Report Location:
- Reports are generated in `target/ExtentReport/` directory
- Open `ExtentReport.html` in any web browser

### Screenshot Capture:
- Automatic screenshot capture on test failures
- Manual screenshot capture using `ReportLog.captureScreenshot()`

## ☁️ BrowserStack Integration

The framework supports cloud testing via BrowserStack:

### Configuration (`browserstack.yml`):
```yaml
userName: your_browserstack_username
accessKey: your_browserstack_access_key
framework: testng
app: bs://your_app_id
platforms:
  - platformName: android
    deviceName: Google Pixel 4
    platformVersion: 11.0
parallelsPerPlatform: 1
browserstackLocal: true
buildName: browserstack-build-1
projectName: BrowserStack Sample
```

### Running Tests on BrowserStack:
```bash
# Upload app to BrowserStack
curl -u "USERNAME:ACCESS_KEY" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@src/main/resources/app/app.apk"

# Run tests on BrowserStack
mvn clean test -P browserstack
```

### BrowserStack Features:
- **Real device testing** on 3000+ devices
- **Parallel execution** across multiple devices
- **Video recording** of test sessions
- **Network logs** and debugging capabilities
- **Integration** with CI/CD pipelines

## 🔍 Troubleshooting

### Common Issues and Solutions:

#### 1. Appium Server Connection Issues
```bash
# Check if Appium server is running
curl -X GET http://localhost:4723/wd/hub/status

# Start Appium with specific port
appium --port 4723
```

#### 2. Device Not Found
```bash
# List connected devices
adb devices

# Restart ADB server
adb kill-server
adb start-server
```

#### 3. App Not Installed
```bash
# Install APK manually
adb install -r src/main/resources/app/app.apk

# Check installed packages
adb shell pm list packages | grep ecommerce
```

#### 4. Element Not Found
- Verify element locators using **Appium Inspector**
- Check if app is in the expected state
- Add explicit waits for elements

#### 5. Maven Dependency Issues
```bash
# Clean and reinstall dependencies
mvn clean install -U

# Clear Maven cache
mvn dependency:purge-local-repository
```

## 🧪 Adding New Tests

### 1. Create New Page Object:
```java
public class NewPage extends BasePage {
    // Define page elements and methods
}
```

### 2. Create New Test Class:
```java
public class NewTest extends BaseTest {
    @Test
    public void testNewFeature() {
        // Test implementation
    }
}
```

### 3. Update TestNG XML:
```xml
<classes>
    <class name="com.test.NewTest"></class>
</classes>
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

### Code Standards:
- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Write unit tests for utility methods
- Maintain consistent code formatting

## 📄 Dependencies

### Main Dependencies:
- **Selenium WebDriver**: 4.8.0
- **Appium Java Client**: 8.3.0
- **TestNG**: 7.10.2
- **ExtentReports**: 5.1.2
- **Jackson Databind**: 2.17.2
- **AssertJ**: 3.26.0
- **Apache Commons Lang**: 3.12.0
- **BrowserStack Java SDK**: Latest

### Build Tools:
- **Maven**: Build automation
- **Maven Compiler Plugin**: Java 22 compilation
- **Maven Surefire Plugin**: Test execution

## 📞 Support

For questions or issues:
- Create an issue in the GitHub repository
- Contact: [LeDoanTrung](https://github.com/LeDoanTrung)

---

**Happy Testing! 🚀**
