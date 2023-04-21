package client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
  private ViewAll viewall;
  private ViewComplaint comp;
  private ViewQuery viewquery;
    private CardLayout view;
	private JPanel viewpanel;
	private ClientHandler client;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

    public Dashboard(ClientHandler client) {
    	this.client = client;
    	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 704);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		//setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(0, 191, 255));
		menu.setBounds(6, 6, 177, 664);
		menu.setLayout(null);
		
		JTextPane txtpnWelcomePleaseSelect = new JTextPane();
		txtpnWelcomePleaseSelect.setOpaque(false);
		txtpnWelcomePleaseSelect.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnWelcomePleaseSelect.setEditable(false);
		txtpnWelcomePleaseSelect.setText("Sort option");
		txtpnWelcomePleaseSelect.setBounds(6, 75, 163, 35);
		menu.add(txtpnWelcomePleaseSelect);
		
		JButton btnNewButton_1 = new JButton("Query");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.show(viewpanel, "Query");
				
			}
		});
		
		JButton btnNewButton = new JButton("Complaint");
		btnNewButton.setBounds(6, 146, 96, 44);
		menu.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.show(viewpanel, "complain");
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		btnNewButton_1.setBounds(102, 144, 96, 49);
		menu.add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("View All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				view.show(viewpanel, "all");
			}
		});
		btnNewButton_2.setBounds(6, 111, 192, 35);
		menu.add(btnNewButton_2);
		
		
		viewall = new ViewAll(this.client);
		viewquery = new ViewQuery(this.client);
		comp = new ViewComplaint(this.client);
		view = new CardLayout();
		viewpanel = new JPanel(view);
		viewpanel.setBounds(210, 0, 901, 676);
		
		
		viewpanel.add("complain",comp);
		viewpanel.add("Query",viewquery);
		viewpanel.add("all",viewall);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		paneMainContent.setBounds(195, 648, 910, -635);
		menu.add(viewpanel);
		paneMainContent.setLayout(null);
		
		
		
		
		menuClicked(viewall);
		getContentPane().add(menu,BorderLayout.CENTER);
		
		btnNewButton_3 = new JButton("Assign Advior");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assignview Assignview = new Assignview(client);
				Assignview.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(6, 272, 117, 29);
		menu.add(btnNewButton_3);
		
		
		
	}
	
	public void menuClicked(JPanel panel) {
		comp.setVisible(false);
		viewquery.setVisible(false);
		viewall.setVisible(false);
		
		panel.setVisible(true);
	}
}
