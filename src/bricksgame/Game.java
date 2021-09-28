package bricksgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game  extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;
    private int playerX = 310;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    public Game() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
       timer = new Timer(delay, this);
       timer.start();

    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(1, 1, 692, 592);
//border
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 691, 3);
        graphics.fillRect(691, 0, 3, 592);
//paddel
        graphics.setColor(Color.BLUE);
        graphics.fillRect(playerX, 550, 100, 8);

//the Ball
        graphics.setColor(Color.RED);
        graphics.fillOval(ballposX, ballposY, 20, 20);
   graphics.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
timer.start();
if(play){
    ballposX+=ballXdir;
    ballposY+=ballYdir;

    if(ballposX < 0){
        ballXdir = -ballXdir;
    }
    if(ballposY < 0){
        ballYdir = -ballYdir;
}
    if(ballposX > 670) {
        ballXdir = -ballXdir;
    }
}

repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
    }

    private void moveRight() {
        play = true;
        playerX+=20;

    }
    private void moveLeft() {
        play = true;
        playerX-=20;
    }
}
