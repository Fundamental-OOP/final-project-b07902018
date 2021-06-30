package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import item.mobileItem.ingredient.ApplePie;
import item.staticItem.*;
import item.staticItem.abandoningItem.PickupWindow;
import item.staticItem.abandoningItem.TrashCan;
import item.staticItem.craftingItem.ApplePieStove;
import item.staticItem.craftingItem.FriedEggStove;
import item.staticItem.craftingItem.SaladBowl;
import item.staticItem.craftingItem.SandwichMaker;
import item.staticItem.factoryItem.AppleBox;
import item.staticItem.factoryItem.BreadBasket;
import item.staticItem.factoryItem.CheeseBlock;
import item.staticItem.factoryItem.EggBasket;
import item.staticItem.factoryItem.PieBox;
import item.staticItem.factoryItem.SpinachGarden;
import item.staticItem.factoryItem.TomatoBasket;
import item.staticItem.factoryItem.VegetableFactory;
import order.OrderDiplayer;
import order.OrderList;
import scoring.ScoreApplePie;
import scoring.ScoreBoard;
import scoring.ScoreComputer;

public class WorldExample2 extends World {

    private final int gridWidth = 75;

    private final int gridHeight = 75;

    private final SpriteShape staticItemShape 
        = new SpriteShape(new Dimension(75, 75), new Dimension(10, 10), new Dimension(55, 55));

    private final SpriteShape mobileItemShape
        = new SpriteShape(new Dimension(50, 50), new Dimension(33, 38), new Dimension(66, 105));

    public WorldExample2(CollisionHandler collisionHandler, int width, int height, ScoreBoard scoreboard, List<Sprite> sprites, JPanel panel) {
        super(collisionHandler, width, height, scoreboard, sprites);
        
        for(int i = 0; i < 12; ++i){
            addSprite(new PieBox(computeCoordinate(i, 0), staticItemShape, mobileItemShape));
        }
        /*
        addSprite(new Plant1(new Point(0, 100)));
        addSprite(new Plant1(new Point(0, 600)));
        addSprite(new WoodPlatform(new Point(100, 700)));
        addSprite(new WoodPlatform(new Point(200, 700)));
        addSprite(new WoodPlatform(new Point(400, 700)));
        addSprite(new WoodPlatform(new Point(500, 700)));
        addSprite(new WoodPlatform(new Point(700, 700)));
        addSprite(new WoodPlatform(new Point(800, 700)));

        addSprite(new ApplePieStove(new Point(0, 200)));
        addSprite(new PieBox(new Point(0, 300)));
        addSprite(new BreadBasket(new Point(0, 400)));
        addSprite(new FriedEggStove(new Point(0, 500)));

        addSprite(new TrashCan(new Point(100, 100)));
        addSprite(new EggBasket(new Point(100, 600)));

        addSprite(new AppleBox(new Point(300, 700)));

        addSprite(new SaladBowl(new Point(400, 400)));

        addSprite(new SandwichMaker(new Point(500, 400)));

        addSprite(new CheeseBlock(new Point(600, 700)));

        addSprite(new SpinachGarden(new Point(800, 100)));
        addSprite(new TomatoBasket(new Point(800, 600)));

        addSprite(new WoodPlatform(new Point(900, 100)));
        addSprite(new WoodPlatform(new Point(900, 200)));
        addSprite(new WoodPlatform(new Point(900, 300)));
        addSprite(new WoodPlatform(new Point(900, 500)));
        addSprite(new WoodPlatform(new Point(900, 600)));
        
        ScoreComputer scoreComputer = new ScoreComputer(new ArrayList<>());
        scoreComputer.addScoreConversion(new ScoreApplePie(new ApplePie(null)));


        PickupWindow window = new PickupWindow(new Point(900, 400), scoreboard, scoreComputer);
        addSprite(window); 
        scoreboard.setX(1050);
        addSprite(new OrderDiplayer(1050, 200, window, panel));
        */
    }

    public Point computeCoordinate(int Xgrid, int Ygrid){
        return new Point(Xgrid * gridWidth, Ygrid * gridHeight);
    }
    
}
