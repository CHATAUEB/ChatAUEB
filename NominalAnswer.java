public class NominalAnswer extends Answer {
    
    @Override
    public Answer(String answer) {
        this.answer = answer;
        this.type = Nominal;
    }
    
    @Override
    public static boolean checkAnswer(int i) {
       //TODO communication with AI, so it can evaluate nominal values e.g the dream job of the user  
    }
}
