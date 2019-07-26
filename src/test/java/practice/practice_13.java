// Create a Maven Project and Setup the POM.xml dependencies
// Goto “www.automationPUB.com” -> Select “February”
// by Index from the Blog Archive Dropdown box and verify the title of the page loaded
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 24.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practice_13 extends practice_init {

    @Test
    public void test() {
        String baseUrl = "http://www.automationPUB.com";
        String title;
        // 브라우저 호출
        webDriver.get(baseUrl);

        // Select 클래스를 인스턴스로 선언
        // Select 인스턴스는 드롭 다운 상자를 제어할 때만 사용
        Select dropdown = new Select(webDriver.findElement(By.id("archives-dropdown-2")));
        // selectByIndex() 메서드를 통해 드롭 박스 옵션 중 5번째 옵션 선택
        dropdown.selectByIndex(4);
        pause(1);

        // 현재 페이지의 타이틀을 title 변수에 대입
        title = webDriver.getTitle();
        System.out.println("The title is " + title);
    }
}
