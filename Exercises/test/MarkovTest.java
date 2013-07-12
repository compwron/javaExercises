import org.junit.Ignore;
import org.junit.Test;
import src.Markov;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarkovTest {
    @Test
    public void shouldReadEmptyFrequencyFromEmptyText(){
        String text = "";
        Markov chain = new Markov(text);
        assertThat(chain.frequencyOf("a"), is(0));
    }

    @Test
    public void shouldReadFrequenciesFromText(){
        String text = "ab";
        Markov chain = new Markov(text);
        assertThat(chain.frequencyOf("a"), is(1));
    }

    @Test
    public void shouldReadMultipleFrequenciesFromText(){
        String text = "aaaa";
        Markov chain = new Markov(text);
        assertThat(chain.frequencyOf("a"), is(4));
    }

    @Ignore
    @Test
    public void shouldReadCommonlyFollowedByFromText(){
        String text = "ab";
        Markov chain = new Markov(text);
        assertThat(chain.mostCommonlyFollowedOf("a"), is("b"));
    }
}
