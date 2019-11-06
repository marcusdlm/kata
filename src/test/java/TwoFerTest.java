import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoFerTest {
    @Test
    public void test() {
        TwoFer t = new TwoFer();

        assertEquals("One for null, one for me.",t.say(null)) ;

        assertEquals("One for you, one for me.",t.say("you")) ;
    }
}