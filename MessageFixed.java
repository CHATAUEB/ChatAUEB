import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Message {

    // Replace with your actual API key and model name
    private static final String API_KEY = "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";
    private static final String MODEL = "gpt-3.5-turbo";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    /**
     * Sends a user message to the OpenAI GPT-3.5 Turbo API and retrieves the model's response.
     *
     * @param message User's input message.
     * @return Model's response.
     */
    public static String chatGPT(String message) {
        try {
            // Create URL object
            URL url = new URL(API_URL);

            // Open connection to the API
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + API_KEY);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoOutput(true);

            try (OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), StandardCharsets.UTF_8)) {
                // Build JSON request body with user message
                String body = String.format("{\"model\": \"%s\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}", MODEL, message);
                writer.write(body);
            }

            // Check if the request was successful (HTTP status code 200)
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                    // Read and concatenate the model's response
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    // Extract and return the content from the response
                    return extractContentFromResponse(response.toString());
                }
            } else {
                throw new RuntimeException("HTTP request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Extracts the content from the API response.
     *
     * @param response API response in JSON format.
     * @return Extracted content.
     */
    public static String extractContentFromResponse(String response) {
        int startMarker = response.indexOf("content") + 11;
        int endMarker = response.indexOf("\"", startMarker);
        return response.substring(startMarker, endMarker);
    }

    /**
     * Main method for testing the chatGPT method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test the chatGPT method with a Greek message
        assert response != null : "Response should not be null";
        assert !response.isEmpty() : "Response should not be empty";
        System.out.println(chatGPT("Πως να ξεκινήσω να βγαίνω απο το σπίτι;"));
    }
}
