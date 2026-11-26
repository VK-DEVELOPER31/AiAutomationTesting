
package org.example.maintenance;
import org.example.ai.AIClient;
public class SmartMaintenance {

    public static void main(String[] args) {

        String oldLocator = "By.id(\"loginBtn\")";

        String newHTML =
                "<button id='submitBtn'>Login</button>";

        String prompt =
                "The old locator was: " + oldLocator
                        + ". The new HTML is: " + newHTML
                        + ". Explain how to update the locator.";

        String result = AIClient.askAI(prompt);

        System.out.println("Maintenance Suggestion:");
        System.out.println(result);
    }
}
