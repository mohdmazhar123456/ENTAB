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
            pages.getLoginPage().clickUserIdTextBox();
            String userNamePlaceholder = pages.getLoginPage().getUserNamePlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(userNamePlaceholder, "Enter Your User ID", "Placeholder Is Correct for User Id Field", "Placeholder Is NOT Correct for User Id Field"));
            pages.getLoginPage().enterUserName();
            pages.getLoginPage().clickPasswordTextBox();
            String passwordPlaceholder = pages.getLoginPage().getPasswordPlaceholder();
            assertCheck.append(AssertActions.assertEqualStringType(passwordPlaceholder, "Enter Your Password", "Placeholder Is Correct for Password Field", "Placeholder Is NOT Correct for Password Field"));
            pages.getLoginPage().enterPassword();
            pages.getLoginPage().clickLogin();
            try {
                pages.getLoginPage().acceptAlert();
            }catch (Exception e){
                CommonLib.info(e.getMessage());
            }
            pages.getLoginPage().enterUserName();
            pages.getLoginPage().enterPassword();
            pages.getLoginPage().clickLogin();
            String otpPlaceholder = pages.getLoginPage().getOtpPlaceholder();
            assertCheck.append((AssertActions.assertEqualStringType(otpPlaceholder, "A12XY2", "Placeholder Is Correct for Otp field", "Placeholder Is Not Correct for")));
            pages.getLoginPage().clickOtpField();
            pages.getLoginPage().enterOtp();
            pages.getLoginPage().verifyButton();
            pages.getDashboardPage().erpButton();
            pages.getDashboardPage().classButton();
            pages.getDashboardPage().addButton();
            AssertActions.checkAllAssertCheck(assertCheck);
        } catch (Exception e) {
            CommonLib.error(e.getMessage());
        }

    }
}

