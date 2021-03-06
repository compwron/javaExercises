import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MarkovTest {
    private final String longText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

    @Test
    public void shouldReadEmptyFrequencyFromEmptyText(){
        String text = "";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.frequencyOf("a"), is(0));
    }

    @Test
    public void shouldReadFrequenciesFromText(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.frequencyOf("a"), is(1));
    }

    @Test
    public void shouldReadMultipleFrequenciesFromText(){
        String text = "aaaa";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.frequencyOf("a"), is(4));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromText(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.mostCommonlyFollowedOf("a").unit(), is("b"));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromTextAsNullWhenNone(){
        String text = "ab";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.mostCommonlyFollowedOf("a").unit(), is("b"));
    }

    @Test
    public void shouldReadCommonlyFollowedByFromTextAsLastWhenTied(){
        String text = "acadad";
        MarkovGenerator chain = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(chain.mostCommonlyFollowedOf("a").unit(), is("d"));
    }

    @Test
    public void shouldGenerateShortText(){
        String text = "ac ac ";
        MarkovGenerator generator = new MarkovGenerator(text, GenerateLevel.Letter);
        assertThat(generator.generate(5), is("ac ac"));
    }

    @Test
    public void shouldGenerateLongText(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Letter);
        assertTrue(generator.generate(500) != null);
    }

    @Test
    public void shouldByDefaultGenerateNumberOfCharactersAsInOriginalText(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Letter);
        assertThat(generator.generate().length(), is(longText.length()));
    }

    @Test
    public void shouldGenerateSpecifiedNumberOfCharacters(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Letter);
        assertThat(generator.generate(50).length(), is(50));
    }

    @Test
    public void shouldGenerateFromSourceTextInWordChunks(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Word);
        System.out.println(generator.generate());
        System.out.println(longText);
        assertTrue(generator.generate().contains("ipsum"));
        assertFalse(generator.generate().equals(longText));
    }

    @Test
    public void generatedWordsShouldNotBeTheSameAsSourceWords(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Word);
        assertFalse(generator.generate().contains(longText));
    }

    @Test
    public void generatedWordsShouldByDefaultHaveTheSameNumberOfWordsAsTheSourceText(){
        MarkovGenerator generator = new MarkovGenerator(longText, GenerateLevel.Word);
        assertThat(wordsIn(generator.generate()), is(wordsIn(longText)));
    }

    private Integer wordsIn(String longText) {
        int wordCount = 0;
        for (String word : longText.split(GenerateLevel.Word.splitSymbol)){
            wordCount++;
        }
        return wordCount;
    }

}
