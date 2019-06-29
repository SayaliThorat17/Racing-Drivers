/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.util.Results;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import racingDrivers.util.FileProcessor;
import racingDrivers.driverStates.DriverContext;



/**
 * @author sayali
 *this class is used to hold references to DriverContextClass.
 */

public class RaceContext {
	private String inputFile;

	private double arr[];	//
	private int totalNoOfDriver;
	private DriverContext[] DriverContextObj;	//obj of class //arr of obj



	public RaceContext(String inputFile) {
		super();
		this.inputFile = inputFile;
		totalNoOfDriver=0;
	}

	public void setTotalNumberOfDriver(int driver) {
		this.totalNoOfDriver=driver;
	}

	public int getTotalNumberOfDriver() {
		return this.totalNoOfDriver;
	}

	public void createObjects(int numObjects) {

		DriverContextObj = new DriverContext[numObjects];
		for (int i = 0; i < totalNoOfDriver; i++)
		{
		this.DriverContextObj[i] = new DriverContext(totalNoOfDriver);
		}
	}



	public void setDriverContext(String line) {

		String[] splited = line.split("\\s+");

		for (int i = 0; i < splited.length; i++) {

			//this.arr[i] = Double.parseDouble(splited[i]);

			System.out.println(Double.parseDouble(splited[i]));
			//this.arr[i] = Double.parseDouble(splited[i]);

			this.DriverContextObj[i].totalDistanceTravelled(Double.parseDouble(splited[i])); 

		}



	}


	public void calculateLeader( int size, Results resultObj) throws IOException {
		
		DriverContext[] copyArray=Arrays.copyOf(DriverContextObj, DriverContextObj.length);
		System.out.println("Before sort");
		 for(DriverContext p: copyArray) {
		        System.out.println(p.getDriverNo());
		    }
		Arrays.sort(copyArray);
		System.out.println("After sort");
		int position=0;
		
		for (int j = 0; j < copyArray.length; j++) 
		{
			if(j==0)
			{
				copyArray[j].setPosition(position+1);
				if(copyArray[j+1].getTotalDis()==copyArray[j].getTotalDis())
				{
					copyArray[j].setState("RECKLESS");
				}
				else
				{
					copyArray[j].setState(calculation(copyArray[j].getPosition()));
				}
				position++;
			}
			else if(copyArray[j-1].getTotalDis()==copyArray[j].getTotalDis())
			{
				copyArray[j].setPosition(position);
				copyArray[j].setState("RECKLESS");
			}
			else 
			{
				copyArray[j].setPosition(position+1);
				position++;
				copyArray[j].setState(calculation(copyArray[j].getPosition()));
			}
			
			 
		}

		 System.out.println("**************Driver Position **************");
		// for(DriverContext p: DriverContextObj) {
		  //      System.out.print("\t"+p.getPosition());
		    //}
		
		 System.out.println("**************State **************");
		 for(DriverContext p: DriverContextObj) {
		        System.out.print("\t"+p.getState()+"\t");
		        resultObj.writeToFile("\t"+p.getState()+"\t");
		    }
		
	
	
	} 
	
	public String calculation(int position) {
		

		//System.out.println("Driver num" +driverNumber);
		if(position <(0.3 * getTotalNumberOfDriver() ))
			return "CONFIDENT";
		else if( ( (Math.round(0.3 * getTotalNumberOfDriver() )) <= position ) &&   ((Math.round(0.3 * getTotalNumberOfDriver() ))  < (Math.round(0.7 * getTotalNumberOfDriver() )) ) && (position < (Math.round(0.7 * getTotalNumberOfDriver() )) ))	
			return "CALCULATIVE";
		else if(position >= (Math.round(0.7 * getTotalNumberOfDriver())))
			return "RECKLESS";
		else
			return "";
			

		}

}