import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 12/6/2014.
 */
public class Food extends JLabel{
    int XPos, YPos;


    public Food(int newXPos, int newYPos) {
        XPos = newXPos;
        YPos = newYPos;

        this.setSize(10, 10);
        this.setFont(new Font(this.getFont().getName(), this.getFont().getStyle(), 20));
        this.setText(".");
        this.setLocation(XPos, YPos);
        this.setOpaque(true);
        this.setForeground(Color.WHITE);
    }

}
