package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    @Test
    public void testSomme() {
        double a = 5,b = 9;
        double expected = 14;
        double res = 5+9;
        //Assert.assertTrue(res==expected);
        Assert.assertEquals(res,expected,0.001);
    }
}
