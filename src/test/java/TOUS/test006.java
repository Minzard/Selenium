// Create a Maven Project and Setup the POM.xml dependencies
// Add an item to a wish list
// 2019. 08. 02.

package TOUS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test006 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";

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
        WebElement checkbox = webDriver.findElement(By.className("checkbox-label"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", checkbox);
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

    }
}
