package Map;

import Main.Constants;
import Player.Keyboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background {

    private int posX;
    private int posY;
    private final int widthRect = 200;


    Image background;

    public Background(String Url){

        this.posY = 0;
        this.posX = 0;
        background = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(Url))).getImage();

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }





    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(background, this.posX,this.posY,null);

    }

    public void draw(Graphics2D graphics2D, boolean draw){
        graphics2D.drawImage(background, this.posX,this.posY,null);
        graphics2D.setColor(Color.white);
        graphics2D.draw(getCollisionMoveLeft());
        graphics2D.setColor(Color.magenta);
        graphics2D.draw(getCollisionMoveRight());

        graphics2D.setColor(Color.GREEN);
        graphics2D.draw(getCollionMapLeft());
        graphics2D.draw(getCollionMapRight());

    }



    public Rectangle getCollionMapLeft(){
        return new Rectangle(0,0, 1, Constants.windowHeight);
    }
    public Rectangle getCollionMapRight(){
        return new Rectangle(Constants.windowWidth - 1,0, 1, Constants.windowHeight);
    }

    public Rectangle getCollisionMoveLeft(){
        return new Rectangle(0,0, this.widthRect, Constants.windowHeight);
    }
    public Rectangle getCollisionMoveRight(){

        return new Rectangle(Constants.windowWidth - this.widthRect,0, widthRect, Constants.windowHeight);
    }

    public void update(Rectangle object, int x, Keyboard keyboard){
        // Right = Negative
        if(object.intersects(getCollisionMoveLeft()) && this.posX < 0 && keyboard.Key_Left){
            if(this.posX + x >= 0){
                this.posX = 0;
            }else{
                this.posX += x;
            }
        }
        else if(object.intersects(getCollisionMoveRight()) && keyboard.Key_Right){

            int max_X = -1 *(Math.abs(background.getWidth(null)- Constants.windowWidth));
            if(this.posX > max_X){
                if(this.posX - x <= max_X){
                    this.posX = max_X;
                }else{
                    this.posX -= x;
                }
            }
        }
    }

}
