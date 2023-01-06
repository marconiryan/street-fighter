package Main;
import Map.Background;
import Player.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {
    Keyboard keyboard = new Keyboard();
    Thread gameThread;
    Background background;

    Player entity = new Player(100, Constants.windowHeight - 130, 60, 88);
    Entity floor = new Entity(0,Constants.windowHeight - 50, Constants.windowWidth, 50);
    final double FPS = 60;



    public Game() {
        this.addKeyListener(keyboard);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(Constants.windowWidth,Constants.windowHeight));
        this.setFocusable(true);
        this.background = new Background("/Sprites/background.gif");
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D graphics2D = (Graphics2D) graph;
        if(keyboard.Key_Help){
            floor.drawEntity(graphics2D, Color.BLACK);
            background.draw(graphics2D, true);
            entity.drawEntity(graphics2D, Color.cyan);
        }
        else{
            floor.drawEntity(graphics2D, Color.BLACK);
            background.draw(graphics2D);
            entity.drawEntity(graphics2D);
        }

        graphics2D.dispose();


    }

    public void update() {
        entity.update(
                keyboard,
                !background.getCollionMapRight().intersects(entity.getEntityShape()),
                !background.getCollionMapLeft().intersects(entity.getEntityShape()),
                !floor.getEntityShape().intersects(entity.getEntityShape()),
                true);


        background.update(entity.getEntityShape(),2, keyboard);
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
}




