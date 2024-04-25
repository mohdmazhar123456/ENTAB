import com.entab.driver.Driver;
import org.testng.annotations.Test;

public class LoginPageTest extends Driver {

    @Test
    public void testLogin() throws InterruptedException {
        try{
            commonLib.info("Going to test Landing page");
            String landingPageTitleText = pages.getLandingPage().getLandingPageTitleText();
        }catch (Exception e){
            commonLib.error(e.getMessage());
        }
    }
}
