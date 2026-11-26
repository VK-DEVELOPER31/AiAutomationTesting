
package org.example.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SmartWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(
                    "https://the-internet.herokuapp.com/dynamic_loading/1"
            );

            driver.findElement(By.cssSelector("#start button")).click();

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            WebElement result = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("finish")
                    )
            );

            System.out.println(result.getText());

        } finally {

            driver.quit();
        }
    }
}
