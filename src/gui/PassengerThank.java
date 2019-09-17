package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PassengerThank extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3277852444987462936L;
	public PassengerThank()
	{
	JLabel thankYou=new JLabel("Thanks For Buying the ticket");
	setLayout(new BorderLayout());
	add(thankYou,BorderLayout.CENTER);
	}

}
