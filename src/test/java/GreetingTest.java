import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

//input "Hello $first_name $last_name"
//attributes input:
//"$first_name" : "Aki"
//$last_name" : "Enomoto"
//Output: "Hello Aki Enomoto"

public class GreetingTest {

    Greeting Greetings = new Greeting();

    @Test
    public void shouldReturnFormattedGreeting() {
        String template = "Hello $first_name $last_name";
        String templateFirst = "$first_name";
        String templateLast = "$last_name";
        Map testInput = new HashMap();

        testInput.put(templateFirst, "Haki");
        testInput.put(templateLast, "Enomoto");

        System.out.println("Hello " + testInput.get(templateFirst) + " " + testInput.get(templateLast));

      //  System.out.println("output ;" + Greetings.generateGreetings(template, testInput));
        Assert.assertEquals ("Hello Haki Enomoto",Greetings.generateGreetings(template, testInput));
    }
}
