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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
public class PassengerRegistration extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1557184925928490846L;
	private JLabel aadharIDLabel;
	private JLabel PINLabel;
	private JLabel bloodgroupLabel;
	private JList<String> bloodgroupMenu;
	private JTextField aadharIDField;
	private JPasswordField PINField;
	private JButton okBtn;
	private RegistrationListener registrationListener;
	private JLabel showMessage;
	private JScrollPane bloodgroupScrollPane;
	public PassengerRegistration() {
 String menuitems[]= {"O-","O+","A-","A+","B-","B+","AB-","AB+"};
 bloodgroupMenu= new JList<String>(menuitems);
 bloodgroupMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 bloodgroupMenu.setLayoutOrientation(JList.VERTICAL);
 bloodgroupScrollPane = new JScrollPane(bloodgroupMenu);
 bloodgroupScrollPane.setMinimumSize(new Dimension(100, 50));
 bloodgroupMenu.setVisibleRowCount(4);
 aadharIDLabel=new JLabel("AADHAR ID :");
 bloodgroupLabel=new JLabel("Blood Group  :");
 PINLabel=new JLabel("4 DIGIT PIN  :");
 aadharIDField=new JTextField(40);
 PINField=new JPasswordField(40);
 okBtn=new JButton("SUBMIT");
 showMessage=new JLabel("");
 okBtn.addActionListener(new ActionListener() 
		 {
	 public void actionPerformed(ActionEvent e)
	 {   long aadhar_id=0;
	     int PIN=0;
	     String blood_group="";
		 try {
		 aadhar_id=Long.parseLong(aadharIDField.getText());
		 PIN=Integer.parseInt(String.valueOf(PINField.getPassword()));
		 blood_group=bloodgroupMenu.getSelectedValue();
	      }
	     catch(Exception exception)
	 {
	    	 JOptionPane.showMessageDialog(null,"Enter Correct values");
	 }
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
 add(bloodgroupScrollPane,gc);
 gc.gridy=3;
 gc.gridx=1;
 add(okBtn,gc);
 gc.anchor=GridBagConstraints.LINE_END;
 gc.gridy=4;
 gc.gridx=1;
 add(showMessage);
	}
	 public void setRegistrationListener(RegistrationListener listener)
	 {
		 this.registrationListener=listener;
	 } 
}
