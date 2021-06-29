package controller;

import model.World;
import model.WorldExample1;
import model.WorldExample2;
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
import item.mobileItem.ingredient.*;
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
    protected boolean gamestart = false;

    public void setView(View view) {
        this.view = view;
    }

    public void gameStart(){
        gamestart = true;
    }

    public Boolean isStart(){
        return gamestart;
    }

    public void start(Game game) {
        GameView gameview = new GameView(game);
        gameview.launchMenu();
        List<Character> players = new ArrayList<>();
        List<Sprite> Sprites = new ArrayList<>();
        if(gameview.getMenu().getPlayernum()==1){
            Character p1 = new Character(new Point(100, 100));
            players.add(p1);
            Sprites.add(p1);
        }else{
            Character p1 = new Character(new Point(100, 100));
            Character p2 = new Character(new Point(500, 100));
            players.add(p1);
            players.add(p2);
            Sprites.add(p1);
            Sprites.add(p2);
        }

        ScoreBoard scoreboard = new ScoreBoard(0, 800, 100);

        World world2 = new WorldExample2(new CharacterCollisionHandler(), scoreboard, Sprites,gameview.getCanvas());
        game.setWorld(world2);
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
