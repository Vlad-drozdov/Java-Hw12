import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {

    private String number = "0";

    public  MyTextField(String number) {
        super(number);
    }

    public void setNumber(String number) {
        this.number = number;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font( "Arial",Font.BOLD, 18));
        g.drawString(number, getWidth()/2, 23);
    }
}
