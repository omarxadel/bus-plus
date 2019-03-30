package application;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Database {
	private Formatter x;
	
	public void openFile(String name) {
		try{
		x = new Formatter("Database.txt");
		}
		catch(Exception e) {
			
		}
	}
	
	public void addData(String data) {
		x.format("%s", data);
	}
}
  