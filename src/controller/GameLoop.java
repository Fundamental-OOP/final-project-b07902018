package controller;

import model.World;
import views.GameView;
import views.View;
import controller.Game;
import java.util.List;

import javax.swing.JPanel;

import java.util.ArrayList;
import model.Sprite;
import character.Character;
import java.awt.*;
import item.mobileItem.*;
import item.staticItem.*;
import order.OrderList;
import scoring.*;
import character.*;
/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class GameLoop {

    protected boolean running;
    
    protected View view;

    public void setView(View view) {
        this.view = view;
    }

    public void start(Game game) {
        GameView gameview = new GameView(game);
        gameview.menu();

        Character p1 = new Character(new Point(0, 0));
        Character p2 = new Character(new Point(300, 300));
        List<Character> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        game.setPlayers(players);
        
        new Thread(this::gameLoop).start();
        gameview.launch();
    }

    private void gameLoop() {
        running = true;
        while (running) {
            World world = getWorld();
            world.update();
            view.render(world);
            delay(15);
        }
    }

    protected abstract World getWorld();

    public void stop() {
        running = false;
    }

    private void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
