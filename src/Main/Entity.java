package Main;

import Player.Keyboard;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Entity {
    private int posX;
    private int posY;
    private int width;
    private int height;

    private boolean down;

    private boolean moving;



    private final LinkedList<Shape> collision;



    Entity(int posX, int posY, int width, int height){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        collision = new LinkedList<>();
        setCollisionBox();
    }





    public LinkedList<Shape> getCollision() {
        return collision;
    }

    public void setCollision(Shape shape){
        this.collision.add(shape);
    }
    public void resetCollisionBox(){
        this.collision.clear();
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public boolean isDown() {
        return down;
    }

    public void drawEntity(Graphics2D graphics2D, Color c){
        resetCollisionBox();
        setCollisionBox();
        graphics2D.setColor(c);
        graphics2D.fill(getEntityShape());

    }
    public void drawEntity(Graphics2D graphics2D, Color c, boolean showCollision){
        resetCollisionBox();
        setCollisionBox();
        graphics2D.setColor(c);
        graphics2D.fill(getEntityShape());
        graphics2D.setColor(Color.WHITE);
        for(Shape s: getCollision()){
            graphics2D.draw(s);
        }
    }


    public void update(){

    }

    public void update(Keyboard keyboard, boolean right, boolean left, boolean down, boolean up){
        this.down = keyboard.Key_Down;

        setMoving(keyboard.Key_Left || keyboard.Key_Right);
        if(keyboard.Key_Right && right){
            this.posX += 5;
        }
        else if (keyboard.Key_Left && left){
            this.posX -= 5;
            setMoving(true);
        }
        else if (keyboard.Key_Down && down){
            this.posY += 5;
        }
        else if (keyboard.Key_UP && up){
            this.posY -= 5;
        }

    }


    public Rectangle getCollisionBoxBottom(){
        return new Rectangle(this.posX, this.posY + 10, this.width, this.height);
    } public Rectangle getCollisionBoxTop(){
        return new Rectangle(this.posX, this.posY - 10, this.width, this.height);
    } public Rectangle getCollisionBoxLeft(){
        return new Rectangle(this.posX - 10, this.posY, this.width, this.height);
    } public Rectangle getCollisionBoxRight(){
        return new Rectangle(this.posX + 10, this.posY, this.width, this.height);
    }

    public void setCollisionBox(){

        setCollision(new Rectangle(this.posX + this.width, this.posY, 1, this.height));
        setCollision(new Rectangle(this.posX, this.posY + this.height, this.width, 1));
        setCollision(new Rectangle(this.posX, this.posY, 1, this.height));
        setCollision(new Rectangle(this.posX, this.posY, this.width, 1));
    }


    public Rectangle getEntityShape(){
        return new Rectangle(this.posX, this.posY, this.width, this.height);
    }
}
