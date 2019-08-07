// Create a Maven Project and Setup the POM.xml dependencies
// Log in correctly and log out correctly.
// 2019. 08. 01.

package testSample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class test001 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";

        // 브라우저 호출
        webDriver.get(baseUrl);
        pause(3);

        webDriver.findElement(By.xpath("//a[@title='Sign In']")).click();
        pause(3);

        webDriver.findElement(By.id("j_username")).sendKeys("tester77@outlook.es");
        webDriver.findElement(By.id("j_password")).sendKeys("********");
        webDriver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        pause(3);

        // 로그아웃
        webDriver.findElement(By.xpath("//a[@title='Sign Out']")).click();
    }
}
