import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

public class InventoryManagementSystem {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtID, txtName, txtQuantity, txtPrice;

    public InventoryManagementSystem() {
        frame = new JFrame("Inventory Management System");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblID = new JLabel("Item ID:");
        lblID.setBounds(20, 20, 100, 25);
        frame.add(lblID);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 60, 100, 25);
        frame.add(lblName);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(20, 100, 100, 25);
        frame.add(lblQuantity);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 140, 100, 25);
        frame.add(lblPrice);

        // Text fields
        txtID = new JTextField();
        txtID.setBounds(120, 20, 150, 25);
        frame.add(txtID);

        txtName = new JTextField();
        txtName.setBounds(120, 60, 150, 25);
        frame.add(txtName);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 100, 150, 25);
        frame.add(txtQuantity);

        txtPrice = new JTextField();
        txtPrice.setBounds(120, 140, 150, 25);
        frame.add(txtPrice);

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(300, 20, 100, 25);
        frame.add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(300, 60, 100, 25);
        frame.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(300, 100, 100, 25);
        frame.add(btnDelete);

        // Table
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Item ID", "Name", "Quantity", "Price"});
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 200, 640, 150);
        frame.add(scroll);

        // Add button action
        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{
                    txtID.getText(),
                    txtName.getText(),
                    txtQuantity.getText(),
                    txtPrice.getText()
            });
            clearFields();
        });

        // Update button action
        btnUpdate.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.setValueAt(txtID.getText(), selectedRow, 0);
                model.setValueAt(txtName.getText(), selectedRow, 1);
                model.setValueAt(txtQuantity.getText(), selectedRow, 2);
                model.setValueAt(txtPrice.getText(), selectedRow, 3);
                System.out.println("Updated row: " + selectedRow);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row to update");
            }
        });

        // Delete button action
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
                System.out.println("Deleted row: " + selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row to delete");
            }
        });

        // Table click to load data into text fields
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                txtID.setText(model.getValueAt(selectedRow, 0).toString());
                txtName.setText(model.getValueAt(selectedRow, 1).toString());
                txtQuantity.setText(model.getValueAt(selectedRow, 2).toString());
                txtPrice.setText(model.getValueAt(selectedRow, 3).toString());
            }
        });

        frame.setVisible(true);
    }

    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }

    public static void main(String[] args) {
        new InventoryManagementSystem();
    }
}

