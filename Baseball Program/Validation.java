/*
	This file contains:
	Variables
	Conditionals
	Iterations
	User-defined methods
		that pass arguments(s)
		that return a value
	ArrayList
*/
import java.util.*;		//ArrayList, Random, etc.
import java.text.DecimalFormat;

public class Validation {
	
	public static boolean alreadyInList(ArrayList<Integer> list, int test) {
		if (list.size() != 0) {
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i) == test) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean alreadyInList(ArrayList<String> list, String test) {
		if (list.size() != 0) {
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(test)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
