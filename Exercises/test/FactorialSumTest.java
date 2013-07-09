import org.junit.Test;import src.FactorialSum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialSumTest {

    @Test
    public void sumOfOneIsOne(){
        assertThat(new FactorialSum(1).sum(), is(1));
    }

    @Test
    public void sumOfFiveIsFifteen(){
        assertThat(new FactorialSum(5).sum(), is(15));
    }
}
