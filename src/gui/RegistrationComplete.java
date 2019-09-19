package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistrationComplete extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6338652618392353339L;

	public RegistrationComplete(int cust_id)
	{
		JLabel validate=new JLabel("Generated Customer ID:"+cust_id);
		this.add(validate);
		
	}
	
}
