import auxiliary.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 150 && mouseX <= 450) {
            if (mouseY >= 200 && mouseY <= 280) {
                Game.state = State.GAME;
            }
        }

        if (mouseX >= 150 && mouseX <= 450) {
            if (mouseY >= 300 && mouseY <= 380) {
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
