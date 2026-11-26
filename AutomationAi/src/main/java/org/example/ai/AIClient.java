
package org.example.ai;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class AIClient {

    private static final String URL =
            "http://localhost:11434/api/chat";

    private static final String MODEL = "qwen2.5:7b";

    public static String askAI(String prompt) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            // Create the message
            Map<String, Object> message = Map.of(
                    "role", "user",
                    "content", prompt
            );

            // Create the request body
            Map<String, Object> requestBody = Map.of(
                    "model", MODEL,
                    "messages", List.of(message),
                    "stream", false
            );

            // Convert Java object into valid JSON
            String json = mapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() != 200) {
                return "Ollama Error: " + response.body();
            }

            // Read AI response
            Map<?, ?> result = mapper.readValue(
                    response.body(), Map.class
            );

            Map<?, ?> aiMessage = (Map<?, ?>) result.get("message");

            return aiMessage.get("content").toString();

        } catch (Exception e) {
            return "AI Error: " + e.getMessage();
        }
    }
}
