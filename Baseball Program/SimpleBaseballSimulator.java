/*
	This file contains:
	Variables
	Conditionals
	Iterations
	User-defined methods
		that pass arguments(s)
	File Input and Output
	Array
	ArrayList
*/

import java.io.*;				//File I/O classes
import java.util.*; 			//Random, Array List, Scanner
import java.text.DecimalFormat;	//decimal formatting

public class SimpleBaseballSimulator {

	//define minimum terminal window size:
	static final int WINDOW_HEIGHT = 40;
	static final int WINDOW_WIDTH = 100;
	
	//define default input filenames
	static String teamFilename = "TeamNames.txt";
	static String firstFilename = "FirstNames.txt";
	static String lastFilename = "LastNames.txt";
	
	//define default output filename
	static String outputFilename = "SavedScores.txt";
	
	
	

	public static void main (String[] args) throws IOException {
			
		int stopsign = 0;
		
		Display.windowGuide(WINDOW_HEIGHT, WINDOW_WIDTH);
		oneStop();
		displayWelcome();
		
	
		Team[] teams = new Team[2];		//generate two new teams
		System.out.println("Home:");
		teams[0] = new Team(false, teamFilename, firstFilename, lastFilename);		//set the first team to "home"
		System.out.println("Away:");
		teams[1] = new Team(true, teamFilename, firstFilename, lastFilename);		//set the second team to "away"
		
		Field field = new Field();		//create a new field
		
		todaysMatchup(teams);

		//For reference: 	enum PAResult { TRIPLE, HR, DOUBLE, SINGLE, WALK, K, PO, LO, FO, GO }
		
		Display.clearWindow(WINDOW_HEIGHT);
		
		for(int inning = 1; inning <= 9; inning++) {	//nine innings
			for(int t = 0; t < teams.length; t++) {		//each half-inning
				if (!(inning == 9 && t == 1 && teams[1].getScore() > teams[0].getScore())) { //!(9th inning&&home team due up&&home team is winning)
					while (field.getOuts() < 3) {
						
						//Display the current box score of the batting team with the at-bat indicator
						teams[t].showBox(true);
						System.out.print("\n");
						
						//Display the pitching line
						teams[Math.abs(t-1)].showPitchingLine();
						System.out.print("\n");
						
						//Display the score
						displayLineScore(teams, inning, t, true);
						System.out.print("\n");
						
						//Display the inning (in plain english).
						displayInning(inning, t);
						
						//Display the outs.
						System.out.println("Outs: " + Display.outDots(field.getOuts()));
						System.out.print("\n");
						
						//Draw the field
						field.showField();		//display the field
						
						System.out.println("Now Batting: " + teams[t].getWhosUpName());
						
						if(stopsign == 0) {
							System.out.print("\nPress [Enter] to complete the plate appearance: ");
							oneStop();
						}
						
						System.out.print("\nResult: ");
						switch (teams[t].batterUp()) {
							case TRIPLE:
								System.out.println("Triple!!!");
								field.new3B();
								break;
							case HR:
								System.out.println("Home Run!!!!");
								field.newHR();
								break;
							case DOUBLE:
								System.out.println("Double!!");
								field.new2B();
								break;
							case SINGLE:
								System.out.println("Single!");
								field.new1B();
								break;
							case WALK:
								System.out.println("Walk!");
								field.newWalk();
								break;
							case K:		//Strikeout
								System.out.println("Strikeout.");
								field.newK();
								break;	
							case PO:	//Pop Out
								System.out.println("Pop Out.");
								field.newPopOut();
								break;
							case LO:	//Line Out
								System.out.println("Line Drive Out.");
								field.newLineOut();
								break;	
							case FO:	//Fly Out
								if(field.newFlyOut()) {
									teams[t].sacrificed();
									System.out.println("Sacrifice Fly");
								}
								else
									System.out.println("Fly Out.");
								break;	
							case GO:	//Ground Out
								System.out.println("Ground out.");
								field.newGroundOut();
								break;
						}
						System.out.print("\n");
						
						if(field.getOuts() == 3)
							System.out.println("The inning is over");
						
						if(stopsign == 0) {
							stopsign = newStopSign();
						}
						nextUp(field, teams[t], inning);
					}
				}
				field.resetInning();
				//Display.clearWindow(WINDOW_HEIGHT);
				//displayInningBreak();
			}
			if(stopsign == 1) {
				stopsign = newStopSign();
			}
		}
		
		endOfGame(teams);	//Display the result and box score
		
		saveScores(teams);	//Prompt to store the result, and calculate the average runs scored.
	}
	
