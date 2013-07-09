import org.junit.Test;
import src.ApproximatePi;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ApproximatePiTest {
    @Test
    public void shouldApproximatePiWithMinimumAlgorithmAccuracy(){
        assertThat(new ApproximatePi().accuracy(1), is(3.14));
    }

    @Test
    public void shouldApproximatePiWithLargeAlgorithmAccuracy(){
        assertThat(new ApproximatePi().accuracy(100), is(3.141419));
    }
}
