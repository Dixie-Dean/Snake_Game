import auxiliary.Renderer;

import java.awt.*;

public class GameRenderer implements Renderer {
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(Game.appleX, Game.appleY, Game.UNIT_SIZE, Game.UNIT_SIZE);

        for (int i = 0; i < Game.bodyParts; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(Game.x[i], Game.y[i], Game.UNIT_SIZE, Game.UNIT_SIZE);
            } else {
                graphics.setColor(new Color(45, 150, 0));
                graphics.fillRect(Game.x[i], Game.y[i], Game.UNIT_SIZE, Game.UNIT_SIZE);
            }
        }

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("aerials", Font.BOLD, 20));
        FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(
                "Score: " + Game.applesEaten,
                (Game.SCREEN_WIDTH - metrics.stringWidth("Score: " + Game.applesEaten)) - 5,
                metrics.getFont().getSize()
        );
    }
}
