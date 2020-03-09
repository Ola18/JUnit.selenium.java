package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.FirstPage;
import pages.SecondPage;

public class RegisterToBankAccount extends BaseTest{

    @Test
    public void shouldSignUp() {
        FirstPage firstRegistrationPage = new FirstPage(driver);
        firstRegistrationPage.doNotHaveAnAccount()
                .selectUserTitle()
                .createNewUser()
                .clickOnNextButton();

        SecondPage secondPage = new SecondPage(driver);
        secondPage.enterUserData()
                .confirmForm();

        Assert.assertEquals("Success", secondPage.getAssertText());
    }
}

