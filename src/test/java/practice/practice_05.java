// Create a Maven Project and Setup the POM.xml dependencies
// Print in console “Welcome to AutomationPUB.com” & “Hello Selenium” via a NON-STATIC void method with argument
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

public class practice_05 {
    public static void main(String[] args) {
        String a = "Welcome to AutomationPUB.com";
        String b = "Hello Selenium";

        practice_05 p5 = new practice_05();

        // argument를 대입하여 메서드 내에서 결과값 출력
        p5.print(a);
        p5.print(b);
    }

    // 파라미터의 자료형을 String으로 명시
    public void print(String text) {
        System.out.println(text);
    }

}
