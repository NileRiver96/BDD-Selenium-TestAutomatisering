package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MyStepdefsreg {
    private WebDriver driver;
    private WebDriver driverr;



    @Given("I go to wished {string} on {string}")
    public void iGoToWished(String site, String browser) {


        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            driver.get(site);
        } else if (browser.equalsIgnoreCase("Firefox")) {

            driver = new FirefoxDriver();
            driver.get(site);

        }
    }
    @When("I enter registration details {string}, {string}, {string}, {string}, and {string}")
    public void iEnterRegistrationDetailsAnd(String firstName, String lastName, String email, String password, String confirmPassword) {
        WebElement fieldOne = driver.findElement(By.name("DateOfBirth"));
        fieldOne.click();
        WebElement month = driver.findElement(By.className("datepicker-switch"));
        month.click();

        WebElement year = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]"));
        year.click();

        WebElement slideYear = driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/thead/tr[2]/th[1]"));
        slideYear.click();
        slideYear.click();
        slideYear.click();


        WebElement chooseYear = driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[8]"));
        chooseYear.click();



        WebElement chooseMonth = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[12]"));
        chooseMonth.click();



        WebElement chooseDate = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[4]/td[4]"));
        chooseDate.click();



        WebElement firstNam = driver.findElement(By.cssSelector("input#member_firstname"));
        firstNam.sendKeys(firstName);
        waitForElementToBeClickable(firstNam);


        WebElement lastNam = driver.findElement(By.cssSelector("input#member_lastname"));
        lastNam.sendKeys(lastName);
        waitForElementToBeClickable(lastNam);


        WebElement emailAdress = driver.findElement(By.cssSelector("input[name='EmailAddress']"));
        emailAdress.sendKeys(email);
        waitForElementToBeClickable(emailAdress);


        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='ConfirmEmailAddress']"));
        confirmEmail.sendKeys(email);
        waitForElementToBeClickable(confirmEmail);


        WebElement pass = driver.findElement(By.cssSelector("#signupunlicenced_password"));
        pass.sendKeys(password);
        waitForElementToBeClickable(pass);

        WebElement confirmPass = driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"));
        confirmPass.sendKeys(confirmPassword);
        waitForElementToBeClickable(confirmPass);

    }
   // @When("I enter enter registration details {string}, {string}, {string}, {string}, and {string}")
  //  public void iEnter(String firstName, String lastName, String email, String password, String confirmPassword) {



  //  }

    @And("I accept the terms {string}")
    public void iAcceptTheTerms(String acceptsTerms) {
        switch (acceptsTerms) {
            case "acceptOne":
            case "acceptTwo":
            case "acceptThree":

                acceptTermsAndJoin();
                break;
            case "notAccept":
                noacceptAgeAndEthics();
                break;
            default:
                // Om inget matchar, gör ingenting
                break;
        }
    }

    @Then("A user account should be created succesfully and a {string} message should be displayed")
    public void aUserAccountShouldBeCreatedSuccesfullyAndAMessageShouldBeDisplayed(String messageType) {String expectedMessage;
        switch (messageType) {
            case "success":
                WebElement successMessage = driver.findElement(By.cssSelector("h2.bold:nth-child(1)"));
                String actual = successMessage.getText();
                expectedMessage = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
                assertEquals(expectedMessage, actual);
                break;
            case "errorLastname":
                WebElement errorMessageElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span"));
                String actualMessage = errorMessageElement.getText();
                String expectedErrorMessage = "Last Name is required";
                assertEquals(expectedErrorMessage, actualMessage);
                break;
            case "errorMismatched":
                WebElement mismatched = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[8]/div/div[2]/div[2]/div/span/span"));
                String actualErrorMessage = mismatched.getText();
                String expectedErrorMessageMismatched = "Password did not match";
                assertEquals(expectedErrorMessageMismatched, actualErrorMessage);
                break;
            case "errorTerms":
                WebElement termNoConfirmed = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span"));
                String actualErrorTerm = termNoConfirmed.getText();
                String expectedErrorTerm = "You must confirm that you have read and accepted our Terms and Conditions";
                assertEquals(expectedErrorTerm, actualErrorTerm);
                break;
            default:

                break;
        }
    }




    private void acceptTermsAndJoin() {
        WebElement checkFan = driver.findElement(By.cssSelector("div.col-sm-4:nth-child(12) > div:nth-child(1) > label:nth-child(3) > span:nth-child(3)"));
        checkFan.click();


        WebElement checkTerms = driver.findElement(By.cssSelector("div.row:nth-child(12) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(3) > span:nth-child(3)"));
        checkTerms.click();


        WebElement checkAgeTerms = driver.findElement(By.cssSelector("div.row:nth-child(12) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > label:nth-child(3) > span:nth-child(3)"));
        checkAgeTerms.click();


        WebElement checkBoxEthics = driver.findElement(By.cssSelector("div.md-checkbox:nth-child(7) > label:nth-child(3) > span:nth-child(3)"));
        checkBoxEthics.click();


        WebElement confirmAndJoin = driver.findElement(By.cssSelector("input[name='join']"));
        confirmAndJoin.click();

    }
    private void noacceptAgeAndEthics() {
        WebElement checkFan = driver.findElement(By.cssSelector("div.col-sm-4:nth-child(12) > div:nth-child(1) > label:nth-child(3) > span:nth-child(3)"));
        checkFan.click();



        WebElement checkBoxEthics = driver.findElement(By.cssSelector("div.md-checkbox:nth-child(7) > label:nth-child(3) > span:nth-child(3)"));
        checkBoxEthics.click();


        WebElement confirmAndJoin = driver.findElement(By.cssSelector("input[name='join']"));
        confirmAndJoin.click();

    }
    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



}



