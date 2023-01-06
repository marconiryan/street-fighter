package Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    public boolean Key_UP= false, Key_Down = false, Key_Left = false, Key_Right = false, Key_Help = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){
            Key_UP = true;
        }
        if (code == KeyEvent.VK_DOWN){
            Key_Down = true;
        }
        if (code == KeyEvent.VK_LEFT){
            Key_Left = true;
        }
        if (code == KeyEvent.VK_RIGHT){
            Key_Right = true;
        }
        if (code == KeyEvent.VK_H){
            Key_Help = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){
            Key_UP = false;
        }
        if (code == KeyEvent.VK_DOWN){
            Key_Down = false;
        }
        if (code == KeyEvent.VK_LEFT){
            Key_Left = false;
        }
        if (code == KeyEvent.VK_RIGHT){
            Key_Right = false;
        }
        if (code == KeyEvent.VK_H){
            Key_Help = false;
        }
    }
}
