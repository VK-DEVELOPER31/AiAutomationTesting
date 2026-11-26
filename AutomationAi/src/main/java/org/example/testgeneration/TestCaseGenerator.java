
package org.example.testgeneration;
import org.example.ai.AIClient;
public class TestCaseGenerator {

    public static void main(String[] args) {

        String requirement =
                "Test a login page";

        String prompt =
                "Generate 5 test cases for this requirement: "
                        + requirement
                        + ". Include positive and negative scenarios. "
                        + "Use simple English.";

        String result = AIClient.askAI(prompt);

        System.out.println("Generated Test Cases:");
        System.out.println(result);
    }
}
