import java.text.DecimalFormat;

public class Display {

	public static String displayIn(String str, int i) {	//adds spaces to the end of a string to get it to i characters
		int len = str.length();	
		if (i <= 0)
			return "";
		else if (len == i)
			return str;
		else if (len > i)
			return str.substring(0, i-1);
		else {
			while (str.length() < i) {
				str += " ";
			}
			return str;
		}
	}
	
	public static String displayIn(int n, int i) {		//displays an integer as a string in i characters 
		String str = Integer.toString(n);
		return displayIn(str, i);
	}
	
	public static String displayIn(double n, int i) {	//displays a double as a string in i characters
		DecimalFormat f = new DecimalFormat("#.000");
		String str = "";
		if(n < 1) {
			str = " ";
		}
		str += f.format(n);
		return displayIn(str, i);
	}
	
	public static String outDots(int o) {

		if (o == 0)			//if there are no outs, always return "None"
			return "None";

		String dots = "";	//Otherwise, return a series of dots
		for (int i = 0; i < o; i++) {
			dots += "•";
		}
		
		return dots;
	}
	
	public static String englishInning(int i) {
		switch (i) {
			case 1:
				return "1st";
			case 2:
				return "2nd";
			case 3:
				return "3rd";
			default:
				return Integer.toString(i) + "th";
		}
	}
	
	public static void windowGuide(int rows, int columns) {
		String str = "";
		for(int i = 0; i < rows; i++) {
			if(i == 0 || i == (rows-1)) {
				str = "*";
			}
			else if (i == (rows / 2)) {
				System.out.println("*                               Welcome to Simple Baseball Simulator                               *");
				System.out.println("*                                    Press [Enter] to continue                                     *");

				i += 2;
			}
			else {
				str = " ";
			}
			System.out.print("*");
			for(int j = 0; j < (columns-2); j++) {
				System.out.print(str);
			}
			System.out.print("*");
		}
	}
	
	public static void clearWindow(int lines) {
		for(int i = 0; i < lines; i++) {
			System.out.print("\n");
		}
	}

}