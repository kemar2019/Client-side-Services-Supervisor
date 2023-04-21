package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.ClientHandler;
import domain.ComplaintsAndQueries;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Assignview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ClientHandler client;
	private ComplaintsAndQueries cq;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignview frame = new Assignview(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Assignview(ClientHandler Client) {
		this.client = client; 
		cq = new ComplaintsAndQueries();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Advisor ID:");
		lblNewLabel.setBounds(22, 59, 87, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("complain or Query #:");
		lblNewLabel_1.setBounds(22, 111, 154, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(209, 54, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 106, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
					String stu = textField.getText();
					String pass = textField_1.getText();
					cq.setId(stu);
					cq.setAdvisorId(pass);
					client.sendAction("Assign Advisor");
					client.Assign(cq);
					
					}catch(Exception ex){
					
						
					}
				
				
			}
		});
		btnNewButton.setBounds(154, 190, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Assign Advisor");
		lblNewLabel_2.setBounds(157, 6, 146, 16);
		contentPane.add(lblNewLabel_2);
	}
}
