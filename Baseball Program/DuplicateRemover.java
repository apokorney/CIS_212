import java.util.Scanner;	//Scanner class for input
import java.io.*;			//File I/O classes

public class DuplicateRemover { 
	public static void main (String[] args) throws IOException {
		
		String inputFileName = "";
		String outputFileName = "";
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the name of the input file ");
		
		inputFileName = in.nextLine();
		
		System.out.print("Enter the name of the output file: ");
		
		outputFileName = in.nextLine();
		
		PrintWriter outputFile = new PrintWriter(outputFileName);		//creates a new PrintWriter called outputFile.
		
		File someFile = new File(inputFileName);		//opens a file for input
		
		if (!someFile.exists()) {						//checks that the file exists
			System.out.println("The file does not exist");
			System.exit(0);								//exits if it doesn't exist
		}	
		
		Scanner inputFile = new Scanner(someFile);		//creates a scanner "inputFile" linked to someFile
		
		String lastLine = "";
		
		while(inputFile.hasNext()) {					//checks for data and loops while data exists
			String nextLine = inputFile.nextLine();	//reads in the line
			if (!nextLine.equals(lastLine)) {			//if the next line is new,
				outputFile.println(nextLine);			//write it to the output file
				System.out.println("New " + nextLine);
			}
			else
				System.out.println("Duplicate");
			
			lastLine = nextLine;						//advance

		}
		outputFile.close();
		inputFile.close();	
	
	}
}