package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Menu extends JPanel{
    public static final int HEIGHT = 1024;
    public static final int WIDTH = 768;

    public void render(){
        repaint();
    }

    @Override
        protected void paintComponent(Graphics g /*paintbrush*/) {
            super.paintComponent(g);
            // Now, let's paint
            g.setColor(Color.WHITE); // paint background with all white
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.drawString("Press Enter in terminal to start", 300, 300);
        }
}
