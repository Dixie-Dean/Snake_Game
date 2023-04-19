import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    private final static int PANEL_SIZE = 300;

    public Menu() {
        JFrame menuFrame = new JFrame();

        JLabel label = new JLabel("Press the button to start the game");

        JButton startingButton = new JButton("Start");
        startingButton.addActionListener(this);

        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(BorderFactory.createEmptyBorder(PANEL_SIZE, PANEL_SIZE, PANEL_SIZE, PANEL_SIZE));
        menuPanel.setLayout(new GridLayout());
        menuPanel.add(label);
        menuPanel.add(startingButton);

        menuFrame.add(menuPanel, BorderLayout.CENTER);
        menuFrame.setTitle("Main Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GameFrame();
    }
}
