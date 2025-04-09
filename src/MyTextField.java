import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {

    private String opNow = "";

    public  MyTextField(String opNow) {
        super(opNow);
    }

    public void setOpNow(String opNow) {
        this.opNow = opNow;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font( "Arial",Font.BOLD, 18));
        g.getFontMetrics();
        g.drawString(opNow, (getWidth()-g.getFontMetrics().stringWidth(opNow))-5, (getHeight()/2)-30);
    }
}
