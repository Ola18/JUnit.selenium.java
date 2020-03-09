package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import user.NewUser;

import java.util.List;

public class FirstPage extends PageObject {

    NewUser user = new NewUser();

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/p/a")
    private WebElement signUp;

    @FindBy(id = "title")
    private  WebElement selectTitle;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "gender")
    private List<WebElement> genderRadio;

    @FindBy(id = "dob")
    private WebElement birthDate;

    @FindBy(id = "ssn")
    private WebElement ssnNumber;

    @FindBy(id = "emailAddress")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    public FirstPage doNotHaveAnAccount() {
        signUp.click();
        return this;
    }

    public FirstPage selectUserTitle() {
        Select select = new Select(selectTitle);
        if (user.getGender() == 1) {
            select.selectByIndex(3);
        } else {
            select.selectByIndex(1);
        }
        return this;
    }

    public FirstPage createNewUser() {
        firstName.sendKeys(user.createFirstName());
        lastName.sendKeys(user.createLastName());
        genderRadio.get(user.getGender()).click();
        birthDate.sendKeys(user.createDateOfBirth());
        ssnNumber.sendKeys(user.createSSN());
        email.sendKeys(user.createEmailAddress());
        password.sendKeys("Pass1234");
        confirmPassword.sendKeys("Pass1234");
        return this;
    }

    public FirstPage clickOnNextButton() {
        nextButton.click();
        return this;
    }
}
