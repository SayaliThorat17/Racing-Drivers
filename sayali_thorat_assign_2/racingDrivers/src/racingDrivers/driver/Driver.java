/**
 * 
 */
package racingDrivers.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import racingDrivers.util.Results;
import racingDrivers.driverStates.RaceContext;
import racingDrivers.util.FileProcessor;

/**
 * @author sayali
 *this class is used to create all objects and to deal with command line arguments
 */
public class Driver {

	/**
	 * @param args
	 * the arguments passed to the main file are inputfile, outputfile and debugger value
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		if(args.length != 2) {
			
			System.out.println("Missing Input or Output File");
			System.out.println("Run the program as  : ant -buildfile build.xml run -Darg0=infile.txt -Darg1=outfile.txt");
			System.exit(0);
		}
		
		String inputFile = args[0];
		String outputFile= args[1];
		System.out.println("Argo 0 "+inputFile);

		
		FileProcessor fpobj = new FileProcessor();
		RaceContext rcobj = new RaceContext(inputFile);
		Results resultObj = new Results(outputFile);
		BufferedReader br1 = fpobj.OpenFile(inputFile);
		int numOfDriver=0;
		String line = fpobj.readLine(br1);

		while (line != null) 
		{
			//System.out.println(line);
			String[] splited = line.split("\\s+");
			
			if(splited.length==1) {
				//call new array
				//create_array(Integer.parseInt(splited[0]));
				System.out.println("No of drivers is : " + Integer.parseInt(splited[0]));
				numOfDriver=Integer.parseInt(splited[0]);
						rcobj.setTotalNumberOfDriver(numOfDriver);
				//create dat much objs
				
				rcobj.createObjects(Integer.parseInt(splited[0]));
				
			}
			else {
				
				rcobj.setDriverContext(line);
				System.out.println(line);
				rcobj.calculateLeader(numOfDriver,resultObj);
				resultObj.writeToFile("\n");
			}
			line = fpobj.readLine(br1);

			
		}
		
		resultObj.closeFile();
		//rcobj.check();
	}

}
