package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class PassengerHistory extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6551816939436179745L;
    private JTable jt;
    private JScrollPane sp;
    public PassengerHistory(ResultSet rs) throws SQLException
    {
    	rs.next();
    	Vector <Vector<Object>> data=new Vector<Vector<Object>>();
    	Vector<String> column=new Vector<String>();
    	column.add("From Place");
    	column.add("To Place");
    	column.add("Time");
        do
       {
            Vector<Object> row = new Vector<Object>();

               row.addElement( rs.getObject("fromplace") );
               row.addElement( rs.getObject("toplace") );
               row.addElement(rs.getObject("printdate") );
               

           data.add( row );
       }while(rs.next());
    	jt=new JTable(data,column);
        sp=new JScrollPane(jt); 
        add(sp);
    }
}
