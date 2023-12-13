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

    Answer[] a = new Answer[size];
    public void insertAnswers(int number, String answer) {
        Answer ans = new Answer(answer);
        a[number] = ans;
    }
}