package views;

import controller.Game;
import controller.GameLoop;
import model.Direction;
import model.Sprite;
import model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GameView extends JFrame {
    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    public static final int P1 = 1;
    public static final int P2 = 2;
    private final Canvas canvas = new Canvas();
    private final Game game;

    public GameView(Game game) throws HeadlessException {
        this.game = game;
        game.setView(canvas);
    }

    public void launch() {
        // GUI Stuff
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(canvas);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);

        // Keyboard listener
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.moveCharacter(P1, Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.moveCharacter(P1, Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.moveCharacter(P1, Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.moveCharacter(P1, Direction.RIGHT);
                        break;
                    
                    // case KeyEvent.VK_Q:
                    //    game.pickUpItem(P1);
                    //    break;
                    // case KeyEvent.VK_E:
                    //     game.releaseItem(P1);
                    //     break;
                    
                    case KeyEvent.VK_I:
                        game.moveCharacter(P2, Direction.UP);
                        break;
                    case KeyEvent.VK_K:
                        game.moveCharacter(P2, Direction.DOWN);
                        break;
                    case KeyEvent.VK_J:
                        game.moveCharacter(P2, Direction.LEFT);
                        break;
                    case KeyEvent.VK_L:
                        game.moveCharacter(P2, Direction.RIGHT);
                        break;

                    case KeyEvent.VK_U:
                        game.pickUpItem(P2);
                        break;
                    case KeyEvent.VK_O:
                        game.releaseItem(P2);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.stopCharacter(P1, Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.stopCharacter(P1, Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.stopCharacter(P1, Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.stopCharacter(P1, Direction.RIGHT);
                        break;
                    case KeyEvent.VK_I:
                        game.stopCharacter(P2, Direction.UP);
                        break;
                    case KeyEvent.VK_K:
                        game.stopCharacter(P2, Direction.DOWN);
                        break;
                    case KeyEvent.VK_J:
                        game.stopCharacter(P2, Direction.LEFT);
                        break;
                    case KeyEvent.VK_L:
                        game.stopCharacter(P2, Direction.RIGHT);
                        break;
                    case KeyEvent.VK_Q:
                        game.pickUpItem(P1);
                        break;
                    case KeyEvent.VK_E:
                        game.releaseItem(P1);
                        break;
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
    }

    public static class Canvas extends JPanel implements View {
        private World world;

        @Override
        public void render(World world) {
            this.world = world;
            repaint(); // ask the JPanel to repaint, it will invoke paintComponent(g) after a while.
        }

        @Override
        protected void paintComponent(Graphics g /*paintbrush*/) {
            super.paintComponent(g);
            // Now, let's paint
            g.setColor(Color.WHITE); // paint background with all white
            g.fillRect(0, 0, GameView.WIDTH, GameView.HEIGHT);

            world.render(g); // ask the world to paint itself and paint the sprites on the canvas
        }
    }
}
