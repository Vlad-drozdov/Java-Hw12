import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300,400);
        f.setLayout(new BorderLayout());
        JTextField display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font( "",Font.BOLD, 30));
        f.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));
        String[] buttonsName = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };
        for (int i = 0; i < 16; i++) {
            JButton b = new JButton(buttonsName[i]);
            panel.add(b);
        }
        f.add(panel);
        f.setVisible(true);


    }

}