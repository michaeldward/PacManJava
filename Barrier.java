import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 11/30/2014.
 */
public class Barrier extends JLabel {
    int XPos, YPos, XLength, YLength;
    Color color;

    public Barrier(int newXPos, int newYPos, int newXLength, int newYLength, Color newColor) {
        XPos = newXPos;
        YPos = newYPos;
        XLength = newXLength;
        YLength = newYLength;

        this.setSize(XLength, YLength);
        this.setLocation(XPos, YPos);
        this.setOpaque(true);
        this.setBackground(newColor);
    }
}
