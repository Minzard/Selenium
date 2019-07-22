// 페이스북 페이지에서 email이라는 id를 가진 Element를 출력하는 코드
// 2019. 07. 16

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class facebook extends initialize {

    @Test
    public  void test() {
        String baseUrl = "http://www.facebook.com";
        String tagName;

        webDriver.get(baseUrl);
        tagName = webDriver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
    }
}
