package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EasySheetsModel {
	
	public static Properties getProperties(String filename) throws IOException {
		File file = new File(filename);
		FileInputStream reader = new FileInputStream(file);
		Properties userProp = new Properties();
		userProp.load(reader);
		reader.close();
		return userProp;
	}

}
