package menu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import controller.Game;

public class Menu extends JPanel{
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1024;
    private int playernum;
    private int worldNo;
    private Game game;

    public Menu(Game game){
        this.game = game;
        playernum = 1;
        worldNo = 1;
    }
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

            // JLabel num = new JLabel("player number 1");
            // add(num);//Chiller
            // num.setFont(new Font("Chiller",Font.BOLD,50));
            // num.setBounds(0, 400, 400, 100);

            JButton playerNum = new JButton("Player Number: 1");
            add(playerNum);
            playerNum.setBounds(400, 100, 200, 50);

            JButton worldSelect = new JButton("Select World");
            add(worldSelect);
            worldSelect.setBounds(400, 250, 200, 50);

            JButton startB = new JButton("Start");
            add(startB);
            startB.setBounds(400, 400, 200, 50);
            // g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
            
            ActionListener ButtonListener = new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    String cmd = ae.getActionCommand();
                    switch(cmd){
                        case "P":
                            playernum = playernum % 2 + 1;
                            playerNum.setText(String.format("Player Number: %d", playernum));
                            break;
                        case "W":
                            break;
                        case "Start":
                            game.gameStart();
                            break;
                        default:
                            System.out.println("fuck");
                    }

                }
            };

            playerNum.setActionCommand("P");
            playerNum.addActionListener(ButtonListener);

            startB.setActionCommand("Start");
            startB.addActionListener(ButtonListener);

        }
        public int getPlayernum(){
            return playernum;
        }
        public int getWorldNo(){
            return worldNo;
        }
        
}
