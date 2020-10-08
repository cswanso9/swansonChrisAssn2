package cse360assignment02;
import java.util.LinkedList;
import java.util.Queue;


/**
 * <h1>Adding Machine</h1>
 * This program adds and subtracts from an initial value, keeping a running total in the "total" variable.
 * The Queues "numList" and "signList" keep track of all actions performed until "clear()" is called.
 * "numList" contains the list of integers, and "signList" contains 1's, corresponding with adding, and -1's, corresponding with subtracting.
 * 
 * @author Chris Swanson
 * 
 */
public class AddingMachine {
	private int total;
	private Queue<Integer> numList = new LinkedList<Integer>();
	private Queue<Integer> signList = new LinkedList<Integer>();
	  
	/**
	 * The constructor instantiates an object and sets the initial total to 0.
	 * It also pushes the first transaction onto the Queues, which is to add 0.
	 */
	  public AddingMachine () {
	    total = 0;  // not needed - included for clarity
	    numList.add(0);
	    signList.add(1);
	  }
	  
	  /**
	   * This method returns the total of all additions and subtractions thus far.
	   * @return int The total.
	   */
	  public int getTotal () {
	    return total;
	  }
	  
	  /**
	   * This method adds the value passed to the running total. 
	   * It also pushes a representation of the transaction onto the Queues.
	   * @param value The number to be added.
	   * @return Nothing.
	   */
	  public void add (int value) {
		  total = total + value;
		  numList.add(value);
		  signList.add(1);
	  }

	  /**
	   * This method subtracts the value passed from the running total. 
	   * It also pushes a representation of the transaction onto the Queues.
	   * @param value The number to be subtracted.
	   * @return Nothing.
	   */
	  public void subtract (int value) {
		  total = total - value;
		  numList.add(value);
		  signList.add(-1);
	  }

	  /**
	   * This method returns a list of all actions made to the point at which it is called.
	   * It returns in the form "x + y - z ... ".
	   * @return String The list of actions performed by the AddingMachine
	   */
	  public String toString () {
		  	String totalMessage = "";
		  	Queue<Integer> numTemp = new LinkedList<Integer>();
		  	Queue<Integer> signTemp = new LinkedList<Integer>();
		  	int actionCount = numList.size();
		  
		  	for (int i = 0; i < actionCount; i++) {
			  	int currentInt = numList.remove();
			  	int currentSign = signList.remove();
			  	numTemp.add(currentInt);
			  	signTemp.add(currentSign);
			  	
			  	if (i == 0) {
			  		totalMessage = totalMessage + currentInt;
			  	}
			  	else {
			  		if (currentSign == 1) {
			  			totalMessage = totalMessage + " + " + currentInt;
			  		}
			  		else {
			  			totalMessage = totalMessage + " - " + currentInt;
			  		}
			  	}
			  	
		  	}
		  
		  	numList = numTemp;
		  	signList = signTemp;
		  	return totalMessage;
	  }

	  /**
	   * This method resets the adding machine such that the running total is 0, and the transaction history is erased.
	   * @return Nothing.
	   */
	  public void clear() {
		  total = 0;
		  
		  int queueSize = numList.size();
		  for (int i = 0; i < queueSize; i++) {
			  numList.remove();
			  signList.remove();
		  }
		  numList.add(0);
		  signList.add(1);
	  }

}

