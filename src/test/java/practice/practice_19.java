// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Click menu “Selenium” -> Click the”Facebook Like” button -> enter facebook credentials and submit
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 25.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class practice_19 extends practice_init{

    @Test
    public void test(){
        String baseUrl = "http://www.automationPUB.com";
        String title;

        webDriver.get(baseUrl);
        pause(1);

        // 현재 윈도우 핸들을 변수에 대입
        String winHandleBefore = webDriver.getWindowHandle();

        webDriver.findElement(By.id("menu-item-428")).click();
        webDriver.findElement(By.className("theChampFacebookSvg")).click();
        pause(3);

        // getWindowHandles() 메서드를 통해 현재 모든 윈도우 핸들을 변수에 저장
        // swichTo().window 메서드를 통해 다른 윈도우 핸들로 포커싱 변경
        for (String winHandle : webDriver.getWindowHandles())
            webDriver.switchTo().window(winHandle);

        // 페이스북 로그인 창에서 각 입력창에 값 전송 후 로그인 버튼 클릭
        webDriver.findElement(By.id("email")).sendKeys("alswp0210@hanmail.net");
        webDriver.findElement(By.id("pass")).sendKeys("*********");
        webDriver.findElement(By.name("login")).click();
        pause(3);

        // 페이스북 윈도우 창 종료
        webDriver.close();
        pause(1);

        // 처음 윈도우 핸들로 포커싱
        webDriver.switchTo().window(winHandleBefore);
        title = webDriver.getTitle();

        System.out.println(title);
    }
}
