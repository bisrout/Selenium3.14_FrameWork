$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "LoginFeature",
  "description": "This feature is responsible for testing all the scenarios",
  "id": "loginfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 53386529800,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Check Login with  correct username and password",
  "description": "",
  "id": "loginfeature;check-login-with--correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I ensure application opened",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "I click login link",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I enter Username and Password",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password"
      ],
      "line": 7
    },
    {
      "cells": [
        "Biswajit",
        "Biswa@789"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I click login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I should see username with hello",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iEnsureApplicationOpened()"
});
formatter.result({
  "duration": 501574900,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginLink()"
});
formatter.result({
  "duration": 881997400,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterUsernameAndPassword(DataTable)"
});
formatter.result({
  "duration": 362274000,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginButton()"
});
formatter.result({
  "duration": 675102200,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeUsernameWithHello()"
});
formatter.result({
  "duration": 174447200,
  "status": "passed"
});
formatter.after({
  "duration": 6044771400,
  "status": "passed"
});
formatter.before({
  "duration": 44786179800,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Check registration",
  "description": "",
  "id": "loginfeature;check-registration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I ensure logged off",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click Registration Link",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "enter details",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I click RegisterButton",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I should get username with hello",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployyeeReg.iEnsureLoggedOff()"
});
formatter.result({
  "duration": 752800,
  "status": "passed"
});
formatter.match({
  "location": "EmployyeeReg.iClickRegistrationLink()"
});
formatter.result({
  "duration": 750142200,
  "status": "passed"
});
formatter.match({
  "location": "EmployyeeReg.enterdetails()"
});
formatter.result({
  "duration": 20462368000,
  "status": "passed"
});
formatter.match({
  "location": "EmployyeeReg.iClickRegisterButton()"
});
formatter.result({
  "duration": 651953100,
  "status": "passed"
});
formatter.match({
  "location": "EmployyeeReg.iShouldGetUsernameWithHello()"
});
formatter.result({
  "duration": 30192796800,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: Log off\nFor documentation on this error, please visit: https://selenium.dev/exceptions/#no_such_element\nBuild info: version: \u00274.0.0-alpha-5\u0027, revision: \u0027b3a0d621cc\u0027\nSystem info: host: \u0027USHYDBISROUT1\u0027, ip: \u002710.0.75.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 76.0.1, javascriptEnabled: true, moz:accessibilityChecks: false, moz:buildID: 20200507114007, moz:geckodriverVersion: 0.24.0, moz:headless: false, moz:processID: 15256, moz:profile: C:\\Users\\bisrout\\AppData\\Lo..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10.0, rotatable: false, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: ea148063-1fb6-4794-a1de-d281f475bedb\n*** Element info: {Using\u003dlink text, value\u003dLog off}\r\n\tat sun.reflect.GeneratedConstructorAccessor29.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:196)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:129)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:161)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:582)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:333)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:391)\r\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:233)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:325)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\r\n\tat com.ea.Framework.Controls.api.ControlHandler.invoke(ControlHandler.java:29)\r\n\tat com.sun.proxy.$Proxy27.toString(Unknown Source)\r\n\tat java.lang.String.valueOf(String.java:2994)\r\n\tat java.lang.StringBuilder.append(StringBuilder.java:131)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.toString(ExpectedConditions.java:305)\r\n\tat java.lang.String.valueOf(String.java:2994)\r\n\tat java.lang.StringBuilder.append(StringBuilder.java:131)\r\n\tat org.openqa.selenium.support.ui.FluentWait.lambda$checkConditionInLoop$2(FluentWait.java:253)\r\n\tat java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1590)\r\n\tat java.util.concurrent.CompletableFuture$AsyncSupply.exec(CompletableFuture.java:1582)\r\n\tat java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:289)\r\n\tat java.util.concurrent.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1056)\r\n\tat java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1692)\r\n\tat java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:157)\r\n\tat ✽.Then I should get username with hello(Login.feature:17)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 3450929600,
  "status": "passed"
});
});