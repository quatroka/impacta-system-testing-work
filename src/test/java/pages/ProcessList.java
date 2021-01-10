package pages;

import support.DriverQA;

public class ProcessList extends BasePage {
    public static final String URL = "http://agapito-server.herokuapp.com/processos";

    public ProcessList(DriverQA driver) {
        super(driver);
    }

    public void clickNewProcessButton() {
        driver.click("btn-novo");
    }

    public void clickEditProcess(String id) {
        driver.click("btn-edit_" + id);
    }

    public void clickDetailProcess(String id) {
        driver.click("btn-show_" + id);
    }

    public void clickDeleteProcess(String id) {
        driver.click("btn-delete_" + id);
        driver.ChooseOkOnNextConfirmation();
    }
}
