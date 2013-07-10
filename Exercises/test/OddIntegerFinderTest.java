import org.junit.Test;
import src.IntegerFinder;
import src.IntegerType;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OddIntegerFinderTest {
    @Test
    public void findsOneOddInteger(){
        assertThat(new IntegerFinder(TestHelper.arrayContaining(1), IntegerType.ODD).results(), is(TestHelper.arrayContaining(1)));
    }

    @Test
    public void findsNoOddIntegers(){
        assertThat(new IntegerFinder(TestHelper.arrayContaining(2), IntegerType.ODD).results(), is(new ArrayList<Integer>()));
    }

    @Test
    public void findsOnlyOddIntegersInMixedList(){
        assertThat(new IntegerFinder(TestHelper.arrayContaining(2, 1, 19, 0, 21, 22), IntegerType.ODD).results(), is(TestHelper.arrayContaining(1, 19, 21)));
    }

    @Test
    public void findsOnlyEvenIntegersInMixedList(){
        assertThat(new IntegerFinder(TestHelper.arrayContaining(2, 1, 19, 0, 21, 22), IntegerType.EVEN).results(), is(TestHelper.arrayContaining(2, 0, 22)));
    }
}
