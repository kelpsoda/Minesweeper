package mineSweeper;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new MyPanel());
        this.pack();
        this.setLocale(null);
        this.setVisible(true);
    }
}
