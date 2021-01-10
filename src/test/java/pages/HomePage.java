package pages;

import support.DriverQA;

public class HomePage  extends BasePage {

    public HomePage(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void open() {
        final String url = "http://agapito-server.herokuapp.com/";
        driver.openURL(url);
    }
}
