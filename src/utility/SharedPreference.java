package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Class to manage project settings or user preferences
 *
 * @author Richa
 */
public class SharedPreference {

    /**
     * @return ArrayList of key,value pair
     */
    public static ArrayList<PreferenceData> getAllKeyValuePair() {
        ArrayList<PreferenceData> result = new ArrayList<>();
        try {
            Properties prop = getPropertyInstance();
            Set set = prop.entrySet();
            Iterator itr = set.iterator();
            while (itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();
                result.add(new PreferenceData(entry.getKey().toString(), entry.getValue().toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key name of the key to be removed
     * @return true if the key is removed
     */
    public static boolean removePrefKey(String key) {
        boolean result = false;
        try {
            Properties prop = getPropertyInstance();
            prop.remove(key);
            result = updatePropertyFile(prop);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @return true if the node is removed
     */
    public static boolean removePrefNode() {
        boolean result = false;
        try {
            File file = new File(CommonUtil.currentWorkingDirectoryPath() + Constants.SHARED_PREFERENCE_FILE_PATH);

            if (file.delete()) {
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @return true if the key are unset
     */
    public static boolean clear() {
        boolean result = false;
        try {
            Properties prop = getPropertyInstance();
            prop.clear();            
            result = updatePropertyFile(prop);;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @return Instance of properties class with all listed properties from file
     */
    public static Properties getPropertyInstance() {
        Properties prop = new Properties();
        try {
            File file = new File(CommonUtil.currentWorkingDirectoryPath() + Constants.SHARED_PREFERENCE_FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream in = new FileInputStream(CommonUtil.currentWorkingDirectoryPath() + Constants.SHARED_PREFERENCE_FILE_PATH);
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * @param  prop Instance of properties to be updated
     * @return true if file updated
     */
    public static boolean updatePropertyFile(Properties prop) {
        try {
            FileWriter sw = new FileWriter(CommonUtil.currentWorkingDirectoryPath() + Constants.SHARED_PREFERENCE_FILE_PATH, false);
            prop.store(sw, "Properties Updated");
            sw.flush();
            sw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @return ArrayList[] of all the key
     */
    public static ArrayList<String> getAllKeys() {
        Enumeration<?> keys = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            Properties prop = getPropertyInstance();
            keys = prop.keys();
            while (keys.hasMoreElements()) {
                result.add(keys.nextElement().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key name of the key to be retrieved
     * @return String value of the key
     */
    public static String getPrefVal(String key) {
        String result = "";
        try {
            Properties prop = getPropertyInstance();
            result = prop.getProperty(key, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key name of the key to be assigned value
     * @param value value to be assigned
     * @return true if the value saved
     */
    public static boolean setPrefVal(String key, String value) {
        boolean result = false;
        try {
            Properties prop = getPropertyInstance();
            prop.setProperty(key, value);
            updatePropertyFile(prop);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

}
