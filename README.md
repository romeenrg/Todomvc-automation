# TodoMVC Test Automation Project
Browser used for testing: Chrome

Variants being tested: React and Preact

The automated tests we have written have revealed a bug with the React framework.

# Bug Report
## It's Impossible to Add a Single-Character Todo Item When Using the React Framework

### Description
When a user attempts to add a Todo item that's only a single character, no new item is created, and the character remains in the "What needs to be done?" input box.  
This is different to the Preact, Backbone.js and Angular frameworks, which accept single-character items without issue.  
It's unlikely that most users would find a single-character Todo item useful, and choosing an item name of two or more characters is simple, making this a low-priority bug to fix.

### Steps to reproduce manually
In the React framework, type the letter 't' in the 'What needs to be done?' box and press enter. No new item will be created.
### Priority
low
### Metadata
method testAddItems fails when trying to add a letter 't', and provides the following error date:

> Task :compileJava NO-SOURCE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources UP-TO-DATE
> Task :testClasses UP-TO-DATE
Nov 20, 2025 5:22:54 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 142, returning the closest version; found: 138; Please update to a Selenium version that supports CDP version 142

no such element: Unable to locate element: {"method":"css selector","selector":"li:nth-child(1) label"}
(Session info: chrome=142.0.7444.176)
For documentation on this error, please visit: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
Build info: version: '4.34.0', revision: '707dcb4246*'
System info: os.name: 'Mac OS X', os.arch: 'aarch64', os.version: '15.7.1', java.version: '21.0.9'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Command: [5ea01071d322630d1b478a9008a4388e, findElement {value=li:nth-child(1) label, using=css selector}]
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 142.0.7444.176, chrome: {chromedriverVersion: 142.0.7444.59 (4b8153ab58d3..., userDataDir: /var/folders/wd/nmrds70s61x...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:50298}, goog:processID: 38078, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: mac, proxy: Proxy(), se:cdp: ws://localhost:50298/devtoo..., se:cdpVersion: 142.0.7444.176, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Session ID: 5ea01071d322630d1b478a9008a4388e
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"li:nth-child(1) label"}
(Session info: chrome=142.0.7444.176)
For documentation on this error, please visit: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
Build info: version: '4.34.0', revision: '707dcb4246*'
System info: os.name: 'Mac OS X', os.arch: 'aarch64', os.version: '15.7.1', java.version: '21.0.9'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Command: [5ea01071d322630d1b478a9008a4388e, findElement {value=li:nth-child(1) label, using=css selector}]
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 142.0.7444.176, chrome: {chromedriverVersion: 142.0.7444.59 (4b8153ab58d3..., userDataDir: /var/folders/wd/nmrds70s61x...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:50298}, goog:processID: 38078, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: mac, proxy: Proxy(), se:cdp: ws://localhost:50298/devtoo..., se:cdpVersion: 142.0.7444.176, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Session ID: 5ea01071d322630d1b478a9008a4388e
at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)
at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)
at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
at org.openqa.selenium.remote.ErrorCodec.decode(ErrorCodec.java:167)
at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:138)
at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:50)
at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:215)
at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:216)
at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:174)
at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:544)
at org.openqa.selenium.remote.ElementLocation$ElementFinder$2.findElement(ElementLocation.java:165)
at org.openqa.selenium.remote.ElementLocation.findElement(ElementLocation.java:59)
at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:367)
at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:361)
at TodoChromeTest.testAddItems(TodoChromeTest.java:30)
at java.base/java.lang.reflect.Method.invoke(Method.java:580)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133)
at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1939)
at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:276)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:276)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:276)
at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)



00

> Task :test
TodoChromeTest > Adding items to Todo list: React > Adding item t, which tests adding single char item FAILED
org.openqa.selenium.NoSuchElementException at TodoChromeTest.java:30
15 tests completed, 1 failed
> Task :test FAILED
FAILURE: Build failed with an exception.
* What went wrong:
  Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/philipcharlesridgers/Projects/Automating%20Checking/Todomvc-automation/build/reports/tests/test/index.html
* Try:
> Run with --scan to get full insights.
BUILD FAILED in 7s
3 actionable tasks: 1 executed, 2 up-to-date


