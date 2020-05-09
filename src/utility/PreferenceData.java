package utility;

/**
 * Key-value pair of user data
 *
 * @author Richa
 */
public class PreferenceData {

    private String key, value;

    /**
     * @param key name of keyword
     * @param value value to be stored
     */
    public PreferenceData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public PreferenceData() {
    }

    /**
     * @return key name
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key attribute name
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return value stored in the key
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value attribute value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return string representation of key value
     */
    @Override
    public String toString() {
        return key + " : " + value; //To change body of generated methods, choose Tools | Templates.
    }

}
