import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number  = ran.nextInt(999999);
    JButton back ,add;
    JTextField tfname , tffname , tfsalary,  tfaddress,  tfphone, tfemail, tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel  labeleidn ;

    AddEmployee(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name :-");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);


        tfname = new JTextField();
        tfname.setBounds(225,150,250,30);
        add(tfname);


//        fathers name
        JLabel  labelfname = new JLabel("Fathers Name :-");
        labelfname.setBounds(50,200,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);


        tffname = new JTextField();
        tffname.setBounds(225,200,250,30);
        add(tffname);

//        date of birth

        JLabel  labeldob = new JLabel("Date of Birth:-");
        labeldob.setBounds(50,250,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);


        dcdob = new JDateChooser();
        dcdob.setBounds(225,250,250,30);
        add(dcdob);

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

        String courses []  = {"BBA" , "BCA " , "B.COM" , "BA" , "MBA" , "BSC", "MCA" ,"M.COM" ,"MA" , "B.Tech" , "M.tech" ,"MSC" ,"Ph.d" , "M.B.B.S" , "M.D" ,"Super Specialist"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(225,500,150,30);
        add(cbeducation);

//      aadhar number
        JLabel  labelaadhar = new JLabel("Aadhar Number :- ");
        labelaadhar.setBounds(50,550,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);


        tfaadhar = new JTextField();
        tfaadhar.setBounds(225,550,250,30);
        add(tfaadhar);

//       Employee id
        JLabel  labeleid = new JLabel("Employee Id :- ");
        labeleid.setBounds(50,600,150,30);
        labeleid.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleid);

        labeleidn = new JLabel(number+"");
        labeleidn.setBounds(225,600,150,30);
        add(labeleidn);

        //button add
        add = new JButton("Add Employee");
        add.setBounds(400,650,150,50);
        add.setBackground(Color.BLACK);
        add.setOpaque(true);
        add.setBorderPainted(false);
        add.setForeground(Color.WHITE);
        add(add);
        add.addActionListener(this);

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
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent Ae) {
        if(Ae.getSource()== add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String education = (String)cbeducation.getSelectedItem();
            String eid = labeleidn.getText();

            try{
                Conn conn = new Conn();
                conn.s.executeUpdate ("insert into employee "
                        + "(name, fname, dob,salary , address , phone , email , aadhar , education , empid )"
                        + "values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+education+"','"+eid+"')");
//                String query = "insert into employee ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+education+"','"+eid+"')";
//                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Successfully added");
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
