import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class facebook {
    WebDriver webDriver;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public  void test() {
        String baseUrl = "http://www.facebook.com";
        String tagName;

        webDriver.get(baseUrl);
        tagName = webDriver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
    }

    @AfterTest
    public void tearDown () {
        webDriver.close();
        System.exit(0);
    }
}
