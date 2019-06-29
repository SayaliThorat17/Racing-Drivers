/**
 * 
 */
package racingDrivers.driverStates;

//import racingDriver.driverState.DriverContext;

/**
 * @author sayali
 *this class is used to implement DriverContextInterface. Here all the methods for finding positions of driver, finding leader are implemented. 
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
	}

	public void totalDistanceTravelled(double input) {

		this.DriverState = this.DriverState + input;

	}

	public void setState(String s) {

		this.state =s;

	}
	public void setPosition(int pos) {

		this.driverposition =pos;

	}
	public int getPosition() {

		return this.driverposition;

	}


	public String getState() {

		return this.state;
	}
	public int getDriverNo() {

		return this.driverNumber;
	}
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
