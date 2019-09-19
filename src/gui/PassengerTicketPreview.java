package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class PassengerTicketPreview extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4943621946978425696L;
	private int fare;
	private JLabel faredisplay;
	private JLabel thanks;
	private JButton okbtn;
	private BackListener backListener;
	
	public PassengerTicketPreview(String toPlace)
	{
		Border innerBorder=BorderFactory.createTitledBorder("Ticket Preview"); 
		Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		thanks=new JLabel(" ");
		okbtn=new JButton("PAY NOW");
		okbtn.addActionListener(this);
		fareCalculator(toPlace);
		faredisplay=new JLabel("Calculated Fare to "+toPlace+" : "+fare);
		add(faredisplay);
		add(okbtn);
		add(thanks);
	}
    public void actionPerformed(ActionEvent e)
    {
    	if(backListener!=null)
    	{
    		backListener.back();
    	}
    	thanks.setText("Thanks for Payment and Enjoy your Journey");
    	okbtn.setText("Payed");
    	okbtn.setEnabled(false);
    }
	public void fareCalculator(String toPlace) {
		if(toPlace.equals("Thirumangalam"))
			fare=10;
		else if(toPlace.equals("Annanagar"))
			fare=20;
		else if(toPlace.equals("Pachaiyappa College"))
			fare=30;
		else if(toPlace.equals("Egmore"))
			fare=40;
	}
	public void setBackListener(BackListener backlistener)
	{
		this.backListener=backlistener;
	}

}
