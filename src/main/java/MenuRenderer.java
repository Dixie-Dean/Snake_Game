import auxiliary.Renderer;

import java.awt.*;

public class MenuRenderer implements Renderer {
    public final int HEIGHT = 80;
    public final int WIDTH = 300;
    public final int X = 150;

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        //title
        Font fontTitle = new Font("Aerials", Font.BOLD, 70);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.ORANGE);
        FontMetrics metrics = graphics.getFontMetrics(fontTitle);
        graphics.drawString("Snake Game", (Game.SCREEN_WIDTH - metrics.stringWidth("Snake Game")) / 2, 100);

        //buttons
        Font fontBTN = new Font("Aerials", Font.BOLD, 30);

        Rectangle playButton = new Rectangle(X, 200, WIDTH, HEIGHT);
        graphics2D.draw(playButton);
        graphics.setFont(fontBTN);
        graphics.drawString(
                "PLAY",
                (Game.SCREEN_WIDTH - (metrics.stringWidth("PLAY")) / 2) / 2,
                250
        );
    }
}
