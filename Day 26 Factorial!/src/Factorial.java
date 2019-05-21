/*
 * Created by: Allison Cook
 * Created on: 19-May-2019
 * Created for: ICS4U
 * Day #26 (Factorial!)
 * This program gets a number and displays its factorial using recursion
*/
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Factorial {

	//global variables
	static int nextFactor = 1; 
	static int orginalNumber = 0;
	
	public static void main(String[] args) throws InterruptedException {
		//variables
		int number = 0;
		
		//get the scanner
		Scanner read = new Scanner(System.in);
		
		//until they enter a int
		while(number == 0) {
			//displpay text to user
			System.out.println("Enter a number:");
			
			//wait
			TimeUnit.SECONDS.sleep(5);
			
			//get the input
			try {
				//get number
				number = Integer.parseInt(read.nextLine());
				orginalNumber = number;
				//call the factroial function
				Factorial(number);
			}
			catch(Exception e) {
				//display an error
				System.out.println("Please enter an integer.");
			}
		}
		
	}
	
	public static void Factorial(int factor) {
		//check if the factor is greater or equal to 1
		if(factor >= 1) 
		{
			//get the next multiplcation
			nextFactor = nextFactor * factor;
			
			//recall the factorial function to the next factor
			Factorial(factor - 1);
		}
		else
		{
			//end the program
			//display the factorial
			System.out.println(orginalNumber + "! = " + nextFactor );
		}
	}
}
