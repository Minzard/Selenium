import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface.
        // not the implementation.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is : " + webDriver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load. timeout after 10 seconds
        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see : "cheese! - Google Search"
        System.out.println("Page title is : " + webDriver.getTitle());

        // Close the browser
        webDriver.quit();

    }
}
