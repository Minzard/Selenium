// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” and count the no. of menu links and print it to the console
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 24.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class practice_15 extends practice_init{

    @Test
    public void test() {
        String baseUrl = "http://www.automationPUB.com";

        webDriver.get(baseUrl);

        // List에 클래스명에 'menu-item'이 포함되는 Element들을 대입
        List<WebElement> menuList = webDriver.findElements(By.className("menu-item"));

        System.out.println("the number of menu links is " + menuList.size());

        for(int i=0; i<menuList.size(); i++) {
            // menuList의 각 Element 하위 태그들에 대해 Tag name이 a인 태그들의 href 속성 값을 출력
            System.out.println(i+1 + "." + menuList.get(i).findElement(By.tagName("a")).getAttribute("href"));
        }
    }
}
