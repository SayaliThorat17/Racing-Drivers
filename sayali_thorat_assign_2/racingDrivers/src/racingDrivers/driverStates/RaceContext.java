/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.util.MyLogger;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger.DebugLevel;

import java.io.IOException;
import java.util.Arrays;
import racingDrivers.driverStates.CalculativeState;
import racingDrivers.driverStates.ConfidentState;
import racingDrivers.driverStates.RecklessState;
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
		MyLogger.writeMessage("RaceContext Contructor is called.", DebugLevel.CONSTRUCTOR);
	}

	/*
	 * This method sets numofDrivers.
	 */
	public void setTotalNumberOfDriver(int driver) {
		this.totalNoOfDriver=driver;
	}

	
	/*
	 * This method is used to get numofDrivers.
	 */
	public int getTotalNumberOfDriver() {
		return this.totalNoOfDriver;
	}

	
	/*
	 * This method is used to create array.
	 */
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
			
			//System.out.println(Double.parseDouble(splited[i]));
			//this.arr[i] = Double.parseDouble(splited[i]);

			this.DriverContextObj[i].totalDistanceTravelled(Double.parseDouble(splited[i])); 

		}



	}


	
	/*
	 *This function is used to the driver who is leading i.e. to get the positions of drivers based on the distances covered. 
	 */
	public void calculateLeader( int size, Results resultObj) throws IOException {

		DriverContext[] copyArray=Arrays.copyOf(DriverContextObj, DriverContextObj.length);
			//System.out.println("Before sort");
		for(DriverContext p: copyArray) {
			//	System.out.println(p.getDriverNo());
		}
		Arrays.sort(copyArray);
			//System.out.println("After sort");
		int position=0;
		RecklessState r= new RecklessState();


		for (int j = 0; j < copyArray.length; j++) 
		{
			if(j==0)
			{
				copyArray[j].setPosition(position+1);
				if(copyArray[j+1].getTotalDis()==copyArray[j].getTotalDis())
				{

					r.setState(copyArray[j]);
				}
				else
				{
					calculateState(copyArray[j].getPosition(),copyArray[j]);
				}
				position++;
			}
			else if(copyArray[j-1].getTotalDis()==copyArray[j].getTotalDis())
			{
				copyArray[j].setPosition(position);
				r.setState(copyArray[j]);
			}
			else 
			{
				copyArray[j].setPosition(position+1);
				position++;
				calculateState(copyArray[j].getPosition(),copyArray[j]);
			}


		}

		/*
		 * To check the driver position 
		 */
		//System.out.println("**************Driver Position **************");
		// for(DriverContext p: DriverContextObj) {
		//      System.out.print("\t"+p.getPosition());
		//}
		
		

		/*
		 * To check the Driver state
		 */
		//System.out.println("**************State **************");
		
		for(DriverContext p: DriverContextObj) {
			//System.out.print("\t"+p.getState()+"\t");
			MyLogger.writeMessage( p.getState(),DebugLevel.STATE_CHANGE);
			resultObj.writeToFile("\t"+p.getState()+"\t");
		}

	} 

	
	
	/*
	 * This function is used to calculate the states of drivers based on the positions they are in.
	 */
	public void calculateState(int position, DriverContext context) {

		RecklessState r= new RecklessState();
		ConfidentState c=new ConfidentState();
		CalculativeState ca=new CalculativeState();
		//System.out.println("Driver num" +driverNumber);
		if(position <(0.3 * getTotalNumberOfDriver() ))
			c.setState(context);
		else if( ( (Math.round(0.3 * getTotalNumberOfDriver() )) <= position ) &&   ((Math.round(0.3 * getTotalNumberOfDriver() ))  < (Math.round(0.7 * getTotalNumberOfDriver() )) ) && (position < (Math.round(0.7 * getTotalNumberOfDriver() )) ))	
			ca.setState(context);
		else if(position >= (Math.round(0.7 * getTotalNumberOfDriver())))
			r.setState(context);
	}
}
