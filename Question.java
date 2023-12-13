public class Question {
    
    private static final int size = 30; //Questionnaire consists of 30 questions

    static enum QuestionType{
        NOMINAL,ORDINAL //The two types of question that the questionnaire of our application contains
    }
    
    private static String question; //Each question of the questionnaire
    private static QuestionType type; //Each type of question:Either nominal or ordinal
    private static int number; //Each number of the question 
    
    public Question(int number, String question, QuestionType type) {
      this.number = number;
      this.question = question;
      this.type = type;
    }

    public static Question getQuestionfromNumber(int number) {
        return q[number];
    }
    
    public static String getQuestion() { //Class that returns the text of a question
        return question;
    }

    public static QuestionType getType() { //Class that returns the type of a question
        return type;
    }

    static Question[] q = new Question[size];
    
    public static void insertQuestions() {
        q[1] = new Question(1,"What is your favorite color?", QuestionType.NOMINAL);
        q[2] = new Question(2, "On a scale of 1 to 10, how much do you enjoy outdoor activities?", QuestionType.ORDINAL);
        q[3] = new Question(3, "Do you prefer tea or coffee?", QuestionType.NOMINAL);
        q[4] = new Question(4, "How often do you exercise? (1: Rarely, 2: Occasionally, 3: Regularly)", QuestionType.ORDINAL);
        q[5] = new Question(5, "What is your favorite programming language?", QuestionType.NOMINAL);
        q[6] = new Question(6, "Rate your proficiency in Java on a scale of 1 to 5:", QuestionType.ORDINAL);
        q[7] = new Question(7, "Do you enjoy reading books?", QuestionType.NOMINAL);
        q[8] = new Question(8, "How satisfied are you with your current job? (1: Not satisfied, 5: Very satisfied)", QuestionType.ORDINAL);
        q[9] = new Question(9, "What is your preferred mode of transportation?", QuestionType.NOMINAL);
        q[10] = new Question(10, "How often do you eat fast food? (1: Rarely, 2: Occasionally, 3: Frequently)", QuestionType.ORDINAL);
    } //TODO - Get questions from a file

    public static void printQuestion(int number) {
            System.out.println(getQuestionfromNumber(number));
    }

}