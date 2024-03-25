package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefsRegisterr {


    private WebDriver driver;

    @Given("I navigate to {string}")
    public void iNavigateTo(String webs) {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {

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


        WebElement firstName = driver.findElement(By.cssSelector("input#member_firstname"));
        firstName.sendKeys("Saleh");

        WebElement lastName = driver.findElement(By.cssSelector("input#member_lastname"));
        lastName.sendKeys("Alisheik");

        WebElement emailAdress = driver.findElement(By.cssSelector("input[name='EmailAddress']"));
        emailAdress.sendKeys("Saleh.Attund@outlook.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='ConfirmEmailAddress']"));
        confirmEmail.sendKeys("Saleh.Attund@outlook.com");

        WebElement password = driver.findElement(By.cssSelector("#signupunlicenced_password"));
        password.sendKeys("Amira1");

        WebElement confirmPassword = driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"));
        confirmPassword.sendKeys("Amira1");


    }

    @And("I accept the terms and conditions")
    public void iAcceptTheTermsAndConditions() {
        WebElement checkFan = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[10]/div/div/div[4]/div/label/span[3]"));
        checkFan.click();


        WebElement checkTerms = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]"));
        checkTerms.click();

        WebElement checkAgeTerms = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]"));
        checkAgeTerms.click();

        WebElement checkBoxEthics = driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]"));
        checkBoxEthics.click();

        WebElement confirmAndJoin = driver.findElement(By.cssSelector("input[name='join']"));
        confirmAndJoin.click();


    }

    @Then("the user account should be created successfully")
    public void theUserAccountShouldBeCreatedSuccessfully() {
        WebElement successMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/h2"));

        String actualErrorMessage = successMessage.getText();
        String expectedErrorMessage = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";

        assertEquals( expectedErrorMessage, actualErrorMessage);

    }

    @When("I enter valid registration details without last name")
    public void iEnterValidRegistrationDetailsWithoutLastName() {
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

        WebElement firstName = driver.findElement(By.cssSelector("input#member_firstname"));
        firstName.sendKeys("Saleh");


        WebElement emailAdress = driver.findElement(By.cssSelector("input[name='EmailAddress']"));
        emailAdress.sendKeys("Saleh.AttundaGol@outlook.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='ConfirmEmailAddress']"));
        confirmEmail.sendKeys("Saleh.AttundaGol@outlook.com");

        WebElement password = driver.findElement(By.cssSelector("#signupunlicenced_password"));
        password.sendKeys("Amira1");

        WebElement confirmPassword = driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"));
        confirmPassword.sendKeys("Amira1");


    }

    @Then("The registration form should show an error message asking the user to enter last name")
    public void theRegistrationFormShouldShowAnErrorMessageAskingTheUserToEnterLastName() {

        WebElement errorMessageElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Last Name is required";

        assertEquals( expectedErrorMessage, actualErrorMessage);

        
    }

    @And("The user account should not be created")
    public void theUserAccountShouldNotBeCreated() {
    }

    @When("I enter valid registration with mismatched password")
    public void iEnterValidRegistrationWithMismatchedPassword() {
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

        WebElement firstName = driver.findElement(By.cssSelector("input#member_firstname"));
        firstName.sendKeys("Saleh");


        WebElement emailAdress = driver.findElement(By.cssSelector("input[name='EmailAddress']"));
        emailAdress.sendKeys("Saleh.AttundaGol@outlook.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='ConfirmEmailAddress']"));
        confirmEmail.sendKeys("Saleh.AttundaGol@outlook.com");

        WebElement password = driver.findElement(By.cssSelector("#signupunlicenced_password"));
        password.sendKeys("Amira1");

        WebElement confirmPassword = driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"));
        confirmPassword.sendKeys("Amira");


    }

    @Then("The registration form should show an error message that the Password did not match")
    public void theRegistrationFormShouldShowAnErrorMessageThatThePasswordDidNotMatch() {
        WebElement errorMessageElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[8]/div/div[2]/div[2]/div/span/span"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Password did not match";

        assertEquals( expectedErrorMessage, actualErrorMessage);
    }

    @And("I dont accept the terms and conditions")
    public void iDontAcceptTheTermsAndConditions() {    WebElement checkFan = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[10]/div/div/div[4]/div/label/span[3]"));
        checkFan.click();

        WebElement checkAgeTerms = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]"));
        checkAgeTerms.click();

        WebElement checkBoxEthics = driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]"));
        checkBoxEthics.click();

        WebElement confirmAndJoin = driver.findElement(By.cssSelector("input[name='join']"));
        confirmAndJoin.click();


    }

    @Then("The registration form should show an error message that i need to accept the terms and conditions")
    public void theRegistrationFormShouldShowAnErrorMessageThatINeedToAcceptTheTermsAndConditions() {
        WebElement errorMessageElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "You must confirm that you have read and accepted our Terms and Conditions";
        assertEquals( expectedErrorMessage, actualErrorMessage);
    }
}