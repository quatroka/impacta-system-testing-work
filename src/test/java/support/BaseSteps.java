package support;

public class BaseSteps {

    protected static DriverQA driver = new DriverQA();

    public BaseSteps(){
//        driver.start("chrome");
        driver.start("firefox");
    }

}
