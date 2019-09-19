package gui;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
public class BackButton extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private JButton backButton;
	private BackListener backListener;
	private static final long serialVersionUID = 7969247279741060211L;
    public BackButton()
    {
    	setBorder(BorderFactory.createEtchedBorder());
    	backButton=new JButton("BACK");
    	setLayout(new FlowLayout(FlowLayout.LEFT));
    	backButton.addActionListener(this);
    	add(backButton);
     }
    public void setBack(BackListener listener)
    {
    	this.backListener=listener;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {	
    	if(backListener!=null)
    	{
    		backListener.back();
    	}
    }
}
