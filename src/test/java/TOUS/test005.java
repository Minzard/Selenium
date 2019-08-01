// Create a Maven Project and Setup the POM.xml dependencies
// Share an item via email
// 2019. 08. 01.

package TOUS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class test005 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";
        String tempMail;

        // 마우스 호버링을 위해 Actions 클래스 인스턴스화
        Actions action = new Actions(webDriver);
        WebElement catalogue, jewelry;
        String windowHandle = webDriver.getWindowHandle();

        // 브라우저 호출
        webDriver.get(baseUrl);
        pause(3);

        catalogue = webDriver.findElement(By.xpath("//div[contains(text(),'Catalogue')]"));
        action.moveToElement(catalogue).perform();

        JavascriptExecutor scrollGuess = (JavascriptExecutor) webDriver;
        jewelry = webDriver.findElement(By.xpath("//a[@title='JEWELRY']"));
        scrollGuess.executeScript("arguments[0].click();", jewelry);

        webDriver.findElement(By.id("productDetailsImages918542620")).click();
        pause(3);

        webDriver.findElement(By.className("icon-tous-email-pdp")).click();
        pause(3);

        ((JavascriptExecutor) webDriver).executeScript("window.open('https://10minutemail.net/?lang=ko');");
        pause(3);

        for(String winHandle : webDriver.getWindowHandles())
            webDriver.switchTo().window(winHandle);

        tempMail = webDriver.findElement(By.className("mailtext")).getAttribute("value");

        webDriver.switchTo().window(windowHandle);
        webDriver.findElement(By.id("senderMailAddress")).sendKeys("help.es@tous.com");
        webDriver.findElement(By.id("receiversMails")).sendKeys(tempMail);

        WebElement checkbox = webDriver.findElement(By.id("terms2"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", checkbox);

        webDriver.findElement(By.id("button-share-product")).click();
        pause(3);

        for(String winHandle : webDriver.getWindowHandles())
            webDriver.switchTo().window(winHandle);

        webDriver.findElement(By.className("fa-refresh")).click();

//        pause(30);

        List<WebElement> mailList = webDriver.findElement(By.id("maillist")).findElements(By.className("td"));

        for(WebElement mail : mailList)
            System.out.println(mail.getText());
        pause(5);
    }
}
