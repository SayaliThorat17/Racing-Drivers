/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.driverStates.DriverContext;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *this class is used to implement DriverContextInterface.  
 *This class is mostly used to get and set states and positions of drivers.
 */

public class DriverContext implements DriverContextI,Comparable<DriverContext>{
	double DriverState;

	private double totaldistancecovered;

	private String state ;
	private int driverNumber;
	private int driverposition ;

	public DriverContext(int num) {
		// TODO Auto-generated constructor stub

		driverNumber=num;
		MyLogger.writeMessage("DriverContext Contructor is called.", DebugLevel.CONSTRUCTOR);
	}

	
	/*
	 * This method is used to set total distance travelled by driver.
	 */
	public void totalDistanceTravelled(double input) {

		this.DriverState = this.DriverState + input;

	}

	/*
	 * this method is used to setState of driver
	 */
	public void setState(String s) {

		this.state =s;

	}
	
	/*
	 * this method is used to setPosition of driver
	 */
	public void setPosition(int pos) {

		this.driverposition =pos;

	}
	
	/*
	 * this method is used to getPosition of driver
	 */
	public int getPosition() {

		return this.driverposition;

	}


	public String getState() {

		return this.state;
	}
	
	/*
	 * this method is used to get number of drivers
	 */
	public int getDriverNo() {

		return this.driverNumber;
	}
	
	/*
	 * this method is used to get total distance of drivers
	 */
	public double getTotalDis() {

		return this.DriverState;
	}

	@Override
	public int compareTo(DriverContext o) {
		if (this.getTotalDis()>o.getTotalDis()) return -1;
		if (this.getTotalDis()==o.getTotalDis()) return 0;
		else return 1;
	}
}
