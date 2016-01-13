/*
	This file contains:
	Variables
	Constants
	User-defined methods
		that pass arguments(s)
		that return a value
	this keyword
*/

import java.text.DecimalFormat;
import java.util.*;					//Random, ArrayList


public class Player {
	
	//STATIC VARIABLES	//////////////////////////////////////////////////////////////////////////

	//INSTANCE OBJECTS	//////////////////////////////////////////////////////////////////////////
	private Random randy = new Random();
	private DecimalFormat f = new DecimalFormat("#.000");


	//INSTANCE VARIABLES//////////////////////////////////////////////////////////////////////////
	private String firstName;
	private String lastName;
	
	private int uniformNumber;
	private int position;			//position, stored as an int (i.e. Pitcher: 1, Catcher: 2, etc.)
	
	private int pa;		//stat counting
	private int ab;
	private int r;
	private int h;
	private int rbi;
	private int bb;
	private int so;
	
	private int singles;	//hit type counting
	private int doubles;
	private int triples;
	private int dingers;
		
	private double trueAverage;		//generated player statistics
	private double trueWalkRate;
	private double trueKRate;
	
	
	//CONSTRUCTORS		//////////////////////////////////////////////////////////////////////////
	
	/**
      This constructor creates a new player and assigns new random values for the player's stats.
      @param firstName the player's first name
      @param lastName the player's last name
   */	
	Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		trueAverage = randomTrueAverage();
		trueWalkRate = randomTrueWalkRate();
		trueKRate = randomTrueKRate();
	}

	//PUBLIC SETTERS	//////////////////////////////////////////////////////////////////////////
	public void setNumber(int n) {
		uniformNumber = n;
	}
	
	public void setPosition(int n) {
		position = n;
	}
	
	public void isAtThePlate() {
		pa++;
	}
	
	public void registeredAtBat() {
		ab++;
	}
	
	public void scoredARun() {
		r++;
	}
	
	public void hit() {
		h++;
	}
	
	public void addRBI(int n) {
		rbi += n;
	}
	
	public void walked() {
		bb++;
	}
	
	public void struckOut() {
		so++;
	}
	
	public void sac() {
		ab--;
	}
	
	//PUBLIC GETTERS	//////////////////////////////////////////////////////////////////////////
	public String toString() {
		return Display.displayIn(getPosition(), 3) + Display.displayIn(" #" + uniformNumber, 5) + nameFirstLast() + ": " + f.format(trueAverage) + "/" + f.format(trueAverage + trueWalkRate) + "/" + "OPS";
	}
	
	public String nameLastFirst() {
		return lastName + ", " + firstName;
	}
	
	public String nameFirstLast() {
		return firstName + " " + lastName;
	}
	
	public String number() {
		return "#" + uniformNumber;
	}
	
	public double getAvg() {
		if (ab == 0)
			return 0;	
		return ((double) h) / ab;		//compute in-game batting average.
	}
	
	public double getOBP() {
		if (pa == 0)
			return 0;
		return ((double) (h + bb)) / pa;		//compute in-game batting average.
	}
	
	public double getOPS() {
		return getSlug() + getOBP();		//compute in-game on base plus slugging.
	}
	
	public double getSlug() {
		if (ab == 0)
			return 0;
		return ((double) getTB()) / ab;		//compute in-game slugging average.
	}
	
	public int getTB() {
		return singles + (2 * doubles) + (3 * triples) + (4 * dingers);		//compute in-game total bases.
	}
		
	public int getHits() {
		return h;
	}
	
	public int getPA() {
		return pa;
	}
	
	public int getAB() {
		return ab;
	}
	
	public int getRBI() {
		return rbi;
	}
	
	public int getWalks() {
		return bb;
	}
	
	public int getKs() {
		return so;
	}
	
	public int get1B() {
		return singles;
	}
	
	public int get2B() {
		return doubles;
	}
	
	public int get3B() {
		return triples;
	}
	
	public int getHR() {
		return dingers;
	}
	
	public String getPosition() {
		switch (position) {	
		case 1:
			return "P";
		case 2:
			return "C";
		case 3:
			return "1B";
		case 4:
			return "2B";
		case 5:
			return "3B";
		case 6:
			return "SS";
		case 7:
			return "LF";
		case 8:
			return "CF";
		case 9:
			return "RF";
		}
		return "ER";
	}
	
	public int getPositionNumber() {
		return position;
	}
	
	public League.PAResult bat() {
		double batRoll = randy.nextDouble();
		double eventRoll = randy.nextDouble();
				
		isAtThePlate();								//register a plate appearance
		
		if (batRoll < trueAverage) {				//hit
			statUpdate(League.Stat.HIT);
			if (eventRoll < League.TRIPLE_RATE) {
				triples++;
				return League.PAResult.TRIPLE;
				}
			else if (eventRoll < League.TRIPLE_RATE + League.HR_RATE) {
				dingers++;
				return League.PAResult.HR;
				}
			else if (eventRoll < League.TRIPLE_RATE + League.HR_RATE + League.DOUBLE_RATE) {
				doubles++;
				return League.PAResult.DOUBLE;
				}
			else {
				singles++;
				return League.PAResult.SINGLE;
				}
		}
		else if (batRoll < (trueAverage + trueWalkRate)) {		//walk
			statUpdate(League.Stat.WALK);
			return League.PAResult.WALK;
		}
		else {								//out of some type.
			if (eventRoll < trueKRate) {	//strikeout
				statUpdate(League.Stat.K);
				return League.PAResult.K;
			}
			else {							//in-play out
				statUpdate(League.Stat.INPLAY);
				eventRoll = randy.nextDouble();		//reroll for in-play out type
				if (eventRoll < League.PO_RATE)		//pop out
					return League.PAResult.PO;
				else if (eventRoll < League.PO_RATE + League.LO_RATE)	//line out
					return League.PAResult.LO;
				else if (eventRoll < League.PO_RATE + League.LO_RATE + League.FO_RATE)	//fly out
					return League.PAResult.FO;
				else
					return League.PAResult.GO;		//ground out
					
			}
			
		}

	}
	
	//PRIVATE SETTERS	//////////////////////////////////////////////////////////////////////////
	private void statUpdate(League.Stat s) {
		switch (s) {
			case HIT:
			registeredAtBat();
			hit();
			break;
			case WALK:
			walked();
			break;
			case K:
			registeredAtBat();
			struckOut();
			break;
			case INPLAY:
			registeredAtBat();
			break;
		}
	}
	
	private double randomTrueAverage() {
		double offset = ((double) (randy.nextInt(126) - 50)) / 1000;
		return League.BATTING_AVERAGE + offset;
	}
	
	private double randomTrueWalkRate() {
		return League.MIN_WALK_RATE + (randy.nextDouble() * (League.MAX_WALK_RATE - League.MIN_WALK_RATE));
	}
	
	private double randomTrueKRate() {
		return League.MIN_K_RATE + (randy.nextDouble() * (League.MAX_K_RATE - League.MIN_K_RATE));
	}
}