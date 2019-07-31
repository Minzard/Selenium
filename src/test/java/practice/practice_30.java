// Create a Maven Project and Setup the POM.xml dependencies
// Logout application and verify whether the system is logged out or not
// by validating the whether “www.automationPUB.com” home page is displayed
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 31.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practice_30 extends practice_init {

    @Test
    public void test() {

        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";

        // Actions 클래스를 인스턴스화 하여 마우스 호버링 기능 사용
        Actions action = new Actions(webDriver);

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

        // xpath()를 통해 Visible Text가 'Admin'인 Element 저장
        // 로그아웃을 위해 선행되어야하는 버튼 클릭
        WebElement admin = webDriver.findElement(By.xpath("//span[contains(text(), 'Admin')]"));
        action.moveToElement(admin).click().perform();

        // Admin 버튼을 클릭해 서브 메뉴가 생성되면 logout 버튼 클릭
        WebElement logout = webDriver.findElement(By.name("logout"));
        action.moveToElement(logout).click().perform();
        pause(3);

        // Assert 클래스를 이용해 현재 페이지의 URL과 contains() 메서드의 파라미터 값을 비교
        // 포함하고 있으면 정상 종료
        Assert.assertEquals(webDriver.getCurrentUrl().contains("https://automationpub.com"), true);
        System.out.println("Success!");
    }
}
