
package org.example.optimization;

import org.example.ai.AIClient;

public class TestOptimizer {

    public static void main(String[] args) {

        // Display AI information
        System.out.println("==================================");
        System.out.println("   AI TEST OPTIMIZATION SYSTEM");
        System.out.println("==================================");

        System.out.println("AI Model : Qwen 2.5 - 7B");
        System.out.println("Platform : Ollama");
        System.out.println("Status   : Sending data to AI...\n");

        // Test execution history

        String testData = """
        Login Test:
        Passed 98 times
        Failed 2 times

        Payment Test:
        Passed 95 times
        Failed 5 times

        Profile Test:
        Passed 100 times
        Failed 0 times

        Search Test:
        Passed 99 times
        Failed 1 time

        Registration Test:
        Passed 100 times
        Failed 0 times

        Cart Test:
        Passed 97 times
        Failed 3 times

        Logout Test:
        Passed 100 times
        Failed 0 times
        """;

        System.out.println("TEST EXECUTION HISTORY");
        System.out.println("----------------------");
        System.out.println(testData);

        // Ask AI to analyze the test history

        String prompt = """
        You are an AI software testing assistant.

        Analyze the following test execution results:

        %s

        Your tasks:
        1. Calculate the total passed and failed tests.
        2. Identify tests with failures.
        3. Give the highest priority to tests with more failures.
        4. Explain possible reasons for each failure.
        5. Suggest simple debugging steps.
        6. Identify tests that are performing well.
        7. Give an overall testing quality summary.

        Important:
        - Do not invent failures.
        - Use only the supplied test results.
        - Give suggestions in simple English.
        - Format the report with clear headings.
        """.formatted(testData);

        System.out.println("AI IS ANALYZING THE TEST DATA...");
        System.out.println("Please wait...\n");

        // Connect to local AI
        String result = AIClient.askAI(prompt);

        // Display AI result
        System.out.println("==================================");
        System.out.println("       AI ANALYSIS REPORT");
        System.out.println("==================================");

        System.out.println(result);

        System.out.println("\n==================================");
        System.out.println("          ANALYSIS COMPLETE");
        System.out.println("==================================");
    }
}
