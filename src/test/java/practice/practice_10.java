// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Click Selenium -> click the panel with name “001 Selenium – WebDriver”
// and Click ReadMore -> print the post view count in the console
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 23.

package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class practice_10 extends practice_init {

    @Test
    public void test() {
        String baseUrl="http://www.automationPUB.com";
        int count;

        // 브라우저 호출
        webDriver.get(baseUrl);
        // xpath를 통해 Element 호출 후 클릭
        // //*(현재 노드의 모든 Element에 대해서) contains(text(), '') (태그 내용이 ''와 같은 Element 추출)
        webDriver.findElement(By.xpath("//*[contains(text(), '001 Selenium – webdriver')]")).click();
        pause(1);
        webDriver.findElement(By.xpath("//a[@href='https://automationpub.com/2019/01/29/selenium-webdriver/']")).click();

        // String 값을 받아와서 Int 형변환 후 count 변수에 대입
        count = Integer.parseInt(webDriver.findElement(By.className("post-views-count")).getText());

        System.out.println("The post views count is " + count);
    }
}
