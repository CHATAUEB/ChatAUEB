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

    //Unit Testing Questions class
    
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

    //Unit Testing User class

    @Test
    public void testCreateDefaultUsers() {
        User.createDefaultUsers();
        assertNotNull(User.nullUser);
        assertNotNull(User.guestUser);
    }

    @Test
    public void testSignUp() {
        User.createDefaultUsers();

        // Test signing up with invalid credentials
        assertEquals(User.nullUser, User.signUp("", ""));
        assertEquals(User.nullUser, User.signUp("validUsername", ""));

        // Test signing up with a taken username
        User existingUser = new User("existingUser", "password");
        assertEquals(User.nullUser, User.signUp("existingUser", "newPassword"));

        // Test successful sign up
        User newUser = User.signUp("newUser", "newPassword");
        assertEquals("newUser", newUser.username);
        assertEquals("newPassword", newUser.password);
        assertEquals(newUser, User.logIn("newUser", "newPassword"));
    }

    @Test
    public void testLogIn() {
        User.createDefaultUsers();

        // Test login with invalid credentials
        assertEquals(User.nullUser, User.logIn("", ""));
        assertEquals(User.nullUser, User.logIn("validUsername", ""));

        // Test login with non-existing username
        assertEquals(User.nullUser, User.logIn("nonExistingUser", "password"));

        // Test login with wrong password
        User existingUser = new User("existingUser", "password");
        assertEquals(User.nullUser, User.logIn("existingUser", "wrongPassword"));

        // Test successful login
        assertEquals(existingUser, User.logIn("existingUser", "password"));
    }

    @Test
    public void testClearAnswers() {
        User user = new User("testUser", "testPassword");
        user.answers[0] = "answer1";
        user.answers[1] = "answer2";

        user.clearAnswers();

        for (String answer : user.answers) {
            assertEquals("", answer);
        }
    }

    @Test
    public void testCountAnswers() {
        User user = new User("testUser", "testPassword");
        user.answers[0] = "answer1";
        user.answers[2] = "answer2";

        assertEquals(2, user.countAnswers());

        // Test with no answers
        assertEquals(0, new User("emptyUser", "emptyPassword").countAnswers());
    }

    //Unit Testing class ProgressBar
    
    @Test
    public void testProgressBar() {
        ProgressBar progressBar = new ProgressBar();
        
        // Set the initial value to 0 and ensure it is set correctly
        assertEquals(0, progressBar.bar.getValue());

        // Run the thread to simulate the progress bar filling up
        progressBar.start();

        // Sleep for a while to allow the progress bar to fill up (adjust as needed)
        try {
            Thread.sleep(1000); // Adjust the time depending on your needs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ensure that the progress bar value reaches 100
        assertEquals(100, progressBar.bar.getValue());

        // Ensure that the final message is set to "Done"
        assertEquals("Done", progressBar.bar.getString());

    }

    //Unit Test Labels class
    
    @Test
    public void testCreatePurpose() {
        Labels.createPurpose();
        Assert.assertNotNull("Purpose label is null", Labels.PURPOSE);
        Assert.assertTrue("Purpose label is empty", Labels.PURPOSE.trim().length() > 0);
    }

    @Test
    public void testCreateTeam() {
        Labels.createTeam();
        Assert.assertNotNull("Team label is null", Labels.TEAM);
        Assert.assertTrue("Team label is empty", Labels.TEAM.trim().length() > 0);
    }

    @Test
    public void testCreateHelp() {
        Labels.createHelp();
        Assert.assertNotNull("Help label is null", Labels.HELP);
        Assert.assertTrue("Help label is empty", Labels.HELP.trim().length() > 0);
    }

    @Test
    public void testCreateFAQ() {
        Labels.createFAQ();
        Assert.assertNotNull("FAQ label is null", Labels.FAQ);
        Assert.assertTrue("FAQ label is empty", Labels.FAQ.trim().length() > 0);
    }

    @Test
    public void testCreateLabels() {
        Labels.createLabels();
        Assert.assertNotNull("Purpose label is null", Labels.PURPOSE);
        Assert.assertNotNull("Team label is null", Labels.TEAM);
        Assert.assertNotNull("Help label is null", Labels.HELP);
        Assert.assertNotNull("FAQ label is null", Labels.FAQ);
        Assert.assertTrue("Purpose label is empty", Labels.PURPOSE.trim().length() > 0);
        Assert.assertTrue("Team label is empty", Labels.TEAM.trim().length() > 0);
        Assert.assertTrue("Help label is empty", Labels.HELP.trim().length() > 0);
        Assert.assertTrue("FAQ label is empty", Labels.FAQ.trim().length() > 0);
    }

    //Unit Test Message class
    
    @Test
    public void testMessage() {
        
        String userMessage = "Test message";
        Message message = new Message(userMessage);

        message.run(); // Sending the message to OpenAI API

        message.waitingForResponse(); // Wait for the response to be received
        assertNotNull(Message.retResponse); // Ensure that the response is not null
    }
    
    /*
    Epomenes klaseis
    */

    private void executeTests() {
        UnitTest unitTest = new UnitTest();

        // QueryBuilder class Unit Test
        unitTest.testQueryGeneration();
        unitTest.testQueryWithMessage();
        unitTest.testMismatchedLengths();
        unitTest.testNullQuestions();
        unitTest.testNullAnswers();

        // Unit Testing Questions class
        unitTest.testCreateQuestionsOnly();

        // Unit Testing User class
        unitTest.testCreateDefaultUsers();
        unitTest.testSignUp();
        unitTest.testLogIn();
        unitTest.testClearAnswers();
        unitTest.testCountAnswers();

        // Unit Testing class ProgressBar
        unitTest.testProgressBar();
    }
}
