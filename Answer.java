import java.util.Scanner;

public abstract class Answer {

    public String answer;
    public Type type; 
    public abstract Answer(); //Default constructor, must be overriden by subclasses
    
    public static Answer readAnswer(int i) {
        System.out.println(Questions.questions[i]);
        Scanner read = new Scanner(System.in);
        String temp = read.nextLine();
        boolean flag = checkAnswer(temp);
    }

    public abstract static boolean checkAnswer(int i);

    public static void setAnswer(int i, Answer answer) {
        this.answer = answer;
    }

    public static Answer getAnswer() {
        return this.answer;
    }



}
