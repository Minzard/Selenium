// 동일한 웹 페이지 내에서 다른 프레임으로 포커싱을 변경하는 코드
// 2019. 07. 16

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class frame extends initialize{

    @Test
    public  void test() {
        String baseUrl = "http://demo.guru99.com/selenium/deprecated.html";

        webDriver.get(baseUrl);
        // 요소를 찾을 프레임으로 포커싱 변경
        webDriver.switchTo().frame("classFrame");
        webDriver.findElement(By.linkText("Deprecated")).click();
        pause(15);
    }
}
