import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {

    private final MyTextField display;
    private int num1, num2, result;
    private String operator;
    private JLabel lastActionText;

    UI(){
        super("Title");
        setSize(450,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(450,150));
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(Color.black);




        lastActionText = new JLabel(EFile.loadLastAction());
        lastActionText.setFont(new Font("Arial",Font.BOLD,18));
        lastActionText.setForeground(Color.lightGray);

        display = new MyTextField("");
        display.setHorizontalAlignment(MyTextField.RIGHT);
        display.setPreferredSize(new Dimension(450,100));
        display.setFont(new Font( "Arial",Font.BOLD, 30));
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(null);
        display.setFocusable(false);
        displayPanel.add(Box.createVerticalGlue());
        displayPanel.add(lastActionText, BorderLayout.EAST);
        displayPanel.add(display, BorderLayout.SOUTH);
        add(displayPanel, BorderLayout.NORTH);


        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
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
            b.setBackground(Color.decode("#434343"));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setBorderPainted(false);
            b.setFont(new Font("Arial", Font.BOLD, 36));
            if (buttonsName[i].equals("/")||buttonsName[i].equals("*")||buttonsName[i].equals("-")||buttonsName[i].equals("+")){
                b.setForeground(Color.decode("#FF8C00"));
            }

            panel.add(b);
            b.addActionListener(this);
        }
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "/","*","-","+":
                if (display.getText().isEmpty()){
                    break;
                }
                num1 = Integer.parseInt(display.getText());
                operator = e.getActionCommand();
                display.setText("");
                display.setOpNow(num1+" "+operator);
                break;

            case "=":
                if (display.getText().isEmpty()) {
                    break;
                }
                num2 = Integer.parseInt(display.getText());
                String operation = "";
                switch (operator){
                    case"+":
                        result = num1 + num2;
                        operation = num1+" + "+num2;
                        break;
                    case"-":
                        result = num1 - num2;
                        operation = num1+" - "+num2;
                        break;
                    case"*":
                        result = num1 * num2;
                        operation = num1+" * "+num2;
                        break;
                    case"/":
                        result = num1 / num2;
                        operation = num1+" : "+num2;
                        break;
                }
                EFile.save("" + result, operation);
                display.setText(String.valueOf(result));
                display.setOpNow(num1+" "+operator+" "+num2);
                num1 = result;
                lastActionText.setText(EFile.loadLastAction());
                break;

            case "C":
                num1 = 0;
                num2 = 0;
                result = 0;
                operator = "";
                display.setText("");
                break;
            default:
                if (display.getText().equals("0")){
                    display.setText("");
                }
                display.setText(display.getText()+e.getActionCommand());
                break;

        }
    }
}
