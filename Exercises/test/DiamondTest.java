import org.junit.Test;
import src.Diamond;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiamondTest {

    @Test
    public void shouldMakeDiamondStringWithCenterCountOfOne(){
        assertThat(new Diamond(1).print(), is("*\n"));
    }

    @Test
    public void shouldMakeDiamondStringWithCenterCountOfThree(){
        assertThat(new Diamond(3).print(), is(" *  \\n***\\n *  \\n"));
    }

}
