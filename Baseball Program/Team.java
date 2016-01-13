/*
	This file contains:
	Variables
	Conditionals
	Iterations
	User-defined methods
		that pass arguments(s)
		that return a value
		that return an object
	File Input
	Array
	ArrayList
	Aggregation
	this keyword
*/

import java.util.Scanner;	//Scanner class for input
import java.io.*;			//File I/O classes
import java.util.*;

public class Team {

	//STATIC VARIABLES	//////////////////////////////////////////////////////////////////////////
	private static ArrayList<String> usedTeamNames = new ArrayList<String>();
	private static int longestPlayerName = 0;
	private static int longestTeamName = 0;
	
	//INSTANCE OBJECTS	//////////////////////////////////////////////////////////////////////////
	//private DecimalFormat f = new DecimalFormat("#.000");
	
	//INSTANCE VARIABLES//////////////////////////////////////////////////////////////////////////
	private Random randy = new Random();					//Creates a new random number generator
	
	private String teamName;
	private Player[] players = new Player[9];
	
	private int nextPlayerUp = 0;
	
	private int runsScored;
	private int[] lineScore = new int[9];
	
	private int errors = 0;
	
	private boolean homeTeam;
	
	
	//CONSTRUCTORS		//////////////////////////////////////////////////////////////////////////
	Team(boolean homeTeam, String teamFilename, String firstFilename, String lastFilename) throws IOException {
		
		this.homeTeam = homeTeam;
		newTeamName(teamFilename);
		newTeamPlayers(firstFilename, lastFilename);
		
	}
	
	//PUBLIC GETTERS	//////////////////////////////////////////////////////////////////////////
	public String getName() {
		return teamName;
	}
	
	public String getHome() {
		if (homeTeam)
			return "home";
		else
			return "away";
	}
	
	public static int getLongestTeamName() {
		return longestTeamName;
	}
	
	public int getWhosUp() {
		return nextPlayerUp;
	}
	
	public String getWhosUpName() {
		return players[getWhosUp()].number() + " " + players[getWhosUp()].nameLastFirst();
	}
	
	public String getPitcherName() {
		for(int p = 0; p < players.length; p++) {
			if (players[p].getPositionNumber() == 1)
				return players[p].number() + " " + players[p].nameLastFirst();
		}
		return "";
	}
	
	public int getScore() {
		return runsScored;
	}
		
	public int teamErrors() {
		return errors;
	}
	
	public League.PAResult batterUp() {
		return players[getWhosUp()].bat();
	}
	
	public void sacrificed() {
		players[getWhosUp()].sac();
	}
	
	public void showLineup() {
		for (int p = 0; p < players.length; p++)
			System.out.println(players[p]);
	}
	
