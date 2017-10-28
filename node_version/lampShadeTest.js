const should = require('should');

var webdriver = require('selenium-webdriver'),
    by = webdriver.By,
    until = webdriver.until,
    capabilities = {
        'browserName': 'chrome',
        'chromeOptions': {
            'args': ['--incognito']
        }
    },
    driver = new webdriver.Builder()
        .withCapabilities(capabilities)
        .build(),
    url = 'https://www.amazon.com/'
    lampShadePrice = 0.0;

describe('Browse to Amazon.com and search for lamp shades', function(done) {
    // increase the time out to allow for extended page load times
    this.timeout(15000);

    before(function(done) {
        // go to amazon in a chrome window
        driver.get(url).then(() => done());
    });

    after(function() {
        driver.sleep(2000);
        return driver.quit();
    });

    it('Should verify the price of the selected lamp shade matches the subtotal of the cart.', function(done) {
        // wait for the search box to be located
        driver.wait(until.elementLocated(by.id('twotabsearchtextbox')), 10000)
            .then((searchBox) => {
                // enter 'lamp shades' into the search box
                searchBox.sendKeys('lamp shades');
            })
            .then(() => {
                // click the search button
                driver.findElement(by.xpath('//*[@id="nav-search"]/form/div[2]/div/input')).click();
            })
            .then(() => {
                // select the third result
                driver.wait(until.elementLocated(by.id('result_3')), 10000).click();
            })
            .then(() => {
                // get the price of that item
                return driver.wait(until.elementLocated(by.id('priceblock_ourprice')), 10000).getText();
            })
            .then((priceText) => {
                // store the price
                lampShadePrice = priceText;

                // add that item to the cart
                driver.findElement(by.id('add-to-cart-button')).click();
            })
            .then(() => {
                // get the subtotal
                return driver.wait(until.elementLocated(by.xpath('//*[@id="hlb-subcart"]/div[1]/span/span[2]')), 10000).getText();
            })
            .then((subTotText) => {
                // the should library asserts that the sub total amount is equal to the price of the lamp shade
                should(subTotText).equal(lampShadePrice);
                done();
            })
            .catch((err) => {
                should(err).equal(null);
                done();
            });
    });
});
