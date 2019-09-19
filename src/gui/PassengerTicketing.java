package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
public class PassengerTicketing extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -219988198213800540L;
	private JLabel fromplaceLabel;
	private JLabel toplaceLabel;
	private JLabel fromplace;
	private JButton okBtn;
	private TicketingListener ticketingListener;
	private JList<String> toPlaceList;
	private JScrollPane toPlaceScrollPane;
	public PassengerTicketing() {
		String[] menuItems = { "Thirumangalam", "Annanagar", "Pachaiyappa College", "Egmore"};
		toPlaceList = new JList<String>(menuItems);
		toPlaceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		toPlaceList.setLayoutOrientation(JList.VERTICAL);
		toPlaceScrollPane = new JScrollPane(toPlaceList);
		toPlaceScrollPane.setMinimumSize(new Dimension(100, 50));
		toPlaceList.setVisibleRowCount(4);
 fromplaceLabel=new JLabel("From Place :");
 toplaceLabel=new JLabel("To Place  :");
 fromplace=new JLabel("CHENNAI CENTRAL");
 okBtn=new JButton("SUBMIT");
 okBtn.addActionListener(new ActionListener() 
		 {
	 public void actionPerformed(ActionEvent e)
	 {
		 String toplace=toPlaceList.getSelectedValue();
		 TicketingEvent ev=new TicketingEvent(this,toplace);
		 if(ticketingListener != null)
			 ticketingListener.ticketingEventOccured(ev);
	 }
	  });
 Border innerBorder=BorderFactory.createTitledBorder("Passenger Ticketing"); 
 Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
 setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
 setLayout(new GridBagLayout());
 GridBagConstraints gc=new GridBagConstraints();
 gc.gridx=0;
 gc.gridy=0;
 gc.weightx=2;
 gc.weighty=2;
 gc.fill=GridBagConstraints.NONE; 
 gc.anchor=GridBagConstraints.LINE_END;
 add(fromplaceLabel,gc);
 gc.gridx=1;
 gc.gridy=0;
 gc.anchor=GridBagConstraints.LINE_START;
 add(fromplace,gc);
 gc.gridy=1;
 gc.gridx=0;
 gc.anchor=GridBagConstraints.LINE_END;
 add(toplaceLabel,gc);
 gc.gridy=1;
 gc.gridx=1;
 gc.anchor=GridBagConstraints.LINE_START;
 add(toPlaceScrollPane,gc);
 gc.gridy=2;
 gc.gridx=1;
 gc.anchor=GridBagConstraints.LINE_START;
 add(okBtn,gc);
	}
	 public void setTicketingListener(TicketingListener listener)
	 {
		 this.ticketingListener=listener;
	 } 

}
