package automationPractise;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Stepdefintion {
    String baseUrl = "http://automationpractice.com/index.php";
    public WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @After
   public void closeBrowser() {
      driver.quit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("^I am on the homepage$")
    public void iAmOnHomePage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed());
    }

    @When("^I select SignIn link$")
    public void selectSignInLink() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".login")).click();

    }

    @Then("^I should be on the authentication page$")
    public void verifyAuthenticationPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#create-account_form")).isDisplayed());
    }

    @Then("^I should see SignUp panel$")
    public void verifySingUpPanel() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#center_column")).isDisplayed());

    }

    @When("^I Enter EmailId as (.*)$")
    public void enterEmailaddress(String email) {
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);

    }


    @When("^user enter email address as(.*)$")
    public void enterEmail(String email) {
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);

    }



    @And("^I should not be able to navigate if there is any validation message as(.+)$")
    public void unabletoRegister(String message){
        System.out.println("Expected message: "+message);

        String errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger ol li")).getText();
        Assert.assertEquals(message, errorMessage);
        System.out.println("Actual message : "+errorMessage);



    }

    @Then("^I Should be on the Registration page$")
    public void verifyRegisterPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#authentication")).isDisplayed());
    }

    @And("^I should navigate to Registration form$")
     public void Registrationform(){
        Assert.assertTrue(driver.findElement(By.cssSelector("#authentication")).isDisplayed());
    }
    @When("^I enter username as \"([^\"]*)\", password as \"([^\"]*)\"$")
    public void enterEmsilAndPassword(String email, String password) {
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
    }

    @And("^I click SignIn$")
    public void iClickSignIn() {
        driver.findElement(By.cssSelector("#SubmitLogin")).click();

    }

    @Then("^I Should be loggedIn successfully$")
    public void LoogedInSuccessful() {
        Assert.assertEquals("My account-My Store", driver.getTitle());

    }


    @And("^I should be on my account page$")
    public void myAccountPage() {
        WebElement accountLinks = driver.findElement(By.cssSelector(".myaccount-link-list"));
        Assert.assertTrue(accountLinks.isDisplayed());
    }

    @Then("^I should not be loggedIn$")
    public void loggedIn()
    {
        Assert.assertTrue (driver.findElement(By.cssSelector("#authentication")).isDisplayed());
    }


    //        x. Select the title
    @And("^I enter title as (.+)$")
    public void selectTitle(String title) {
        WebElement abc = driver.findElement(By.cssSelector("#id_gender1"));
        abc.sendKeys(title);
        abc.click();

    }

    @And("^firstname as (.*) and lastname as (.*)$")
    public void firstnameAndlastname(String firstname, String lastname) {
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(lastname);
    }

    @And("^Password as (.*) and Address as (.*) and City as (.*) and State as (.*)$")
    public void passwordAddressAndCity(String password, String address, String city, String state) {
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
        driver.findElement(By.cssSelector("#address1")).sendKeys(address);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        driver.findElement(By.cssSelector("#id_state")).sendKeys(state);
    }


    @And("^DateOfBirth as (.*),(.*),(.*)$")
    public void dateofbirth_(String day, String month, String year) {
        driver.findElement(By.cssSelector("#days")).sendKeys(day);
        driver.findElement(By.cssSelector("#months")).sendKeys(month);
        driver.findElement(By.cssSelector("#years")).sendKeys(year);
    }


    @And("^zipPostal Code as (.*) and mobile no as (.*)$")
    public void zipcodeandmobileno(String zipcode, String mobilenumber) {
        driver.findElement(By.cssSelector("#postcode")).sendKeys(zipcode);
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(mobilenumber);
    }

    @And("^Assign an Address alias for future reference as (.*)$")
    public void enterFutureReference(String reference) {
        driver.findElement(By.cssSelector("#alias")).sendKeys(reference);
    }

    @And("^I select Register button$")
    public void clickRegistorButton() {
        driver.findElement(By.cssSelector("#submitAccount")).click();
    }

    @And("^I should see validation message$")
    public void emailId() {
        String errorMessages = driver.findElement(By.cssSelector("#create_account_error ol li")).getText();
        System.out.println(errorMessages);
    }
    @And("^I should see validation message as (.*)$")
    public void ValidationMessage(String message) {
        System.out.println("Expected message "+message);

        String errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger ol li")).getText();
        Assert.assertEquals(message, errorMessage);

        System.out.println("Actual message : "+errorMessage);
        driver.quit();

    }


    @And("I click Create An Account Button")
    public void iClickCreateAnAccountButton() {
        driver.findElement((By.cssSelector("#SubmitCreate"))).click();
        //String error = driver.findElement(By.cssSelector(".alert.alert-danger ol li")).getText();

    }

    @And("^I see validation message as (.+) I should not loggedIn$")
    public void iSeeValidationMessageAsMessageIShouldNotLoggedIn(String message ) {
        //Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger ol li")).isDisplayed());
       // closeBrowser();
        //System.out.println("test passed)");
        System.out.println("Actual message : "+message);
        String error = driver.findElement(By.cssSelector(".alert.alert-danger ol li")).getText();
        Assert.assertEquals(message, error);
        System.out.println("Expected message : "+error);
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger ol li")).isDisplayed());





    }
}