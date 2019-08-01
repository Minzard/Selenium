// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Archives -> print the entire list of archives in console
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 25.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class practice_17 extends practice_init{

    @Test
    public void test() {
        String baseUrl = "http://www.automationPUB.com";

        webDriver.get(baseUrl);

        // Select 클래스를 인스턴스로 선언
        // Select 인스턴스는 드롭 다운 상자를 제어할 때만 사용
        Select dropdown = new Select(webDriver.findElement(By.id("archives-dropdown-2")));

        // getOptions() 메서드를 통해 옵션들을 리스트에 저장
        List<WebElement> archiveList = dropdown.getOptions();

        for(int i = 0; i < archiveList.size(); i++) {
                // 옵션내에 value 속성값을 출력
                System.out.println(archiveList.get(i).getAttribute("value"));
        }
    }
}
