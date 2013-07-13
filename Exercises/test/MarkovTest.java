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
        assertThat(chain.mostCommonlyFollowedOf("a").character(), is('b'));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromTextAsNullWhenNone(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.mostCommonlyFollowedOf("a").character(), is('b'));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromTextAsLastWhenTied(){
        String text = "acad";
        MarkovGenerator chain = new MarkovGenerator(text);
        assertThat(chain.mostCommonlyFollowedOf("a").character(), is('d'));
    }

    @Test
    public void shouldGenerateShortText(){
        String text = "ac ac ";
        MarkovGenerator generator = new MarkovGenerator(text);
        assertThat(generator.generate(5), is("ac ab"));
    }
}