	//	END OF MAIN METHOD ///////////////////////////////////////////////////////////////
	
	/**
      nextUp() is called when a bater completes a plate appearance (by making an out or reaching base).
      It tells the current team to advance to the next batter,
      and tells the field to collect & reset the runs scored on the previous play.
      @param field the Field object.
      @param team the team that is currently batting
      @param inning the current inning (for extended linescore counting)
   */
	public static void nextUp(Field field, Team team, int inning) {
		team.addRBI(field.getRuns());
		team.addScore(field.getRuns(), inning);
		team.nextUp();
		field.resetRuns();
	}
	
	/**
      displayWelcome() shows the welcome screen and sets the input file names
   */	
   public static void displayWelcome() {
		Scanner in = new Scanner(System.in);
		String input = "";
		
		Display.clearWindow(WINDOW_HEIGHT);
		
		System.out.print("Please enter the name of the file containing the list of team names,\n(or press [Enter] to use the default file \"TeamNames.txt\"): ");
		input = in.nextLine();
		if (!input.equals("")) {
			teamFilename = input;
		}
		System.out.print("Please enter the name of the file containing the list of player first names,\n(or press [Enter] to use the default file \"FirstNames.txt\"): ");
		input = in.nextLine();
		if (!input.equals("")) {
			firstFilename = input;
		}
		System.out.print("Please enter the name of the file containing the list of player last names,\n(or press [Enter] to use the default file \"LastNames.txt\"): ");
		input = in.nextLine();
		if (!input.equals("")) {
			lastFilename = input;
		}
	}
	
	/**
      newStopSign() is used to pause the game for user input.
      @return the stopsign signifier:
      	0 to stop after the next batter
      	1 to stop after this inning
      	2 to keep running until the end of the game
   */	
	public static int newStopSign() {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.print("Please choose ");
		
		while(true) {
			System.out.print("[Enter] = See Next Batter, 1 = Complete the Inning, 2 = Complete the Game: ");
			input = in.nextLine();
			Display.clearWindow(WINDOW_HEIGHT);
			if (input.equals("")) {
				return 0;
			}
			if (input.equals("1")) {
				return 1;
			}
			if (input.equals("2")) {
				return 2;
			}
			else {
				System.out.print("Invalid input. ");
			} 
		}
				
	}
	
