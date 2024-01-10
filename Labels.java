/**
* Class used to create the different texts we want to display in our graphic user interface
*/

public class Labels {
    
    static String PURPOSE;
    static String TEAM;
    static String HELP;
    static String FAQ;

    /**
    * A method that creates the first label used in the aboutUsFrame of Gui
    * @see Gui#openAboutUsFrame()
    */
    
    public static void createPurpose() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("Ο Στόχος μας");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Το ChatAUEB είναι μια εφαρμογή η οποία προτείνει σε υποψήφιους φοιτητές του Οικονομικού Πανεπιστημιού Αθηνών το τμήμα που ταιριάζει σε αυτούς περισσότερο.");
        builder.append("<br/>"); 
        builder.append("Η εφαρμογή λειτουργεί ως επαγγελματικός οδηγός για έναν μαθητή που επιθυμεί να φοιτήσει στην σχολή μας και θα ήθελε να μάθει ποιο τμήμα ανταποκρίνεται πληρέστερα στα ενδιαφέροντα και τις δεξιότητες του.");
        builder.append("<br/>");
        builder.append("Η εφαρμογή αναπτύχθηκε στα πλαίσια του μαθήματος Προγραμματισμός ΙΙ και της ομαδικής εργασίας αυτού.");
        builder.append("</html>");

