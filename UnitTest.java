import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

    //Unit Testing Questions class (trexei mia xara)
    
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
/*
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
    */
    
    //Unit Test Labels class ( trexei mia xara )
    
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

    //Unit Test Message class (trexei mia xara)
    
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

        // Unit Testing Questions class
        unitTest.testCreateQuestionsOnly();

        /*
        // Unit Testing User class
        unitTest.testCreateDefaultUsers();
        unitTest.testSignUp();
        unitTest.testLogIn();
        unitTest.testClearAnswers();
        unitTest.testCountAnswers();
        */

        //Unit Test Labels class
        unitTest.testCreatePurpose();
        unitTest.testCreateTeam();
        unitTest.testCreateHelp();
        unitTest.testCreateFAQ();
        unitTest.testCreateLabels();
            
        //Unit Test Message class
        unitTest.testMessage();
    }
}

