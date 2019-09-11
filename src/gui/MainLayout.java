package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.Toolkit;

public class MainLayout extends JFrame 
{
 
 public MainLayout()
 {
     super("Electronic Metro Ticketing System");
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 double width = screenSize.getWidth();
	 double height = screenSize.getHeight();
     setSize((int)width,(int)height);//setting size of the window
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
 }
	
}
