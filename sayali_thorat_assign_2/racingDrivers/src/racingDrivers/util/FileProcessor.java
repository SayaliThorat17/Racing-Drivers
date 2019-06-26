package racingDrivers.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Sayali Thorat
 *this class is used to read the input file and process it.
 */


public class FileProcessor {
	
	private String fileName;
	private BufferedReader br;
	public FileProcessor(String fileName) {
		this.fileName=fileName;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.print("File not found");
			e.printStackTrace();
		}
	}
	
	public String readLine() {
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.print("Error Reading file");
			e.printStackTrace();
		}
			return line;
	}
	
	public void closeFile() throws IOException {
		br.close();
		
	}


}
