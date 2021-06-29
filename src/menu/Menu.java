package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import javax.imageio.ImageIO;

public class Menu extends JPanel{
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1024;

    public void render(){
        repaint();
    }

    @Override
        protected void paintComponent(Graphics g /*paintbrush*/) {
            super.paintComponent(g);
            // Now, let's paint
            // g.setColor(Color.WHITE); // paint background with all white
            // g.fillRect(100, 100, WIDTH-200, HEIGHT-200);
            try{
                File file = new File("assets/menu/1.png");
                Image im = ImageIO.read(file);
                g.drawImage(im, 10, 10, WIDTH-30, HEIGHT-100, this);
                // System.out.println("success");
            }catch(Exception e){
                System.out.println(e.toString());
            };
            g.setColor(Color.BLACK);
            g.drawString("Press Enter in terminal to start", 300, 300);

            
            

            // Container mainP = frame1.getContentPane();
            setLayout(null);

            JLabel titleL = new JLabel("WELCOME");

            add(titleL);
            titleL.setFont(new Font("Chiller",Font.BOLD,50));
            titleL.setBounds(100, 30, 200, 50);
        }
}
