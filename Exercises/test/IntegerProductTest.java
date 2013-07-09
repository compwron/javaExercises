import org.junit.Test;
import src.IntegerProduct;

import static org.hamcrest.core.Is.is;import static org.junit.Assert.assertThat;

public class IntegerProductTest {
    @Test
    public void productOf1ShouldBe1(){
        assertThat(new IntegerProduct(1).product(), is(1));
    }

    @Test
    public void productOf10and3ShouldBe30(){
        assertThat(new IntegerProduct(10, 3).product(), is(30));
    }

}
