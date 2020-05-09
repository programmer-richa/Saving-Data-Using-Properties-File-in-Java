package generalisation;

import utility.CommonUtil;
import utility.SharedPreference;

/**
 * Example of generic implementation of Properties (SharedPreferenceerence)
 * class
 *
 * @author Richa
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SharedPreference.setPrefVal("Name", "Richa");
        SharedPreference.setPrefVal("Qualification", "MCA");
        SharedPreference.setPrefVal("Company", "TCY");
        System.out.println("Returned value : " + SharedPreference.getPrefVal("Name"));
        System.out.println(SharedPreference.getAllKeyValuePair());
        System.out.println(SharedPreference.getAllKeys());
        CommonUtil.printSeperator();
        SharedPreference.removePrefKey("Richa"); // doesn't raise an exception
        SharedPreference.removePrefKey("Name");
        System.out.println(SharedPreference.getAllKeys());
        CommonUtil.printSeperator();
        SharedPreference.clear();
        System.out.println(SharedPreference.getAllKeys());
        CommonUtil.printSeperator();
        SharedPreference.removePrefNode();
    }

}
