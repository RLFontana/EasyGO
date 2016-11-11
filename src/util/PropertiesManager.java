package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public abstract class PropertiesManager {
	private final static Properties properties = new Properties();
	private static InputStream input = null;

	private static void initFile() throws IOException{
		if(input == null){
			input = PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(input);
		}
	}
	
	public static String getProperties(String key){
		try{
			initFile();
			return properties.getProperty(key);
		}catch (IOException e){
			e.printStackTrace();
			return "";
		}finally{
			if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static boolean setProperties(String key, String value){
		try{
			initFile();
			properties.setProperty(key, value);
			properties.store(new FileOutputStream("config.properties"), null);
			return true;
		}catch (IOException e){
			e.printStackTrace();
			return false;
		}finally{
			if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void setProperties(Map<String, String> map){
		try{
			initFile();
			for (Map.Entry<String, String> entry : map.entrySet()){
				properties.setProperty(entry.getKey(), entry.getValue());
			}
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
