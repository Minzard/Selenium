// Create a Maven Project and Setup the POM.xml dependencies
// Goto Menu Management -> Menu-> Create a new ingredient & verify the confirmation message
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 29.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practice_26 extends practice_init {

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
        webDriver.findElement(By.id("inventoryResetId")).click();

        // ingredient 추가 할 때, 드롭 박스의 옵션을 선택하기 위해 Select 클래스 인스턴스화
        Select invenDrop = new Select(webDriver.findElement(By.id("inventoryTypeId")));
        Select cuisineDrop = new Select(webDriver.findElement(By.id("itemCategory2Id")));
        Select vegDrop = new Select(webDriver.findElement(By.id("itemCategory3Id")));
        Select itemDrop = new Select(webDriver.findElement(By.id("itemCategory4Id")));

        // 각 드롭박스에 대해 옵션을 선택
        invenDrop.selectByVisibleText("Ingredient");
        cuisineDrop.selectByVisibleText("Ingredient");
        vegDrop.selectByVisibleText("Pasta");
        itemDrop.selectByVisibleText("Others");
        pause(1);

        // input 텍스트를 적기전 지우고나서 String 값 전송
        webDriver.findElement(By.id("itemCodeId")).clear();
        webDriver.findElement(By.id("itemCodeId")).sendKeys("1801");

        webDriver.findElement(By.id("itemNameId")).sendKeys("Tomato Pasta");

        // input 텍스트를 적기전 지우고나서 String 값 전송
        webDriver.findElement(By.id("quantityId")).clear();
        webDriver.findElement(By.id("quantityId")).sendKeys("10");

        // input 텍스트를 적기전 지우고나서 String 값 전송
        webDriver.findElement(By.id("maxRetailPriceId")).clear();
        webDriver.findElement(By.id("maxRetailPriceId")).sendKeys("1000");

        // Update가 정상적으로 이루어졌을때 나타나는 toast 메시지 내용을 출력
        try {
            webDriver.findElement(By.id("inventorySubmitId")).click();
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