import org.junit.Test;
import src.IntegerFinder;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OddIntegerFinderTest {
    @Test
    public void findsOneOddInteger(){
        assertThat(new IntegerFinder(arrayContaining(1)).results(), is(arrayContaining(1)));
    }

    @Test
    public void findsNoOddIntegers(){
        assertThat(new IntegerFinder(arrayContaining(2)).results(), is(new ArrayList<Integer>()));
    }

    @Test
    public void findsOnlyOddIntegersInMixedList(){
        assertThat(new IntegerFinder(arrayContaining(2, 1, 19, 0, 21, 22)).results(), is(arrayContaining(1, 19, 21)));
    }

    private ArrayList<Integer> arrayContaining(Integer... integers){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (Integer integer : integers){
            array.add(integer);
        }
        return array;
    }
}
