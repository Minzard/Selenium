// Create a Maven Project and Setup the POM.xml dependencies
// Go to dashboard, count the no. of URLs and print the count and url link. Use ForEach Loop
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 26.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class practice_24 extends practice_init{

    @Test
    public void test() {
        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";

        // 브라우저 호출
        webDriver.get(baseUrl);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("********");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        List<WebElement> urlList = webDriver.findElements(By.xpath("//*[@href]"));

        System.out.println("The count of URL is " + urlList.size());

        for(WebElement url : urlList)
            System.out.println(url.getAttribute("href"));
    }
}
