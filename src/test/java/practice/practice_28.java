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

        // list1 변수는 숨겨진 메뉴의 정보를 얻기 위해 클릭 할 메뉴 리스트를 담음
        // div2 변수는 대쉬보드의 중앙 메뉴 리스트 정보를 담음
        List<WebElement> list1, div2;

        // 브라우저 호출
        webDriver.get(baseUrl);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("********");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        // 하위 메뉴를 가지고 있는 메뉴들을 클릭하여 하위 메뉴를 보여지게 함
        // "WebDriver는 보여지지 않는 Element 정보를 출력 할 수 없다!"
        // 클릭 할 Element가 현재 브라우저 창에 보여지지 않으면 에러 발생
        list1 = webDriver.findElements(By.className("accordion"));
        for(int i = 0; i < list1.size(); i++) {
            list1.get(i).click();
            pause(1);
        }

        div2 = webDriver.findElements(By.className("col-xs-6"));

        // list2 변수는 div2 변수의 Visible Text 정보를 담음
        // add() 함수를 통해 리스트에 추가하므로 초기화
        List<WebElement> allMiddleList = new ArrayList<>();

        // list2 변수에 tagName() 메서드를 통해 Visible Text를 반복하여 저장
        for(int j = 0; j < div2.size(); j++)
            allMiddleList.add(div2.get(j).findElement(By.tagName("a")));

        // 메뉴 클릭을 통해 모든 하위 메뉴가 보여지는 상황에서 Elements 저장
        List<WebElement> allLeftList= webDriver.findElement(By.className("main-menu")).findElements(By.tagName("a"));

        System.out.println("no. of Menu items on the left hand side is " + allLeftList.size());
        System.out.println("----------------------------------------------");
        // for each 문을 이용해 listNum의 값 출력
        for(WebElement leftList : allLeftList)
            System.out.println(leftList.getText() + "   " + leftList.getAttribute("href"));

        System.out.println();

        System.out.println("no. of Menu items on the middle is " + allMiddleList.size());
        System.out.println("----------------------------------------------");
        // for each 문을 이용해 list2의 값 출력
        for(WebElement middleList :allMiddleList) {
            System.out.println(middleList.getText());
            System.out.println(middleList.getAttribute("href"));
        }

    }
}