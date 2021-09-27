package bricksgame;

import javax.swing.*;
import java.awt.*;

public class Main {
   public static void main (String[]args){
       JFrame obj = new JFrame();
       Game game  = new Game();
       obj.setBounds(10,60,700,600);
       obj.setTitle("Breakout Ball");
       obj.setBackground(Color.green);
       obj.setResizable(false);
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       obj.add(game)


   }
}
