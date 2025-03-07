import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {

    private final MyTextField display;
    private int num1, num2, result;
    private String operator;

    UI(){
        super("Title");
        setSize(450,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new MyTextField("");
        display.setHorizontalAlignment(MyTextField.RIGHT);
        display.setFont(new Font( "Arial",Font.BOLD, 30));
        display.setBackground(Color.GRAY);
        display.setForeground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel);
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
            b.addActionListener(this);
        }
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            default:
                if (display.getText().equals("0")){
                    display.setText("");
                }
                display.setText(display.getText()+e.getActionCommand());
                break;

            case "/","*","-","+":
                num1 = Integer.parseInt(display.getText());
                operator = e.getActionCommand();
                display.setText("");
                display.setNumber(num1+" "+operator);
                break;

            case "=":
                num2 = Integer.parseInt(display.getText());
                switch (operator){
                    case"+":
                        result = num1 + num2;
                        break;
                    case"-":
                        result = num1 - num2;
                        break;
                    case"*":
                        result = num1 * num2;
                        break;
                    case"/":
                        result = num1 / num2;
                        break;
                }
                display.setText(String.valueOf(result));
                display.setNumber(String.valueOf(result));
                num1 = result;
                break;

            case "C":
                num1 = 0;
                num2 = 0;
                result = 0;
                operator = "";
                display.setText("");
                break;
        }
    }
}
