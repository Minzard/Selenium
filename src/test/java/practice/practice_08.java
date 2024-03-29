// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Click Selenium -> click the panel with name “001 Selenium – WebDriver”
// and Click ReadMore -> Verify whether the TITLE of this post is matching with the title in the Panel
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practice_08 extends practice_init{

    @Test
    public void test() {
        String baseUrl="http://www.automationPUB.com";

        // 브라우저 호출
        webDriver.get(baseUrl);
        // xpath를 통해 Element 호출 후 클릭
        // //*(현재 노드의 모든 Element에 대해서) contains(text(), '') (태그 내용이 ''와 같은 Element 추출)
        webDriver.findElement(By.xpath("//*[contains(text(), '001 Selenium – webdriver')]")).click();
        pause(1);
        webDriver.findElement(By.xpath("//a[@href='https://automationpub.com/2019/01/29/selenium-webdriver/']")).click();

        // 왼쪽 파라미터(예상값)과 오른쪽 파라미터(실제값)이 같으면 정상 종료, 다르면 에러
        Assert.assertEquals("001 Selenium – webdriver | AutomationPub.com",webDriver.getTitle());
    }
}
