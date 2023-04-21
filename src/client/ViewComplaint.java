package client;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.ComplaintsAndQueries;
import domain.ComplaintsAndQueriesTable;

public class ViewComplaint extends JPanel {

	/**
	 * Create the panel.
	 * @param client 
	 */
	public ViewComplaint(ClientHandler client) {
		setBounds(0, 0, 981, 581);
		setLayout(null);
		
		
		client.sendAction("Get All Complaints");
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
			
			JScrollPane scrollPane = new JScrollPane(complaintsTable);
			scrollPane.setBounds(6, 6, 969, 569);
			add(scrollPane);
		
		


	}

}
