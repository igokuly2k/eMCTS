package main;
import javax.swing.*;
import gui.MainLayout;
public class EMCTSMain 
{
 public static void main(String args[])
 {
	 SwingUtilities.invokeLater(new Runnable()
			 {
		 public void run()
		 {
			 new MainLayout();
		 }
			 });
 }
}

