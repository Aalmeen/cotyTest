package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	public String readConfigFile(String key)
	{
		String value = null;
		Properties prop = new Properties();
		try
		{
			File ff = new File(System.getProperty("user.dir") + "\\resources\\config.properties");
			if (ff.exists())
			{
				prop.load(new FileInputStream(ff));
				value = prop.getProperty(key);
			}
		}
		catch(Exception e)
		{
			System.out.println("Could not read properties file" + " " + e);}
	return value;
}
	public String getFilePath() {
		File ff = new File("");
		String str = ff.getAbsolutePath();
		String path = str.replace("\\\\+", "/");
		return path;
	}
}
