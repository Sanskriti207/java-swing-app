import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    double num1, num2, result;

    public CalculatorApp() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-", 
                            "1", "2", "3", "*", "0", "C", "=", "/"};

        for (String text : buttons) {
            JButton b = new JButton(text);
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789".contains(cmd))
            display.setText(display.getText() + cmd);
        else if ("+-*/".contains(cmd)) {
            operator = cmd;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText("" + result);
        } else if (cmd.equals("C")) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}