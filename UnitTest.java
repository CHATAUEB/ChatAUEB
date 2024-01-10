import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
    String[] questions = {"One", "Two", "Three"};
    String[] answers = {"1", "2", "3"};
    String message = "";
  
    //QueryBuilder class Unit Test
    @Test
    public void testQueryGeneration() {
    String result = QueryBuilder.query(questions, answers, message);
        Assert.assertNotNull("Generated query is null", result);
        Assert.assertTrue("Generated query does not contain expected information",
                result.contains(QueryBuilder.TEXT));
        Assert.assertTrue("Generated query does not contain expected question",
                result.contains(QueryBuilder.DEFAULTQUESTION));
    }

    @Test
    public void testQueryWithMessage() {
        message = "Custom message";
        String result = QueryBuilder.query(questions, answers, message);
        Assert.assertNotNull("Generated query is null", result);
        Assert.assertTrue("Generated query does not contain custom message",
                result.contains(message));
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
    
    @Test
    public void testCreateQuestionsOnly() {
        // Arrange
        Questions.createQuestions(); // Initialize questions in fullQuestions array

        // Act
        String[] questionsOnly = Questions.createQuestionsOnly(Questions.fullQuestions);

        // Assert
        Assert.assertNotNull(questionsOnly);
        Assert.assertEquals(User.answersLength, questionsOnly.length);

    }

}
