import java.util.HashMap;
import java.util.List;

public class HelloPeople {

    public String render(String template, HashMap<String, String> attributes) {

        String[] buffer = template.split(" ");

        for (int i = 0; i < buffer.length; i++)
            if (buffer[i].contains("$"))
                buffer[i] = attributes.get(buffer[i].replace("$", ""));

        return String.join(" ", buffer);
    }

//        public String render(String template, HashMap<String, String> attributes) {
//            for (String attribute : attributes.keySet()) {
//                template = template.replace("$" + attribute,attributes.get(attribute));
//            }
//
//            return template;
//        }
//        public String render(String template, List<Attribute> attributes) {
//            String result = template;
//            for (Attribute attribute : attributes) {
//                result += attribute.replaceIn(template);
//            }
//            return result;
//        }
//
//    public class Attribute {
//            String name;
//            String value;
//
//        public String replaceIn(String template) {
//            return template.replace("$" + name,value);
//        }
//    }
}
