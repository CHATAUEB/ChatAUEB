import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
  
  //QueryBuilder class Unit Test
   @Test
    public static void testQueryGeneration() {
        String result = QueryBuilder.query(questions, answers, message);
        Assert.assertNotNull("Generated query is null", result);
        Assert.assertTrue("Generated query does not contain expected information",
                result.contains(QueryBuilder.TEXT));
        Assert.assertTrue("Generated query does not contain expected questions",
                result.contains(QueryBuilder.defaultQuestion));
    }
  
    @Test
    public void testMismatchedLengths() {
        // Mismatched lengths of questions and answers arrays
        String[] mismatchedQuestions = {"One", "Two", "Three"};
        String[] mismatchedAnswers = {"1", "2"};
        QueryBuilder.query(mismatchedQuestions, mismatchedAnswers, message);
    }

    @Test
    public void testNullQuestions() {
        questions = null;
        QueryBuilder.query(questions, answers, message);
    }

    @Test
    public void testNullAnswers() {
        answers = null;
        QueryBuilder.query(questions, answers, message);
    }

}
