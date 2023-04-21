package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignDialog extends JDialog {

    private JTextField idField;
    private JButton assignButton;

    private int id;
    private String advisoryId;

    public AssignDialog(Frame parent, int id, String advisoryId) {
        super(parent, "Assign Advisor", true);
        this.id = id;
        this.advisoryId = advisoryId;
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("complaint ID: "));
        panel.add(new JLabel(String.valueOf(id)));

        panel.add(new JLabel("Advisor ID: "));
        idField = new JTextField(advisoryId);
        panel.add(idField);

        assignButton = new JButton("Assign");
        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(assignButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public String getAdvisorId() {
        return idField.getText();
    }
}