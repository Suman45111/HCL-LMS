package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener {
	Choice cEmpId;
	JButton delete, back;
	RemoveEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblempId = new JLabel("Employee Id");
		lblempId.setBounds(50, 50, 100, 30);
		add(lblempId);

		cEmpId = new Choice();
		cEmpId.setBounds(200, 50, 150, 30);
		add(cEmpId);

		try {
			Conn c = new Conn();
			String query = "select * from employee";
			ResultSet rs = c.e.executeQuery(query);
			while(rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(50, 100, 100, 30);
		add(lblname);

		JLabel labelname = new JLabel();
		labelname.setBounds(200, 100, 100, 30);
		add(labelname);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(50, 150, 100, 30);
		add(lblphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(200, 150, 100, 30);
		add(labelphone);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(50, 200, 100, 30);
		add(lblemail);

		JLabel labelEmail = new JLabel();
		labelEmail.setBounds(200, 200, 1000, 30);
		add(labelEmail);

		try {
			Conn c = new Conn();
			String query = "select * from employee where empId ='"+cEmpId.getSelectedItem()+"'";
			ResultSet rs = c.e.executeQuery(query);
			while(rs.next()) {
				labelname.setText(rs.getString("name"));
				labelphone.setText(rs.getString("phone"));
				labelEmail.setText(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		cEmpId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					String query = "select * from employee where empId ='"+cEmpId.getSelectedItem()+"'";
					ResultSet rs = c.e.executeQuery(query);
					while(rs.next()) {
						labelname.setText(rs.getString("name"));
						labelphone.setText(rs.getString("phone"));
						labelEmail.setText(rs.getString("email"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		delete = new JButton("Delete");
		delete.setBounds(80, 300, 100, 30);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("Back");
		back.setBounds(220, 300, 100, 30);
		back.addActionListener(this);
		add(back);
		
		setSize(1000,400);
		setLocation(300,150);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== delete) {
			try {
				Conn c = new Conn();
				String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
				c.e.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Information successfully deleted");
				setVisible(false);
				new Home();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Home();
		}

	}
	public static void main(String args[]) {
		new RemoveEmployee();
	}

}
