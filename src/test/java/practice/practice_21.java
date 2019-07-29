// Create a Maven Project and Setup the POM.xml dependencies
// And verify if the bill is saved by verifying the presence of the table button in the “unpaid table bills”.
// For 3 dropdowns, use 3 ways to select the value for ex: SelectByVisibleText, SelectByValue, SelectByIndex
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 26.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practice_21 extends practice_init {

    @Test
    public void test() {
        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";

        // 브라우저 호출
        webDriver.get(baseUrl);

        // Actions 클래스를 인스턴스화 하여 마우스 호버링 기능 사용
        Actions action = new Actions(webDriver);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("********");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        // Billing 메뉴 선택
        webDriver.findElement(By.id("salesUserBillMenuIdv2")).click();
        // practice_20에서 저장한 unpaid bill 클릭
        webDriver.findElement(By.id("editInvoiceId_3 style=")).click();
        pause(1);

        // 3개의 드롭박스에 대해서 인스턴스화를 진행해 옵션을 제어
        Select dropdown1 = new Select(webDriver.findElement(By.name("servingType")));
        Select dropdown2 = new Select(webDriver.findElement(By.name("paymentMode")));
        Select dropdown3 = new Select(webDriver.findElement(By.name("salesPerson")));

        // Index를 통해 옵션 선택
        dropdown1.selectByIndex(4);
        pause(5);
        // VsibleTest, 웹사이트에 실제로 보이는 텍스트를 통해 옵션 선택
        dropdown2.selectByVisibleText("Card");
        pause(5);
        // value 속성을 통해 옵션 선택
        dropdown3.selectByValue("001");
        pause(5);

        webDriver.findElement(By.id("btnSave")).submit();
        pause(1);

        WebElement logout = webDriver.findElement(By.name("logout"));
        action.moveToElement(logout).click().perform();
    }
}
