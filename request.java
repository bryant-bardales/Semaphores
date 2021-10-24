//Bryant Bardales
//CISC 3320
//Assignment #2

import java.util.concurrent.*;

public class request extends Thread
{
	mainprog rqst;

	public request(mainprog rqst) 
	{
		this.rqst = rqst;
	}

	@Override

	public void run() 
	{
		int n= ThreadLocalRandom.current().nextInt(1, 3 + 1); //Generate a random number between 1 to 3 to determine which resource it will request.

		Semaphore s = null; //The current semaphore is represented by variable s.

		switch (n) 
		{

		case 1: // Case 1: Printer is requested.
		{
			System.out.println("Requested a printer.");

			s = rqst.Printer;

			break;
		}

		case 2: //Case 2: Plotter is requested.
		{
			System.out.println("Requested a plotter.");

			s = rqst.Plotter;

			break;
		}

		case 3: //Case 3: Scanner is requested.
		{
			System.out.println("Requested a scanner.");

			s = rqst.Scanner;

			break;
		}

		}//End of switch case.

		System.out.println("Semaphore value is: "+s.availablePermits());// Shows the value of the called current semaphore

		boolean done = false;

		while(!done) 
		{

			if(s.tryAcquire()) //If the computer resource is available...
			{

				System.out.println("Sucessful request!"); //Print this message to let end-user know success.
				System.out.println(" \t"); //Added for neatness.

				try 
				{
					Thread.sleep(ThreadLocalRandom.current().nextInt(1, 5 + 1)*1000);//Follows the rule to sleep for random time between 1 to 5 seconds.
				} 

				catch (InterruptedException e) //Catches any errors.
				{
					e.printStackTrace(); //Prints where the error is according by line #.
				}

				s.release();

				done = true;

			}//End of successful resource case.

			else //Otherwise, if computer is not available...
			{
				System.out.println("Failure to request!");//Print this message to let end-user know unsuccessful.
				System.out.println(" \t");//Added for neatness.

				try 
				{
					Thread.sleep(ThreadLocalRandom.current().nextInt(2, 5 + 1)*1000); //Follows the rule to sleep for random time between 2 to 5 seconds.
				} 

				catch (InterruptedException e) //Catches any errors.
				{
					e.printStackTrace(); //Prints where the error is according by line #.
				}

			}//End of unsuccessful resource case.

		}//End of while loop.

	}//End of run().

}//End.
