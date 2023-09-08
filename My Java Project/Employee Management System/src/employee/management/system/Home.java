package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	JButton add, view, update, remove;
	Home(){
		
		

		setLayout(null);

		ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\My Java Project\\Employee Management System\\icons\\home.jpg");
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1120, 630);
		add(image);

		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(600, 0, 500, 100);//Used for set dimension
		heading.setFont(new Font("Raleway", Font.BOLD, 25));
		image.add(heading);
		
		add = new JButton("Add Employee");
        add.setBounds(600, 120, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(770, 120, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(600, 180, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(770, 180, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

		setSize(1120,630);
		setLocation(250,100);
		setVisible(true);


	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == add) {
			setVisible(false);
			new AddEmployee();
			
		}else if (ae.getSource() == view) {
			setVisible(false);
			new ViewEmployees();
			
		}else if (ae.getSource() == update) {
			setVisible(false);
			new ViewEmployees();
			
		}else {
			setVisible(false);
			new RemoveEmployee();
		}
		
	}

	public static void main(String[] args) {
		new Home();

	}

}
