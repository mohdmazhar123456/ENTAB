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
    public void testLoginFunctionality() {
        try {
            CommonLib.info("Going to test Login Functionality");
            pages.getLandingPage().clickLoginBtn();
            String url = pages.getLandingPage().getUrl();
            assertCheck.append(AssertActions.assertEqualBoolean(url.contains("Logon"), true, "Login page opened successfully", "Login page NOT opened"));
            AssertActions.checkAllAssertCheck(assertCheck);

        } catch (Exception e) {
            CommonLib.error(e.getMessage());
        }

    }

    @Test
    public void testLoginPageFunctionality() {
        try {
            CommonLib.info("Going to test UserId box is clickable");
            pages.getLandingPage().clickUserIdTextBox();
            String userNamePlaceholder = pages.getLandingPage().getUserNamePlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(userNamePlaceholder, "Enter Your User ID", "Placeholder Is Correct for User Id Field", "Placeholder Is NOT Correct for User Id Field"));
            pages.getLandingPage().enterUserName();
            pages.getLandingPage().clickPasswordTextBox();
            String passwordPlaceholder = pages.getLandingPage().getPasswordPlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(passwordPlaceholder, "Enter Your Password", "Placeholder Is Correct for Password Field", "Placeholder Is NOT Correct for Password Field"));
            pages.getLandingPage().enterPassword();
            pages.getLandingPage().clickLogin();
            pages.getLandingPage().acceptAlert();
            pages.getLandingPage().enterUserName();
            pages.getLandingPage().enterPassword();
            pages.getLandingPage().clickLogin();
            String otpPlaceholder = pages.getLandingPage().getOtpPlaceholder();
            assertCheck.append((AssertActions.assertEqualStringType(otpPlaceholder, "A12XY2", "Placeholder Is Correct for Otp field", "Placeholder Is Not Correct for")));
            pages.getLandingPage().clickOtpField();
            pages.getLandingPage().enterOtp();
            AssertActions.checkAllAssertCheck(assertCheck);
        } catch (Exception e) {
            CommonLib.error(e.getMessage());
        }

    }
}

