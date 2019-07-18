import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class testng extends initialize{

    @Test
    public void testLogin () {
//        driver.get("https://www.naver.com/");
//
//        String title = driver.getTitle();
//        System.out.println(title);
//        Assert.assertEquals(title, "NAVER");
//        takeScreenShotTest(driver,title);

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
//        WebElement nameInput = driver.findElement(By. className ("firstName"));
//        WebElement nameInput = driver.findElement(By. id ("firstName"));
//        WebElement nameInput = driver.findElement(By. partialLinkText ("firstName"));
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

    public static void takeScreenShotTest(WebDriver driver, String imageName) {

        // Directory that will keep saved pictures
        File directory = new File("C:\\captureSelenium");

        try {
            if (directory.isDirectory()) {
                File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(imagen, new File(directory.getAbsolutePath() + "\\" + imageName
                        +".png"));
            } else {

                throw new IOException("ERROR : 지정된 경로가 디렉토리가 아닙니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
