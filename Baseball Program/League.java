/*
	This file contains:
	Constants	
*/

public class League {

	//League-Wide Player Constants
	public static final double BATTING_AVERAGE = 0.253;
	
	public static final double MIN_WALK_RATE = 0.04;
	public static final double MAX_WALK_RATE = 0.15;
	
	public static final double MIN_K_RATE = 0.15;
	public static final double MAX_K_RATE = 0.32;

	//League-Wide Game Situation Constants
	public static final double TRIPLE_RATE = 0.05;	//Triples
	public static final double HR_RATE = 0.10;		//Home Runs
	public static final double DOUBLE_RATE = 0.20;	//Doubles
	//Singles rate: 0.65							//Else, Singles

	public static final double PO_RATE = 0.069;		//Pop Outs
	public static final double LO_RATE = 0.147;		//Line Out
	public static final double FO_RATE = 0.225;		//Fly Out
													//Else, Ground Out
	
	public static final double XB_TAKEN_RATE = 0.39;		//Extra base taken rate
	
	public static final double GIDP_RATE = 0.70;			//Percentage of GIDB
	public static final double LEAD_RUNNER_OUT_RATE = 0.50;	//Percentage of the time to get the lead runner.
	
	public static final double PROD_OUT_RATE = 0.30;		//productive out rate.
	
	//Enumerated event results
	enum PAResult { TRIPLE, HR, DOUBLE, SINGLE, WALK, K, PO, LO, FO, GO }
	enum Stat { HIT, WALK, K, INPLAY }

}