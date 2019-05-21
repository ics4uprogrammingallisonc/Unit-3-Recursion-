/*
 * Created by: Allison Cook
 * Created on: 19-May-2019
 * Created for: ICS4U
 * Day #27 (Binary Search Recursively)
 * This program searches a list for a number using binary search recursively
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BinarySearch {

	private JFrame frmBinarySearch;
	private JTextField txtNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinarySearch window = new BinarySearch();
					window.frmBinarySearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BinarySearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//create a list
	ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

	private void initialize() {
		frmBinarySearch = new JFrame();
		frmBinarySearch.setTitle("Binary Search");
		frmBinarySearch.setBounds(100, 100, 426, 247);
		frmBinarySearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBinarySearch.getContentPane().setLayout(null);
		
		JLabel lblEnterNumber = new JLabel("Enter a number to search for:");
		lblEnterNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterNumber.setBounds(38, 32, 192, 23);
		frmBinarySearch.getContentPane().add(lblEnterNumber);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(239, 35, 148, 20);
		frmBinarySearch.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//variables
				int number = 0;
				boolean targetOnList = false;
				int Randomnumber = 0;
				
				//get the number from the list
				try {
					number = Integer.parseInt(txtNumber.getText());
					
					//add the numbers to the list
					for (int counter = 0; counter < 100; counter ++) {
						//get a number
						Randomnumber = (int) (Math.random() * (100));
						
						//add to list
						randomNumbers.add(Randomnumber);
					}
					
					//sort the list
					randomNumbers.sort(null);
					
					//check if the number is on the list
					for(int index = 0; index < randomNumbers.size(); index ++) {
						//check all the numbers
						if(randomNumbers.get(index) == number) {
							//if the target is there check boolean
							targetOnList = true;
						}
						else {
							if(targetOnList == true) {
								targetOnList = true;
							}
							else {
								targetOnList = false;
							}
						}
					}
					
					if (targetOnList == true) {
						//call the search function
						BinarySearch(0, 100, number);
					}
					else {
						//display the message that it is not on the list
						JOptionPane.showMessageDialog(null, "The number you entered is not on the list", "Binary Search", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(Exception e) {
					//display an error message
					JOptionPane.showMessageDialog(null, "Please only enter a integer", "Binary Search", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(168, 132, 89, 23);
		frmBinarySearch.getContentPane().add(btnSearch);
	}
	
	public void BinarySearch(int min, int max, int target) {
		
		//find the middle
		int mid = (min + max)/2;
		int position = 0; 

		//check if the number at the mid is the target
		if( randomNumbers.get(mid) == target) {
			//get the position
			position = mid;
			
			//display the position
			JOptionPane.showMessageDialog(null, target + " is at the " + position + " position", "Binary Search", JOptionPane.INFORMATION_MESSAGE);
		}
		//check if greater than target
		else if (randomNumbers.get(mid) > target) {
			//change the max
			max = mid - 1;
			
			//recall the function
			BinarySearch(min, max, target);
			
		}
		else if (randomNumbers.get(mid)< target) {
			//change the min
			min = mid + 1;
			
			//recall the function
			BinarySearch(min, max, target);
		}
	}
}
