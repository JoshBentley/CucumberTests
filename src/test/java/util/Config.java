package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config
{
    public String properties(String key)
    {
        File file = new File(System.getProperty("user.dir") + "/config.properties");

        FileInputStream fileInput = null;

        try
        {
            fileInput = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Properties props = new Properties();

        try
        {
            props.load(fileInput);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String returnString = props.getProperty(key);
        return returnString;
    }
}
