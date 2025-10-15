import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagementForm extends JFrame implements ActionListener {
    JTextField nameField, deptField, salaryField;
    JButton addButton;
    JTable table;
    DefaultTableModel model;

    public EmployeeManagementForm() {
        setTitle("Employee Management");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        formPanel.add(deptField);

        formPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        formPanel.add(salaryField);

        addButton = new JButton("Add Employee");
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Name", "Department", "Salary"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String dept = deptField.getText();
        String salary = salaryField.getText();

        if (!name.isEmpty() && !dept.isEmpty() && !salary.isEmpty()) {
            model.addRow(new Object[]{name, dept, salary});
            nameField.setText("");
            deptField.setText("");
            salaryField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementForm();
    }
}