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
        Character p1 = new Character(new Point(0, 0));
        Character p2 = new Character(new Point(300, 300));
        Sprites.add(p1);
        Sprites.add(p2);
        Sprites.add(new Table(new Point(300, 0)));
        Sprites.add(new ApplePieStove(new Point(300, 150)));
        Sprites.add(new AppleFactory(new Point(0, 150)));
        Sprites.add(new PieFactory(new Point(0, 300)));
        Sprites.add(new VegetableFactory(new Point(150, 0)));
        Sprites.add(new TrashCan(new Point(150, 300)));

        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        // scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));
        scoreComputer.addScoreConversion(new Apple(null), 2);
        scoreComputer.addScoreConversion(new Pie(null), 3);
        scoreComputer.addScoreConversion(new ApplePie(null), 5);
        scoreComputer.addScoreConversion(new EnsaladaCompleta(null), 7);
        scoreComputer.addScoreConversion(new EnsaladaDeLechugaMaizYCebolla(null), 11);
        scoreComputer.addScoreConversion(new EnsaladaDeLechugaPepinoYCebolla(null), 13);
        scoreComputer.addScoreConversion(new EnsaladaDeLechugaTomateYCebolla(null), 17);
        scoreComputer.addScoreConversion(new EnsaladaDeTomateMaizYCebolla(null), 19);
        scoreComputer.addScoreConversion(new EnsaladaDeTomatePepinoYCebolla(null), 23);
        scoreComputer.addScoreConversion(new Lechuga(null), 29);
        scoreComputer.addScoreConversion(new Maiz(null), 31);
        scoreComputer.addScoreConversion(new Onion(null), 37);
        scoreComputer.addScoreConversion(new Pepino(null), 41);
        scoreComputer.addScoreConversion(new Tomato(null), 43);

        ScoreBoard scoreboard = new ScoreBoard(0, 10, 10);
        Sprites.add(new PickupWindow(new Point(450, 450), scoreboard, scoreComputer));

        World world = new World(new CharacterCollisionHandler(), scoreboard, Sprites);
        game.construct(world, p1, p2);
        
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
