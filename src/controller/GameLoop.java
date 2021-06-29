package controller;

import model.World;
import model.WorldExample1;
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

    public void setView(View view) {
        this.view = view;
    }

    public void start(Game game) {
        GameView gameview = new GameView(game);
        gameview.menu();

        List<Sprite> Sprites = new ArrayList<>();
        Character p1 = new Character(new Point(100, 100));
        Character p2 = new Character(new Point(500, 100));
        Sprites.add(p1);
        Sprites.add(p2);
        //Sprites.add(new Table(new Point(300, 0)));
        //Sprites.add(new ApplePieStove(new Point(300, 150)));
        //Sprites.add(new AppleFactory(new Point(0, 150)));
        //Sprites.add(new PieFactory(new Point(0, 300)));
        //Sprites.add(new VegetableFactory(new Point(150, 0)));
        //Sprites.add(new TrashCan(new Point(150, 300)));
        //OrderList o1 = new OrderList();
        //o1.addOrder(new ApplePie(new Point(0, 0)));
        //ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        //scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));

        ScoreBoard scoreboard = new ScoreBoard(0, 100, 100);
        //Sprites.add(new PickupWindow(new Point(450, 450), o1, scoreboard, scoreComputer));

        World world1 = new WorldExample1(new CharacterCollisionHandler(), scoreboard, Sprites);
        // World w2;
        
        // based on menu 
        game.construct(world1, p1, p2);
        
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
