package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
public class PassengerLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8702486653058297103L;
	private JLabel custIDLabel;
	private JLabel PINLabel;
	private JTextField custIDField;
	private JPasswordField PINField;
	private JButton okBtn;
	private LoginListener loginListener;
	public PassengerLogin() 
	{
		custIDLabel=new JLabel("Customer ID :");
		 PINLabel=new JLabel("PIN  :");
		 custIDField=new JTextField(10);
		 PINField=new JPasswordField(10);
		 okBtn=new JButton("SUBMIT");
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
		 add(custIDLabel,gc);
		 gc.gridx=1;
		 gc.gridy=0;
		 gc.anchor=GridBagConstraints.LINE_START;
		 add(custIDField,gc);
		 gc.gridy=1;
		 gc.gridx=0;
		 gc.anchor=GridBagConstraints.LINE_END;
		 add(PINLabel,gc);
		 gc.gridy=1;
		 gc.gridx=1;
		 gc.anchor=GridBagConstraints.LINE_START;
		 add(PINField,gc);
		 gc.gridy=2;
		 gc.gridx=1;
		 gc.anchor=GridBagConstraints.LINE_START;
		 
		 
		 add(okBtn,gc);
		 okBtn.addActionListener(new ActionListener() 
		 {
		public void actionPerformed(ActionEvent e)
		{
		 int customer_id=Integer.parseInt(custIDField.getText());
		 int PIN=Integer.parseInt(String.valueOf(PINField.getPassword()));
		 LoginEvent ev=new LoginEvent(this,customer_id,PIN);
		 if(loginListener != null)
			loginListener.loginEventOccured(ev);
		}
		});
			}
			 public void setLoginListener(LoginListener listener)
			 {
				 this.loginListener=listener;
			 } 

}
