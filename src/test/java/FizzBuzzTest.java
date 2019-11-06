import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class FizzBuzzTest {

    FizzBuzz f = new FizzBuzz();

    @Test
    public void testnoFB() {
        assertEquals("1", f.fizzbuzz(1));
    }

    @Test
    public void testFizz() {
        assertEquals("fizz", f.fizzbuzz(3));
    }

    @Test
    public void testBuzz() {
        assertEquals("buzz", f.fizzbuzz(5));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", f.fizzbuzz(15));
    }

}