package gui;
import java.awt.BorderLayout;
import database.*;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
public class MainLayout extends JFrame 
{
/**
	 * 
	 */
	private static final long serialVersionUID = 6672634193071504157L;
	private PassengerLogin passengerLogin;
	private PassengerLogin passengerLogin1;
	private PassengerTicketing passengerTicketing;
	private PassengerTicketPreview passengerTicket;
	private Container contentPane;
	private BackButton backB;
	private ClickOption clickOption;
	private PassengerRegistration passengerRegistration;
	private PassengerHistory passengerHistory;
	private SetPassengerDatabase setPassenger;
	private GetPassengerDatabase getPassenger;
	private PassengerHelp passengerHelp;
	private String toPlace;
	private int cus_id;
	private int cus_id1;
    public MainLayout() throws IOException, ClassNotFoundException, SQLException
    {	
        super("Electronic Metro Ticketing System");
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    double width = screenSize.getWidth();
	    double height = screenSize.getHeight();
        setSize((int)width,(int)height);//setting size of the window
        setPassenger=new SetPassengerDatabase();
        getPassenger=new GetPassengerDatabase();
        passengerLogin=new PassengerLogin();
        passengerLogin1=new PassengerLogin();
        passengerRegistration=new PassengerRegistration();
        passengerTicketing=new PassengerTicketing();
        passengerTicket=new PassengerTicketPreview("Annanagar");
    	contentPane=getContentPane();
    	passengerHelp=new PassengerHelp();
    	backB=new BackButton();
       	contentPane.setLayout(new BorderLayout());	   
   	    clickOption =new ClickOption();
        changePanel(clickOption);
        backB.setBack(new BackListener()
		{
	public void back()
	{
		try {
			dispose();
			new MainLayout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		});
    	clickOption.setClickOptionListener(new ClickOptionListener()
		{
    		public void click(int Option){
		switch(Option)
		{
		  case 1:    changePanel(passengerRegistration);break;
		  case 2:    changePanel(passengerLogin);break;
		  case 3:    changePanel(passengerLogin1);break;
		  case 4:    changePanel(passengerHelp);break;
		}
	    }
		});
    	passengerRegistration.setRegistrationListener(new RegistrationListener()
    			{
			@Override
			public void registrationEventOccured(RegistrationEvent e) {
				try {
					String cus=Long.toString(e.getAadharID());
					String PIN=String.valueOf(e.getPIN());
					if(e.getAadharID()!=0 && cus.length()==12 && PIN.length()==4)
					{
					setPassenger.setPassengerData(e.getAadharID(),e.getBloodGroup(),e.getPIN());
					changePanel(new RegistrationComplete(getPassenger.getCustomerId()));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Proper AADHAR ID/PIN");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Enter Correct Values");
				}
				}	
    			});
		passengerLogin.setLoginListener(new LoginListener()
		{
			
        public void loginEventOccured(LoginEvent e)
        {
        	boolean check=false;
        	try {
        		
				check=getPassenger.validatePIN(e.getCustomerID(),e.getPIN());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Enter Correct UserID/PIN");
			}
        	if(check) {
        		cus_id=e.getCustomerID();
        	changePanel(passengerTicketing);}
        	else
        	{
            	JOptionPane.showMessageDialog(null,"Enter Correct UserID/PIN");
        	}
		}
	    });
		passengerLogin1.setLoginListener(new LoginListener()
		{
        public void loginEventOccured(LoginEvent e)
        {
        	boolean check=false;
        	try {
				check=getPassenger.validatePIN(e.getCustomerID(),e.getPIN());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Enter Correct UserID/PIN");
			}
        	if(check)
        	{
        		cus_id1=e.getCustomerID();
        		try {
					passengerHistory=new PassengerHistory(getPassenger.getPassengerHistory(cus_id1));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	changePanel(passengerHistory);
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null,"Enter Correct UserID/PIN");
        	}
		}
	    });
		passengerTicketing.setTicketingListener(new TicketingListener()
		{
        public void ticketingEventOccured(TicketingEvent e)
        {
        	toPlace=e.getToPlace();
        	passengerTicket=new PassengerTicketPreview(toPlace);
           changePanel(passengerTicket);
           passengerTicket.setBackListener(new BackListener()
   		{
        	public void back()
        	{
        		try {
   				setPassenger.setPassengerHistory(cus_id,"Chennai Central",toPlace);
   			} catch (ClassNotFoundException | SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   	    }
   		});
		}
	    });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
     }	
    public void changePanel(JPanel j)
    {
    	contentPane.removeAll();
    	contentPane.add(backB,BorderLayout.NORTH);  
        contentPane.add(j,BorderLayout.CENTER);
        validate();
        setVisible(true); 
    }
    public String returnToPlace()
    {
    	return toPlace;
    }
}
