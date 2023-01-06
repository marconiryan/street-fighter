package Main;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Player extends Entity{

    private boolean moving;
    private boolean var;
    private LinkedList<String> orderDraw;

    private long lastTime;
    {
        lastTime = System.nanoTime() / 100000000;
        var = true;
        orderDraw = new LinkedList<>();
        orderDraw.add("ryu1");
    }
    Player(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);

    }

    public long getLastTime() {
        return lastTime ;
    }

    public void updateLastTime() {
        this.lastTime = getCurrentTime();
    }

    public long getCurrentTime(){
        return (System.nanoTime() / 100000000);
    }

    @Override
    public boolean isMoving() {
        return moving;
    }

    @Override
    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    public void drawEntity(Graphics2D graphics2D) {
        if(isDown()){
            graphics2D.drawImage(ImageEntity("/Sprites/ryu3.png"), getPosX(), getPosY() +10, getWidth(), getHeight(), null);
            return;
        }
        if(getCurrentTime() - getLastTime() > 1 && isMoving()){
            updateLastTime();
            if(var){
                orderDraw.add("ryu2");
                orderDraw.removeFirst();
            }

            else{
                //graphics2D.drawImage(ImageEntity("/Sprites/ryu1.png"), getPosX(), getPosY(), null);
                orderDraw.add("ryu1");
                orderDraw.removeFirst();
            }
            var = !var;
        }
        if(isMoving())
            graphics2D.drawImage(ImageEntity("/Sprites/"+ orderDraw.getFirst() + ".png"), getPosX(), getPosY(), getWidth(), getHeight(), null);
        else{
            graphics2D.drawImage(ImageEntity("/Sprites/ryu1.png"), getPosX(), getPosY(), getWidth(), getHeight(), null);
        }

    }
    private Image ImageEntity(String Url){
        return new ImageIcon(Objects.requireNonNull(this.getClass().getResource(Url))).getImage();
    }
}
