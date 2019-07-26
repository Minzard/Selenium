// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Click Selenium -> click the panel with name “001 Selenium – WebDriver”
// and Click ReadMore -> Verify whether the TITLE of this post is matching with the title in the Panel
// and print whether a pass or fail
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 23.

package practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.ExceptionListener;

public class practice_09 extends practice_init{

    @Test
    public void test() {
        String baseUrl="http://www.automationPUB.com";
        String titleName, panelName;
        boolean check;

        // 브라우저 호출
        webDriver.get(baseUrl);
        // xpath를 통해 Element 호출 후 클릭
        // //*(현재 노드의 모든 Element에 대해서) contains(text(), '') (태그 내용이 ''와 같은 Element 추출)
        webDriver.findElement(By.xpath("//*[contains(text(), '001 Selenium – webdriver')]")).click();
        pause(1);
        webDriver.findElement(By.xpath("//a[@href='https://automationpub.com/2019/01/29/selenium-webdriver/']")).click();

        titleName = webDriver.findElement(By.className("entry-title")).getText();
        panelName = webDriver.findElement(By.xpath("//a[contains(text(), '001 Selenium – webdriver')]")).getText();

        if(checkTitle(titleName, panelName) == false)
            System.out.println("fail");
        else
            System.out.println("pass");
    }

    // 두 스트링 값을 비교하여 true, false를 리턴하는 메서드
    // assertEquals() 메서드에 대한 Exception이 AssertionError
    public  boolean checkTitle(String titleName, String panelName){
        try{
            Assert.assertEquals(titleName,panelName);
        } catch(AssertionError e) {
            return false;
        }
        return true;
    }
}
