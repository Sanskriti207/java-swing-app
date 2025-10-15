import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSimulation extends JFrame implements ActionListener {
    JPasswordField pinField;
    JButton loginButton, checkBalBtn, depositBtn, withdrawBtn;
    JLabel message;
    double balance = 5000.0;
    final String PIN = "1234";

    public ATMSimulation() {
        setTitle("ATM Simulation");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter PIN:"));
        pinField = new JPasswordField(10);
        add(pinField);

        loginButton = new JButton("Login");
        add(loginButton);

        message = new JLabel("");
        add(message);

        loginButton.addActionListener(this);
        setVisible(true);
    }

    public void showMenu() {
        getContentPane().removeAll();
        setLayout(new GridLayout(4, 1, 10, 10));

        checkBalBtn = new JButton("Check Balance");
        depositBtn = new JButton("Deposit ₹1000");
        withdrawBtn = new JButton("Withdraw ₹1000");

        add(checkBalBtn);
        add(depositBtn);
        add(withdrawBtn);

        checkBalBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);

        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enteredPin = new String(pinField.getPassword());
            if (enteredPin.equals(PIN)) showMenu();
            else message.setText("Incorrect PIN!");
        } 
        else if (e.getSource() == checkBalBtn)
            JOptionPane.showMessageDialog(this, "Balance: ₹" + balance);
        else if (e.getSource() == depositBtn) {
            balance += 1000;
            JOptionPane.showMessageDialog(this, "Deposited ₹1000. New Balance: ₹" + balance);
        } 
        else if (e.getSource() == withdrawBtn) {
            if (balance >= 1000) balance -= 1000;
            JOptionPane.showMessageDialog(this, "Withdrawn ₹1000. New Balance: ₹" + balance);
        }
    }

    public static void main(String[] args) {
        new ATMSimulation();
    }
}
