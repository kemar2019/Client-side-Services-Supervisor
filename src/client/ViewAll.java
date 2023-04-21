package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.ComplaintsAndQueries;
import domain.ComplaintsAndQueriesTable;
import javax.swing.JLabel;

public class ViewAll extends JPanel {

	/**
	 * Create the panel.
	 * @param client 
	 */
	public ViewAll(ClientHandler client) {
		setBounds(0, 0, 981, 581);
		setLayout(null);
		
		
		 client.sendAction("Get All Complaint_Query");
		 List<ComplaintsAndQueries> resp = client.receiveObject();
		 
		// Create complaints table
	        ComplaintsAndQueriesTable tableCreator = new ComplaintsAndQueriesTable(resp);
	        JTable complaintsTable = tableCreator.createTable();
	        complaintsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one row to be selected at a time
	        
	     // Add a listener to detect when a row is selected
	        complaintsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    int selectedRow = complaintsTable.getSelectedRow();
	                    if (selectedRow >= 0) {
	                    	 int id = (Integer) complaintsTable.getValueAt(selectedRow, 0);
	                    	    AssignDialog assignDialog = new AssignDialog(null, id, "");
	                    	    assignDialog.setVisible(true);
	                    }
	                }
	            }
	        });
	        
	        int unresolvedCount = 0;
	        int resolvedCount = 0;

	        for (int i = 0; i < complaintsTable.getRowCount(); i++) {
	            String resolved = (String) complaintsTable.getValueAt(i, complaintsTable.getColumn("Resolved").getModelIndex());
	            if (resolved == null || resolved.isEmpty()) {
	                unresolvedCount++;
	            } else {
	                resolvedCount++;
	            }
	        }
		
		JScrollPane scrollPane = new JScrollPane(complaintsTable);
		scrollPane.setBounds(6, 6, 969, 502);
		add(scrollPane);
		
		JLabel statusLabel = new JLabel();
		statusLabel.setBounds(42, 540, 212, 16);
		// Set the text of the status label based on the count variables
		statusLabel.setText("Resolved: " + resolvedCount + "  Unresolved: " + unresolvedCount);
		add(statusLabel);
		

	}
}
