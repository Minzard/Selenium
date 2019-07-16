import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class testng {
    WebDriver webDriver;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
    }

    @Test
    public void testLogin () {
//        webDriver.get("https://www.naver.com/");
//
//        String title = webDriver.getTitle();
//        System.out.println(title);
//        Assert.assertEquals(title, "NAVER");
//        takeScreenShotTest(webDriver,title);

        List<WebElement> registerlink = webDriver.findElements(By.className("liOffcanvas"));
        registerlink.get(0).click();
        //Enter URL
        webDriver.get("https://www.naver.com");
        //To change to another tab
        Set<String> tab_handles = webDriver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        webDriver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
        //Save URL from page where you are located
        String urlsite = webDriver.getCurrentUrl();
        //Save variables/page elements
        WebElement nameInput = webDriver.findElement(By. name ("firstName"));
//        WebElement nameInput = webDriver.findElement(By. className ("firstName"));
//        WebElement nameInput = webDriver.findElement(By. id ("firstName"));
//        WebElement nameInput = webDriver.findElement(By. partialLinkText ("firstName"));
        webDriver.findElement(By. tagName ("firstName"));
        //Save page elements with tags not included in selenium, as title etc...
        WebElement sitePR = webDriver.findElement(By.xpath("//*[@title='titulo']"));
        sitePR.click();
    }

    @AfterTest
    public void tearDown () {
        webDriver.close();
        System.exit(0);
    }

    public static void takeScreenShotTest(WebDriver webDriver, String imageName) {

        // Directory that will keep saved pictures
        File directory = new File("C:\\captureSelenium");

        try {
            if (directory.isDirectory()) {
                File imagen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(imagen, new File(directory.getAbsolutePath() + "\\" + imageName
                        +".png"));
            } else {

                throw new IOException("ERROR : La ruta especificada no es un directorio!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pause(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
