import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
  
  //QueryBuilder class
   @Test
    public void testQueryGeneration() {
        String result = QueryBuilder.query(questions, answers, message);
        Assert.assertNotNull("Generated query is null", result);
        Assert.assertTrue("Generated query does not contain expected information",
                result.contains(QueryBuilder.TEXT));
        Assert.assertTrue("Generated query does not contain expected questions",
                result.contains(QueryBuilder.defaultQuestion));
    }

}
