import org.junit.Test;import src.SumOf1ToN;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumOf1ToNTest {

    @Test
    public void sumOfOneIsOne(){
        assertThat(new SumOf1ToN(1).sum(), is(1));
    }

    @Test
    public void sumOfFiveIsFifteen(){
        assertThat(new SumOf1ToN(5).sum(), is(15));
    }
}
