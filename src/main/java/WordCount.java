import java.util.*;

public class WordCount{

    public static void main (String[] args) {
        String input = "John Doe says hi to John Doe";
        createMap(input);
    }

    public static Map createMap(String sentence) {

        String[] tableau = sentence.split(" ");

        HashMap<String, Integer> createdMap = new HashMap<String, Integer>();

        for (int i = 0; i < tableau.length; i++) {
            String key = tableau[i];

            if (createdMap.containsKey(key)) {
                createdMap.put(key,createdMap.get(key)+1);
            }
            else createdMap.put(key,1);
        }

        System.out.println(createdMap.entrySet());

        return createdMap;
    }


}
