// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> home page -> Click the”Facebook Like” button -> enter facebook credentials and submit
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 25.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class practice_18 extends practice_init{

    @Test
    public void test(){
        String baseUrl = "http://www.automationPUB.com";
        String title;
        List<String> windowHandlesSet= new ArrayList<>();

        webDriver.get(baseUrl);
        pause(1);

        webDriver.findElement(By.className("theChampFacebookSvg")).click();
        pause(3);

        // windowHandlesSet 변수에 getWindowHandles() 메서드를 통해 얻은 스트링값을 저장
        for (String winHandle : webDriver.getWindowHandles())
            windowHandlesSet.add(winHandle);

        // swichTo().window 메서드를 통해 인덱스 값을 줘 다른 윈도우 핸들로 포커싱 변경
        webDriver.switchTo().window(windowHandlesSet.get(1));
        // 페이스북 로그인 창에서 각 입력창에 값 전송 후 로그인 버튼 클릭
        webDriver.findElement(By.id("email")).sendKeys("alswp0210@hanmail.net");
        webDriver.findElement(By.id("pass")).sendKeys("*******");
        webDriver.findElement(By.name("login")).click();
        pause(3);

        // 페이스북 윈도우 창 종료
        webDriver.close();
        pause(1);

        // 처음 윈도우 핸들로 포커싱
        webDriver.switchTo().window(windowHandlesSet.get(0));
        title = webDriver.getTitle();

        System.out.println(title);
    }
}
