// Create a Maven Project and Setup the POM.xml dependencies
// After Login , verify the same email id is present in the dashboard page
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 31.

package practice;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;


public class practice_29 extends practice_init{


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

        // Assert 클래스를 이용해 Element의 Visible Text가 contains() 메서드의 파라미터 값을 비교
        // 포함하고 있으면 정상 종료
        Assert.assertEquals(webDriver.findElement(By.className("navbar-inner")).getText().contains("alswp0210@abc.com"), true);
        System.out.println("Success!");
    }
}
