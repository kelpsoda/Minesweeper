package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MyPanel extends JPanel{
    Random random;

    final int SCREEN_HEIGHT = 600;
    final int SCREEN_WIDTH = 600;
    final int SCREEN_UNITS = 25;
    int numOfColumns = 10;
    int NUM_OF_MINES = 25;

    int[][] Mine = new int [NUM_OF_MINES][NUM_OF_MINES];

    MyPanel(){
        init();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.addMouseListener(new MouseListener());
        StartGame();
        this.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int x = 0; x<=numOfColumns; x++){
            g.drawLine(0, x* SCREEN_UNITS, SCREEN_WIDTH, x* SCREEN_UNITS);
            g.drawLine(x* SCREEN_UNITS, 0,x* SCREEN_UNITS, SCREEN_HEIGHT);
        }
        g.setColor(Color.RED);
        for (int i = 0; i < NUM_OF_MINES; i++) {
            g.fillRect(Mine[i][0], Mine[0][i], SCREEN_UNITS, SCREEN_UNITS);
        }

    }
    void StartGame(){

    }
    void init(){
        random = new Random();
        for (int i = 0; i < NUM_OF_MINES; i++) {
            Mine[0][i] = random.nextInt(SCREEN_WIDTH / SCREEN_UNITS) * SCREEN_UNITS;
            Mine[i][0] = random.nextInt(SCREEN_WIDTH / SCREEN_UNITS) * SCREEN_UNITS;
        }
    }

    class MouseListener extends MouseAdapter{

        int getMouseX;
        int getMouseY;

        @Override
        public void mouseClicked(MouseEvent e) {
            getMouseX = (e.getX()/ SCREEN_UNITS) * SCREEN_UNITS;
            getMouseY = (e.getY()/ SCREEN_UNITS) * SCREEN_UNITS;
            System.out.println(getMouseY);
            System.out.println(getMouseX);
            for(int i = 0;i < NUM_OF_MINES;i++){
                int x = random.nextInt(SCREEN_WIDTH / SCREEN_UNITS) * SCREEN_UNITS;
                int y = random.nextInt(SCREEN_HEIGHT / SCREEN_UNITS) * SCREEN_UNITS;
                Mine[i][0] = x;
                Mine[0][i] = y;
            }
            repaint();
        }
    }
}
