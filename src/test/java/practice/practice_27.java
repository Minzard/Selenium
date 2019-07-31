// Create a Maven Project and Setup the POM.xml dependencies
// Goto Menu Management -> Menu-> Search for an ingredient
// and verify the no. of rows returned and print the no. of records returned
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 30.

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class practice_27 extends practice_init {

    @Test
    public void test() {

        String baseUrl = "http://automationpub.com/demoAutomationSite/demoSeleniumSite/";
        WebElement div1, div2;
        List<WebElement> listNum, ingreList;

        // 브라우저 호출
        webDriver.get(baseUrl);

        /// xpath() 메서드를 통해 'Sign-In'을 Visible text로 갖는 Element를 클릭
        webDriver.findElement(By.xpath("//*[contains(text(), 'Sign-In')]")).click();

        // sendKeys() 메서드를 통해 input 입력창에 파라미터 값을 넣어줌
        webDriver.findElement(By.id("email1")).sendKeys("alswp0210@abc.com");
        webDriver.findElement(By.id("password1")).sendKeys("********");
        // submit() 메서드를 통해 클릭, 버튼 실행
        webDriver.findElement(By.xpath("//input[@type='submit']")).submit();
        pause(3);

        // Menu Management ->  Menu 이동
        webDriver.findElement(By.className("glyphicon-th")).click();
        webDriver.findElement(By.className("glyphicon-certificate")).click();
        pause(1);

        // span 태그를 포함하고 있는 div 태그를 findElement() 메서드로 받아옴
        div1 = webDriver.findElement(By.id("inventoryListIngredientsId_paginate"));
        // 초기 iteration 변수 i의 범위를 설정하기 위한 할당
        // span 태그 내의 a 태그를 tagName() 메서드를 통해 받아옴
        listNum = div1.findElement(By.tagName("span")).findElements(By.tagName("a"));

        // tbody 태그를 포함하고 있는 table 태그를 findElement() 메서드로 받아옴
        div2 = webDriver.findElement(By.id("inventoryListIngredientsId"));
        // 초기 iteration 변수 j의 범위를 설정하기 위한 할당
        // tbody 태그 내의 tr 태그를 tagName() 메서드를 통해 받아옴
        ingreList = div2.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        // click() 메서드가 수행될때마다 값을 반환하므로 매번 findElement를 진행하여야 함
        // 개선된 for문을 사용하기 위해서는 고정된 listNum 리스트를 사용하므로 부적절
        // 이중 iteration을 통해 list number를 클릭하여 페이지를 전환하고 테이블의 data를 출력
        for(int i = 0; i < listNum.size(); i++) {
            listNum = div1.findElement(By.tagName("span")).findElements(By.tagName("a"));
            listNum.get(i).click();
            pause(3);
            System.out.println("Inventory Type |" +"Category |" +"Sub-Category |" +"Item Type |" +"Item Code |" +
                            "Item Name |" +"Units |");
            System.out.println("-------------------------------------------------------------------------------");
            for(int j = 0; j < ingreList.size(); j++) {
                ingreList = div2.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
                System.out.println(ingreList.get(j).getText());
            }
            System.out.println();
            pause(3);
        }
    }
}
