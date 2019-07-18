// 위키피디아 한글 홈페이지에서 리스트를 선언해 각 언어 사이트 URL이 담긴 메뉴바 Elements 대입
// 각 언어 별로 사이트마다 제공되는 언어 개수가 다르므로 뒤로가기를 통해 동일한 조건에서 반복
// 콘솔창에 결과값으로 title, 즉 언어 이름과 url 주소를 출력
// 2019. 07. 17

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class wiki2 extends initialize {

    @Test
    // pause() 함수가 없으면 clickable Exception 발생
    public void test() {
        String baseURL = "https://ko.wikipedia.org/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC:%EB%8C%80%EB%AC%B8";
        String url, title;

        // navigate() 메서드는 back, forward 등의 기능을 지원. to() 메서드를 통해 URL값 받아옴 (navigate()는 void 값)
        webDriver.navigate().to(baseURL);
        List<String> langList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();

        // for문 반복 횟수를 결정하는 요소의 갯수를 얻기 위한 List 생성
        List<WebElement> lang = webDriver.findElements(By.className("interlanguage-link-target"));
        int size = lang.size();


        for (int i = 0; i < size; i++) {
            // get() 메서드를 반환함과 동시에 Element 값을 지운다.
            lang = webDriver.findElements(By.className("interlanguage-link-target"));
            lang.get(i).click();
            // 현재 URL 주소를 String 형태로 반환
            url = webDriver.getCurrentUrl();
            urlList.add(url);
            pause(1);

            // 이전 페이지로 돌아가는 메서드
            webDriver.navigate().back();
            pause(1);

            // get() 메서드를 사용하기 위해 다시 Elements를 받아옴
            lang = webDriver.findElements(By.className("interlanguage-link-target"));
            title = lang.get(i).getAttribute("title");
            langList.add(title);


            // get() 메서드를 통해 각 요소들을 하나씩 출력
            System.out.println(i+1 + "번째 Title : " + langList.get(i));
            System.out.println(i+1 + "번째 URL : " + urlList.get(i));

            System.out.println();
        }
    }
//        public void scrollDown() {
//            JavascriptExecutor jsescrolldown = (JavascriptExecutor) webDriver;
//            jsescrolldown.executeScript("window.scrollBy(0,250)", "");
//        }
//        public void doubleClick (WebElement doubleclick) {
//            Actions action = new Actions(webDriver);
//            action.doubleClick(doubleclick).perform();
//        }
}
