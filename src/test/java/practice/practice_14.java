// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com”-> Demo Site -> Login to Selenium App -> Logout
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 24.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class practice_14 extends practice_init {

    @Test
    public void test() {
        String baseUrl = "http://www.automationPUB.com";
        // 브라우저 호출

        webDriver.get(baseUrl);

        // Actions 클래스를 인스턴스화 하여 마우스 호버링 기능 사용
        Actions action = new Actions(webDriver);
        WebElement wd1 = webDriver.findElement(By.xpath("//a[@href='https://automationpub.com/category/uncategorized/']"));
        WebElement wd2 = wd1.findElement(By.xpath("//a[@href='http://automationpub.com/demoAutomationSite/demoSeleniumSite/']"));
        // 마우스 커서를 wd1 Element로 이동 (perform() 메서드를 통해 동작 수행)
        action.moveToElement(wd1).perform();
        pause(1);

        // 마우스 커서를 wd2 Element로 이동 후 클릭 (perform() 메서드를 통해 동작 수행)
        action.moveToElement(wd2).click().perform();
        pause(1);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("********");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(1);

        WebElement lg1 = webDriver.findElement(By.xpath("//button[@class='btn btn-xs btn-default dropdown-toggle']"));
        action.moveToElement(lg1).click().perform();

        // xpath()를 통해 Visible Text가 'Admin'인 Element 저장
        // 로그아웃을 위해 선행되어야하는 버튼 클릭
        WebElement admin = webDriver.findElement(By.xpath("//span[contains(text(), 'Admin')]"));
        action.moveToElement(admin).click().perform();

        // Admin 버튼을 클릭해 서브 메뉴가 생성되면 logout 버튼 클릭
        WebElement logout = webDriver.findElement(By.name("logout"));
        action.moveToElement(logout).click().perform();
        pause(3);
    }
}
