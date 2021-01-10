package pages;

import support.DriverQA;

public class ProcessDetail extends BasePage {

    public ProcessDetail(DriverQA stepDriver) {
        super(stepDriver);
    }

    public String getNotice() {
        return driver.getText("notice");
    }

    public String getTextOfField(String field) {
        return driver.getText(field);
    }
}
