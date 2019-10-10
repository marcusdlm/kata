import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//how to handle simply for a known amount of numbers? i.e. before the for loop
public class StringCalc {
    String negatives = "";

    public int add(String input) throws Exception {
        int sum = 0;
        if (input.equals("")) return sum;
        List<String> lines = splitLines(input, "\n");

        String currentDelimiter = ",";

        for (String line : lines) {
            if (line.startsWith("//")) currentDelimiter = getDelimiter(line);
            else sum += addLine(line, currentDelimiter);
        }

        return sum;
    }

    private String getDelimiter(String line) {
        // //[***]
        // 1***2***3

        if (line.contains("[")) {
            int endDelimiter = line.indexOf("]");
            String currentDelimiter = line.substring(3, endDelimiter);
        }
        String currentDelimiter = line.substring(2);

        return currentDelimiter;
    }

    private int addLine(String input, String currentDelimiter) throws Exception {
        int sum = 0;
        List<String> arrayNum = splitLines(input, currentDelimiter);

        for (int i = 0; i < arrayNum.size(); i++) {
            String value = arrayNum.get(i);
            if (!value.equals("") && Integer.valueOf(value) < 1000) sum = sum + Integer.valueOf(value);
            else i = i++;

            if (value.contains("-")) negatives = negatives + value;
        }

        warnNegative(negatives);
        return sum;
    }


    public List<String> splitLines(String input, String currentDelimiter) {

        List<String> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(input, currentDelimiter);
        while (tokenizer.hasMoreTokens()) list.add(tokenizer.nextToken());

        return list;
    }


//    public int convertToNumbers(String input) {
//        int numbers= Integer.parseInt(input);
//        return numbers;
//    }

    public void warnNegative(String negatives) throws Exception {
        if (negatives.contains("-"))
            throw new Exception("negatives not allowed, " + negatives);
    }

}
