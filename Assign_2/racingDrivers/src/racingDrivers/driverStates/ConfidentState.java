/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.driverStates.DriverContext;
import racingDrivers.driverStates.DriverStateI;

/**
 * @author sayali
 *This class is used to print Confident state for driver when he is leading in race. This class implements DriverState interface.
 */
public class ConfidentState implements DriverStateI {

	@Override
	public void setState(DriverContext context) {
		// TODO Auto-generated method stub
		context.setState("CONFIDENT");
		
	}

}

