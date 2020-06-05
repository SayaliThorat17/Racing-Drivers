/**
 * 
 */
package racingDrivers.driverStates;

import racingDrivers.driverStates.DriverContext;
import racingDrivers.driverStates.DriverStateI;

/**
 * @author sayali
 *This class is used to print Calculative state of driver if he is holding on.This class implements DriverState interface.
 */
public class CalculativeState implements DriverStateI{

	@Override
	public void setState(DriverContext context) {
		// TODO Auto-generated method stub
		context.setState("CALCULATIVE");
		
	}


}
