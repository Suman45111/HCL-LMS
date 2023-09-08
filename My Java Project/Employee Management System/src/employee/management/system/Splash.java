package employee.management.system;

 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 

public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.WHITE);//BG Color
        setLayout(null);//Remove the already build layout

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(90, 30, 1200, 60);//Used for set dimension
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\My Java Project\\Employee Management System\\icons\\front.jpg");
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(95, 100, 1000, 550);
        add(image);


        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(460, 550, 300, 70);
        //clickhere.setBackground(Color.BLACK);
        //clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        add(clickhere);

        setSize(1200,750); //Size of the Frame(length, Breath)
        setLocation(200, 50); //display location(from left, from top) 
        setVisible(true);//It will allow visibility of the frame

        while(true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch(Exception e) {

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }
            catch(Exception e) {

            }
        }
    }

    public void actionPerformed(ActionEvent as) {
        setVisible(false);
        new Login();

    }
    public static void main(String args[]) {
        new Splash();

    }

 

}