package ex02_adapter;
import java.io.*;

public abstract class FileIO {
	public abstract void readFromFile(String filename) throws IOException;
	public abstract void writeToFile(String filename) throws IOException;
	public abstract void setValue(String key,String value);
	public abstract String getValue(String key);
}