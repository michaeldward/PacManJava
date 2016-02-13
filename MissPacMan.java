import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Michael on 11/26/2014.
 */
public class MissPacMan extends JLabel{
    private final int SIZE = 10;
    private final int LENGTH = 9 *  SIZE, WIDTH = 9 * SIZE;
    Direction direction;
    Direction next;
    private int XPos, YPos, radius;
    private Color color;
    public Image picture = null;
    String UpOpen = "MissPacManUpOpen.png";
    String LeftOpen = "MissPacManLeftOpen.png";
    String RightOpen = "MissPacManRightOpen.png";
    String DownOpen = "MissPacManDownOpen.png";
    String UpClosed = "MissPacManUpClosed.png";
    String LeftClosed = "MissPacManLeftClosed.png";
    String RightClosed = "MissPacManRightClosed.png";
    String DownClosed = "MissPacManDownClosed.png";
    Boolean open = false;


    public MissPacMan(int newXPos, int newYPos, String filename) {
        // this.setText("PacMan");
        direction = Direction.LEFT;
        next = Direction.LEFT;
        //this.setFont(new Font(this.getFont().getName(), Font.PLAIN, 25));
        //this.setSize(100, 100);
        //Image img = new ImageIcon("d://PacManUpOpen.png").getImage();
        //BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        //Graphics g = bufferedImage.createGraphics();
        //g.drawImage(img, 0, 0, null);
        //g.dispose();
        XPos = newXPos;
        YPos = newYPos;
        this.setLocation(XPos, YPos);
        this.setSize(LENGTH, WIDTH);
        color = Color.YELLOW;
        this.setBackground(color);
        //radius = 40;
        setImage(filename);
    }

    public Image getImage(String path){
        Image tempImage = null;
        try {
            URL imageURL = PacMan.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch(Exception e) {
            System.out.println("An error occurred - " + e.getMessage());
        }
        return tempImage;
    }

    public void setImage(String filename) {
        Image picture = getImage(filename);
        Image resizedImage = picture.getScaledInstance(LENGTH, WIDTH, Image.SCALE_SMOOTH);
        Icon imageIcon = new ImageIcon(resizedImage);
        this.setIcon(imageIcon);
    }

    public void changeDirection(Direction newDirection, int change, Barrier barriers[]){
        next = newDirection;
        if(checkBarriers(newDirection, barriers)) {
            direction = newDirection;
        }
    }


    public int getXPos() {
        return XPos;
    }

    public int getYPos() {
        return YPos;
    }

    public void changeLocation(int score, Food food[]) {
        //check to see if location is out of bounds
        if(XPos <= -WIDTH) {
            XPos = 161 * SIZE;
        } else if (XPos >= 161 * SIZE) {
            XPos = -WIDTH;
        }
        this.setLocation(XPos, YPos);
        checkFood(score, food);
    }

    public void openClose(){
        if (direction == Direction.UP) {
            if (open) {
                setImage(UpClosed);
                open = false;
            } else {
                setImage(UpOpen);
                open = true;
            }
        } else if (direction == Direction.DOWN) {
            if (open) {
                setImage(DownClosed);
                open = false;
            } else {
                setImage(DownOpen);
                open = true;
            }
        } else if (direction == Direction.LEFT) {
            if (open) {
                setImage(LeftClosed);
                open = false;
            } else {
                setImage(LeftOpen);
                open = true;
            }
        } else if (direction == Direction.RIGHT) {
            if (open) {
                setImage(RightClosed);
                open = false;
            } else {
                setImage(RightOpen);
                open = true;
            }
        }
    }


    public void move(int change, Barrier barriers[], int score, Food food[]) {
        if(next != direction) {
            if(checkBarriers(next, barriers)) {
                direction = next;
            }
        }
        switch (direction) {
            case UP:
                if (checkBarriers(Direction.UP, barriers)) {
                    YPos -= change;
                    setImage(UpClosed);
                    changeLocation(score, food);
                }
                break;
            case RIGHT:
                if (checkBarriers(Direction.RIGHT, barriers)) {
                    XPos += change;
                    setImage(RightClosed);
                    changeLocation(score, food);
                }
                break;
            case LEFT:
                if (checkBarriers(Direction.LEFT, barriers)) {
                    XPos -= change;
                    setImage(LeftClosed);
                    changeLocation(score, food);
                }
                break;
            case DOWN:
                if (checkBarriers(Direction.DOWN, barriers)) {
                    YPos += change;
                    setImage(DownClosed);
                    changeLocation(score, food);
                }
                break;
        }

    }

    public Boolean checkBarriers(Direction checkDirection, Barrier barriers[]) {
        switch (checkDirection) {
            case UP:
                for (int i = 0; i < 100; ++i) {
                    if(barriers[i] != null) {
                        for (int n = XPos; n < XPos + WIDTH; ++n) {
                            if ((YPos <= barriers[i].YPos + barriers[i].YLength) && (YPos >= barriers[i].YPos) && (n < barriers[i].XPos + barriers[i].XLength) && (n > barriers[i].XPos)) {
                                return false;
                            }
                        }
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < 100; ++i) {
                    if(barriers[i] != null) {
                        for (int n = YPos; n < YPos + LENGTH; ++n) {
                            if ((XPos <= barriers[i].XPos + barriers[i].XLength) && (XPos >= barriers[i].XPos) && (n < barriers[i].YPos + barriers[i].YLength) && (n > barriers[i].YPos)) {
                                return false;
                            }
                        }
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < 100; ++i) {
                    if(barriers[i] != null) {
                        for (int n = XPos; n < XPos + WIDTH; ++n) {
                            if ((YPos + LENGTH >= barriers[i].YPos) && (YPos + LENGTH <= barriers[i].YPos + barriers[i].YLength) && (n < barriers[i].XPos + barriers[i].XLength) && (n > barriers[i].XPos)) {
                                return false;
                            }
                        }
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < 100; ++i) {
                    if(barriers[i] != null) {
                        for (int n = YPos; n < YPos + LENGTH; ++n) {
                            if ((XPos + WIDTH >= barriers[i].XPos) && (XPos + WIDTH <= barriers[i].XPos + barriers[i].XLength) && (n < barriers[i].YPos + barriers[i].YLength) && (n > barriers[i].YPos)) {
                                return false;
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public void checkFood(int score, Food food[]) {
        for (int i = 0; i < 300; ++i) {
            if(food[i] != null) {
                if(food[i].isVisible()) {
                    if (food[i].XPos >= XPos && food[i].XPos <= XPos + WIDTH && food[i].YPos >= YPos && food[i].YPos <= YPos + LENGTH) {
                        food[i].setVisible(false);
                        ++score;
                    }
                }
            }
        }
    }
}
