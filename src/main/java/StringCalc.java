import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalc {
    //how to handle simply for a known amount of numbers? i.e. before the for loop
    //        “//;\n1;2” == 3
    String negatives = "";

    public int add(String input) throws Exception {
        int sum = 0;
        if (input.equals("")) return sum;
        List<String> lines = splitLine(input);

        String currentDelimiter = ",";
        for (String line : lines) {
            if (line.startsWith("//")) currentDelimiter = getDelimiter(line);
            else sum += addLine(line, currentDelimiter);
        }

        return sum;
    }

    private String getDelimiter(String line) {

        return ";";
    }

    private List<String> splitLine(String input) throws Exception {

        List<String> lines = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, "\n");
        while (tokenizer.hasMoreTokens()) lines.add(tokenizer.nextToken());

        return lines;
    }

    private int addLine(String input, String currentDelimiter) throws Exception {
        int sum = 0;
        List<String> arrayNum = stringToArray(input, currentDelimiter);

        for (int i = 0; i < arrayNum.size(); i++) {
            String value = arrayNum.get(i);
            if (!value.equals("") && Integer.valueOf(value) < 1000) sum = sum + Integer.valueOf(value);
            else i = i++;

            if (value.contains("-")) negatives = negatives + value;
        }

        warnNegative(negatives);
        return sum;
    }




    public List<String> stringToArray(String input, String currentDelimiter) {
//        arrayNum = input.split(",|\\n|;|:");

        List<String> list = new ArrayList<>();

            StringTokenizer tokenizer = new StringTokenizer(input, currentDelimiter);
            while (tokenizer.hasMoreTokens()) list.add(tokenizer.nextToken());


        return list;
    }

//    public String changeDelimiter(String input) {
//        //[***]\n1***2***3
//
//
//        int startDelimiter = input.indexOf("//");
//        int endDelimiter = input.indexOf("\n");
//        String delimiter = input.substring(startDelimiter + 2, endDelimiter);
//        return delimiter;
//    }

//    public int convertToNumbers(String input) {
//        int numbers= Integer.parseInt(input);
//        return numbers;
//    }

    public void warnNegative(String negatives) throws Exception {
        if (negatives.contains("-"))
            throw new Exception("negatives not allowed, " + negatives);
    }

}
