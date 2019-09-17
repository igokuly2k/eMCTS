package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Toolkit;
import java.io.IOException;
public class MainLayout extends JFrame 
{
/**
	 * 
	 */
	private static final long serialVersionUID = 6672634193071504157L;
    //private final String dir=System.getProperty("user.dir");
	private PassengerLogin passengerLogin;
	private PassengerTicketing passengerTicketing;
	private PassengerThank passengerThank;
	private Container contentPane;
	private BackButton backB;
	private ClickOption clickOption;
	private PassengerRegistration passengerRegistration;
	private PassengerHistory passengerHistory;
	private PassengerHelp passengerHelp;
    public MainLayout() throws IOException
    {	
        super("Electronic Metro Ticketing System");
        //setContentPane(new JLabel(new ImageIcon(dir+"/images/hi.png")));
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    double width = screenSize.getWidth();
	    double height = screenSize.getHeight();
        setSize((int)width,(int)height);//setting size of the window
        passengerLogin=new PassengerLogin();
        passengerRegistration=new PassengerRegistration();
        passengerHelp=new PassengerHelp();
        passengerHistory=new PassengerHistory();
        passengerTicketing=new PassengerTicketing();
        passengerThank=new PassengerThank();
    	contentPane=getContentPane();
    	backB=new BackButton();
       	contentPane.setLayout(new BorderLayout());	   
   	    clickOption =new ClickOption();
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
				}
        	}
        		});
        changePanel(clickOption);
    	clickOption.setClickOptionListener(new ClickOptionListener()
		{
    		public void click(int Option){
		switch(Option)
		{
		  case 1:    changePanel(passengerRegistration);break;
		  case 2:    changePanel(passengerLogin);break;
		  case 3:    changePanel(passengerHistory);break;
		  case 4:    changePanel(passengerHelp);break;
		}
	    }
		});
		passengerLogin.setLoginListener(new LoginListener()
		{
        public void loginEventOccured(LoginEvent e)
        {
        	changePanel(passengerTicketing);
		}
	    });
		passengerTicketing.setTicketingListener(new TicketingListener()
		{
        public void ticketingEventOccured(TicketingEvent e)
        {
           changePanel(passengerThank);
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
}
