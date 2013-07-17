import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOf1ToNTest {

    @Test
    public void sumOfOneIsOne(){
        assertThat(new ListOf1ToN(1).list(), is(TestHelper.arrayContaining(1)));
    }

    @Test
    public void sumOfFiveIsFifteen(){
        assertThat(new ListOf1ToN(5).list(), is(TestHelper.arrayContaining(1, 2, 3, 4, 5)));
    }
}
