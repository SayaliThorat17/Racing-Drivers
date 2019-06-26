package racingDrivers.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import racingDrivers.driverStates.RaceContext;
import racingDrivers.util.FileProcessor;

/**
 * @author Sayali Thorat
 *this class is used to create all objects and to deal with command line arguments
 */

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		if(args.length != 1) {
			
			System.out.println("Missing Input or Output File");
			System.out.println("Run the program as  : ant -buildfile build.xml run -Darg0=infile.txt -Darg1=outfile.txt");
			System.exit(0);
		}
		
		String inputFile = args[0];
		System.out.println("Argo 0 "+inputFile);

		
		FileProcessor fpobj = new FileProcessor(inputFile);
		RaceContext rcobj = new RaceContext(inputFile);
	}
}
