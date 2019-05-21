/*
 * Created by: Allison Cook
 * Created on: 19-May-2019
 * Created for: ICS4U
 * Day #25 (using recursion)
 * This program Rewrites a string backwards
*/
package src;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//variables
		String currentString;
		
		//get the scanner
		Scanner read = new Scanner(System.in);
		
		//displpay text to user
		System.out.println("Enter a string:");
		
		//get the string
		currentString = read.nextLine();
		
		//get the class
		Recursion newClass = new Recursion();
		
		//call the recursion function
		newClass.ReverseString(currentString);
	}
	
	
}

class Recursion {
	
	//gobal variable
	String reverse = "";
	
	public void ReverseString(String theSentence) {
		//local varibales
		String theSentenceSubString; 
		char lastCharacterOfString;
		
		//check to see if there are characters in the string
		if (theSentence.length() > 0) {
			//create a anew string that is the same as the previous sentence without the last letter
			theSentenceSubString = theSentence.substring(0, theSentence.length()-1);
			
			//get the last character 
			lastCharacterOfString = theSentence.charAt(theSentence.length()-1);
			
			//add to the other string
			reverse = reverse + lastCharacterOfString;
			
			//recall the reverseString function with the shorter string
			ReverseString(theSentenceSubString);
		}
		else {
			//end the program once the string is completely revsersed
			//display the reversed string
			System.out.println("Reversed string: " + reverse);
		}
	}
	
}
