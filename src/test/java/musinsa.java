// https://store.musinsa.com/app/ 페이지에 접근하여 실시간으로 변하는 랭킹 division Element를 추출해
// 각 주제별 Rank 1 ~ 4 까지의 아이템들 마우스 호버링하는 프로그램
// 2019. 07. 19

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class musinsa extends initialize {

    @Test
    public void test() {
        String baseName = "https://store.musinsa.com/app/";
        Actions action = new Actions(webDriver);
        webDriver.get(baseName);

        List<WebElement> menuList = webDriver.findElements(By.xpath("//ul[@class='ranking_category font_basic']/*/a[@*]"));
        List<WebElement> subList = webDriver.findElements(By.xpath("//span[@class='txt_num_rank']"));

        for(int i = 0; i < menuList.size(); i++) {
            action.moveToElement(menuList.get(i)).perform();
            action.click(menuList.get(i)).perform();
            pause(1);
            for(int j = 0; j < 3 ; j++){
                action.moveToElement(subList.get(j)).perform();
                pause(1);
            }
        }
    }
}
