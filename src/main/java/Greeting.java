import java.util.HashMap;
import java.util.Map;

public class Greeting {

    public String generateGreetings (String template, Map input ) {

        template = "Hello $first_name $last_name";
        String templateFirst = "$first_name";
        String templateLast = "$last_name";

        input = new HashMap();
        input.put(templateFirst, "Haki");
        input.put(templateLast, "Enomoto");

        return ("Hello " + input.get(templateFirst) + " " + input.get(templateLast));

    }
}


