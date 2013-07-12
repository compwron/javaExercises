import org.junit.Test;
import src.Markov;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarkovTest {

    @Test
    public void shouldReadFrequenciesFromText(){

        // list of: letter => [[following letter => frequency], [following letter => frequency]]
//        for(words in text.count); make_word
        String text = "ab";
        Markov chain = new Markov(text);
        assertThat(chain.frequencyOf("a"), is(1));
        assertThat(chain.mostCommonlyFollowedBy("a"), is("b"));

    }

}
