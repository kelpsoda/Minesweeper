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
    int numOfColumns = 13;

    final int SCREEN_UNITS_X = SCREEN_WIDTH/numOfColumns;
    final int SCREEN_UNITS_Y = SCREEN_HEIGHT/numOfColumns;

    int NUM_OF_MINES = 10;
    int[] mineX = new int[NUM_OF_MINES];
    int[] mineY = new int[NUM_OF_MINES];

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
            g.drawLine(0, x* (SCREEN_HEIGHT/numOfColumns), SCREEN_WIDTH, x*(SCREEN_HEIGHT/numOfColumns));
            g.drawLine(x* (SCREEN_WIDTH/numOfColumns), 0,x*(SCREEN_WIDTH/numOfColumns), SCREEN_HEIGHT);
        }
        g.setColor(Color.RED);
        for(int i = 0; i < NUM_OF_MINES; i++) {
            g.fillRect(mineX[i], mineY[i], (SCREEN_WIDTH/numOfColumns), (SCREEN_HEIGHT/numOfColumns));
        }

    }
    void StartGame(){

    }
    void init(){
        random = new Random();
        for(int i = 0; i < NUM_OF_MINES; i++) {
            mineX[i] = random.nextInt(SCREEN_WIDTH/SCREEN_UNITS_X) * SCREEN_UNITS_X;
            mineY[i] = random.nextInt(SCREEN_HEIGHT/SCREEN_UNITS_Y) * SCREEN_UNITS_Y;
        }
    }

    class MouseListener extends MouseAdapter{

        int getMouseX;
        int getMouseY;

        @Override
        public void mouseClicked(MouseEvent e) {
            getMouseX = (e.getX()/ SCREEN_UNITS_X) * SCREEN_UNITS_X;
            getMouseY = (e.getY()/ SCREEN_UNITS_Y) * SCREEN_UNITS_Y;
            System.out.println(getMouseY);
            System.out.println(getMouseX);

            repaint();
        }
    }
}
