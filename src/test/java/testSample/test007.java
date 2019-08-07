// Create a Maven Project and Setup the POM.xml dependencies
// Share a wishlist item
// 2019. 08. 02.

package testSample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class test007 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";
        // 윈도우 탭 이동을 위한 handle 변수
        // 초기 윈토우 탭 핸들을 저장
        String tempMail;
        String windowHandle = webDriver.getWindowHandle();

        // 마우스 호버링을 위해 Actions 클래스 인스턴스화
        Actions action = new Actions(webDriver);
        // 홈페이지 메뉴바에 있는 catalogue 메뉴와 하위 히든 메뉴 jewelry 메뉴에 대한 element 변수
        WebElement catalogue, jewelry;

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

        // 위시리스트 버튼 클릭
        // 위시리스트가 없으면 생성 창으로 이동
        webDriver.findElement(By.className("pickUp-store-button")).click();
        pause(3);

        // 위시리스트 입력 후 생성 버튼 클릭
        webDriver.findElement(By.id("createWishlistInputName")).sendKeys("FAV");
        webDriver.findElement(By.id("createWishlistSaveButton")).click();
        pause(3);

        // 위시리스트 담기 클릭
        webDriver.findElement(By.className("pickUp-store-button")).click();
        pause(1);

        // 체크박스 클릭
        WebElement wishCheckbox = webDriver.findElement(By.className("checkbox-label"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", wishCheckbox);
        pause(1);

        // 위시리스트에 담기
        webDriver.findElement(By.id("submit-selected-wishlists")).click();
        pause(5);

        // 현재 위시리스트 보기
        webDriver.findElement(By.className("wishlist-li")).findElement(By.tagName("a")).click();
        pause(3);

        // 위시리스트 페이지에 있는 아이템 이름, 개수 저장 변수 생성
        String itemNum = webDriver.findElement(By.className("wishlist-number-products")).getText();
        String item = webDriver.findElement(By.className("lazyloaded")).getAttribute("alt");

        System.out.println("================== Item List ==================");
        System.out.println(itemNum);
        System.out.println(item);

        // 버튼을 보이게 하기 위해 브라우저 창의 스크롤을 제일 밑으로 내림
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // See Wishlist 버튼 클릭
        webDriver.findElement(By.className("wishlist-button-mobile-margin-button")).click();
        pause(3);

        // 위시리스트 공유 버튼 클릭
        webDriver.findElement(By.id("js-wishlist-share")).click();
        pause(1);

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
        webDriver.findElement(By.id("recievers[0].mailAddress")).sendKeys(tempMail);

        // 체크박스 클릭
        WebElement sendCheckbox = webDriver.findElement(By.id("terms2"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", sendCheckbox);

        webDriver.findElement(By.id("button-wishlist")).click();
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

        // for each 문을 이용해 이메일 텍스트 출력
        System.out.println("================== Mail List ==================");

        for(WebElement mail : mailList)
            System.out.println(mail.getText());

        pause(5);
    }
}
