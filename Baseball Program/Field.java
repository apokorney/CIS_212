import java.util.*;

public class Field {
	//STATIC VARIABLES	//////////////////////////////////////////////////////////////////////////

	//INSTANCE OBJECTS	//////////////////////////////////////////////////////////////////////////
	private Random randy = new Random();					//Creates a new random number generator
	
	//INSTANCE CONSTANTS//////////////////////////////////////////////////////////////////////////
	final int THIRD = 2;
	final int SECOND = 1;
	final int FIRST = 0;
	
	//INSTANCE VARIABLES//////////////////////////////////////////////////////////////////////////
	private int outs;
	
	private int runsScoredOnPlay;
	private boolean[] bases = new boolean[3];
	
	//CONSTRUCTORS		//////////////////////////////////////////////////////////////////////////
	Field() {
		resetInning();
	}
	
	//PUBLIC SETTERS	//////////////////////////////////////////////////////////////////////////
	public void resetRuns() {
		runsScoredOnPlay = 0;
	}
	
	public void resetInning() {						//called at the end of a half inning to make sure everything is reset
		for (int i = 0; i < bases.length; i++) {	//loop through bases and set all to false.
			bases[i] = false;
		}
		runsScoredOnPlay = 0;		//reset runs scored counter
		outs = 0;					//reset outs
	}
	
	public void newWalk() {
		if(hasForce(THIRD))
			advanceFromThird();
		if(hasForce(SECOND))
			advanceFromSecond();
		advanceFromFirst();
		bases[FIRST] = true;
	}
	
	public void new1B() {
		if (bases[THIRD]) {
			runsScoredOnPlay++;
			bases[THIRD] = false;
		}
		if (bases[SECOND]) {
			runsScoredOnPlay++;
			bases[SECOND] = false;
		}
		if (bases[FIRST]) {
			bases[THIRD] = true;
			bases[FIRST] = false;
		}
		bases[FIRST] = true;
	}
	
	public void new2B() {
		if (bases[THIRD]) {
			runsScoredOnPlay++;
			bases[THIRD] = false;
		}
		if (bases[SECOND]) {
			runsScoredOnPlay++;
			bases[SECOND] = false;
		}
		if (bases[FIRST]) {
			bases[THIRD] = true;
			bases[FIRST] = false;
		}
		bases[SECOND] = true;
	}
	
	public void new3B() {
		if (bases[THIRD]) {
			runsScoredOnPlay++;
			bases[THIRD] = false;
		}
		if (bases[SECOND]) {
			runsScoredOnPlay++;
			bases[SECOND] = false;
		}
		if (bases[FIRST]) {
			runsScoredOnPlay++;
			bases[FIRST] = false;
		}
		bases[THIRD] = true;
	}
		
	public void newHR() {
		runsScoredOnPlay++;
		for(int b = 1; (b-1) < bases.length; b++) {
			if (bases[b-1]) {
				runsScoredOnPlay++;
				bases[b-1] = false;
			}
		}
	}

	public boolean newFlyOut() {
		boolean sacrifice = false;
	
		if (outs < 2) {
			if (bases[THIRD]) {
				runsScoredOnPlay++;
				bases[THIRD] = false;
				sacrifice = true;
			}
			if (bases[SECOND]) {
				if (randy.nextDouble() < League.XB_TAKEN_RATE) {
					bases[SECOND] = false;
					bases[THIRD] = true;
					sacrifice = true;
				}
			}
			if (bases[FIRST]) {
				if (randy.nextDouble() < League.XB_TAKEN_RATE && !bases[SECOND]) {
					bases[SECOND] = true;
					bases[FIRST] = false;
					sacrifice = true;
				}
			}
			outs++;
		}
		else {
			outs++;
		}
		
		return sacrifice;
	}
	
	public void newK() {
		outs++;
	}
	
	public void newPopOut() {
		outs++;
	}
	
