package gui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PassengerHelp extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198925543948466557L;
	public PassengerHelp()
	{
		String dir=System.getProperty("user.dir");
		JLabel label=new JLabel(new ImageIcon(dir+"/hi.jpeg"));
		add(label);
	}
}
