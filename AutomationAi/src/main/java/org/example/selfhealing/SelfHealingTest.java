
package org.example.selfhealing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.ai.AIClient;
public class SelfHealingTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/login");

            try {

                driver.findElement(By.id("wrongUsername"));

            } catch (NoSuchElementException e) {

                System.out.println("Original locator failed!");

                String suggestion = AIClient.askAI(
                        "For the login username field on " +
                                "the-internet.herokuapp.com/login, " +
                                "suggest a Selenium locator using id or name."
                );

                System.out.println("AI Suggestion:");
                System.out.println(suggestion);

                // Known fallback locator, validated by Java
                WebElement username =
                        driver.findElement(By.id("username"));

                username.sendKeys("tomsmith");
            }

        } finally {

            driver.quit();
        }
    }
}
