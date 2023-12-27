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
        String t = "Σε ενα πανεπιστημιο υπαρχουν 8 τμηματα:   1) διεθνων ευρωπαικων και οικονομικων σπουδων,   2) οικονομικων επιστημων,   3) διοικητικης επιστημης και τεχνολογιας,   4) οργανωσης και διοικησης επιχειρησεων,   5) λογιστικης και χρηματοοικονομικης,   6) μαρκετινγκ και επικοινωνιας,   7) πληροφορικης,   8) στατιστικης.   Ενας μαθητης θελει να σπουδασει σε αυτο το πανεπιστημιο, αλλα δεν ξερει ποιο τμημα να διαλεξει.  Ο μαθητης απαντησε στο παρακατω ερωτηματολογιο οσων αφορα στις προτιμησεις του:   Σε ποια μαθήματα έχετε επιτύχει περισσότερο ή έχετε εκδηλώσει ιδιαίτερο ενδιαφέρον στο λύκειο;  Σε τι τομείς θα θέλατε να εργαστείτε μελλοντικά;  Ποια δραστηριότητα σας ενθουσιάζει περισσότερο;  Ποιο είναι το επίπεδο του ενδιαφέροντος σας στην τεχνολογία και την εφαρμογή της  στην διοίκηση των επιχειρήσεων;  Θα θέλατε να εργαστείτε σαν διοικητικό στέλεχος σε μια επιχείρηση ή οργανισμό;  Πώς σας ακούγεται η οργάνωση και η λειτουργία των λογιστικών και ελεγκτικών υπηρεσιών σε επιχειρήσεις ιδιωτικού ή και δημοσίου τομέα;  Σας ενδιαφέρει η διαδικασία προώθησης των πωλήσεων μέσω διαφήμισης,κοινωνικών δικτύων,ηλεκτρονικού εμπορίου;  Έχετε ενδιαφέρον για τις κοινωνικές επιστήμες και τα οικονομικά ζητήματα που βρίσκονται στην  καθημερινή, κοινωνική και πολιτική ζωή;  Θα σας άρεσε να διευρύνετε την Οικονομική Επιστήμη σε ευρωπαϊκό και διεθνές επίπεδο;  Σας αρέσει η πληροφορική και η επιστήμη των Η/Υ;  Θα θέλατε να ασχοληθείτε με την επιχειρησιακή έρευνα και την στατιστική ανάλυση;  Ποιό είδος εργασίας θεωρείτε πιο ενδιαφέρον;  Προτιμάτε να εργάζεστε πάνω σε αναλυτικά στατιστικά δεδομένα ή σε στρατηγικά σχέδια και οργάνωση;  Τι σας ακούγεται πιο συναρπαστικό;  Πόσο σημαντικό είναι για εσάς να έχετε πρόσβαση σε σύγχρονα εργαλεία και τεχνολογίες στον χώρο εργασίας;  Σας είναι σημαντικό να έχετε την δυνατότητα να ταξιδεύετε στο πλαίσιο της  εργασίας;  Ποιά εργασία σας ελκύει περισσότερο;  Ποιό μάθημα από αυτά σας ελκύει περισσότερο;  Ποιο τμήμα να διαλέξει ο χρήστης;";
        System.out.println(chatGPT(t));
    }
}
