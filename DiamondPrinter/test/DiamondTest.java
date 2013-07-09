import org.junit.Test;
import src.Diamond;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiamondTest {

    @Test
    public void shouldMakeDiamondStringWIthCenterCount(){
        assertThat(new Diamond(1).print(), is("*"));
    }
}
