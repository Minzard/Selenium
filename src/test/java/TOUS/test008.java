// Create a Maven Project and Setup the POM.xml dependencies
// Sort the products (lowest price first)
// 2019. 08. 02.

package TOUS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test008 extends test_init {

    @Test
    public void test() {

        String baseUrl = "https://www.tous.com/us-en";

        // 아이템 리스트 Elements를 저장할 List
        List<WebElement> alphabetSort, lowPriceSort;

        // 알파벳 순으로 정렬된 Elements의 Visible Text를 저장할 List
        List<String> alphabetList = new ArrayList<>();
        // 낮은 가격 순으로 정렬된 Elements의 Visible Text를 저장할 List
        List<String> lowPriceList = new ArrayList<>();

        // 마우스 호버링을 위해 Actions 클래스 인스턴스화
        Actions action = new Actions(webDriver);
        // 홈페이지 메뉴바에 있는 catalogue 메뉴와 하위 히든 메뉴 jewelry 메뉴에 대한 element 변수
        // Sort 메뉴의 히든 메뉴를 이용하기 위한 element 변수
        WebElement catalogue, jewelry, sort;

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


        webDriver.findElement(By.className("pagination-toolbar")).click();
        pause(1);

        // 하위 메뉴를 클릭하기 위해 javaScript 코드를 이용해 element 클릭
        // 하위 메뉴 리스트 중 알파벳 순을 클릭
        JavascriptExecutor itemSort = (JavascriptExecutor) webDriver;
        sort = webDriver.findElement(By.xpath("//a[@data-value='name-desc']"));
        // Javascript 코드를 실행하기 위한 메서드
        itemSort.executeScript("arguments[0].click();", sort);
        pause(5);

        // 알파벳 순으로 정렬된 아이템 리스트 저장
        alphabetSort = webDriver.findElements(By.className("category-fix"));
        // 각 엘리먼트의 Visible Text를 String 리스트에 저장
        for(WebElement alphabet : alphabetSort)
           alphabetList.add(alphabet.getText());

        webDriver.findElement(By.className("pagination-toolbar")).click();
        pause(1);

        // 하위 메뉴를 클릭하기 위해 javaScript 코드를 이용해 element 클릭
        // 하위 메뉴 리스트 중 낮은 가격순을 클릭
        sort = webDriver.findElement(By.xpath("//a[@data-value='price-asc']"));
        // Javascript 코드를 실행하기 위한 메서드
        itemSort.executeScript("arguments[0].click();", sort);
        pause(5);

        // 낮은 가격 순으로 정렬된 아이템 리스트 저장
        lowPriceSort = webDriver.findElements(By.className("category-fix"));

        // 각 엘리먼트의 Visible Text를 String 리스트에 저장
        for(WebElement lowPrice : lowPriceSort)
            lowPriceList.add(lowPrice.getText());

        System.out.println("========================================= Item List =========================================");
        System.out.println("Number | Alpahbet Sort\t\t\t\t\t\t  | Low Price Sort\t\t\t\t\t\t      | ");

        // 리스트에 담긴 String 값을 하나씩 출력
        // String 리스트가 아닌 WebElment 리스트의 getText() 메서드를 이용하면 Element 값을
        // 각 이터레이션 마다 인스턴스화 해야 돼서 String 리스트로 텍스트를 대입한 후
        // 반복문 수행
        for (int i = 0; i < alphabetSort.size(); i++)
            System.out.println(i+1 + ".\t\t" + alphabetList.get(i) + "|  " + lowPriceList.get(i));
    }
}
