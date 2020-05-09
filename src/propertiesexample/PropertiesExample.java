package propertiesexample;

import utility.CommonUtil;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Read properties from data.properties file
 *
 * @author Richa
 */
public class PropertiesExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String projectPath = CommonUtil.currentWorkingDirectoryPath();
        FileReader reader = new FileReader(projectPath + "\\src\\propertiesexample\\data.properties");
        Properties p = new Properties();
        p.load(reader);
        System.out.println(p.getProperty("name"));
        System.out.println(p.getProperty("qualification"));
    }

}
