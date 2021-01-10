package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definition.ProcessEntity;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class CRUDProcessSteps extends BaseSteps {
    private final HomePage homePage = new HomePage(driver);
    private final MenuImpacta menuImpacta = new MenuImpacta(driver);
    private final ProcessList processList = new ProcessList(driver);
    private final ProcessForm processForm = new ProcessForm(driver);
    private final ProcessDetail processDetail = new ProcessDetail(driver);

    @Given("^are on home page$")
    public void areOnHomePage() {
        homePage.open();
    }

    @And("^user clicks in 'Processos' on menu$")
    public void userClicksInProcessosOnMenu() {
        menuImpacta.clickProcess();
    }

    @And("^user clicks on button 'Novo Processo'$")
    public void userClicksOnButtonNovoProcesso() {
        processList.clickNewProcessButton();
    }

    @And("^user fills input with required fields$")
    public void userFillsInputWithRequiredFields() {
        processForm.fillStringInput("Vara", "São Paulo");
        processForm.fillStringInput("Numero processo", "6924");
        processForm.fillStringInput("Natureza", "Civil");
        processForm.fillStringInput("Partes", "Leonardo X Caio");
        processForm.fillStringInput("Data entrada", "24/08/1998");
        processForm.fillStringInput("Status", "Ativo");
    }

    @When("^user clicks on 'Salvar' button$")
    public void userClicksOnSaveButton() {
        processForm.clickSave();
    }

    @Then("^user must see the \"([^\"]*)\" message$")
    public void userMustSeeTheMessage(String message) {
        Assert.assertEquals(message, processDetail.getNotice());
        ProcessEntity.setId(processDetail.getTextOfField("codigo"));
    }

    @Given("^user wants see details of a created process$")
    public void userWantsSeeDetailsOfACreatedProcess() {
        Assert.assertNotNull(ProcessEntity.getId());
    }

    @When("^user clicks on 'Mostrar' button$")
    public void userClicksOnMostrarButton() {
        processList.clickDetailProcess(ProcessEntity.getId());
    }

    @Then("^user see process details$")
    public void userSeeProcessDetails() {
        Assert.assertEquals(processDetail.getTextOfField("vara"), "São Paulo");
        Assert.assertEquals(processDetail.getTextOfField("numero"), "6924");
        Assert.assertEquals(processDetail.getTextOfField("natureza"), "Civil");
        Assert.assertEquals(processDetail.getTextOfField("partes"), "Leonardo X Caio");
        Assert.assertEquals(processDetail.getTextOfField("dt_entrada"), "1998-08-24");
        Assert.assertEquals(processDetail.getTextOfField("status"), "Ativo");
    }

    @And("^user clicks on 'Editar' button of ID of created process$")
    public void userClicksOnEditarButton() {
        processList.clickEditProcess(ProcessEntity.getId());
    }

    @And("^user informs \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void userInformsEqualsTo(String label, String value) {
        if (label.equals("Arbitramento")) {
            processForm.fillArbitration(value);
        } else if (label.equals("Urgente")) {
            processForm.fillUrgency(value);
        } else {
            processForm.fillStringInput(label, value);
        }
    }

    @Given("^user wants delete a process$")
    public void userWantsDeleteAProcess() {
        Assert.assertNotNull(ProcessEntity.getId());
    }

    @When("^user clicks on 'Apagar' button of ID of created process$")
    public void userClicksOnApagarButtonOfIDOfCreatedProcess() {
        processList.clickDeleteProcess(ProcessEntity.getId());
    }


    @Then("^user returns to page of process list$")
    public void userReturnsToPageOfProcessList() {
        Assert.assertEquals(driver.getCurrentUrl(), ProcessList.URL);
    }
}
