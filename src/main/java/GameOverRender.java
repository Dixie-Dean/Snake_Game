import auxiliary.Renderer;

import java.awt.*;

public class GameOverRender implements Renderer {

    @Override
    public void render(Graphics graphics) {
        drawGameOver(graphics);
        drawScore(graphics);
        drawExitBtn(graphics);
    }

    private void drawGameOver(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("aerials", Font.BOLD, 70));
        FontMetrics metricsGO = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(
                "Game Over",
                (Game.SCREEN_WIDTH - metricsGO.stringWidth("Game Over")) / 2,
                100
        );
    }

    private void drawScore(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("aerials", Font.BOLD, 40));
        FontMetrics metricsScore = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(
                "Your Score: " + Game.applesEaten,
                (Game.SCREEN_WIDTH - metricsScore.stringWidth("Your Score: " + Game.applesEaten)) / 2,
                200
        );
    }

    private void drawExitBtn(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        Font fontBTN = new Font("Aerials", Font.BOLD, 30);

        Rectangle exitButton = new Rectangle(150, 300, 300, 80);
        graphics2D.draw(exitButton);
        graphics.setFont(fontBTN);
        FontMetrics metricsAgain = graphics.getFontMetrics(graphics.getFont());
        graphics.drawString(
                "EXIT",
                (Game.SCREEN_WIDTH - metricsAgain.stringWidth("EXIT")) / 2,
                350
        );
    }
}
