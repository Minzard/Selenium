// Create a Maven Project and Setup the POM.xml dependencies
// Try to log in with invalid data, correct data, log in correctly and exit correctly.
// 2019. 08. 01.

package testSample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class test002 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";
        String errMsg;

        // 브라우저 호출
        webDriver.get(baseUrl);
        pause(3);

        webDriver.findElement(By.xpath("//a[@title='Sign In']")).click();
        pause(3);

        // input 태그 양식에 맞지 않는 스트링 값 입력
        webDriver.findElement(By.id("j_username")).sendKeys("tester77");
        webDriver.findElement(By.id("j_password")).sendKeys("********");
        pause(3);

        // input 태그 안 Text clear
        webDriver.findElement(By.id("j_username")).clear();
        webDriver.findElement(By.id("j_password")).clear();

        // 유효하지 않은 계정으로 로그인 시도
        webDriver.findElement(By.id("j_username")).sendKeys("testerABC@outlook.es");
        webDriver.findElement(By.id("j_password")).sendKeys("********");
        webDriver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        pause(1);

        // Invalid Message 출력
        errMsg = webDriver.findElement(By.className("alert-dismissable")).getText();
        System.out.println(errMsg);

        // 유효한 계정으로 로그인 시도
        webDriver.findElement(By.id("j_username")).clear();
        webDriver.findElement(By.id("j_username")).sendKeys("tester77@outlook.es");
        webDriver.findElement(By.id("j_password")).sendKeys("********");
        webDriver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        pause(3);

        // 로그아웃
        webDriver.findElement(By.xpath("//a[@title='Sign Out']")).click();
    }
}
