//Bryant Bardales
//CISC 3320
//Assignment #2

import java.util.concurrent.*;

public class mainprog 
{

	public Semaphore Printer, Plotter, Scanner;

	private void Semaphores() //Defines the computer resources as semaphores.
	{

		Printer = new Semaphore(5);

		Plotter = new Semaphore(6);

		Scanner = new Semaphore(4);

	}

	public static void main(String[] args) throws Exception 
	{

		mainprog rqst = new mainprog();

		rqst.Semaphores();//Declares and initializes the semaphores with its' appropriate values. 

		for(int i = 1; i <= 100; i++) //Makes sure the process loops through 100x.
		{
			new request(rqst).start();  //Creates a child process to request the computer resource each time.

			Thread.sleep(ThreadLocalRandom.current().nextInt(2, 5 + 1)*1000); //Makes sure the program sleeps for a random time between 2 to 5 seconds in between computer resource calls. 

		}//End for loop.

	}//End main()

}//End
