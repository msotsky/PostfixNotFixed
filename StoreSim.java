//package postfix;
// Name: Weiting Li, Lopsii Olagoke, Max Sotsky, Ayomide Adekiitan, Ayomide Adekiitan

/**
  Complete all missing or incomplete method implementations for this class
*/

//Simulates the flow of customers through a line in a store.

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

class StoreSim{
	public static void main (String args[]) throws IOException {
		LinkedQueue custQ = new LinkedQueue( ); // Line (queue) of customers containing 
												//   the time that each customer arrived 
                                 				//   and joined the line
	    Random rand                  				// Initialize random number generator
	        = new Random(System.currentTimeMillis());   // seed is system 
	                                                    // clocktime to limit 
	                                                    // sequence repetition
	    Scanner keyboard = new Scanner(System.in);
	    
	    int simLength,              // Length of simulation (minutes)
	        minute,                 // Current minute
	        timeArrived,            // Time dequeued customer arrived
	        waitTime,               // How long dequeued customer waited
	        totalServed = 0,        // Total customers served
	        totalWait   = 0,        // Total waiting time for all customers
	        maxWait     = 0,        // Longest wait
	        numArrivals = 0;        // Number of new arrivals
	
	
	
	    System.out.println("Enter the Number of minutes the Simulator will run: ");      
	    simLength = keyboard.nextInt();
	
	    for ( minute = 0 ; minute < simLength ; minute++ ){
	        // Output time & number of customers waiting in line
			waitTime = minute;
			System.out.println("Time of customers waiting in line: "+waitTime);
			System.out.println("Number of customers waiting in line: "+custQ.getSize());

	        // Dequeue the first customer in line (if any). Increment
	        // totalServed, add the time that this customer waited to
	        // totalWait, and update maxWait if this customer waited
	        // longer than any previous customer.
			if(!custQ.isEmpty()){
	        	waitTime = (int)custQ.dequeue();
			}
			totalServed++;
	        totalWait += minute;
	        maxWait = (maxWait<waitTime)?waitTime:maxWait;

	        // Determine the number of new customers.
	        // Uses a random number generator.
	        switch ( rand.nextInt(4) ){  // Randomly generate a number from 0 to 3
				case 0:
					numArrivals = 0;
					break;
				case 1:
					numArrivals = 1;
					break;
				case 2:
					numArrivals = 2;
					break;
				default:
	        }
	        // Add the new customers to the line
			if(numArrivals == 1){
				custQ.enqueue(minute);
			}else{
				custQ.enqueue(minute);
				custQ.enqueue(minute);
			}
	    }
    
	    // set precision to 2 decimal places
	    DecimalFormat fmt = new DecimalFormat("0.##");
	    
	    System.out.println("\nCustomers served : " + totalServed);
	    System.out.println("Average wait     : " + fmt.format((double)totalWait/totalServed));
	    System.out.println("Longest wait     : " + maxWait);

	}

//	Customers served : 30
//	Average wait     : 14.5
//	Longest wait     : 17

//	Customers served : 60
//	Average wait     : 29.5
//	Longest wait     : 31

//	Customers served : 120
//	Average wait     : 59.5
//	Longest wait     : 73

//	Customers served : 480
//	Average wait     : 239.5
//	Longest wait     : 278

}
