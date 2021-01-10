package pages;

import support.DriverQA;

public class ProcessForm extends BasePage {

    public ProcessForm(DriverQA driver) {
        super(driver);
    }

    public void fillStringInput(String label, String value) {
        final String labelXPath = "//label[text()='" + label + "']";
        final String inputId = driver.getAttribute(labelXPath, "for", "xpath");
        driver.sendKeys(value, inputId);
    }

    public void fillUrgency(String value) {
        driver.selectByText(value, "processo_urgente");
    }

    public void fillArbitration(String value) {
        if (value.equals("Sim")) {
            driver.click("#processo_arbitramento_s", "css");
        } else {
            driver.click("#processo_arbitramento_n", "css");
        }
    }

    public void clickSave() {
        driver.click("#btn-save", "css");
    }
}
