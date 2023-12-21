public class QueryBuilder {
    
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


    public String QueryBuilder(questions[], answer[], message) {

        StringBuilder builder = null;
        builder.append(TEXT);
        builder.append(questions[0] + ": ");
        builder.append(answer[0] + "\n");
        builder.append(questions[1] + ": ");
        builder.append(answer[1] + "\n");
        builder.append(questions[2] + ": ");
        builder.append(answer[2] + "\n");
        builder.append(questions[3] + ": ");
        builder.append(answer[3] + "\n");
        builder.append(questions[4] + ": ");
        builder.append(answer[4] + "\n");
        builder.append(questions[5] + ": ");
        builder.append(answer[5] + "\n");
        builder.append(questions[6] + ": ");
        builder.append(answer[6] + "\n");
        builder.append(questions[7] + ": ");
        builder.append(answer[7] + "\n");

        if (message != null) {
            builder.append(message);
        }

        String toChat = builder.toString();
        return toChat;
    }
}
