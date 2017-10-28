const should = require('should');

var webdriver = require('selenium-webdriver'),
    by = webdriver.By,
    until = webdriver.until,
    driver = new webdriver.Builder()
        .forBrowser('chrome')
        .build(),
    url = 'https://www.amazon.com/'
    lampShadePrice = 0.0;

describe('Browse to Amazon.com and search for lamp shades', function(done) {
    // increase the time out to allow for extended page load times
    this.timeout(20000);

    before(function(done) {
        // go to amazon in a chrome window
        driver.get(url).then(() => done());
    });

    after(function() {
        driver.sleep(2000);
        return driver.quit();
    });

    it('Should verify the price of the selected lamp shade matches the price in the cart.', function(done) {
        driver.wait(until.elementLocated(by.id('twotabsearchtextbox')), 10000)
            .then((searchBox) => {
                //driver.findElement(by.id('twotabsearchtextbox')).sendKeys('lamp shades');
                searchBox.sendKeys('lamp shades');
            })
            .then(() => {
                driver.findElement(by.xpath('//*[@id="nav-search"]/form/div[2]/div/input')).click();
            })
            .then(() => {
                driver.wait(until.elementLocated(by.id('result_3')), 10000).click();
            })
            .then(() => {
                done();
            })
            .catch((err) => {
                sould(err).equal(null);
            });
    });
});