	public void showBox(boolean nowBatting) {
		System.out.print("\n");
		System.out.println("The " + teamName);
		System.out.print(Display.displayIn("Pos", 4));
		System.out.print(Display.displayIn("Num", 4));
		System.out.print(Display.displayIn("Name", (longestPlayerName + 3)));
		//System.out.print(Display.displayIn("PA", 4));
		System.out.print(Display.displayIn("AB", 4));
		System.out.print(Display.displayIn("H", 4));
		System.out.print(Display.displayIn("RBI", 4));
		System.out.print(Display.displayIn("BB", 4));
		System.out.print(Display.displayIn("SO", 5));
		System.out.print(Display.displayIn("AVG", 6));
		System.out.print(Display.displayIn("OBP", 6));
		System.out.print(Display.displayIn("OPS", 6));
		System.out.print("\n");
		
		for(int i = 0; i < players.length; i++) {
			System.out.print(Display.displayIn(players[i].getPosition(), 4));
			System.out.print(Display.displayIn(players[i].number(), 4));
			System.out.print(Display.displayIn(players[i].nameFirstLast(), (longestPlayerName + 3)));
			//System.out.print(Display.displayIn(players[i].getPA(), 4));
			System.out.print(Display.displayIn(players[i].getAB(), 4));
			System.out.print(Display.displayIn(players[i].getHits(), 4));
			System.out.print(Display.displayIn(players[i].getRBI(), 4));
			System.out.print(Display.displayIn(players[i].getWalks(), 4));
			System.out.print(Display.displayIn(players[i].getKs(), 4));
			System.out.print(Display.displayIn(players[i].getAvg(), 6));
			System.out.print(Display.displayIn(players[i].getOBP(), 6));
			//if(players[i].getOPS() < 1)
			//	System.out.print(" ");
			System.out.print(Display.displayIn(players[i].getOPS(), 6));
			if (nowBatting && getWhosUp() == i)
				System.out.print(" <<<");
			System.out.print("\n");
		}
		System.out.print("        ");
		System.out.print(Display.displayIn("Totals:", (longestPlayerName + 3)));
		//System.out.print(Display.displayIn(teamPA(), 4));
		System.out.print(Display.displayIn(teamAB(), 4));
		System.out.print(Display.displayIn(teamHits(), 4));
		System.out.print(Display.displayIn(teamRBI(), 4));
		System.out.print(Display.displayIn(teamWalks(), 4));
		System.out.print(Display.displayIn(teamKs(), 4));
		System.out.print(Display.displayIn(teamAvg(), 6));
		System.out.print(Display.displayIn(teamOBP(), 6));
		//if(teamOPS() < 1)
		//	System.out.print(" ");
		System.out.print(Display.displayIn(teamOPS(), 6));
		//System.out.print(Display.displayIn(teamSlug(), 6));
		//System.out.print(Display.displayIn(teamTB(), 6));
		//System.out.print(Display.displayIn(teamAB(), 6));
		System.out.print("\n");
	}
	
