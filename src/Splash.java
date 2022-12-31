import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends  JFrame  implements ActionListener {
    Splash(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel heading = new JLabel("Employee Management System ");
        heading.setBounds(200,30,1200,65);
        heading.setFont(new Font("serif" , Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("startimg.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,100,1050,500);
        add(image);

//        button
        JButton click = new JButton("Click Here To Continue ");
        click.setBounds(400,400,300,70);
        click.addActionListener(this);
        image.add(click);

        setSize(1170,690);
        setVisible(true);
        setLocation(100,50);

        while(true){
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
        }


    }

    public static void main(String[] args) {
        new  Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
