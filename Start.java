import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael on 12/6/2014.
 */
public class Start extends JFrame implements ActionListener {
    private final int SIZE = 10;


    private JButton startButton;
    private JRadioButton singlePlayer;
    private JRadioButton twoPlayer;
    private JComboBox playerSelect;
    private ButtonGroup group;

    Start(){
        super();
        this.setSize(50 * SIZE, 100 * SIZE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Main Menu");
        startButton = new JButton("Start");
        startButton.setSize(15 * SIZE, 8 *  SIZE);
        startButton.setLocation(10 * SIZE, 10 * SIZE);
        Font startFont = new Font(startButton.getFont().getName(), Font.BOLD, 2 * SIZE);
        startButton.setFont(startFont);
        singlePlayer = new JRadioButton("Single Player");
        singlePlayer.setFont(startFont);
        twoPlayer = new JRadioButton("Two Player");
        twoPlayer.setFont(startFont);
        playerSelect = new JComboBox();
        playerSelect.setFont(startFont);
        playerSelect.addItem("PacMan");
        playerSelect.addItem("Miss PacMan");
        singlePlayer.setSize(20 * SIZE, 5 * SIZE);
        singlePlayer.setLocation(10 * SIZE, 22 * SIZE);
        twoPlayer.setSize(20 * SIZE, 5 * SIZE);
        twoPlayer.setLocation(10 * SIZE, 30 * SIZE);
        playerSelect.setSize(20 * SIZE, 5 * SIZE);
        playerSelect.setLocation(10 * SIZE, 37 * SIZE);
        group = new ButtonGroup();
        group.add(singlePlayer);
        group.add(twoPlayer);
        singlePlayer.setSelected(true);

        Container pane = this.getContentPane();
        pane.add(startButton);
        pane.add(singlePlayer);
        pane.add(twoPlayer);
        pane.add(playerSelect);

        this.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(singlePlayer.isSelected()) {
                    if(playerSelect.getSelectedIndex() == 0) {
                        GUI gui = new GUI(0);
                    }
                    if(playerSelect.getSelectedIndex() == 1) {
                        GUI gui = new GUI(1);
                    }
                } else {
                    GUI gui = new GUI(2);
                }

            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    }

}
