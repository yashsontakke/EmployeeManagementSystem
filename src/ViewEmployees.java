import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEmployees extends JFrame implements ActionListener {

    JTable table ;
    Choice cempid ;
    JButton search , print , update , back ;

    ViewEmployees(){

        setLayout(null);

        table = new JTable();
        JLabel searchlbl = new JLabel("Search by Employee id ");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);

        cempid = new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()){
                cempid.add(rs.getString("empid"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while (rs.next()){
                cempid.add(rs.getString("empid"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1500,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        print = new JButton("Print");
        print.setBounds(110,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(200,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(290,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(1500,700);
        setLocation(300,100);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ViewEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"' ";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else  if(e.getSource()==print){
            try{
                table.print();

            }catch (Exception ae){
               ae.printStackTrace();
            }
        }else if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cempid.getSelectedItem());
        }else{
                setVisible(false);
                new Home();
        }
    }
}
