package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PassengerHistory extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6551816939436179745L;
    private JTable jt;
    private JScrollPane sp;
    public PassengerHistory(ResultSet rs) throws SQLException
    {
    	String column[]={"FROM PLACE","TO PLACE","PRINT TIME"};   
    	String data[][]=new String[20][3];
        while (rs.next()) {
            String em = rs.getString("fromplace");
            for(int i=0;i<20;i++) {
           data[i][0]= em.split("\n")[i];}
           }
        while (rs.next()) {
            String em = rs.getString("toplace");
           for(int j=0;j<20;j++)
               data[j][1]= em.split("\n")[j];
           }
        while (rs.next()) {
            String em = rs.getString("printdate");
            for(int k=0;k<20;k++)
                data[k][2]= em.split("\n")[k];
           }
        jt=new JTable(data,column);
        sp=new JScrollPane(jt); 
        add(sp);
    }
}
