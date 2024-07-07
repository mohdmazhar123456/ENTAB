import com.entab.commonutils.actions.AssertActions;
import com.entab.commonutils.commonlib.CommonLib;
import com.entab.driver.Driver;
import org.testng.annotations.Test;

public class LoginPageTest extends Driver {

    @Test
    public void testLandingPage() throws InterruptedException {
        try {
            CommonLib.info("Going to test Landing page");
            String landingPageTitleText = pages.getLandingPage().getLandingPageTitleText();
            assertCheck.append(AssertActions.assertEqualStringType(landingPageTitleText, "Lotus Valley International School", "Title matched successfully", "Title not matched"));
            AssertActions.checkAllAssertCheck(assertCheck);
        } catch (Exception e) {
            CommonLib.error(e.getMessage());
        }
    }

    @Test
    public void testLoginPageFunctionality() {
        try {
            CommonLib.info("Going to test UserId box is clickable");
            pages.getLandingPage().clickLoginBtn();
            pages.getLoginPage().clickUserIdTextBox();
            String userNamePlaceholder = pages.getLoginPage().getUserNamePlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(userNamePlaceholder, "Enter Your User ID", "Placeholder Is Correct for User Id Field", "Placeholder Is NOT Correct for User Id Field"));
            pages.getLoginPage().enterUserName();
            pages.getLoginPage().clickPasswordTextBox();
            String passwordPlaceholder = pages.getLoginPage().getPasswordPlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(passwordPlaceholder, "Enter Your Password", "Placeholder Is Correct for Password Field", "Placeholder Is NOT Correct for Password Field"));

            pages.getLoginPage().enterPassword();
            pages.getLoginPage().clickLogin();
            pages.getLoginPage().enterOtp();
            pages.getLoginPage().verifyButton();

            Thread.sleep(10000);
            pages.getLoginPage().clickDateDropdown();
            Thread.sleep(10000);
            
            pages.getLoginPage().clickOn2023Session();
            Thread.sleep(10000);
            
        } catch (Exception e) {
            CommonLib.error(e.getMessage());
        }

    }
    
    
}

