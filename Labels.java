public class Labels {
    
    static String PURPOSE;
    static String TEAM;
    static String HELP;
    static String FAQ;

    public static void createPurpose() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("Ο Στόχος μας");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Το ChatAUEB είναι μια εφαρμογή η οποία προτείνει σε υποψήφιους φοιτητές του Οικονομικού Πανεπιστημιού Αθηνών το τμήμα που ταιριάζει σε αυτούς περισσότερο.");
        builder.append("<br/>"); 
        builder.append("Η εφαρμογή λειτουργεί ως επαγγλματικός οδηγός για έναν μαθητή που επιθυμεί να φοιτήσει στην σχολή μας και θα ήθελε να μάθει ποιο τμήμα ανταποκρίνεται πληρέστερα στα ενδιαφέροντα και τις δεξιότητες του.");
        builder.append("<br/>");
        builder.append("Η εφαρμογή αναπτύχθηκε στα πλαίσια του μαθήματος Προγραμματισμός ΙΙ και της ομαδικής εργασίας αυτού.");
        builder.append("</html>");

        PURPOSE = builder.toString();
    }

    public static void createTeam() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("Η Ομάδα μας");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Έρνολντ Μουλάι(8220092): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για το GitHUB, υπεύθυνος για τον SQL server");
        builder.append("<br/>");
        builder.append("Έμπορος Ποδοσφαιρικών Εμφανίσεων. @athens_jersey στο Instagram");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Εμμανουήλ Παπαγιάννη(8220116): ");
        builder.append("<br/>");
        builder.append(" Συντονιστής κώδικα, αρμόδιος για τη γραφική απεικόνιση");
        builder.append("<br/>");        
        builder.append("Full-Time Καθηγητής και Part-Time Σεναριογράφος");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Σταύρος Βλάχος(8220019): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος ερωτηματολογίου");
        builder.append("<br/>");
        builder.append("Bodybuilder, Επενδυτής και επαγγελματίας παίκτης LoL");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Νικόλαος Σινάνι(8220225): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τις κλάσεις του project ");
        builder.append("<br/>");
        builder.append("Γνήσιος Κουκακιώτης, ερασιτέχνης παίκτης LoL και Full-Time Υποστηρικτής του Cristiano Ronaldo");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Σπήλιος Δημακόπουλος(8220035): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τις κλάσεις του project,υπευθύνος για τη διεπαφή με μοντέλο ΤΝ");
        builder.append("<br/>");
        builder.append("Μόνιμος Κάτοικος Βούλας, φίλος του Μανώλη");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Αθανάσιος-Παναγιώτης Σακκάτος(8220132): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τις κλάσεις του project ");
        builder.append("<br/>");
        builder.append("Προπονητής Ποδοσφαιρικής Ομάδας, Κουρέας και Full-Time Άνεργος");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Άντζελα Ντάσι(8220231): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνη για συλλογή πληροφοριών του ΟΠΑ ");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Ευγενία Βέκιου(8220015): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνη για συλλογή πληροφοριών του ΟΠΑ ");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Παύλος Σταμάτης(8220141): ");
        builder.append("<br/>");
        builder.append("Δημιουργός του μοντέλου ChatGPT-3 της OpenAI");
        builder.append("</html>");

        TEAM = builder.toString();
    }

    public static void createHelp() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("</html>");
        HELP = builder.toString();
    }

    public static void createFAQ() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("</html>");
        FAQ = builder.toString();
    }

    public static void createLabels() {
        createPurpose();
        createTeam();
        createHelp();
        createFAQ();
    }

    

    
}
