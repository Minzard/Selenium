// Create a Maven Project and Setup the POM.xml dependencies
// Go to dashboard, count the no. of Menu items on the left hand side and
// print the count of Menu items and their names. Use ForEach Loop
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 30.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class practice_28 extends practice_init {

    @Test
    public void test() {

        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";
        WebElement div1;
        List<WebElement> list1, div2;
        List<WebElement> list2 = new ArrayList<>();

        // 브라우저 호출
        webDriver.get(baseUrl);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("whdrnr");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        div1 = webDriver.findElement(By.className("main-menu"));
        list1 = div1.findElements(By.tagName("li"));

        div2 = webDriver.findElements(By.className("col-xs-6"));

        for(int j = 0; j < div2.size(); j ++)
            list2.add(div2.get(j).findElement(By.tagName("a")));

        System.out.println("no. of Menu items on the left hand side is " + list1.size());
        System.out.println("----------------------------------------------");
        for(WebElement leftList : list1)
            System.out.println(leftList.getText());

        System.out.println();

        System.out.println("no. of Menu items on the middle is " + list2.size());
        System.out.println("----------------------------------------------");

        for(WebElement centerList :list2)
            System.out.println(centerList.getText());
    }
}