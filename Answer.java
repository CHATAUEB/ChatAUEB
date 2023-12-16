public class Answer {

    private static final int size = 30;
    enum AnswerType{
        NOMINAL, ORDINAL
    }

    private String answer1;
    private int answer2;

    public Answer(String answer1) {
        this.answer1 = answer1;
    }

    public Answer(int answer2) {
        this.answer2 = answer2;
    }

    Answer[] a = new Answer[size]; //Na uparxei if statement me synthiki poy tha elegxei to type tou question kai tha kalei thn antistoixh methodo
    public void insertNominalAnswers(int number, String answer) {
        Answer ans = new Answer(answer);
        a[number] = ans;
    }

    public void insertOrdinalAnswers(int number, int answer) {
        Answer ans = new Answer(answer);
        a[number] = ans;
    }
}