	public int teamAB() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getAB();
		}
		return total;
	}
	
	public int teamHits() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getHits();
		}
		return total;
	}
	
	public int teamRBI() {
		return runsScored;
	}
	
	public int teamWalks() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getWalks();
		}
		return total;
	}
	
	public int teamKs() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getKs();
		}
		return total;
	}
	
	public int teamPA() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getPA();
		}
		return total;
	}
	
	public int teamTB() {
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			total += players[i].getTB();
		}
		return total;
	}
	
	public double teamAvg() {
		if (teamAB() == 0)
			return 0;	
		return ((double) teamHits()) / teamAB();		//compute in-game batting average.
	}
	
	public double teamOBP() {
		if (teamPA() == 0)
			return 0;
		return ((double) (teamHits() + teamWalks())) / teamPA();		//compute in-game batting average.
	}
	
	public double teamOPS() {
		return teamSlug() + teamOBP();		//compute in-game on base plus slugging.
	}
	
	public double teamSlug() {
		if (teamAB() == 0)
			return 0;
		return ((double)teamTB()) / teamAB();		//compute in-game slugging average.
	}
	
	public String teamRHE() {
		return Display.displayIn(getScore(), 4) + Display.displayIn(teamHits(), 4) + Display.displayIn(teamErrors(), 4);
	}
	
	
	public void showLineScore(int inning, int top, boolean batting) {
		String scores = "";
		System.out.print(Display.displayIn(getName(), (getLongestTeamName() + 3)));		//first, show the team name
		
		if(!homeTeam || (homeTeam && top == 1)) {
			for(int i = 0; i < inning; i++) {
				scores += Display.displayIn(lineScore[i], 4);
			}
		}
		else {
			for(int i = 0; i < inning-1; i++) {
				scores += Display.displayIn(lineScore[i], 4);
			}
		}
		
		System.out.print(Display.displayIn(scores, 39));
		System.out.print(teamRHE());
		
		//if the batting indicator flag is true, and this team is batting, display the indicator.
		if(batting && ((homeTeam && top == 1) || (!homeTeam && top == 0)))
			System.out.print("  <<<");
	}
	
	public void showPitchingLine() {
		System.out.println("Pitching for the " + getName() + ": " + getPitcherName());
	}
	
	//PUBLIC SETTERS	//////////////////////////////////////////////////////////////////////////
	public void nextUp() {
		if (nextPlayerUp == 8)		//if the last player in the lineup was up,
			nextPlayerUp = 0;		//reset to the top of the order
		else
			nextPlayerUp++;			//otherwise, advance to the next player.
	}
	
	public void addRBI(int n) {
		players[getWhosUp()].addRBI(n);
	}
	
	public void addScore(int n, int i) {
		runsScored += n;
		lineScore[i-1] += n;
	}
	
	
	
	//PRIVATE SETTERS	//////////////////////////////////////////////////////////////////////////
	
	private void newTeamName(String filename) throws IOException {
		do {
			ArrayList<String> teamNameList = fillList(filename, 1);			//get a random team name.
			teamName = teamNameList.get(0);									//assign the team name.
		} while (Validation.alreadyInList(usedTeamNames, teamName));		//check that the team name isn't already in use.
		
		usedTeamNames.add(teamName);										//log the used team name.
		
		if (teamName.length() > longestTeamName)
			longestTeamName = teamName.length();
	}
	
	private void newTeamPlayers(String firstFilename, String lastFilename) throws IOException {
		ArrayList<String> firstNameList = fillList(firstFilename, 9);	//make a new list of players first names.
		ArrayList<String> lastNameList = fillList(lastFilename, 9);		//make a new list of players last names.
		
		/*
		System.out.println(firstNameList);
		System.out.println(lastNameList);
		*/			//list testing
		
		for(int i = 0; i < players.length; i++) {							//create a team of 9 players with the random first/last names
			players[i] = new Player(firstNameList.get(i), lastNameList.get(i));
			
			if (players[i].nameFirstLast().length() > longestPlayerName)
				longestPlayerName = players[i].nameFirstLast().length();
		}
		
		assignUniformNumbers(players);
		assignPositions(players);
		
		/* 
		for(int i = 0; i < players.length; i++) {							
			System.out.println(players[i]);
		}
		*/ //hardcoded roster display test.
		
	}
		
	private ArrayList fillList(String fileName, int finalLength) throws IOException {

		ArrayList<String> list = new ArrayList<String>();
		File aFile = new File(fileName);				//opens a file for input
		
		if (!aFile.exists()) {							//checks that the file exists
			System.out.println("The file " + fileName + " does not exist. Exiting now.");
			System.exit(0);								//exits if it doesn't exist
		}	
		
		Scanner inputFile = new Scanner(aFile);
				
		while(inputFile.hasNext()) {					//checks for data and loops while data exists
			list.add(inputFile.nextLine());
		}
		
		while(list.size() > finalLength) {				//randomly removes items until the list is the right size
			list.remove(randy.nextInt(list.size()));
		}
		
		if(list.size() > 1)
			Collections.shuffle(list);					//randomize the order before returning.
		
		return list;									//return the list.
		
	}
	
	private void assignUniformNumbers(Player[] players) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(9);
		
		int test = 0;
		
		for (int i = 0; i < 9; i++) {
			do {
				test = randy.nextInt(42) + 1;					//create a new random uniform number.
			} while (Validation.alreadyInList(numbers, test));	//make sure that the number isn't already used on the team.
			
			numbers.add(test);				//add the new number to the uniform number log.
			players[i].setNumber(test);		//set the player's uniform number.
		}
	}
	
	private void assignPositions(Player[] players) {
		ArrayList<Integer> positions = new ArrayList<Integer>(9);
		
		int test = 0;
		
		for (int i = 0; i < 9; i++) {
			do {
				test = randy.nextInt(9) + 1;				//create a new random position number.
			} while (Validation.alreadyInList(positions, test));	//make sure that the position isn't already filled on the team.
			
			positions.add(test);				//add the new number to the positions number log.
			players[i].setPosition(test);		//set the player's position number.
		}
	}
}
