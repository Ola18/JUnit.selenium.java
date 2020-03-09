package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import user.NewUser;
import java.util.List;

public class SecondPage extends PageObject{

    NewUser user = new NewUser();

    public SecondPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({
            @FindBy(css = ".form-control")
    })
    private List<WebElement> listOfWebElements;

    @FindBy(id="agree-terms")
    private WebElement agreeButton;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement register;

    @FindBy(css = ".badge.badge-pill.badge-success")
    private WebElement assertText;

    public SecondPage enterUserData() {
        int i = -1;
        while (i < listOfWebElements.size()-1) {
            i++;
            listOfWebElements.get(i).sendKeys(user.userCompleteAddress(i));
        }
        return this;
    }

    public SecondPage confirmForm(){
        agreeButton.click();
        register.click();
        return this;
    }

    public String getAssertText(){
        return assertText.getText();
    }
}
