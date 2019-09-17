package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class PassengerRegistration extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1557184925928490846L;
	private JLabel aadharIDLabel;
	private JLabel PINLabel;
	private JLabel bloodgroupLabel;
	private JTextField bloodgroupField;
	private JTextField aadharIDField;
	private JPasswordField PINField;
	private JButton okBtn;
	private RegistrationListener registrationListener;
	public PassengerRegistration() {
 aadharIDLabel=new JLabel("AADHAR ID :");
 bloodgroupLabel=new JLabel("Blood Group  :");
 PINLabel=new JLabel("PIN  :");
 aadharIDField=new JTextField(40);
 bloodgroupField=new JTextField(40);
 PINField=new JPasswordField(40);
 okBtn=new JButton("SUBMIT");
 okBtn.addActionListener(new ActionListener() 
		 {
	 public void actionPerformed(ActionEvent e)
	 {
		 int aadhar_id=Integer.parseInt(aadharIDField.getText());
		 int PIN=Integer.parseInt(String.valueOf(PINField.getPassword()));
		 String blood_group=bloodgroupField.getText();
		 RegistrationEvent ev=new RegistrationEvent(this,aadhar_id,blood_group,PIN);
		 if(registrationListener != null)
			 registrationListener.registrationEventOccured(ev);
	 }
	  });
 Border innerBorder=BorderFactory.createTitledBorder("Passenger Login"); 
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
 add(aadharIDLabel,gc);
 gc.gridx=1;
 gc.gridy=0;
 gc.anchor=GridBagConstraints.LINE_START;
 add(aadharIDField,gc);
 gc.gridy=1;
 gc.gridx=0;
 gc.anchor=GridBagConstraints.LINE_END;
 add(PINLabel,gc);
 gc.gridy=1;
 gc.gridx=1;
 gc.anchor=GridBagConstraints.LINE_START;
 add(PINField,gc);
 gc.gridy=2;
 gc.gridx=0;
 gc.anchor=GridBagConstraints.LINE_START;
 add(bloodgroupLabel,gc);
 gc.gridy=2;
 gc.gridx=1;
 gc.anchor=GridBagConstraints.LINE_END;
 add(bloodgroupField,gc);
 gc.gridy=3;
 gc.gridx=1;
 add(okBtn,gc);
	}
	 public void setTicketingListener(RegistrationListener listener)
	 {
		 this.registrationListener=listener;
	 } 
}
