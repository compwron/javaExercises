import org.junit.Test;
import src.AverageOf1ToN;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AverageOf1ToNTest {
    @Test
    public void averageOf1To1ShouldBe1(){
        assertThat(new AverageOf1ToN(1).average(), is(1.0));
    }

    @Test
    public void averageOf1To10ShouldBe5AndAHalf(){
        assertThat(new AverageOf1ToN(10).average(), is(5.5));
    }
}
