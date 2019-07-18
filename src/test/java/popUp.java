// Pop Up 테스트를 해볼 수 있는 사이트 주소에 접근해
// 팝업 기능을 실행하는 코드
// 2019. 07. 16

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class popUp extends initialize{

    @Test
    public void test() {
        String baseUrl = "http://jsbin.com/usidix/1";
        String alertMessage;

        webDriver.get(baseUrl);
        // cssSelector 방식을 통해 찾아낸 Element 클릭
        webDriver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = webDriver.switchTo().alert().getText();
        webDriver.switchTo().alert().accept();

        System.out.println(alertMessage);

        pause(10);
    }
}
