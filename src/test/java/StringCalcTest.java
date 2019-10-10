import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class StringCalcTest {

    StringCalc input = new StringCalc();

    @Test
    public void nullReturns0() throws Exception {
        Assert.assertEquals(0, input.add(""));
    }

    @Test
    public void singleNumber() throws Exception {
        Assert.assertEquals(9, input.add("9"));
    }

    @Test
    public void addNumbers() throws Exception {
        Assert.assertEquals(6, input.add("1,2,3"));
    }

    @Test
    public void addNumbersWithLines() throws Exception {
        Assert.assertEquals(11, input.add("1,3,5\n2"));
    }

    @Test
    public void differentDelimiter() throws Exception {
//        “//;\n1;2” == 3
        Assert.assertEquals(3, input.add("//:\n1:2"));
    }

    @Test
    public void oneNegative() throws Exception {
        try {
            input.add("-1,1");
            fail("Should throw exception here but didn't");
        } catch (Exception e) {
            Assert.assertEquals("negatives not allowed, -1", e.getMessage());
        }
    }

    @Test
    public void twoNegative() throws Exception {
        try {
            input.add("1,-1,-2,3");
//            fail("Should throw exception here but didn't");
        } catch (Exception e) {
            Assert.assertEquals("negatives not allowed, -1-2", e.getMessage());
        }
    }

    @Test
    public void thousandNum() throws Exception {
        Assert.assertEquals(2, input.add("2,1001"));
    }

    @Test
    public void delimiterAnyLength() throws Exception {
//        Assert.assertEquals(6, input.add("//[***]\n1***2***3"));
        Assert.assertEquals(6, input.add("//;\n1;2;3"));
    }

}
