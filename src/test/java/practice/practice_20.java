// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Login to Demo Site of Selenium app , create a new bill , enter all fields and save a bill.
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 26.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class practice_20 extends practice_init{

    @Test
    public void test() throws AWTException {
        String baseUrl = "http://www.automationPUB.com";

        // 키보드 동작 기능을 위해 Robot 클래스 인스턴스화
        Robot robot = new Robot();

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
        webDriver.findElement(By.id("password1")).sendKeys("whdrnr");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(1);

        webDriver.findElement(By.id("salesUserBillMenuIdv2")).click();
        webDriver.findElement(By.id("addItemsAutoResponseId")).sendKeys("11");

        // 키보드 엔터키를 누르는 기능(아이템을 추가)
        robot.keyPress(KeyEvent.VK_ENTER);
        pause(1);

        webDriver.findElement(By.id("quantity_1")).click();
        // 키보드 위 방향키를 누르는 기능(수량을 늘림)
        robot.keyPress(KeyEvent.VK_UP);
        webDriver.findElement(By.id("tempBillNumId")).sendKeys("17");

        // Select 클래스를 이용해 Select 태그에 접근, 옵션들을 제어
        Select dropdown = new Select(webDriver.findElement(By.id("salesPersonId")));
        dropdown.selectByVisibleText("001");
        webDriver.findElement(By.id("optionsRadiosUnPaidId")).click();
        webDriver.findElement(By.id("btnSave")).submit();
        pause(1);

        WebElement logout = webDriver.findElement(By.name("logout"));
        action.moveToElement(logout).click().perform();
    }
}