	public void newLineOut() {
		outs++;
	}
	
	public void newGroundOut() {
	
		boolean doublePlay = false;
		if (outs < 2 && randy.nextDouble() < League.GIDP_RATE)
			doublePlay = true;
			
			
		if (!runnersOnBase() || outs == 2) {	//if there are no runners on, or there are 2 outs, always record 1 out.
			outs++;
		}
		else if (basesLoaded() && doublePlay) {
			bases[FIRST] = false;
			outs += 2;
		}
		else if (basesLoaded() && !doublePlay) {
			outs++;
		}
		else if (outs == 1) {
			if (bases[FIRST] && doublePlay) {	//if there's someone on first and they turn the DP
				outs += 2;
			}
			else {									//and they don't turn the DP
				if(bases[THIRD])					//advance from third
					advanceFromThird();
				if(bases[SECOND])					//advance from second
					advanceFromSecond();
				if(bases[FIRST]) {					//advance from first
					if (randy.nextDouble() < League.LEAD_RUNNER_OUT_RATE) {	//out at second, safe at first.
						bases[SECOND] = false;
						bases[FIRST] = true;
						outs++;
					}
					else {			//out at first, safe at second.
						bases[SECOND] = true;
						bases[FIRST] = false;
						outs++;
					}
				}
			}
		}
		else {		//no outs
			if (bases[FIRST] && doublePlay) {	//if there's someone on first and they turn the DP
				outs += 2;
				advanceFromThird();
				advanceFromSecond();
			}
			else if (bases[FIRST]) {  //if there's someone on first and they don't turn the DP
				if (randy.nextDouble() < League.LEAD_RUNNER_OUT_RATE) {		//out at second, safe at first.
					bases[SECOND] = false;
					bases[FIRST] = true;
					outs++;
				}
				else {						//out at first, safe at second
					advanceFromFirst();
					outs++;
				}									
			}
			else {			//there's no one on first, take the out at first and advance the runners
				outs++;
				advanceFromThird();
				advanceFromSecond();
			}
		}
	}
	
	//PUBLIC GETTERS	//////////////////////////////////////////////////////////////////////////
	public boolean onBase(int b) {
		return bases[b];
	}
	
	public int getOuts() {
		return outs;
	}
	
	public int getRuns() {
		return runsScoredOnPlay;
	}
		
	public String whosOn(int b) {
		if (b < 0 || b > 2)
			return "E";	
		if (bases[b])
			return "•";
		else
			return " ";
	}
	
	public boolean basesLoaded() {
		if(bases[FIRST] && bases[SECOND] && bases[THIRD])
			return true;
		else
			return false;
	}
	
	public boolean runnersOnBase() {
		for (int i = 0; i < bases.length; i++) {
			if (bases[i])
				return true;
		}
		return false;
	}
	
	private boolean hasForce(int a) {	//checks if there is a force on at a given base.
		for(int b = a; b >= 1; b--) {
			if(!bases[b-1])
				return false;
		}
		return true;
	}
	
	private void advanceFromThird() {
		if(bases[THIRD]) {
			runsScoredOnPlay++;
			bases[THIRD] = false;
		}
	}
	
	private void advanceFromSecond() {
		if (bases[SECOND] && !bases[THIRD]) {
			bases[SECOND] = false;
			bases[THIRD] = true;
		}
	}
	
	private void advanceFromFirst() {
		if (bases[FIRST] && !bases[SECOND]) {
			bases[FIRST] = false;
			bases[SECOND] = true;
		}
	}
	
	public void showField() {
		System.out.print("\t\t\t[ " + whosOn(SECOND) + " ]\n\n\n");
		System.out.print("\t\t[ " + whosOn(THIRD) + " ]\t\t[ " + whosOn(FIRST) + " ]\n\n\n\n\t\t\t ___\n\t\t\t|   |\n\t\t\t \\ /\n\n");
	}
}
















