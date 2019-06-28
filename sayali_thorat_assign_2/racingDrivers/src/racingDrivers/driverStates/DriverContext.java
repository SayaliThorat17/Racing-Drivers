package racingDrivers.driverStates;

/**
 * @author Sayali Thorat
 *this class is used to implement DriverContextInterface. Here all the methods for finding positions of driver, finding leader are implemented. 
 */


public class DriverContext implements DriverContextI {
	
	double DriverState;
	
	double totaldistancecovered;
	
	String state ;
	

	
	
	public DriverContext() {
		// TODO Auto-generated constructor stub
		
		this.totaldistancecovered = totaldistancecovered;
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
	
	/*public double calculateState() {	
		
		
		 
		
	}*/
}
