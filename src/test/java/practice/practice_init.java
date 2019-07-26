// Test를 진행할 때, 사전에 처리해야 할 코드와 테스트가 끝난 후 처리해야 할 코드가 기재되어 있는
// 초기화 및 종료 관련 클래스로 다른 클래스에서 extends 하여 메서드 및 WebDriver 변수 사용
// 2019. 07. 22

package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class practice_init {

    // WebDriver 변수 선언
    public WebDriver webDriver;

    // @Test 애노테이션을 실행하기 전에 실행되는 메서드를 나타냄
    @BeforeTest
    public void setUp() {
        // chrome 드라이버를 설정(drivers 폴더 안에 있는 chromedriver.exe로 지정)
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        webDriver = new ChromeDriver();
        // WebDriver에 의해 실행되는 브라우져 창의 크기를 지정. 전체 화면 상태
        webDriver.manage().window().maximize();
        // Selenium에서 브라우저 자체가 웹 요소들을 기다리도록 만들어주는 옵션
        // Exception을 발생시키기 전 일정시간 기다려 줌
        // 특정 Element가 나타날 때까지 기다려주는 방식은 Explicitly Wait
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    // @Test 애노테이션이 실행하고 난 뒤 실행되는 메서드를 나타냄
    @AfterTest
    public void tearDown() {
        pause(3);
        // 브라우져 창을 닫음(close()는 브라우져창을 닫지 않고 프로그램 종료)
        webDriver.quit();
    }

    // 파라미터에 설정한 숫자 + 초 만큼 일시정지하는 메서드
    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000); }
        catch (InterruptedException e) {
            e.printStackTrace(); } }

}
