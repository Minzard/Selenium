// Create a Maven Project and Setup the POM.xml dependencies
// Goto Reports – Additional -> Products statement and print the list of the records retrieved for a date range
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 31.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;


public class practice_31 extends practice_init {

    @Test
    public void test() throws AWTException {

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

        // Reports 메뉴를 클릭
        // 숨겨진 하위메뉴를 클릭하기 위한 선행 과정
        WebElement menu = webDriver.findElement(By.id("reportsMenuId"));
        menu.click();

        // Additional 메뉴를 클릭
        // 숨겨진 하위메뉴를 클릭하기 위한 선행 과정
        WebElement add = menu.findElement(By.id("AdditionalMenuId"));
        add.click();
        // Products Statement 메뉴를 클릭
        add.findElement(By.tagName("li")).click();
        pause(3);

        // Date를 입력
        WebElement date = webDriver.findElement(By.id("fromDateId"));
        date.sendKeys("0020190701");

        webDriver.findElement(By.id("customReportSearchButtonId")).click();
        pause(1);

        // itemList를 출력하기 위한 리스트 선언
        List<WebElement> itemList;
        itemList = webDriver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        System.out.println("The number of list is " + itemList.size());
        System.out.println("Item Code |" + "Item Name |" + "Sales Count |" + "Item Price |" + "Sales Amount |" + "Total Tax Amount |");
        System.out.println("-------------------------------------------------------------------------------");
        for(int j = 0; j < itemList.size(); j++) {
            itemList = webDriver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            System.out.println(itemList.get(j).getText());
        }
    }
}
