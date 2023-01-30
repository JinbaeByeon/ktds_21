package ex02_adapter;
import java.io.*;
public class FileProperties extends  FileIO  {
	java.util.Properties pro;
	
	public void readFromFile(String filename) {
		try{
			pro.load(new FileInputStream(filename));
		}catch(IOException e) {
			System.out.println(e);
		};
	}
	public void writeToFile(String filename) {
		try {
			String comment = "written by FileProperties";
			pro.store(new FileOutputStream(filename),comment);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public void setValue(String key,String value) {
		pro.setProperty(key, value);
	}
	public String getValue(String key) {
		return pro.getProperty(key);
	}

}
