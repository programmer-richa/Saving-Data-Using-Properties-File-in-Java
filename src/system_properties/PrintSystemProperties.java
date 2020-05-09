package system_properties;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Class prints all system properties as jre version, user dir(current working
 * directory) etc.
 *
 * @author Richa
 */
public class PrintSystemProperties {

    public static void main(String[] args) {
        Properties p = System.getProperties();
        Set set = p.entrySet();

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
