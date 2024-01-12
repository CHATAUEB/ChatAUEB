import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

    //Unit Test StringBuilder class
    
    @Test
    public void testQuery() {
        // Sample questions and answers
        String[] questions = {"Ερώτηση 1", "Ερώτηση 2", "Ερώτηση 3"};
        String[] answers = {"Απάντηση 1", "Απάντηση 2", "Απάντηση 3"};

        // Sample message
        String message = "Επιπλέον μήνυμα";

        // Expected result
        String expected = "Σε ενα πανεπιστημιο υπαρχουν 8 τμηματα: " +
                "1) διεθνων ευρωπαικων και οικονομικων σπουδων, " +
                "2) οικονομικων επιστημων, " +
                "3) διοικητικης επιστημης και τεχνολογιας, " +
                "4) οργανωσης και διοικησης επιχειρησεων, " +
                "5) λογιστικης και χρηματοοικονομικης, " +
                "6) μαρκετινγκ και επικοινωνιας, " +
                "7) πληροφορικης, " +
                "8) στατιστικης. " +
                "Ενας μαθητης θελει να σπουδασει σε αυτο το πανεπιστημιο, αλλα δεν ξερει ποιο τμημα να διαλεξει. " +
                "Ερώτηση 1 Απάντηση 1 Ερώτηση 2 Απάντηση 2 Ερώτηση 3 Απάντηση 3 Επιπλέον μήνυμα ";

        // Actual result
        String actual = QueryBuilder.query(questions, answers, message);

        // Assert
        assertEquals(expected, actual);
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
        unitTest.testQuery();

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

