import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.lang.reflect.Field;

public class UnitTest {
    //Unit Testing QueryBuilder class (trexei mia xara)

    @Test
    public void testQuery() {
        // Sample data for testing
        String[] questions = {"Question1", "Question2", "Question3"};
        String[] answers = {"Answer1", "Answer2", "Answer3"};
        String message = "Additional message";

        // Call the query method and store the result
        String result = QueryBuilder.query(questions, answers, message);

        // Expected result based on the provided data
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
                "Ο μαθητης απαντησε στο παρακατω ερωτηματολογιο οσων αφορα στις προτιμησεις του: " +
                "Question1 Answer1 Question2 Answer2 Question3 Answer3 Additional message";

        // Check if the result matches the expected value
        assertEquals(expected, result);
    }
    
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

    private User testUser;

    @Before
    public void setUp() {
        User.createDefaultUsers(); // Initialize nullUser and guestUser
        testUser = new User("TestUser", "TestPassword");
    }

    @Test
    public void testSignUp() {
        User signedUpUser = User.signUp("NewUser", "NewPassword");
        assertNotNull(signedUpUser);
        assertEquals("NewUser", signedUpUser.username);
        assertEquals("NewPassword", signedUpUser.password);
        assertTrue(User.UserList.contains(signedUpUser));
    }

    @Test
    public void testSignUpWithInvalidCredentials() {
        User invalidUser = User.signUp("", "");
        assertEquals(User.nullUser, invalidUser);
    }

    @Test
    public void testSignUpWithTakenUsername() {
        User existingUser = User.signUp("Guest", "1234");
        assertEquals(User.nullUser, existingUser);
    }

    @Test
    public void testLogIn() {
        User loggedInUser = User.logIn("TestUser", "TestPassword");
        assertNotNull(loggedInUser);
        assertEquals("TestUser", loggedInUser.username);
        assertEquals("TestPassword", loggedInUser.password);
    }

    @Test
    public void testLogInWithInvalidCredentials() {
        User invalidUser = User.logIn("", "");
        assertEquals(User.nullUser, invalidUser);
    }

    @Test
    public void testLogInWithWrongPassword() {
        User wrongPasswordUser = User.logIn("TestUser", "WrongPassword");
        assertEquals(User.nullUser, wrongPasswordUser);
    }

    @Test
    public void testLogInWithNonexistentUsername() {
        User nonExistentUser = User.logIn("NonExistentUser", "SomePassword");
        assertEquals(User.nullUser, nonExistentUser);
    }

    @Test
    public void testClearAnswers() {
        // Assuming clearAnswers method works as expected
        testUser.clearAnswers();
        for (String answer : testUser.answers) {
            assertEquals("", answer);
        }
    }

    @Test
    public void testCountAnswers() {
        // Assuming countAnswers method works as expected
        assertEquals(0, testUser.countAnswers());
        
        // Let's simulate answering a few questions
        testUser.answers[0] = "Answer1";
        testUser.answers[5] = "Answer2";
        testUser.answers[10] = "Answer3";
        
        assertEquals(3, testUser.countAnswers());
    }
    
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
    public void testRun() {
        // Arrange
        String expectedResponse = "Test response";
        String messageContent = "Test message";

        // Act
        Message message = new Message(messageContent);
        message.run();

        // Assert
        assertEquals(expectedResponse, Message.retResponse);
    }

    //Unit Testing ProgressBar 

     @Test
    public void testProgressBar() {
        final ProgressBar progressBar = new ProgressBar();
        progressBar.start();

        try {
            // Sleep for some time to allow the progress bar to update
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the progress bar's value has been updated
        assertTrue(progressBar.bar.getValue() > 0);

        // Check if the progress bar's string has been updated
        assertNotNull(progressBar.bar.getString());
        assertFalse(progressBar.bar.getString().isEmpty());

        // Stop the progress bar thread
        progressBar.interrupt();
    }

    @Test
    public void testErrorCreation() throws Exception {
        Error error1 = Error.invalidCredentials;
        Field field = Error.class.getDeclaredField("errorName");
        field.setAccessible(true);
        assertEquals("Invalid Credentials", (String) field.get(error1));
        field = Error.class.getDeclaredField("errorMessage");
        field.setAccessible(true);
        assertEquals("You have not entered valid credentials. Please try again", (String) field.get(error1));

    }
    
    /*
    Epomenes klaseis
    */

    private void executeTests() {
        UnitTest unitTest = new UnitTest();

        //Unit Testing QueryBuilder class
        unitTest.testQuery();
            
        // Unit Testing Questions class
        unitTest.testCreateQuestionsOnly();

        //Unit Testing User class
        unitTest.testSignUp();
        unitTest.testLogIn();
        unitTest.testClearAnswers();
        unitTest.testCountAnswers();
        
        // Unit Testing User class
        unitTest.testCreateDefaultUsers();
        unitTest.testSignUp();
        unitTest.testLogIn();
        unitTest.testClearAnswers();
        unitTest.testCountAnswers();

        //Unit Test Labels class
        unitTest.testCreatePurpose();
        unitTest.testCreateTeam();
        unitTest.testCreateHelp();
        unitTest.testCreateFAQ();
        unitTest.testCreateLabels();
            
        //Unit Test Message class
        unitTest.testMessage();

        //Unit Testing ProgressBar 
        unitTest.testProgressBar()
    }
}
