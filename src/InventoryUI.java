package ui;

import dao.ItemDAOImpl;
import model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Swing GUI for Inventory Management.
 * Includes responsiveness and usability features.
 */
public class InventoryUI extends JFrame {
    ItemDAOImpl dao = new ItemDAOImpl();
    JTable table;
    DefaultTableModel model;

    public InventoryUI() {
        setTitle("Inventory Manager");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Qty", "Price"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        JButton addBtn = new JButton("Add Item");
        JButton delBtn = new JButton("Delete Item");

        addBtn.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Item Name:");
                int qty = Integer.parseInt(JOptionPane.showInputDialog("Quantity:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                dao.addItem(new Item(name, qty, price));
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        delBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = (int) model.getValueAt(row, 0);
                dao.deleteItem(id);
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Select a row first.");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(addBtn);
        panel.add(delBtn);

        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        loadData();
        setVisible(true);
    }

    private void loadData() {
        model.setRowCount(0);
        List<Item> items = dao.getAllItems();
        for (Item i : items) {
            model.addRow(new Object[]{i.getId(), i.getName(), i.getQuantity(), i.getPrice()});
        }
    }
}
