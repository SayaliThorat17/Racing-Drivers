package racingDrivers.driver;

import java.io.BufferedReader;
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

		
		FileProcessor fpobj = new FileProcessor();
		RaceContext rcobj = new RaceContext(inputFile);
		
		BufferedReader br1 = fpobj.OpenFile(inputFile);
		
		String line = fpobj.readLine(br1);
		while (line != null) 
		{
			//System.out.println(line);
			String[] splited = line.split("\\s+");
			
			if(splited.length==1) {
				//call new array
				//create_array(Integer.parseInt(splited[0]));
				System.out.println("No of drivers is : " + Integer.parseInt(splited[0]));
				
				//create dat much objs
				
				rcobj.createObjects(Integer.parseInt(splited[0]));
				
			}
			else {
				
				rcobj.setDriverContext(line);
				System.out.println(line);
			}
			line = fpobj.readLine(br1);
			
			
		}
		
		
		//rcobj.check();
	}
}
