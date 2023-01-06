package Player;

import java.awt.*;


public class Block {
    private int posx, posy;
    private final int height;
    private final int width;
    Keyboard keyboard;
    public Block(Keyboard keyboard){
        this.posx = 400;
        this.posy = 300;
        this.keyboard = keyboard;
        this.height = 20;
        this.width = 20;
    }
    public void drawBlock(Graphics2D graph){

        graph.setColor(Color.BLUE);
        drawCollision(graph);
        graph.setColor(Color.CYAN);
        graph.fill(drawRect());

    }

    public Rectangle drawRect(){
        return new Rectangle(this.posx,this.posy, this.width,this.height);
    }

    private void drawCollision(Graphics2D graph){
        graph.drawRect(this.posx + this.width /2, this.posy, this.width/2, this.height); // Right
        graph.drawRect(this.posx - this.width/2, this.posy, this.width/2, this.height); // Left
        graph.drawRect(this.posx , this.posy + this.height/2, this.width, this.height/2); // Down
        graph.drawRect(this.posx , this.posy - this.height/2, this.width, this.height/2); // Up
    }


    public void update(){
        if(keyboard.Key_Right){
            this.posx += 5;
        }
        else if (keyboard.Key_Left){
            this.posx -= 5;
        }
        else if (keyboard.Key_Down){
            this.posy += 5;
        }
        else if (keyboard.Key_UP){
            this.posy -= 5;
        }
    }
}
