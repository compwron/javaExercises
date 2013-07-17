import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;import static org.junit.Assert.assertThat;

public class IntegerCollectionTest {
    @Test
    public void productOf1ShouldBe1(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(1)).product(), is(1));
    }

    @Test
    public void productOf10and3ShouldBe30(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(10, 3)).product(), is(30));
    }

    @Test
    public void shouldFindSumOfOneToBeOne(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(1)).sum(), is(1));
    }

    @Test
    public void shouldFindSumOf1And10ToBe11(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(1, 10)).sum(), is(11));
    }

    @Test
    public void averageOf1To1ShouldBe1(){
        assertThat(new IntegerCollection(new ListOf1ToN(1).list()).average(), is(1.0));
    }

    @Test
    public void averageOf1To10ShouldBe5AndAHalf(){
        assertThat(new IntegerCollection(new ListOf1ToN(10).list()).average(), CoreMatchers.is(5.5));
    }
    @Test
    public void findsOneOddInteger(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(1)).ofType(IntegerType.ODD), is(TestHelper.arrayContaining(1)));
    }

    @Test
    public void findsNoOddIntegers(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(2)).ofType(IntegerType.ODD), is(new ArrayList<Integer>()));
    }

    @Test
    public void findsOnlyOddIntegersInMixedList(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(2, 1, 19, 0, 21, 22)).ofType(IntegerType.ODD), is(TestHelper.arrayContaining(1, 19, 21)));
    }

    @Test
    public void findsOnlyEvenIntegersInMixedList(){
        assertThat(new IntegerCollection(TestHelper.arrayContaining(2, 1, 19, 0, 21, 22)).ofType(IntegerType.EVEN), is(TestHelper.arrayContaining(2, 0, 22)));
    }
}
