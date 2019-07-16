import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class frame {
    WebDriver webDriver;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public  void test() {
        String baseUrl = "http://demo.guru99.com/selenium/deprecated.html";

        webDriver.get(baseUrl);
        webDriver.switchTo().frame("classFrame");
        webDriver.findElement(By.linkText("Deprecated")).click();
        pause(15);
    }

    @AfterTest
    public void tearDown () {
        webDriver.close();
        System.exit(0);
    }

    private void pause(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
