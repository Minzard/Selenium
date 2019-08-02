// Create a Maven Project and Setup the POM.xml dependencies
// Search product by name
// 2019. 08. 02.

package TOUS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class test010 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";

        // 브라우저 호출
        webDriver.get(baseUrl);
        pause(3);

        webDriver.findElement(By.id("js-site-search-input")).click();
        webDriver.findElement(By.id("js-site-search-input")).sendKeys("TOUS");
        webDriver.findElement(By.className("js-search-name")).click();
        pause(3);

        webDriver.findElement(By.xpath("//a[@title='TOUS Bear ']")).click();

        WebElement selectedItem = webDriver.findElement(By.id("product-details-desktop-wrapper-first-component")).findElement(By.tagName("h1"));
        System.out.println("Selected Item is : " + selectedItem.getText());

        pause(5);


    }
}
