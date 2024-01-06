/**
* Class used to construct the query for ChatGPT to process.
* It contains information about our university, the questionnaire along with the users answers and a prompt from the user or a default question
*/

public class QueryBuilder {
    
    // Define a constant string for the university information
    final static String TEXT = "Σε ενα πανεπιστημιο υπαρχουν 8 τμηματα: " + 
                        "1) διεθνων ευρωπαικων και οικονομικων σπουδων, " +
                        "2) οικονομικων επιστημων, " +
                        "3) διοικητικης επιστημης και τεχνολογιας, " +
                        "4) οργανωσης και διοικησης επιχειρησεων, " +
                        "5) λογιστικης και χρηματοοικονομικης, " +
                        "6) μαρκετινγκ και επικοινωνιας, " +
                        "7) πληροφορικης, " +
                        "8) στατιστικης. " +
                        "Ενας μαθητης θελει να σπουδασει σε αυτο το πανεπιστημιο, αλλα δεν ξερει ποιο τμημα να διαλεξει. " +
                        "Ο μαθητης απαντησε στο παρακατω ερωτηματολογιο οσων αφορα στις προτιμησεις του: ";

    //Define a default question for Chatgpt: choose a department based on answers
    final static String defaultQuestion = "Ποιο τμήμα να διαλέξει ο χρήστης;";

    /**
    * Method that utilizes StringBuilder's append method to create one String containing everything that is needed in the query
    * 
    * @param questions an array containing the questions of the questionnaire
    * @see Questions#createQuestionsOnly()
    *
    * @param answers an array containing the answers the user gave
    * @see User#answers
    * @see Gui#processAnswers()
    * 
    * @param message the prompt at the end. If it's "" that means we want to ask the deafult question
    * @return the full String
    */
    
    public static String query(String[] questions, String[] answers, String message) {
        
        // Initialize a StringBuilder to construct the final message
        StringBuilder builder = new StringBuilder();

        // Append the university information
        builder.append(TEXT);

        // Append each question and its corresponding answer
        for (int i = 0; i < questions.length; i++) {
            builder.append(questions[i] + " ");
            builder.append(answers[i] + " ");
        }
        
        // Append an additional message if provided
        if (message != "") {
            builder.append(message);
        } else {
            builder.append(defaultQuestion + " ");
        }
        
        // Convert the StringBuilder to a String and return it
        String toChat = builder.toString();
        return toChat;
    }
}

