// Create a Maven Project and Setup the POM.xml dependencies
// Print in console “Welcome to AutomationPUB.com” & “Hello Selenium” via a STATIC void method with argument
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

public class practice_04 {
    public static void main(String[] args) {
        String a = "Welcome to AutomationPUB.com";
        String b = "Hello Selenium";

        // 클래스명을 통해 변수, 메서드 호출 가능
        // argument를 대입하여 결과값 출력
        practice_04.print(a);
        practice_04.print(b);
    }

    // static 메서드는 객체 생성되기 이전에 메모리에 먼저 로드
    // 파라미터의 자료형을 명시
    public static void print(String text) {
        System.out.println(text);
    }
}
