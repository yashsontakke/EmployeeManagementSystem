import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add , update , view , delete ;
    Home(){
        setLayout(null);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("home.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1200,800);
        add(image);

//        heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(550,20,600,50);
        heading.setFont(new Font("serif",Font.BOLD,40));
        heading.setForeground(Color.WHITE);
        image.add(heading);

//        button
         add = new JButton("Add Employee");
        add.setBounds(600,70,150,50);
        image.add(add);
        add.addActionListener(this);

        view  = new JButton("View Employee's");
        view .setBounds(600,120,150,50);
        image.add(view);
        view.addActionListener(this);

        update = new JButton("update Employee");
        update.setBounds(800,70,150,50);
        image.add(update);
        update.addActionListener(this);

        delete = new JButton("remove Employee");
        delete.setBounds(800,120,150,50);
        image.add(delete);
        delete.addActionListener(this);



        setSize(1200,800);
        setVisible(true);
        setLocation(100,50);
    }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(e.getSource()==update){
            setVisible(false);
            new ViewEmployees();
        }else if(e.getSource()==view) {
            setVisible(false);
            new ViewEmployees();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }

    }
}
