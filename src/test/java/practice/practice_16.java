// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Categories -> Selenium
// -> goto the first blog and print the first paragraph of the blog in console
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 24.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class practice_16 extends practice_init{

    @Test
    public void test() {
        String baseUrl = "http://www.automationPUB.com";
        webDriver.get(baseUrl);

        webDriver.findElement(By.xpath("//a[@href='https://automationpub.com/category/selenium/']")).click();
        pause(1);


        // 본문 전체를 나타내는 div의 className을 이용하여 Element들을 List에 대입
        List<WebElement> contentList = webDriver.findElements(By.className("entry-content"));
        // 첫번째 본문, get(0)의 본문 내용이 담겨있는 li 태그 Element 들을 대입
        List<WebElement> paragraph = contentList.get(0).findElements(By.tagName("li"));

        for(int i =0; i<paragraph.size(); i++)
            // 각 Element들의 Visible Text 출력
            System.out.println(paragraph.get(i).getText());
    }
}
