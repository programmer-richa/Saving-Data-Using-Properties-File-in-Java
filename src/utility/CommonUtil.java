/**
 * Common methods used in project
 */
package utility;

/**
 * Defines common methods to be used independently
 *
 * @author Richa
 */
public class CommonUtil {

    /**
     * No instance can be created
     */
    private CommonUtil() {
    }

    /**
     * @return project path
     */
    public static String currentWorkingDirectoryPath() {
        return System.getProperty("user.dir");
    }

    /**
     * @param arr reference of the object array to be printed
     */
    public static void printArray(Object[] arr) {
        for (Object val : arr) {
            System.out.println(val.toString());
        }
    }

    public static void printSeperator() {
        System.out.println("=============================================");
    }

}
