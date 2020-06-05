/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.driverStates.DriverContext;

/**
 * @author sayali
 *This is an interface which will be implemented by DriverState class.this will be used to implement state pattern.
 */
public interface DriverStateI {
	
	public void setState(DriverContext context) ;
}
