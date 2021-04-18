package com.mycompany.a1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Game extends JFrame {
	
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play() {
		JLabel myLabel = new JLabel("Enter a Command:");
		super.add(myLabel);
		final JTextField myTextField = new JTextField();
		this.add(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.setText("");
				
				if (sCommand.length() > 0) {
					switch (sCommand.charAt(0)) {
						case 'x':
							gw.exit();
							break;
						case 'a':
							gw.accelerate();
							System.out.print("\nPlayer Ant has accelerated.");
							break;
						case 'b':
							gw.brake();
							System.out.print("\nPlayer Ant has braked.");
							break;
						case 'l':
							gw.turnLeft();
							System.out.print("\nPlayer Ant has turned 5 degrees to the left.");
							break;
						case 'r':
							gw.turnRight();
							System.out.print("\nPlayer Ant has turned 5 degrees to the right.");
							break;
						case '1':
							System.out.print("\nPlayer Ant has reached Flag 1.");
							gw.collideWithFlag(1);
							break;
						case '2':
							System.out.print("\nPlayer Ant has reached Flag 2.");
							gw.collideWithFlag(2);
							break;
						case '3':
							System.out.print("\nPlayer Ant has reached Flag 3.");
							gw.collideWithFlag(3);
							break;
						case '4':
							System.out.print("\nPlayer Ant has reached Flag 4.");
							gw.collideWithFlag(4);
							break;
						case '5':
							System.out.print("\nPlayer Ant has reached Flag 5.");
							gw.collideWithFlag(5);
							break;
						case '6':
							System.out.print("\nPlayer Ant has reached Flag 6.");
							gw.collideWithFlag(6);
							break;
						case '7':
							System.out.print("\nPlayer Ant has reached Flag 7.");
							gw.collideWithFlag(7);
							break;
						case '8':
							System.out.print("\nPlayer Ant has reached Flag 8.");
							gw.collideWithFlag(8);
							break;
						case '9':
							System.out.print("\nPlayer Ant has reached Flag 9.");
							gw.collideWithFlag(9);
							break;
						case 'f':
							System.out.print("\nPlayer Ant has collided with food station.");
							gw.collideWithFoodStation();
							break;
						case 'g':
							System.out.print("\nPlayer Ant has collided with spider.");
							gw.collideWithSpider();
							break;
						case 't':
							System.out.print("\nClock has ticked.");
							gw.tickClock();
							break;
						case 'd':
							System.out.print("\nDisplaying current game and player Ant state values...\n");
							gw.display();
							break;
						case 'm':
							System.out.print("\nOutputting current map...\n");
							gw.outputMap();
							break;
						case 'y':
							System.out.print("\nExit confirmed.\n");
							System.exit(0);
							break;
						case 'n':
							System.out.print("\nExit not confirmed.\n");
							break;
						default: 
							System.out.print("\nInvalid input. Please try again.");
							break;
					}
				}
			}
		}
		);
	}

}
