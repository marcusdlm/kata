import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class HelloPeopleTest {
    private HelloPeople testRender = new HelloPeople();

    @Test
    public void checkTemplateContainsHello() {
        Assert.assertEquals ("Hello", testRender.render("Hello", new HashMap<>()));
    }

    @Test
    public void ReturnString() {
        Assert.assertEquals ("hi", testRender.render("hi", new HashMap<String, String>()));
    }

    @Test
    public void shouldReturnHelloFirstName() {
        HashMap<String,String> testFirstAttribute = new HashMap<>();
        testFirstAttribute.put("first_name","Hito");
        Assert.assertEquals ("Hello Hito", testRender.render("Hello $first_name", testFirstAttribute));
    }

    @Test
    public void shouldReturnHelloFullName() {
        HashMap testAttributes = new HashMap<>();
        testAttributes.put("first_name","Hito");
        testAttributes.put("last_name","Enomoto");
        Assert.assertEquals ("Hello Hito Enomoto", testRender.render("Hello $first_name $last_name", testAttributes));
    }

    @Test
    public void AttributesAtFirstPosition() {
        HashMap testAttributes = new HashMap<>();
        testAttributes.put("first_name","Marc");
//        testAttributes.put("last_name","Enomoto");
        Assert.assertEquals ("Marc likes cheese", testRender.render("$first_name likes cheese", testAttributes));
    }


}