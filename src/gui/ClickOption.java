package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ClickOption extends JPanel implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1772146235206132019L;
	private ClickOptionListener clickOptionListener;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	public ClickOption()
	{
		 Border innerBorder=BorderFactory.createTitledBorder("CLICK OPTION"); 
		 Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		 setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		 setLayout(new GridBagLayout());
		 GridBagConstraints gc=new GridBagConstraints();
		 btn1=new JButton("REGISTRATION");
		 btn2=new JButton("LOGIN");
		 btn3=new JButton("HISTORY");
		 btn4=new JButton("HELP");
		 btn1.addActionListener(this);
		 btn2.addActionListener(this);
		 btn3.addActionListener(this);
		 btn4.addActionListener(this);
		 gc.gridx=0;
		 gc.gridy=0;
		 gc.weightx=2;
		 gc.weighty=2;
		 add(btn1,gc);
		 gc.gridx=1;
		 gc.gridy=0;
		 add(btn2,gc);
		 gc.gridy=1;
		 gc.gridx=0;
		 add(btn3,gc);
		 gc.gridy=1;
		 gc.gridx=1;
		 add(btn4,gc);
	}
	public void setClickOptionListener(ClickOptionListener listener)
	{
		this.clickOptionListener=listener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked=(JButton)e.getSource();
		if(clicked==btn1)
		{
		if(clickOptionListener!=null)
		{
			clickOptionListener.click(1);
		}
		}
		if(clicked==btn2)
		{
		if(clickOptionListener!=null)
		{
			clickOptionListener.click(2);
		}
		}		if(clicked==btn3)
		{
		if(clickOptionListener!=null)
		{
			clickOptionListener.click(3);
		}
		}
		if(clicked==btn4)
		{
		if(clickOptionListener!=null)
		{
			clickOptionListener.click(4);
		}
		}
		
	}
    
}