        PURPOSE = builder.toString();
    }


    /**
    * A method that creates the second label used in the aboutUsFrame of Gui
    * @see Gui#openAboutUsFrame()
    */
    
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
        builder.append("Υπεύθυνος ερωτηματολογίου, υπεύθυνος για την σχεδίαση της εφαρμογής");
        builder.append("<br/>");
        builder.append("Bodybuilder, Επενδυτής και επαγγελματίας παίκτης LoL");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Νικόλαος Σινάνι(8220225): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τις κλάσεις του project, υπεύθυνος για τον έλεγχο της εφαρμογής ");
        builder.append("<br/>");
        builder.append("Γνήσιος Κουκακιώτης, ερασιτέχνης παίκτης LoL και Full-Time Υποστηρικτής του Cristiano Ronaldo");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Σπήλιος Δημακόπουλος(8220035): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τον έλεγχο της εφαρμογής, υπευθύνος για τη διεπαφή με μοντέλο ΤΝ");
        builder.append("<br/>");
        builder.append("Μόνιμος Κάτοικος Βούλας, φίλος του Μανώλη");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Αθανάσιος-Παναγιώτης Σακκάτος(8220132): ");
        builder.append("<br/>");
        builder.append("Υπεύθυνος για τις κλάσεις του project, υπεύθυνος για την σχεδίαση της εφαρμογής");
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

    /**
    * A method that creates the label used in the helpFrame of Gui
    * @see Gui#openHelpFrame()
    */
    
    public static void createHelp() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("Καλωσήρθατε στο ερωτηματολόγιο!");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Η ομάδα του ChatAUEB σας καλωσορίζει στην εφαρμογή της που θα σας βοηθήσει να ανακαλύψετε το τμήμα του Οικονομικού Πανεπιστημίου Αθηνών που σας ταιριάζει περισσότερο με βάση τα ενδιαφέροντα και τις ικανότητες σας.");
        builder.append("<br/>");
        builder.append("Πρωτού ξεκινήσετε, σας παρέχουμε ενδεικτικά κάποιες οδηγίες για το ερωτηματολόγιο της εφαρμογής.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("1.Σεβαστείτε το ερωτηματόλογιο");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Απαντήστε τις ερωτήσεις με ειλικρίνεια, αφιερώστε τον κατάλληλο χρόνο για να απαντήσετε τα ερωτήματα.");
        builder.append("<br/>");
        builder.append("Κάντε επιπρόσθετη έρευνα σε έννοιες δυσνόητες σε εσάς πρωτού απαντήσετε ένα ερώτημα.");
        builder.append("<br/>");
        builder.append("Χρησιμοποιήστε το πεδίο <<chatwithChatAUEB>> της εφαρμογής, για οποιαδήποτε απορία πάνω στα ερωτήματα ή τις απαντήσεις σας.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("2.Ολοκληρωμένο ερωτηματολόγιο");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Είναι σημαντικό να απαντήσετε όλες τις ερωτήσεις ακόμα και αν δεν ειναι απόλυτα ταιριαστές με τις κλίσεις σας.Φροντίστε να κάνετε ενα review των απαντήσεων σας,να βεβαιωθείτε ότι επιλέξατε τα σωστά πεδία απαντήσεων,ώστε το αποτέλεσμα για το ποιο τμήμα σας ταιριάζει περισσότερο να προσομοιάζει ακριβέστερα την πραγματικότητα.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Επιπρόσθετα, σας παρέχουμε ενδεικτικά κάποιες οδηγίες για το πεδίο <<chat with ChatAUEB>> της εφαρμογής.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Το συγκεκριμένο πεδίο της εφαρμογής παρέχει τη δυνατότητα στο χρήστη να ρωτήσει απευθείας το μοντέλο Τεχνητής Νοημοσύνης σχετικά με το ερωτηματολόγιο.");
        builder.append("<br/>");
        builder.append("Για παράδειγμα, μία ερώτηση προς το συγκεκριμένο μοντέλο θα ήταν η εξής:<<Θέλω να εργαστώ στο εξωτερικό. Ποιο τμήμα του ΟΠΑ να διαλέξω?>>. Γι'αυτό δημιουργήσαμε το πεδίο του <<Direct Prompt>>, ώστε η απευθείας επικοινωνία με το μοντέλο Τεχνητής Νοημοσύνης να εξυπηρετεί τον χρήστη να λαμβάνει απαντήσεις σε πολλαπλές απορίες που μπορεί να έχει.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Να σημειωθεί ότι η εφαρμογή ChatAUEB χρησιμοποεί το μοντέλο GPT-3.5-Turbo της OPEN-AI.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας! Αν έχετε οποιεσδήποτε απορίες, μη διστάσετε να επικοινωνήσετε με την ομάδα υποστήριξης.(about us/our team).");
        builder.append("</html>");
        HELP = builder.toString();
    }

    /**
    * A method that creates the label used in the FAQFrame of Gui
    * @see Gui#openFAQFrame()
    */

    public static void createFAQ() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("Συχνές Ερωτήσεις");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Υπάρχει Θέος?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Δεν ξέρω, ρώτα το ChatGPT.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Να επιλέξω το τμήμα Διοικητικής Επίστημης και Τεχνολογίας?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Μην το διανοηθείς!");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Μετάνιωσα που επέλεξα την εργασία του Docker.Μπορώ να αλλάξω απόφαση?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("ΧΑΧΑΧΑ.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Να βγω ή να κάτσω να διαβάσω?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Το δέυτερο, μπορεί και όχι...");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Τελικά το ν+2 ισχύει?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Μην χρονοτριβείς, κάτσε διάβασε!");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Η σχολή πότε κλείνει για καλοκαίρι?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Σύμφωνα με το ακαδημαικό ημερολόγιο, εμάθα να μην κοιτάω το ακαδημαικό ημερολόγιο για να απαντάω σε αυτήν την ερώτηση.");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Πως έμαθες τόσο καλά να χειρίζεσαι την Java?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Jarpeb and that's a secret!");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("-Το φαγητό στη σχολή τρώγεται?");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("Δεν θυμάμαι να ονομάσαμε την εφαρμογή LesxiAUEB...");
        builder.append("</html>");
        FAQ = builder.toString();
    }

    /**
    * A method used to initialize all the fields of this class
    */
    
    public static void createLabels() {
        createPurpose();
        createTeam();
        createHelp();
        createFAQ();
    }
}
