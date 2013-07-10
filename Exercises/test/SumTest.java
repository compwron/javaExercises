import org.junit.Test;
import src.Sum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumTest {
    @Test
    public void shouldFindSumOfOneToBeOne(){
        assertThat(new Sum(TestHelper.arrayContaining(1)).sum(), is(1));
    }

    @Test
    public void shouldFindSumOf1And10ToBe11(){
        assertThat(new Sum(TestHelper.arrayContaining(1, 10)).sum(), is(11));
    }
}
