import com.entab.commonutils.actions.BaseActions;
import com.entab.commonutils.commonlib.CommonLib;
import com.entab.driver.Driver;
import org.testng.annotations.Test;

public class LoginPageTest extends Driver {

    @Test
    public void testLandingPage() throws InterruptedException {
        try{
            CommonLib.info("Going to test Landing page");
            String landingPageTitleText = pages.getLandingPage().getLandingPageTitleText();
            assertCheck.append(BaseActions.assertEqualStringType(landingPageTitleText,"Lotus Valley International School","Title matched successfully","Title not matched"));
        }catch (Exception e){
            CommonLib.error(e.getMessage());
        }
    }
    @Test
    public void testLoginFunctionality(){
        try{
            CommonLib.info("Going to test Login Functionality");
            pages.getLandingPage().clickLoginBtn();
            String url = pages.getLandingPage().getUrl();
            assertCheck.append(BaseActions.assertEqualBoolean(url.contains("Logon"),true,"Login page opened successfully","Login page NOT opened"));

        }catch(Exception e){
            CommonLib.error(e.getMessage());
        }

    }
}
