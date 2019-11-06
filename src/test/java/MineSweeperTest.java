import org.junit.Assert;
import org.junit.Test;

public class MineSweeperTest {
        MineSweeper game = new MineSweeper();

    @Test
    public void emptyField() {
        Assert.assertEquals("Field #1:\n0 0", game.sweep("0 0"));
    }
    @Test
    public void oneOneField() {
        Assert.assertEquals("Field #1:\n0\n", game.sweep("1 1\n.\n0 0"));
    }
    @Test
    public void oneTwoField() {
        Assert.assertEquals("Field #1:\n00\n", game.sweep("1 2\n..\n0 0"));
    }
    @Test
    public void twoOneField() {
        Assert.assertEquals("Field #1:\n0\n0\n", game.sweep("2 1\n.\n.\n0 0"));
    }
    @Test
    public void fourFourField() {
        Assert.assertEquals("Field #1:\n0000\n0000\n0000\n0*00\n", game.sweep("4 4\n....\n....\n....\n....\n0 0"));
    }
    @Test
    public void oneBomb() {
        Assert.assertEquals("Field #1:\n" +
                "*211\n" +
                "12*1\n" +
                "0111r\n" +
                "0000\n", game.sweep(
                        "4 4\n" +
                "*...\n" +
                "..*.\n" +
                "....\n" +
                "....\n" +
                "0 0"));
    }

    @Test
    public void twoGrids() {

        Assert.assertEquals("Field #1:\n" +
                "*100\n" +
                "1100\n" +
                "0*00\n" +
                "0000\n",

                game.sweep("2 2\n" +
                "..\n" +
                "*.\n" +

                "4 4\n" +
                "*...\n" +
                "..*.\n" +
                "....\n" +
                "....\n" +
                "0 0"));
    }

}
