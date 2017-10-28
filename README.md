# Amazon Lamp Shade Selenium
Short Selenium Webdriver test that searches for lamp shades and then selects a search result, stores the price, and adds the item to the shopping cart.

## Node Version
Since it wasn't specified I've included both a Java version and a NodeJS version. In order to run the
Node version you will need to have Chrome web browser, Node v8.4, and NPM installed.  You will also
need Selenium-WebDriver, Chromedriver, and Mocha installed on your system path.  You will then need
to pull down my code and run:
```
npm install
```
If you are unfamiliar with Node and NPM this will install the project dependencies in a directory
called 'node_modules'.  At this point you should be ready to run the tests.  I used the Mocha library
as a testing library.  Also, to produce the report for the tests I used the Mochawesome library.
To run the test:
```
mocha lampShadeTest.js --reporter mochawesome
```

Then to see the report open the 'mochawesome.html' found under the mochawesome-resport directory.
