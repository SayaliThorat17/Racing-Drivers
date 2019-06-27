package racingDrivers.driverStates;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import racingDrivers.util.FileProcessor;
import racingDrivers.driverStates.DriverContext;

/**
 * @author Sayali Thorat
 *this class is used to hold references to DriverContextClass.
 */


public class RaceContext {
	
	private String inputFile;
	
	private double arr[];	//
	
	private DriverContext[] DriverContextObj;	//obj of class //arr of obj
	
	
	
	public RaceContext(String inputFile) {
		super();
		this.inputFile = inputFile;
	}
	
	
	
	public void createObjects(int numObjects) {
		
		DriverContextObj = new DriverContext[numObjects];
	}
	
	
	
	public void setDriverContext(String line) {
		
		String[] splited = line.split("\\s+");
		
		for (int i = 0; i < splited.length; i++) {
			
			//this.arr[i] = Double.parseDouble(splited[i]);
		
			System.out.println(Double.parseDouble(splited[i]));
			//this.arr[i] = Double.parseDouble(splited[i]);

			this.DriverContextObj[i] = new DriverContext();
			this.DriverContextObj[i].totalDistanceTravelled(Double.parseDouble(splited[i])); 

		}
		
		
		
	}
	
	
	public void calculateLeader(DriverContext[] obj) {
		
		String arr[] = new String[obj.length];
		
		HashMap<DriverContext, Integer> map = new HashMap<>(); 
		
		for (int i = 0; i < obj.length; i++) {
			
			if(arr[i]){
				
			}
			
		}
	}
	
	
	
	
	/*public void create_array(int size) {
		
	arr = new double[size];
	}

	public void check() throws IOException {

		FileProcessor fpobj1 = new FileProcessor(inputFile);
		
		//BufferedReader br;
		try {
			//br = new BufferedReader(new FileReader(inputFile));
			String line = fpobj1.readLine();
			while (line != null) 
			{
				//System.out.println(line);
				String[] splited = line.split("\\s+");
				
				if(splited.length==1) {
					//call new array
					create_array(Integer.parseInt(splited[0]));
					System.out.println("No of drivers is : " + Integer.parseInt(splited[0]));
					
				}
				else {
					
					for (int i = 0; i < splited.length; i++) {
					
						//this.arr[i] = Double.parseDouble(splited[i]);
					
						System.out.println(Double.parseDouble(splited[i]));
						this.arr[i] = Double.parseDouble(splited[i]);

					}
				}
				
				line = fpobj1.readLine();
				//System.out.println(line);
			}
		}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	*/
	

}
