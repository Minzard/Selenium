// Create a Maven Project and Setup the POM.xml dependencies
// Goto Menu Management -> Menu-> Search for an ingredient
// and verify the no. of rows returned and print the no. of records returned
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 29.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class practice_27 extends practice_init {

    @Test
    public void test() {
        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";
        int rowsSize,listNum = 0;
        List<WebElement> rows = new ArrayList<>();

        // 브라우저 호출
        webDriver.get(baseUrl);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("whdrnr");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        // Menu Management ->  Menu 이동
        webDriver.findElement(By.className("glyphicon-th")).click();
        webDriver.findElement(By.className("glyphicon-certificate")).click();
        pause(1);

    }

}
