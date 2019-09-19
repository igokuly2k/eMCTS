package main;
import java.sql.SQLException;
import java.io.IOException;
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
             try 
             {
			 new MainLayout();
			 }
			 catch(IOException e)
			 {
				 System.out.print(e);
			 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			 }); 
 }
}

