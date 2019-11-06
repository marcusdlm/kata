import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

public class WordCountTest{

    WordCount wordCounter = new WordCount();

    @Test
    public void ShouldReturnRightCounts() {
        String sentence = "John Doe says hi to John Doe";

        Map actual = wordCounter.createMap(sentence);

       Assert.assertEquals(2, actual.get("John"));
    }

}

