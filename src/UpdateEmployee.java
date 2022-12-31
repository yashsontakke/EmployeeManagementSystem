import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class UpdateEmployee extends JFrame implements ActionListener {


    JButton back ,update;
    JTextField tfeducation ,  tffname , tfsalary,  tfaddress,  tfphone, tfemail;
    String empid ;
    JLabel lblname , labelaadhar , labeldob ;

    UpdateEmployee(String empid ){
        this.empid = empid;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name :-");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);


        lblname = new JLabel();         //name not editable
        lblname.setBounds(225,150,250,30);
        add(lblname);

//        fathers name
        JLabel  labelfname = new JLabel("Fathers Name :-");
        labelfname.setBounds(50,200,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);


        tffname = new JTextField();
        tffname.setBounds(225,200,250,30);
        add(tffname);

//        date of birth

        JLabel dob = new JLabel("Date of Birth:-");
        dob.setBounds(50,250,150,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);

//        not editable
        labeldob = new JLabel();
        labeldob.setBounds(225,250,250,30);
        add(labeldob);

//        salary class

        JLabel  labelsalary = new JLabel("Salary :- ");
        labelsalary.setBounds(50,300,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);


        tfsalary = new JTextField();
        tfsalary.setBounds(225,300,250,30);
        add(tfsalary);

//        address

        JLabel  labeladdress = new JLabel("Address :- ");
        labeladdress.setBounds(50,350,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);


        tfaddress = new JTextField();
        tfaddress.setBounds(225,350,250,30);
        add(tfaddress);

//        phone no
        JLabel  labelphone = new JLabel("Phone no  :- ");
        labelphone.setBounds(50,400,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);


        tfphone = new JTextField();
        tfphone.setBounds(225,400,250,30);
        add(tfphone);

//        email id
        JLabel  labelemail = new JLabel("Email id :- ");
        labelemail.setBounds(50,450,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);


        tfemail = new JTextField();
        tfemail.setBounds(225,450,250,30);
        add(tfemail);

//      education
        JLabel  labeleducation = new JLabel("Education :- ");
        labeleducation.setBounds(50,500,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);

        tfeducation = new JTextField();    //editable
        tfeducation.setBounds(225,500,150,30);
        add(tfeducation);

//      aadhar number
        labelaadhar = new JLabel("Aadhar No :- ");
        labelaadhar.setBounds(50,550,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);


        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(225,550,250,30);
        add(lblaadhar);

//       Employee id
        JLabel  labeleid = new JLabel("Employee Id :- ");
        labeleid.setBounds(50,600,150,30);
        labeleid.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleid);

        JLabel lbleidn = new JLabel(empid);
        lbleidn.setBounds(225,600,150,30);
        add(lbleidn);

        try{
            Conn conn= new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee where empid = '"+empid+"'");
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                lblaadhar.setText(rs.getString("aadhar"));
                labeldob.setText(rs.getString("dob"));
                tfeducation.setText(rs.getString("education"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tffname.setText(rs.getString("fname"));
                tfsalary.setText(rs.getString("salary"));

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //button add
        update = new JButton("Update Employee");
        update.setBounds(400,650,150,50);
        update.setBackground(Color.BLACK);
        update.setOpaque(true);
        update.setBorderPainted(false);
        update.setForeground(Color.WHITE);
        add(update);
        update.addActionListener(this);

//        button back

        back = new JButton("Back");
        back.setBounds(769,680,100,25);
        back.setBackground(Color.BLACK);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        setSize(900,750);
        setLocation(300,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
    @Override
    public void actionPerformed(ActionEvent Ae) {
        if(Ae.getSource()== update){

            String name = lblname.getText();
            String fname = tffname.getText();
            String dob = labeldob.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = labelaadhar.getText();
            String education =  tfeducation.getText();
            String eid = empid;
            try{
                Conn conn = new Conn();
//
                conn.s.executeUpdate("update employee set fname='"+fname+"' , salary='"+salary+"'  , address='"+address+"' , phone='"+phone+"' , email='"+email+"' , education='"+education+"' where empid ='"+empid+"'");
                JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
                setVisible(false);
                new  Home();
            }catch (Exception e){
                System.out.print("could not add");
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }


    }
}
