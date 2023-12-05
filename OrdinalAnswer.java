public class OrdinalAnswer extends Answer {

    @Override 
    public Answer(int answer) {
        this.answer = answer.toString();
        this.type = Ordinal;
    }
    
}