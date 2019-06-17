/*
 * Created by: Allison Cook
 * Created on: 27-May-2019
 * Created for: ICS4U
 * Day #28 (Tower of Hanoi)
 * This program solves the tower of hanoi using a recursion algorithm
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmTowerOfHanoi;
	private JTextField txtNumberOfLevels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmTowerOfHanoi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTowerOfHanoi = new JFrame();
		frmTowerOfHanoi.setTitle("Tower of Hanoi");
		frmTowerOfHanoi.setBounds(100, 100, 450, 300);
		frmTowerOfHanoi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTowerOfHanoi.getContentPane().setLayout(null);
		
		txtNumberOfLevels = new JTextField();
		txtNumberOfLevels.setBounds(277, 44, 86, 20);
		frmTowerOfHanoi.getContentPane().add(txtNumberOfLevels);
		txtNumberOfLevels.setColumns(10);
		
		JLabel lblHowManyLevels = new JLabel("How many levels does the tower have:");
		lblHowManyLevels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHowManyLevels.setBounds(28, 44, 261, 17);
		frmTowerOfHanoi.getContentPane().add(lblHowManyLevels);
		
		JButton btnCompleteTheTower = new JButton("Complete the tower");
		btnCompleteTheTower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//variables
				int height = 0;
				//get the number from the textbox
				try {
					//get the height
					height = Integer.parseInt(txtNumberOfLevels.getText());
					
					//check to see if it is greater than 0
					if(height > 0) {
						//call the function to solve
					    Solve(height, 'A', 'B', 'C');
					}
					else {
						//display an error message
						JOptionPane.showMessageDialog(null, "Please enter a number greater than 0", "Tower of Hanoi", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(Exception e) {
					//display an error message
					JOptionPane.showMessageDialog(null, "Please only enter numbers into the textbox", "Tower of Hanoi", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnCompleteTheTower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCompleteTheTower.setBounds(133, 196, 167, 29);
		frmTowerOfHanoi.getContentPane().add(btnCompleteTheTower);
		
		JLabel lblImage = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("")).getImage();
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setBounds(50, 86, 333, 99);
		frmTowerOfHanoi.getContentPane().add(lblImage);
	}
	
	//the function to solve the tower
	public void Solve(int numDiscs, char from, char mid, char to) {
		String steps;
		//print steps
		if (numDiscs == 1) {
			//add to setps done
			steps = "Move disc 1 from " + from + " to " + to;
			//print steps
			System.out.println("Step :" + steps);
		}
		else {
			//move the top disk to the middle peg
			Solve(numDiscs - 1, from, to, mid);
			
			//add to setps done
			steps = "Move discs " + numDiscs + " from " + from + " to " + to;
			
			//call again to move to the next peg
			Solve(numDiscs - 1, mid, from, to);
			
			//print steps
			System.out.println("Step :" + steps);
		}
	}
}
