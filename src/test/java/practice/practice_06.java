// Create a Maven Project and Setup the POM.xml dependencies
// Return a String via a static method. Call the same method to return 3 Strings namely
// "www.AutomationPUB.com”, “Selenium Tutorial For Beginners”, “Appium Tutorial For Beginners"
// https://automationpub.com/2019/01/30/selenium-tutorial-for-beginners-practice-tasks/
// 2019. 07. 22.

package practice;

public class practice_06 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;

        System.out.println(print(num1));
        System.out.println(print(num2));
        System.out.println(print(num3));
    }

    public static String print(int num) {
        if(num == 1)
            return "www.AutomationPUB.com";
        else if(num == 2)
            return "Selenium Tutorial For Beginners";
        else
            return "Appium Tutorial For Beginners";
    }
}
