// Create a Maven Project and Setup the POM.xml dependencies
// Goto Menu Management -> Menu-> Ingredient List,
// Edit an ingredient and update the price of the ingredient & verify the confirmation message
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 29.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class practice_25 extends practice_init{

    @Test
    public void test() {
        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";
        String success;

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

        // Menu Management ->  Menu 이동
        webDriver.findElement(By.className("glyphicon-th")).click();
        webDriver.findElement(By.className("glyphicon-certificate")).click();
        pause(1);

        webDriver.findElement(By.id("editInvoiceId_0")).click();
        // 기존의 값을 지우고 1500을 입력함
        webDriver.findElement(By.id("maxRetailPriceId")).clear();
        webDriver.findElement(By.id("maxRetailPriceId")).sendKeys("1500");

        // Update가 정상적으로 이루어졌을때 나타나는 toast 메시지 내용을 출력
        try {
            webDriver.findElement(By.id("inventoryUpdateId")).click();
            pause(3);
            // 토스트 메시지의 Visible Test를 getText() 메서드를 통해 받아옴
            success = webDriver.findElement(By.className("jq-toast-single")).getText();
            // 토스트 메시지 내용 출력
            System.out.println(success);

        } catch (NoSuchElementException e) {
            // try 문이 제대로 수행되지 않았을 때, Exception 내용 출력
            e.printStackTrace();
        }
    }
}
