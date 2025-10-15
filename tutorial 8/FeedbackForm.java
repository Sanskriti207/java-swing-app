import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackForm extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4, r5;
    JTextArea comments;
    JButton submitButton;

    public FeedbackForm() {
        setTitle("Online Feedback Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Rate our service (1-5 stars):"));

        ButtonGroup group = new ButtonGroup();
        r1 = new JRadioButton("1 ★");
        r2 = new JRadioButton("2 ★★");
        r3 = new JRadioButton("3 ★★★");
        r4 = new JRadioButton("4 ★★★★");
        r5 = new JRadioButton("5 ★★★★★");
        group.add(r1); group.add(r2); group.add(r3); group.add(r4); group.add(r5);

        add(r1); add(r2); add(r3); add(r4); add(r5);

        add(new JLabel("Comments:"));
        comments = new JTextArea(5, 30);
        add(new JScrollPane(comments));

        submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String rating = "";
        if (r1.isSelected()) rating = "1 Star";
        else if (r2.isSelected()) rating = "2 Stars";
        else if (r3.isSelected()) rating = "3 Stars";
        else if (r4.isSelected()) rating = "4 Stars";
        else if (r5.isSelected()) rating = "5 Stars";

        JOptionPane.showMessageDialog(this,
                "Thank you for your feedback!\nRating: " + rating +
                        "\nComments: " + comments.getText());
    }

    public static void main(String[] args) {
        new FeedbackForm();
    }
}