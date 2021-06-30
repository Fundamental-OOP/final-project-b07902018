package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import controller.Game;

public class Endpage extends JPanel {
    public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
    private int score;
    private JLabel jscore;
    private JButton again;
    private Image im;
    private Boolean isend;

    public Endpage(int score) {
        this.score = score;
        isend = false;
        setLayout(null);

        jscore = new JLabel(String.format("Score: %d", score));
        add(jscore);
        jscore.setFont(new Font("", Font.BOLD, 50));
        jscore.setBounds(350, 450, 400, 80);

        again = new JButton("Again");
        add(again);
        again.setFont(new Font("", Font.BOLD, 50));
        again.setBounds(400, 550, 200, 80);
        again.setOpaque(false);
        again.setFocusPainted(false);
        again.setContentAreaFilled(false);
        again.setBorderPainted(false);

        ActionListener ButtonListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                isend = true;
            }
        };

        again.addActionListener(ButtonListener);

        try {
            im = ImageIO.read(new File("assets/menu/endbackground.png"));
        } catch (Exception e) {
        }
    }
    
    public Boolean isEnd(){
        return isend;
    }

    public void render() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g /* paintbrush */) {
        super.paintComponent(g);
        // Now, let's paint
        g.setColor(Color.WHITE); // paint background with all white
        g.fillRect(0, 0, WIDTH, HEIGHT+100);
        g.drawImage(im, 100, 50, 800, HEIGHT / 2, null);
    }

}
