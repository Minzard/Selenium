// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Click Selenium -> verify the text “001 Selenium – WebDriver” is displayed
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

// initialize 클래스 extends하여 WebDriver 사용환경 설정
public class practice_07 extends practice_init{

    @Test
    public void test() {
        String baseUrl="http://www.automationPUB.com";

        // 브라우저 호출
        webDriver.get(baseUrl);
        // xpath를 통해 Element 호출 후 클릭
        // //*(현재 노드의 모든 Element에 대해서) contains(text(), '') (태그 내용이 ''와 같은 Element 추출)
        if(webDriver.findElement(By.xpath("//*[contains(text(), '001 Selenium – webdriver')]")).isDisplayed())
            System.out.println("001 Selenium – webdriver is displayed.");
        pause(1);
    }
}
