
package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            System.out.println("Opening browser...");

            driver.get("https://www.google.com");

            String title = driver.getTitle();

            System.out.println("Page Title: " + title);

            if (title.contains("Google")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        } catch (Exception e) {

            System.out.println("TEST FAILED");
            System.out.println(e.getMessage());

        } finally {

            driver.quit();
        }
    }
}
