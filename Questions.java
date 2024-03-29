/**
* Class used to create the questions of the questionnaire as well as the choices the user has for each questions
* The two dimensional array fullQuestions contains the questions in each row as well as the choices in each column
*/

public class Questions {
    public static int questionsLength = User.answersLength;
    public static int choices = 6;
    public static final String[][] fullQuestions = new String[questionsLength][choices + 1];

    /**
    * Method that initializes the fullQuestions array with our questions and choices
    */
    
    public static void createQuestions() {
        fullQuestions[0][0] = "Σε ποια μαθήματα έχετε επιτύχει περισσότερο ή έχετε εκδηλώσει ιδιαίτερο ενδιαφέρον στο λύκειο;";
        fullQuestions[0][1] = "Μαθηματικά";
        fullQuestions[0][2] = "Οικονομικά";
        fullQuestions[0][3] = "Διοίκηση Επιχειρήσεων";
        fullQuestions[0][4] = "Πληροφορική";
        fullQuestions[0][5] = "Σε όλα";
        fullQuestions[0][6] = "Σε κανένα από αυτά";
        fullQuestions[1][0] = "Σε τι τομείς θα θέλατε να εργαστείτε μελλοντικά;";
        fullQuestions[1][1] = "Μάρκετινγκ και Επικοινωνίες";
        fullQuestions[1][2] = "Διεθνείς αγορές και εργασία σε περιβάλλοντα με διαφορετικούς πολιτισμούς";
        fullQuestions[1][3] = "Προγραμματισμό, Αλγόριθμους και Δεδομένα";
        fullQuestions[1][4] = "Διοίκηση Επιχειρήσεων και Οργανισμών σε συνδυασμό με νέες τεχνολογίες";
        fullQuestions[1][5] = "Διαχείρηση οικονομικών χαρτοφυλακίων";
        fullQuestions[1][6] = "Λογιστική και Χρηματοοϊκονομικά";
        fullQuestions[2][0] = "Ποια δραστηριότητα σας ενθουσιάζει περισσότερο;";
        fullQuestions[2][1] = "Ανάλυση δεδομένων και στατιστική";
        fullQuestions[2][2] = "Σχεδιασμός και διαχείριση προγραμμάτων";
        fullQuestions[2][3] = "Οργάνωση, συνεργασία και διαπραγμάτευση";
        fullQuestions[2][4] = "Δημιουργικότητα και διαφήμιση";
        fullQuestions[2][5] = "Τεχνολογία και προηγμένα συστήματα";
        fullQuestions[2][6] = "";
        fullQuestions[3][0] = "Ποιο είναι το επίπεδο του ενδιαφέροντος σας στην τεχνολογία και την εφαρμογή της  στην διοίκηση των επιχειρήσεων;";
        fullQuestions[3][1] = "Χαμηλό";
        fullQuestions[3][2] = "Μέτριο";
        fullQuestions[3][3] = "Υψηλό";
        fullQuestions[3][4] = "";
        fullQuestions[3][5] = "";
        fullQuestions[3][6] = "";
        fullQuestions[4][0] = "Θα θέλατε να εργαστείτε σαν διοικητικό στέλεχος σε μια επιχείρηση ή οργανισμό;";
        fullQuestions[4][1] = "Ναι";
        fullQuestions[4][2] = "Όχι";
        fullQuestions[4][3] = "Δεν ξέρω";
        fullQuestions[4][4] = "";
        fullQuestions[4][5] = "";
        fullQuestions[4][6] = "";
        fullQuestions[5][0] = "Πώς σας ακούγεται η οργάνωση και η λειτουργία των λογιστικών και ελεγκτικών υπηρεσιών σε επιχειρήσεις ιδιωτικού ή και δημοσίου τομέα;";
        fullQuestions[5][1] = "Με ενδιαφέρει";
        fullQuestions[5][2] = "Δεν με ενδιαφέρει";
        fullQuestions[5][3] = "Δεν ξέρω";
        fullQuestions[5][4] = "";
        fullQuestions[5][5] = "";
        fullQuestions[5][6] = "";
        fullQuestions[6][0] = "Σας ενδιαφέρει η διαδικασία προώθησης των πωλήσεων μέσω διαφήμισης,κοινωνικών δικτύων,ηλεκτρονικού εμπορίου;";
        fullQuestions[6][1] = "Πολύ";
        fullQuestions[6][2] = "Λίγο";
        fullQuestions[6][3] = "Καθόλου";
        fullQuestions[6][4] = "";
        fullQuestions[6][5] = "";
        fullQuestions[6][6] = "";
        fullQuestions[7][0] = "Έχετε ενδιαφέρον για τις κοινωνικές επιστήμες και τα οικονομικά ζητήματα που βρίσκονται στην  καθημερινή, κοινωνική και πολιτική ζωή;";
        fullQuestions[7][1] = "Πολύ";
        fullQuestions[7][2] = "Λίγο";
        fullQuestions[7][3] = "Καθόλου";
        fullQuestions[7][4] = "";
        fullQuestions[7][5] = "";
        fullQuestions[7][6] = "";
        fullQuestions[8][0] = "Θα σας άρεσε να διευρύνετε την Οικονομική Επιστήμη σε ευρωπαϊκό και διεθνές επίπεδο;";
        fullQuestions[8][1] = "Ναι";
        fullQuestions[8][2] = "Όχι";
        fullQuestions[8][3] = "";
        fullQuestions[8][4] = "";
        fullQuestions[8][5] = "";
        fullQuestions[8][6] = "";
        fullQuestions[9][0] = "Σας αρέσει η πληροφορική και η επιστήμη των Η/Υ;";
        fullQuestions[9][1] = "Πολύ";
        fullQuestions[9][2] = "Λίγο";
        fullQuestions[9][3] = "Καθόλου";
        fullQuestions[9][4] = "";
        fullQuestions[9][5] = "";
        fullQuestions[9][6] = "";
        fullQuestions[10][0] = "Θα θέλατε να ασχοληθείτε με την επιχειρησιακή έρευνα και την στατιστική ανάλυση;";
        fullQuestions[10][1] = "Ναι";
        fullQuestions[10][2] = "Όχι";
        fullQuestions[10][3] = "";
        fullQuestions[10][4] = "";
        fullQuestions[10][5] = "";
        fullQuestions[10][6] = "";
        fullQuestions[11][0] = "Ποιό είδος εργασίας θεωρείτε πιο ενδιαφέρον;";
        fullQuestions[11][1] = "Οικονομική ανάλυση και έρευνα μεταξύ κρατών σε παγκόσμιο επίπεδο";
        fullQuestions[11][2] = "Συνδυασμός τεχνολογίας με διοικητικές διαδικασίες";
        fullQuestions[11][3] = "Δημιουργική προώθηση προϊόντων ή υπηρεσιών";
        fullQuestions[11][4] = "Ανάλυση δεδομένων και πρόβλεψη τάσεων";
        fullQuestions[11][5] = "Ανάλυση οικονομικών και διαχείριση χρημάτων";
        fullQuestions[11][6] = "";
        fullQuestions[12][0] = "Προτιμάτε να εργάζεστε πάνω σε αναλυτικά στατιστικά δεδομένα ή σε στρατηγικά σχέδια και οργάνωση;";
        fullQuestions[12][1] = "Αναλυτικά στατιστικά δεδομένα";
        fullQuestions[12][2] = "Στρατηγικά Σχέδια και Οργάνωση";
        fullQuestions[12][3] = "Και τα δύο εξίσου";
        fullQuestions[12][4] = "";
        fullQuestions[12][5] = "";
        fullQuestions[12][6] = "";
        fullQuestions[13][0] = "Τι σας ακούγεται πιο συναρπαστικό;";
        fullQuestions[13][1] = "Η επιστήμη των υπολογιστών και την εφαρμογή της σε διάφορους τομείς.";
        fullQuestions[13][2] = "Ο συνδυασμός των σύγχρονων τεχνολογιών με τις επιχειρήσεις";
        fullQuestions[13][3] = "Τα μαθηματικά και οι αριθμητικές πράξεις";
        fullQuestions[13][4] = "Οι κοινωνικές συναναστροφές και η επικοινωνία";
        fullQuestions[13][5] = "Η καταγραφή και ο έλεγχος των δραστηριοτήτων μιας επιχείρησης";
        fullQuestions[13][6] = "";
        fullQuestions[14][0] = "Πόσο σημαντικό είναι για εσάς να έχετε πρόσβαση σε σύγχρονα εργαλεία και τεχνολογίες στον χώρο εργασίας;";
        fullQuestions[14][1] = "Πολύ";
        fullQuestions[14][2] = "Λίγο";
        fullQuestions[14][3] = "Καθόλου";
        fullQuestions[14][4] = "";
        fullQuestions[14][5] = "";
        fullQuestions[14][6] = "";
        fullQuestions[15][0] = "Σας είναι σημαντικό να έχετε την δυνατότητα να ταξιδεύετε στο πλαίσιο της  εργασίας;";
        fullQuestions[15][1] = "Ναι";
        fullQuestions[15][2] = "Όχι";
        fullQuestions[15][3] = "Αδιαφορώ";
        fullQuestions[15][4] = "";
        fullQuestions[15][5] = "";
        fullQuestions[15][6] = "";
        fullQuestions[16][0] = "Ποιά εργασία σας ελκύει περισσότερο;";
        fullQuestions[16][1] = "Πωλήσεις και διαφήμιση";
        fullQuestions[16][2] = "Στατιστικές υπηρεσίες σε δημόσιους ή ιδιωτικούς οργανισμούς";
        fullQuestions[16][3] = "Διοίκηση εφοδιαστικής αλυσίδας";
        fullQuestions[16][4] = "";
        fullQuestions[16][5] = "";
        fullQuestions[16][6] = "";
        fullQuestions[17][0] = "Ποιό μάθημα από αυτά σας ελκύει περισσότερο;";
        fullQuestions[17][1] = "Κοινωνιολογία ";
        fullQuestions[17][2] = "Βάσεις δεδομένων";
        fullQuestions[17][3] = "Διεθνές και Ευρωπαϊκό Δίκαιο";
        fullQuestions[17][4] = "Ψηφιακή καινοτομία και επιχειρηματικότητα";
        fullQuestions[17][5] = "";
        fullQuestions[17][6] = "";
    }

    /**
    * Method that separates the questions from the choices and stores them in a one-dimensional array
    * @param fullQuestions the array created by createQuestions
    * @return a one-dimensional String array containing the questions
    */

    public static String[] createQuestionsOnly(String [][] fullQuestions) {
        String[] ret = new String[User.answersLength];
        for (int i = 0; i <User.answersLength; i++) {
            ret[i] = fullQuestions[i][0];
        }
        return ret;
    }
}
