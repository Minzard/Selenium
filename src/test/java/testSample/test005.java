// Create a Maven Project and Setup the POM.xml dependencies
// Share an item via email
// 2019. 08. 01.

package testSample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class test005 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";
        String tempMail;

        // 마우스 호버링을 위해 Actions 클래스 인스턴스화
        Actions action = new Actions(webDriver);
        // 홈페이지 메뉴바에 있는 catalogue 메뉴와 하위 히든 메뉴 jewelry 메뉴에 대한 element 변수
        WebElement catalogue, jewelry;
        // 윈도우 탭 이동을 위한 handle 변수
        // 초기 윈토우 탭 핸들을 저장
        String windowHandle = webDriver.getWindowHandle();

        // 브라우저 호출
        webDriver.get(baseUrl);
        pause(3);

        // 카탈로그 메뉴 클릭
        catalogue = webDriver.findElement(By.xpath("//div[contains(text(),'Catalogue')]"));
        action.moveToElement(catalogue).perform();

        // 하위 메뉴를 클릭하기 위해 javaScript 코드를 이용해 element 클릭
        JavascriptExecutor scrollGuess = (JavascriptExecutor) webDriver;
        jewelry = webDriver.findElement(By.xpath("//a[@title='JEWELRY']"));
        // Javascript 코드를 실행하기 위한 메서드
        scrollGuess.executeScript("arguments[0].click();", jewelry);

        // 아이템 클릭
        webDriver.findElement(By.id("productDetailsImages918542620")).click();
        pause(3);

        // 이메일로 공유하기 버튼 클릭
        webDriver.findElement(By.className("icon-tous-email-pdp")).click();
        pause(3);

        // 새로운 윈도우 창 생성
        ((JavascriptExecutor) webDriver).executeScript("window.open('https://10minutemail.net/?lang=ko');");
        pause(3);

        // 새 윈도우 창으로 포커스 변경
        // 창이 2개일 때를 기준으로 작성
        for(String winHandle : webDriver.getWindowHandles())
            webDriver.switchTo().window(winHandle);

        // 임시 메일 주소를 tempMail 변수에 저장
        tempMail = webDriver.findElement(By.className("mailtext")).getAttribute("value");

        // 초기 윈도우 탭으로 포커스 변경
        webDriver.switchTo().window(windowHandle);
        webDriver.findElement(By.id("senderMailAddress")).sendKeys("help.es@tous.com");
        webDriver.findElement(By.id("receiversMails")).sendKeys(tempMail);

        // 체크박스 클릭
        WebElement checkbox = webDriver.findElement(By.id("terms2"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", checkbox);

        webDriver.findElement(By.id("button-share-product")).click();
        pause(3);

        // 윈도우 탭 포커스 변경
        for(String winHandle : webDriver.getWindowHandles())
            webDriver.switchTo().window(winHandle);

        // 새로운 이메일 확인을 위한 창 새로고침
        webDriver.findElement(By.className("fa-refresh")).click();

        // 10분 메일 사이트에서 생성한 이메일 주소로 메일이 온 것을 확인하기 위한 시간 지연
        // pause(' ');

        WebElement mailTable = webDriver.findElement(By.id("maillist")).findElement(By.tagName("tbody"));
        List<WebElement> mailList = mailTable.findElements(By.tagName("td"));

        System.out.println("================== Item List ==================");
        // for each 문을 이용해 이메일 텍스트 출력
        for(WebElement mail : mailList)
            System.out.println(mail.getText());

        pause(5);
    }
}
