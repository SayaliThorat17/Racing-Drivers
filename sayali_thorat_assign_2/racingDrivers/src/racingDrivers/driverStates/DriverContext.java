package racingDrivers.driverStates;

/**
 * @author Sayali Thorat
 *this class is used to implement DriverContextInterface. Here all the methods for finding positions of driver, finding leader are implemented. 
 */


public class DriverContext implements DriverContextI,Comparable<DriverContext>{
double DriverState;
	
	private double totaldistancecovered;
	
	String state ;
	private int driverNumber;
	

	
	
	public DriverContext(int num) {
		// TODO Auto-generated constructor stub
		
		this.totaldistancecovered = totaldistancecovered;
		driverNumber=num;
	}
	
	public void totalDistanceTravelled(double input) {
		
		this.DriverState = this.totaldistancecovered + input;
		
	}

	public void setState(String s) {
		
		this.state =s;
		
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
	// TODO Auto-generated method stub
	return 0;
}


}

