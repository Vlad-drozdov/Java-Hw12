import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static String operator = "";

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300,400);
        f.setLayout(new BorderLayout());
        JTextField display = new JTextField();
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

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            JButton b = new JButton(buttonsName[i]);
            panel.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String bText = b.getText();
                    String displayText = display.getText();
                    switch (bText){
                        case "1","2","3","4","5","6","7","8","9","0":
                            display.setText(displayText+bText);
                            break;
                        case "/","*","-","+":
                            operator = bText;
                            numbers.add(Integer.parseInt(displayText));
                            display.setText(operator);
//                        System.out.println(numbers.get(0));
                            break;
                        case "=":
                            if (numbers.size()>=1){
                                numbers.add(Integer.parseInt(displayText));
                                int result = 0;
                                switch (operator){
                                    case"+":
                                        result=numbers.get(0) + numbers.get(1);
                                        break;
                                    case"-":
                                        result=numbers.get(0) - numbers.get(1);
                                        break;
                                    case"/":
                                        result=numbers.get(0) / numbers.get(1);
                                        break;
                                    case"*":
                                        result=numbers.get(0) * numbers.get(1);
                                        break;
                                }
                                numbers.clear();
                                numbers.add(result);
                                display.setText(String.valueOf(result));
                            }

                            break;
                        case "C":
                            display.setText("");
                            numbers.clear();
                            break;
                    }

                }
            });
        }




        f.add(panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

}