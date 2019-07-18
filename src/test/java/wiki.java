// 10분메일 사이트에 접근해 임시 메일을 발급하고 변수에 저장
// 위키피디아 사이트에 접속에 한국어를 클릭하고 계정 만들기 페이지에서
// 사용자 이름, 비밀번호 태그에 접근해 변수를 출력하거나 임의의 값을 출력
// 2019. 07. 17

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class wiki extends initialize {
    @Test
    public void test() {
        String userId;

        // get 메서드는 void를 반환함
        webDriver.get("https://10minutemail.net/");

        // findElement 메서드를 이용해 현재 웹 페이지에서 필요한 Element를 호출할 수 있다.
        userId = webDriver.findElement(By.className("mailtext")).getAttribute("value");

        webDriver.get("https://www.wikipedia.org/");

        // id는 고유한 이름을 갖고 class는 공유되는 이름을 가질 수 있다.
        webDriver.findElement(By.id("js-link-box-ko")).click();
        webDriver.findElement(By.id("pt-createaccount")).click();
        webDriver.findElement(By.className("mw-ui-input")).sendKeys(userId);
        webDriver.findElement(By.id("wpPassword2")).sendKeys("1234");

    }
}
