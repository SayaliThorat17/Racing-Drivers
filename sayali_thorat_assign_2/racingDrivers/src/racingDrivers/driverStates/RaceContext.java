package racingDrivers.driverStates;

import racingDrivers.util.Results;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//import com.sun.tools.classfile.Opcode.Set;

import racingDrivers.util.FileProcessor;
import racingDrivers.driverStates.DriverContext;

/**
 * @author Sayali Thorat
 *this class is used to hold references to DriverContextClass.
 */


public class RaceContext {
	private String inputFile;

	private double arr[];	//
	
	private int driverNumber;

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

			this.DriverContextObj[i] = new DriverContext(i);
			this.DriverContextObj[i].totalDistanceTravelled(Double.parseDouble(splited[i]));

		}

		

	}


	public void calculateLeader( int size) {

		
		Map<Double, DriverContext> map = new TreeMap<>();


		for (int i = 0; i < DriverContextObj.length; i++) {

			map.put(DriverContextObj[i].getTotalDis() ,DriverContextObj[i]);
		}
		
		TreeMap<Double, DriverContext> sorted = new TreeMap<Double, DriverContext>(Collections.reverseOrder());
		//System.out.println(Collections.singletonList(map));
		
		Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
         } 
		
		
		
		/*List<Double> sortedDriver = new ArrayList<>(map.keySet());
		Collections.sort(sortedDriver,Collections.reverseOrder());
		
		Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
         } 
		
		*/
      //Create a hashmap with key as driver number and values as total distance
		//Sort based on value

       
		
        
        
        
        
        
       /* System.out.println("Sorted driver positions");

        for (int i = 0; i < sortedDriver.size(); i++) {
	System.out.println(sortedDriver.get(i));
	} */
		
        
				
					

	}
	
	


}