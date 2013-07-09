import org.junit.Test;
import src.OddIntegerFinder;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OddIntegerFinderTest {
    @Test
    public void findsOneOddInteger(){
        assertThat(new OddIntegerFinder(arrayContaining(1)).odds(), is(arrayContaining(1)));
    }

    @Test
    public void findsNoOddIntegers(){
        assertThat(new OddIntegerFinder(arrayContaining(2)).odds(), is(new ArrayList<Integer>()));
    }

    @Test
    public void findsOnlyOddIntegersInMixedList(){
        assertThat(new OddIntegerFinder(arrayContaining(2, 1, 19, 0, 21, 22)).odds(), is(arrayContaining(1, 19, 21)));
    }

    private ArrayList<Integer> arrayContaining(Integer... integers){
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (Integer integer : integers){
            array.add(integer);
        }
        return array;
    }
}
