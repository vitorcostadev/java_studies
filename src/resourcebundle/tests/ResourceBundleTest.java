package src.resourcebundle.tests;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    static void main(){
        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.of("pt", "BR"));

        System.out.println(bundle.containsKey("hello"));

    }
}
