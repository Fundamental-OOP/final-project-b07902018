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
            // g.setColor(Color.BLACK);
            // g.drawString("Press Enter in terminal to start", 300, 300);

            
            

            // Container mainP = frame1.getContentPane();
            setLayout(null);

            JLabel titleL = new JLabel("WELCOME TO FAKECOOKED!");
            add(titleL);//Chiller
            titleL.setFont(new Font("Chiller",Font.BOLD,50));
            titleL.setBounds(230, 30, 600, 50);

            JButton playerNum = new JButton("Player Number");
            add(playerNum);
            // startB.setMnemonic(KeyEvent.VK_S);
            playerNum.setBounds(400, 100, 200, 50);

            JButton worldSelect = new JButton("Select World");
            add(worldSelect);
            // startB.setMnemonic(KeyEvent.VK_S);
            worldSelect.setBounds(400, 250, 200, 50);

            JButton startB = new JButton("Start");
            add(startB);
            // startB.setMnemonic(KeyEvent.VK_S);
            startB.setBounds(400, 400, 200, 50);

            g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
            
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    switch (keyEvent.getKeyCode()) {
                        case KeyEvent.VK_W:
                            // game.moveCharacter(P1, Direction.UP);
                            break;
                        case KeyEvent.VK_S:
                            // game.moveCharacter(P1, Direction.DOWN);
                            break;
                        case KeyEvent.VK_A:
                            // game.moveCharacter(P1, Direction.LEFT);
                            break;
                        case KeyEvent.VK_D:
                            // game.moveCharacter(P1, Direction.RIGHT);
                            break;
                        
                        // case KeyEvent.VK_Q:
                        //    game.pickUpItem(P1);
                        //    break;
                        // case KeyEvent.VK_E:
                        //     game.releaseItem(P1);
                        //     break;
                        
                        case KeyEvent.VK_I:
                            // game.moveCharacter(P2, Direction.UP);
                            break;
                        case KeyEvent.VK_K:
                            // game.moveCharacter(P2, Direction.DOWN);
                            break;
                        case KeyEvent.VK_J:
                            // game.moveCharacter(P2, Direction.LEFT);
                            break;
                        case KeyEvent.VK_L:
                            // game.moveCharacter(P2, Direction.RIGHT);
                            break;
    
                        case KeyEvent.VK_U:
                            // game.pickUpItem(P2);
                            break;
                        case KeyEvent.VK_O:
                            // game.releaseItem(P2);
                            break;
                    }
                }
    
                @Override
                public void keyReleased(KeyEvent keyEvent) {
                    switch (keyEvent.getKeyCode()) {
                        case KeyEvent.VK_W:
                            // game.stopCharacter(P1, Direction.UP);
                            break;
                        case KeyEvent.VK_S:
                            // game.stopCharacter(P1, Direction.DOWN);
                            break;
                        case KeyEvent.VK_A:
                            // game.stopCharacter(P1, Direction.LEFT);
                            break;
                        case KeyEvent.VK_D:
                            // game.stopCharacter(P1, Direction.RIGHT);
                            break;
                        case KeyEvent.VK_I:
                            // game.stopCharacter(P2, Direction.UP);
                            break;
                        case KeyEvent.VK_K:
                            // game.stopCharacter(P2, Direction.DOWN);
                            break;
                        case KeyEvent.VK_J:
                            // game.stopCharacter(P2, Direction.LEFT);
                            break;
                        case KeyEvent.VK_L:
                            // game.stopCharacter(P2, Direction.RIGHT);
                            break;
                        case KeyEvent.VK_Q:
                            // game.pickUpItem(P1);
                            break;
                        case KeyEvent.VK_E:
                            // game.releaseItem(P1);
                            break;
                    }
                }
                @Override
                public void keyTyped(KeyEvent e) {
    
                }
            });
        }
}
