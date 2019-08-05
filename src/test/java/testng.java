import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class testng extends initialize{

    @Test
    public void testLogin () {
        webDriver.get("https://www.naver.com/");

        String title = webDriver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "NAVER");
        takeScreenShotTest(webDriver,title);

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
