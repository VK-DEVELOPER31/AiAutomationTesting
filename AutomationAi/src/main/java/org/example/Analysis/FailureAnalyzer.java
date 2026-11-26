
package org.example.analysis;

import org.example.ai.AIClient;

public class FailureAnalyzer {

    public static void main(String[] args) {

        String error =
                "NoSuchElementException: Unable to locate username";

        String prompt =
                "You are a software testing expert. "
                        + "Explain this Selenium error: "
                        + error
                        + ". Give possible causes and solutions.";

        String result = AIClient.askAI(prompt);

        System.out.println("Failure Analysis:");
        System.out.println(result);
    }
}
