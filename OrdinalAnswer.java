public class OrdinalAnswer extends Answer {

    @Override 
    public Answer(int answer) {
        this.answer = answer.toString();
        this.type = Ordinal;
    }

    @Override
    public static boolean checkAnswer(int i) {
        //TODO evaluation of Ordinal values.This needs to be done by the application not the AI
    }
    
}