	/**
      oneStop() is used to pause the game until the user presses [Enter].
   */	
	public static void oneStop() {
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
	
	public static void todaysMatchup(Team[] teams) {
		Display.clearWindow(WINDOW_HEIGHT);
		System.out.println("Today's matchup is between the " + teams[0].getName() + " and the " + teams[1].getName());
		for(int t = 0; t < teams.length; t++) {		//display the starting box score.
			System.out.println("\nThe starting lineup for the " + teams[t].getName() + " is:");
			teams[t].showLineup();
			System.out.print("\n");
		}	
		System.out.print("\n\n\nPress [Enter] to continue: ");
		oneStop();	
	}
	
	/**
      displayInning() shows the Inning number, and if it is the top or the bottom of that inning.
      @param i the current inning number
      @param t the top or bottom inning indicator
   */	
	public static void displayInning(int i, int t) {
		System.out.print("Inning: ");
		if(t == 0)
			System.out.print("Top");
		else
			System.out.print("Bottom");
		System.out.println(" of the " + Display.englishInning(i));
	}
	
	public static void displayLineScore(Team[] teams, boolean batting){
		displayLineScore(teams, 9, 1, batting);
	}

	/**
      displayLineScore() gets the current line score for each team, and outputs it with a formatted header.
      @param teams the team array
      @param inning the current inning
      @param top the top or bottom inning indicator
      @param batting a boolean flag for if it should indicate which team is currently batting
   */	
	public static void displayLineScore(Team[] teams, int inning, int top, boolean batting) {
	
		System.out.println("Line Score:");
		System.out.print(Display.displayIn("Team", (Team.getLongestTeamName() + 3)));
		for (int i = 1; i <= 9; i++) {
			System.out.print(Display.displayIn(i, 4));
		}
		System.out.print("   R   H   E\n");
		
		for(int t = 0; t < teams.length; t++) {
			//System.out.println(teams[t].showLineScore(inning));
			teams[t].showLineScore(inning, top, batting);
			System.out.print("\n");
			
		}
	}
	
	/**
      endOfGame() displays the end of game box score and line score for both teams.
      @param teams the Team array
   */	
	public static void endOfGame(Team[] teams) {
		int winningTeam = 0;
		
		Display.clearWindow(WINDOW_HEIGHT);
		System.out.println("The game is over.");
		
		if (teams[1].getScore() > teams[0].getScore()) {	//if team 1 beat team 0, set winningTeam to 1.  Otherwise, leave it at 0.
			winningTeam = 1;
		}
		
		if (teams[1].getScore() != teams[0].getScore()) {	//if there is NOT a tie
			System.out.println("The " + teams[winningTeam].getName() + " beat the " + teams[Math.abs(winningTeam-1)].getName() + " by a score of " + teams[winningTeam].getScore() + " to " + teams[Math.abs(winningTeam-1)].getScore());		
		}
		else {		//if there IS a tie
			System.out.println("The " + teams[0].getName() + " and the " + teams[1].getName() + " were tied at " + teams[0].getScore() + " after 9 innings.");
			System.out.println("Everyone was tired, so they decided to call it a night.");
		}
		
		//Display the end-of-game stats:
		for(int t = 0; t < teams.length; t++) {
			teams[t].showBox(false);
		}
		System.out.print("\n");
	
		displayLineScore(teams, false);
		System.out.print("\n");
	}
	
	/**
      saveScores() saves the total runs scored to a file of the user's choosing.
      @param teams the Team array
   */	
	public static void saveScores(Team[] teams) throws IOException {
	
		int totalScore = 0;
		
		Scanner in = new Scanner (System.in);
				
		boolean validEntry = false;
		String input = "";
		
		do {
			System.out.print("\nWould you like to save the total runs scored in this game to a file? [Y/N]: ");
		
			input = in.nextLine();
			
			if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))
				validEntry = true;
			else
				System.out.print("Invalid entry. ");
			
		} while (!validEntry);
		
		if (input.equalsIgnoreCase("Y")) {
			System.out.print("\nPlease enter the name of the file where you'd like to save the scores,\n(or press [Enter] to use the default file \"SavedScores.txt\"): ");
			input = in.nextLine();
			if (!input.equals("")) {
				outputFilename = input;
			}
			
			totalScore = teams[0].getScore() + teams[1].getScore();
			FileWriter fwriter = new FileWriter(outputFilename, true);		//opens a file, creates one if it doens't exist
			PrintWriter outputFile = new PrintWriter(fwriter);				//creates a PrintWriter from the fwriter object
			
			outputFile.println(totalScore);	//write the total runs scored to the file.
			outputFile.close();
			
			do {
				validEntry = false;		//reset validEntry
				
				System.out.print("\nWould you like to display the average number of runs scored per game? [Y/N]: ");
		
				input = in.nextLine();
			
				if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))
					validEntry = true;
				else
					System.out.print("Invalid entry. ");
			
			} while (!validEntry);
			
			if (input.equalsIgnoreCase("Y")) {
				averageRunsScored();
			}
		}
		
				
	}
	
	/**
      averageRunsScored() calculates the average runs scored in all games stored in the selected outputFile.
   */	
	public static void averageRunsScored() throws IOException {
		DecimalFormat f = new DecimalFormat("#.##");
		ArrayList<Integer> allScores = new ArrayList<Integer>();	//create an arraylist to store the scores.
		int sum = 0;
		double avg = 0;
		
		File file = new File(outputFilename);			//opens a file for input
		if (!file.exists()) {							//checks that the file exists
			System.out.println("The file does not exist. Exiting now.");
			System.exit(0);								//exits if it doesn't exist
		}
		
		Scanner inputFile = new Scanner(file);			//creates a scanner "inputFile" linked to someFile
		
		while(inputFile.hasNext()) {									//checks for data and loops while data exists
			allScores.add(Integer.parseInt(inputFile.nextLine()));		//reads in the line
		}
		
		inputFile.close();		//close the file.
		
		for(int val : allScores) {	//sum the values
			sum += val;
		}
		
		avg = (double) sum / allScores.size();
		
		System.out.print("\nThe average number of runs scored in " + allScores.size() + " ");
		if(allScores.size() == 1) 
			System.out.print("game ");
		else
			System.out.print("games ");
		System.out.println("stored in " + outputFilename + " is " + f.format(avg));
	}
}