public class QueryBuilder {
    
    // Define a constant string for the university information
    final static String TEXT = "Σε ενα πανεπιστημιο υπαρχουν 8 τμηματα: \r\n" + 
                        "1) διεθνων ευρωπαικων και οικονομικων σπουδων, \r\n" +
                        "2) οικονομικων επιστημων, \r\n" +
                        "3) διοικητικης επιστημης και τεχνολογιας, \r\n" +
                        "4) οργανωσης και διοικησης επιχειρησεων, \r\n" +
                        "5) λογιστικης και χρηματοοικονομικης, \r\n" +
                        "6) μαρκετινγκ και επικοινωνιας, \r\n" +
                        "7) πληροφορικης, \r\n" +
                        "8) στατιστικης. \r\n" +
                        "Ενας μαθητης θελει να σπουδασει σε αυτο το πανεπιστημιο, αλλα δεν ξερει ποιο τμημα να διαλεξει.\r\n" +
                        "Ο μαθητης απαντησε στο παρακατω ερωτηματολογιο οσων αφορα στις προτιμησεις του: \r\n";

    //Define a default question for Chatgpt: choose a department based on answers
    final static String defaultQuestion = "Ποιο τμήμα να διαλέξει ο χρήστης;";

    // Constructor method that builds the query
    public static String query(String[] questions,String[] answer,String message) {
        
        // Initialize a StringBuilder to construct the final message
        StringBuilder builder = new StringBuilder();

        // Append the university information
        builder.append(TEXT);

        // Append each question and its corresponding answer
        for (int i = 0; i < questions.length; i++) {
            builder.append(questions[i] + ": ");
            builder.append(answer[i] + "\n");
        }
        
        // Append an additional message if provided
        if (message != "") {
            builder.append(message);
        } else {
            builder.append(defaultQuestion + "\n");
        }
        
        // Convert the StringBuilder to a String and return it
        String toChat = builder.toString();
        return toChat;
    }

    public static void main(String args[]) {
        String[] questions = new String[3];
        String[] answers = new String[3];
        String message = "";
        questions[0] = "One";
        questions[1] = "Two";
        questions[2] = "Three";
        answers[0] = "1";
        answers[1] = "2";
        answers[2] = "3";
        System.out.println(QueryBuilder.query(questions, answers, message));
    }
}

