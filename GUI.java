import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by Michael on 11/17/2014.
 *
 */



public class GUI extends JFrame implements ActionListener, KeyListener {
    int mode;
    //0 for single player PacMan, 1 for single player MissPacMan, 2 for double player
    int score = 0;
    public final int SIZE = 10;
    public final int WIDTH = 161 * SIZE, HEIGHT = 150 * SIZE;
    public final int MOVEDIST = SIZE;

    private PacMan pacman;
    private MissPacMan misspacman;
    private JTextField input;
    private Barrier barrier[] = new Barrier[100];
    private Food food[] = new Food[300];

    public GUI(int inputInt){
        super();
        mode = inputInt;
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setTitle("PacMan");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Image img = new ImageIcon("d://PacManUpOpen.png").getImage();
        // BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        // Graphics g = bufferedImage.createGraphics();
        // g.drawImage(img, 0, 0, null);
        //g.dispose();

        pacman = new PacMan(SIZE, SIZE, "PacManLeftClosed.png");
        misspacman = new MissPacMan(SIZE, SIZE, "MissPacManLeftClosed.png");
        for (int i = 0; i < 100; ++i){
            barrier[i] = null;
        }
        for (int i = 0; i < 300; ++i) {
            food[i] = null;
        }
        barrier[1] = new Barrier(0, 0, SIZE, 61 * SIZE, Color.GREEN);
        barrier[2] = new Barrier(0, 0, WIDTH, SIZE, Color.GREEN);
        barrier[3] = new Barrier(0, HEIGHT - 7 * SIZE, WIDTH, 10, Color.GREEN);
        barrier[4] = new Barrier(WIDTH - 2 * SIZE, 0, SIZE, 60 * SIZE, Color.GREEN);
        //barrier[5] = new Barrier(10 * SIZE, 10 * SIZE, 50 * SIZE, SIZE, Color.BLUE);
        barrier[6] = new Barrier(10 * SIZE, 10 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[7] = new Barrier(10 * SIZE, 40 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[8] = new Barrier(10 * SIZE, 40 * SIZE, 40 * SIZE, SIZE, Color.GREEN);
        barrier[9] = new Barrier(60 * SIZE, 40 * SIZE, 50 * SIZE, SIZE, Color.GREEN);
        barrier[10] = new Barrier(10 * SIZE, 30 * SIZE, 50 * SIZE, SIZE, Color.GREEN);
        barrier[11] = new Barrier(70 * SIZE, 30 * SIZE, 40 * SIZE, SIZE, Color.GREEN);
        barrier[12] = new Barrier(60 * SIZE, 10 * SIZE, SIZE, 21 * SIZE, Color.GREEN);
        barrier[13] = new Barrier(70 * SIZE, 10 * SIZE, SIZE, 21 * SIZE, Color.GREEN);
        barrier[14] = new Barrier(70 * SIZE, 10 * SIZE, 20 * SIZE, SIZE, Color.GREEN);
        barrier[15] = new Barrier(60 * SIZE, 40 * SIZE, SIZE, 10 * SIZE, Color.GREEN);
        barrier[16] = new Barrier(50 * SIZE, 40 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[17] = new Barrier(30 * SIZE, 60 * SIZE, 21 * SIZE, SIZE, Color.GREEN);
        barrier[18] = new Barrier(30 * SIZE, 50 * SIZE, SIZE, 10 * SIZE, Color.GREEN);
        barrier[19] = new Barrier(30 * SIZE, 50 * SIZE, 11 * SIZE, SIZE, Color.GREEN);
        barrier[20] = new Barrier(10 * SIZE, 60 * SIZE, 10 * SIZE, SIZE, Color.GREEN);
        barrier[21] = new Barrier(20 * SIZE, 40 * SIZE, SIZE, 10 * SIZE, Color.GREEN);
        barrier[22] = new Barrier(0, 70 * SIZE, 50 * SIZE, SIZE, Color.GREEN);
        barrier[23] = new Barrier(50 * SIZE, 70 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[24] = new Barrier(60 * SIZE, 60 * SIZE, SIZE, 40 * SIZE, Color.GREEN);
        barrier[25] = new Barrier(60 * SIZE, 60 * SIZE, 10 * SIZE, SIZE, Color.GREEN);
        barrier[26] = new Barrier(40 * SIZE, 90 * SIZE, 11 * SIZE, SIZE, Color.GREEN);
        barrier[27] = new Barrier(40 * SIZE, 100 * SIZE, 11 * SIZE, SIZE, Color.GREEN);
        barrier[28] = new Barrier(50 * SIZE, 100 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[29] = new Barrier(0, 120 * SIZE, 51 * SIZE, SIZE, Color.GREEN);
        barrier[30] = new Barrier(60 * SIZE, 100 * SIZE, 70 * SIZE, SIZE, Color.GREEN);
        barrier[31] = new Barrier(60 * SIZE, 110 * SIZE, 60 * SIZE, SIZE, Color.GREEN);
        barrier[32] = new Barrier(60 * SIZE, 110 * SIZE, SIZE, 40 * SIZE, Color.GREEN);
        barrier[33] = new Barrier(70 * SIZE, 60 * SIZE, SIZE, 20 * SIZE, Color.GREEN);
        barrier[34] = new Barrier(70 * SIZE, 80 * SIZE, 40 * SIZE, SIZE, Color.GREEN);
        barrier[35] = new Barrier(70 * SIZE, 90 * SIZE, 70 * SIZE, SIZE, Color.GREEN);
        barrier[36] = new Barrier(130 * SIZE, 110 * SIZE, 40 * SIZE, SIZE, Color.GREEN);
        barrier[37] = new Barrier(140 * SIZE, 70 * SIZE, SIZE, 21 * SIZE, Color.GREEN);
        barrier[38] = new Barrier(110 * SIZE, 60 * SIZE, SIZE, 21 * SIZE, Color.GREEN);
        barrier[39] = new Barrier(120 * SIZE, 70 * SIZE, 40 * SIZE, SIZE, Color.GREEN);
        barrier[40] = new Barrier(120 * SIZE, 80 * SIZE, 20 * SIZE, SIZE, Color.GREEN);
        barrier[41] = new Barrier(110 * SIZE, 60 * SIZE, 50 * SIZE, SIZE, Color.GREEN);
        barrier[42] = new Barrier(160 * SIZE, 50 * SIZE, SIZE, 10 * SIZE, Color.GREEN);
        barrier[43] = new Barrier(WIDTH - 2 * SIZE, 70 * SIZE, SIZE, 80 * SIZE, Color.GREEN);
        barrier[44] = new Barrier(0, 70 * SIZE, SIZE, 80 * SIZE, Color.GREEN);
        barrier[45] = new Barrier(-100 * SIZE, 70 * SIZE, 100 * SIZE, SIZE, Color.GREEN);
        barrier[46] = new Barrier(-100 * SIZE, 60 * SIZE, 100 * SIZE, SIZE, Color.GREEN);
        barrier[47] = new Barrier(WIDTH, 60 * SIZE, 100 * SIZE, SIZE, Color.GREEN);
        barrier[48] = new Barrier(WIDTH, 70 * SIZE, 100 * SIZE, SIZE, Color.GREEN);
       //barrier[98] = new Barrier(500, 200, 100, 50, new Color(248, 103, 97));
        //barrier[99] = new Barrier(50, 50, 100, 100, new Color(155, 116, 190));


        int placeHeight = 5 * SIZE, placeWidth = 5 * SIZE;
        for (int i = 0; i < 300 && placeWidth != 155; ++i) {
            if (placeHeight == 155 * SIZE) {
                placeHeight = 5 * SIZE;
                placeWidth += 10 * SIZE;
            }
            food[i] = new Food(placeWidth, placeHeight);
            placeHeight += 10 * SIZE;
        }



        input = new JTextField("");
        addKeyListener(this);
        input.setVisible(false);
        input.setSize(100, 50);
        input.setLocation(0, 0);
        //input.addKeyListener(this);

        Container pane = this.getContentPane();
        pane.setBackground(Color.BLACK);
        if(mode == 0 || mode == 2) {
            pane.add(pacman);
        }
        if (mode == 1 || mode == 2) {
            pane.add(misspacman);
        }

        pane.add(input);

        for (int i = 0; i < 100; ++i) {
            if (barrier[i] != null) {
                pane.add(barrier[i]);
            }
        }
        for (int i = 0; i < 300; ++i) {
            if(food[i] != null) {
                pane.add(food[i]);
            }
        }
        //paint(this.getGraphics(), pacman);
        Timer redrawTimer = new Timer(30, this);
        redrawTimer.setInitialDelay(100);
        redrawTimer.start();

    /*
    Timer openCloseTimer = new Timer(60, this);
    openCloseTimer.setInitialDelay(100);
    openCloseTimer.start();
    openCloseTimer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pacman.openClose();
        }
    });
    */
        this.requestFocus();
    }
/*
    public void paint(Graphics g) {
        if(pacman.picture != null) {
            Graphics2D g2 = (Graphics2D) g;
            int red = (int)(Math.random() * 256);
            int green = (int)(Math.random() * 256);
            int blue = (int)(Math.random() * 256);
            g2.setColor(new Color(red, green, blue));
            g2.fillRect(500, 500, 100, 100);
            red = (int)(Math.random() * 256);
            green = (int)(Math.random() * 256);
            blue = (int)(Math.random() * 256);
            g2.setColor(new Color(red, green, blue));
            g2.fillOval(300, 300, 100, 100);
            g2.drawImage(pacman.picture, pacman.getXPos(), pacman.getYPos(), 50, 50, this);
        }

    }
    */

    @Override
    public void actionPerformed(ActionEvent e){
        redraw();
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(mode == 0 || mode == 2) {
            if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                pacman.changeDirection(Direction.LEFT, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                pacman.changeDirection(Direction.RIGHT, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                pacman.changeDirection(Direction.UP, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                pacman.changeDirection(Direction.DOWN, MOVEDIST, barrier);
            }
        }
        if (mode == 1 || mode == 2) {
            if (e.getExtendedKeyCode() == KeyEvent.VK_A) {
                misspacman.changeDirection(Direction.LEFT, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_D) {
                misspacman.changeDirection(Direction.RIGHT, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_W) {
                misspacman.changeDirection(Direction.UP, MOVEDIST, barrier);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_S) {
                misspacman.changeDirection(Direction.DOWN, MOVEDIST, barrier);
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    public void redraw(){
        if(mode == 0 || mode == 2) {
            pacman.move(MOVEDIST, barrier, score, food);
            pacman.openClose();
        }
        if (mode == 1 || mode == 2) {
            misspacman.move(MOVEDIST, barrier, score, food);
            misspacman.openClose();
        }
        for (int i = 0; i < 300; ++i) {
            int int1 = (int) (Math.random() * (double) 256);
            int int2 = (int) (Math.random() * (double) 256);
            int int3 = (int) (Math.random() * (double) 256);
            food[i].setBackground(new Color(int1, int2, int3));
        }
        int int1 = (int) (Math.random() * (double) 256);
        int int2 = (int) (Math.random() * (double) 256);
        int int3 = (int) (Math.random() * (double) 256);
        for (int i = 0; i < 100; ++i) {
            if(barrier[i] != null) {
                barrier[i].setBackground(new Color(int1, int2, int3));
            }
        }

    }
}
