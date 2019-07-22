// Create a Maven Project and Setup the POM.xml dependencies
// Print in console “Welcome to  AutomationPUB.com” via a NON-STATIC void method
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

public class practice_03 {

    public static void main(String[] args) {
        // non-static 메서드를 사용하기 위해 클래스를 인스턴스로 생성
        // 객체 생성 후 메모리에 로드되고 변수, 메서드 사용 가능
        practice_03 p3 = new practice_03();
        // 인스턴스의 메서드를 호출
        p3.print();
    }

    // non-static 메서드, 객체를 통해서 호출 가능
    public void print() {
        System.out.println("Welcome to AutomationPUB.com");
    }

}
