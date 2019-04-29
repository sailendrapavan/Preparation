package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.concurrent.ConcurrentHashMap;

import urjanet.aws.s3.*;

public class testingWeserver {

	
	public void tes() {
		ConcurrentHashMap<String, Object> cache=null;
			String currentFile = "/home/sailendrapavan/Desktop/"
					+ "a.ser";
			System.out.println(currentFile);
			if (new File(currentFile).exists()) {
				System.out.println("saile");
				// deserialize the JobInventory.ser file
				try (InputStream file = new FileInputStream(currentFile);
						InputStream buffer = new BufferedInputStream(file);
						ObjectInput input = new ObjectInputStream(buffer);) {
					// deserialize the Map
					cache = (ConcurrentHashMap<String, Object>) input.readObject();
					System.out.println(cache);
					// display its data
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
				} catch (IOException ex) {
					System.out.println(ex);
				}
				for(Object ob:cache.entrySet()) {
					System.out.println(ob);
				}
			} else {
				System.out.println("No job inventory file exists");
			}
			
			
		
		}
	
	public static void main(String args[]) {
		testingWeserver d = new testingWeserver();
		d.tes();
		
	}
}
