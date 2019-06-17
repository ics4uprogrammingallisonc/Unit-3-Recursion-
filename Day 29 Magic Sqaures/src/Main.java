import java.util.ArrayList;

/*
 * Created by: Allison Cook
 * Created on: 27-May-2019
 * Created for: ICS4U
 * Day #29 (Magic Sqaure)
 * This program uses recursion to create a magic square.
*/
public class Main {
	public static void main(String[] args) {
		//call the function to make the array
		//make an array
		ArrayList<Integer> temp = magic();
		
		//check the magic sqaure
		boolean magicSqaure = check(temp);
		
		//output if it is a magic sqaure
		if(magicSqaure == true) {
			//display that the array is a magic square
			System.out.println("The array " + temp + " is a magic sqaure");
		}
		else {
			//display that the array is not a magic square
			System.out.println("The array " + temp + " is not a magic sqaure");
		}
		
		
	}
			
	public static ArrayList<Integer>  magic() {
		//set the constants
		final int MIN = 1;
		final int MAX = 9;
		
		//variables
		int randomNum = 0;
		
		//make an array
		ArrayList<Integer> magicSqaure = new ArrayList<>();
		
		//loop 9 times
		for(int counter = 0; counter < 9; counter++) {
			//get the random number
			randomNum = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
			
			//add the random number to the array
			magicSqaure.add(randomNum);
		}
		
		//return gthe array
		return magicSqaure;
	}
	
	public static boolean check(ArrayList<Integer> temp) {
		//Constant
		final int equals = 15;
		
		//set the numbers in the array to varriables
		int Number0 = temp.get(0);
		int Number1 = temp.get(1);
		int Number2 = temp.get(2);
		int Number3 = temp.get(3);
		int Number4 = temp.get(4);
		int Number5 = temp.get(5);
		int Number6 = temp.get(6);
		int Number7 = temp.get(7);
		int Number8 = temp.get(8);
		
		boolean magicSquare = false;
		
		//check if all the combinations 
		if(Number0 + Number1 + Number2 == equals) {
			if (Number3 + Number4 + Number5 == equals) {
				if (Number6 + Number7 + Number8 == equals) {
					if (Number0 + Number3 + Number6 == equals) {
						if (Number1 + Number4 + Number7 == equals) {
							if (Number0 + Number3 + Number6 == equals) {
								if (Number2 + Number5 + Number8 == equals) {
									if (Number0 + Number4 + Number8 == equals) {
										if (Number2 + Number4 + Number6 == equals) {
											//return that it is a magic square
											magicSquare = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			magicSquare = false;
		}
		
		return magicSquare;
	}
	
}
