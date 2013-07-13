import org.junit.Ignore;
import org.junit.Test;
import src.MarkovGenerator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarkovTest {
    @Test
    public void shouldReadEmptyFrequencyFromEmptyText(){
        String text = "";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.frequencyOf("a"), is(0));
    }

    @Test
    public void shouldReadFrequenciesFromText(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.frequencyOf("a"), is(1));
    }

    @Test
    public void shouldReadMultipleFrequenciesFromText(){
        String text = "aaaa";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.frequencyOf("a"), is(4));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromText(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.mostCommonlyFollowedOf("a"), is("b"));
    }

    @Ignore("not implemented")
    @Test
    public void shouldReadCommonlyFollowedByFromTextAsNullWhenNone(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.mostCommonlyFollowedOf("a"), is("b"));
    }

    @Ignore("not implemented")
    @Test
    public void shouldReadCommonlyFollowedByFromTextAsFirstWhenTied(){
        String text = "acad";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.mostCommonlyFollowedOf("a"), is("c"));
    }
}
